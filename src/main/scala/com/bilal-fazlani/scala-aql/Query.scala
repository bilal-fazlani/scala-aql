package com.bilalfazlani.scalaAql

case class Query(
    expresion: Expression,
    limit: Option[Int],
    offset: Option[Int],
    include: Set[String]
)
