package com.bilalfazlani.scalaAql

case class Query(
    expresion: Expression,
    limit: Option[Int] = None,
    offset: Option[Int],
    include: Set[String]
)
