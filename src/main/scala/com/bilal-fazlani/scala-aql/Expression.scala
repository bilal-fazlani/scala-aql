package com.bilalfazlani.scalaAql

sealed trait Expression
case class MatcherExpression(param: String, matcher: Matcher) extends Expression
case class And[+E <: Expression: ExpressionEncoder](nested: List[E])
    extends Expression
case class Or[+E <: Expression: ExpressionEncoder](nested: List[E])
    extends Expression
