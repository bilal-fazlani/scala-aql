package com.bilalfazlani.scalaAql

trait ExpressionEncoder[-T <: Expression]:
  extension (expression: T) def encode: String

object ExpressionEncoder:
  def apply[E <: Expression: ExpressionEncoder]: ExpressionEncoder[E] =
    summon[ExpressionEncoder[E]]

  given QueryEncoder[E <: Expression]: ExpressionEncoder[E] =
    new ExpressionEncoder[E]:
      extension (expression: E)
        def encode: String = expression.asInstanceOf[Expression] match {
          case matcher: MatcherExpression => matcher.encode
          case and: And[Expression]       => and.encode
          case or: Or[Expression]         => or.encode
        }

  given ExpressionEncoder[MatcherExpression] =
    new ExpressionEncoder[MatcherExpression]:
      extension (expression: MatcherExpression)
        def encode: String =
          s"""{"${expression.param}" : ${expression.matcher.encode}}"""

  given [E <: Expression: ExpressionEncoder]: ExpressionEncoder[And[E]] =
    new ExpressionEncoder[And[E]]:
      extension (expression: And[E])
        def encode: String =
          s"""{"$$and" : [${expression.nested.map(_.encode).mkString(",")}]}"""

  given [E <: Expression: ExpressionEncoder]: ExpressionEncoder[Or[E]] =
    new ExpressionEncoder[Or[E]]:
      extension (expression: Or[E])
        def encode: String =
          s"""{"$$or" : [${expression.nested.map(_.encode).mkString(",")}]}"""
