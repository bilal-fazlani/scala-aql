package com.bilalfazlani.scalaAql

trait Matcher:
  def encode: String

case class Eq(constant: String) extends Matcher:
  def encode: String = s""""$constant""""

case class Match(pattern: String) extends Matcher:
  def encode: String = s"""{"$$match" : "$pattern"}"""
