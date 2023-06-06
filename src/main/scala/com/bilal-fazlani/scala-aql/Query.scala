package com.bilalfazlani.scalaAql

case class Query[E <: Expression: ExpressionEncoder](
    expresion: E,
    limit: Option[Int],
    offset: Option[Int],
    include: Set[String]
) {
  def encode: String = {
    val sb = java.lang.StringBuilder()
    sb.append("items.find(\n")
    sb.append(expresion.encode)
    sb.append("\n)")
    if (include.nonEmpty) {
      sb.append("\n.include(")
      sb.append(include.map(s => s"\"$s\"").mkString(","))
      sb.append(")")
    }
    offset.foreach(o => sb.append(s"\n.offset($o)"))
    limit.foreach(l => sb.append(s"\n.limit($l)"))
    sb.toString
  }
}