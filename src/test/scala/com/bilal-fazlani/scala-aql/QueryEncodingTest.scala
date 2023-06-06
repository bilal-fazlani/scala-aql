package com.bilalfazlani.scalaAql

import zio.test.*

object QueryEncodingTest extends ZIOSpecDefault:
  val spec = suite("QueryEncodingTest")(
    test("encode query of matcher expressions") {
      val query = Query(
        expresion = And(
          List(
            MatcherExpression("repo", Eq("general")),
            MatcherExpression(
              "path",
              Eq("tests/reports")
            ),
            MatcherExpression("name", Match("*.csv"))
          )
        ),
        limit = Some(10),
        offset = Some(4),
        include = Set("name", "repo", "path")
      )
      assertTrue(query.encode == """items.find(
        |{"$and" : [{"repo" : "general"},{"path" : "tests/reports"},{"name" : {"$match" : "*.csv"}}]}
        |)
        |.include("name","repo","path")
        |.offset(4)
        |.limit(10)""".stripMargin)
    },
    test("encode query of mixed expression types") {
      val query = Query(
        expresion = And(
          List(
            MatcherExpression("repo", Eq("general")),
            Or(
              List(
                MatcherExpression(
                  "path",
                  Eq("tests/reports")
                ),
                MatcherExpression("name", Match("*.csv"))
              )
            )
          )
        ),
        limit = Some(10),
        offset = Some(4),
        include = Set("name", "repo", "path")
      )
      assertTrue(query.encode == """items.find(
        |{"$and" : [{"repo" : "general"},{"$or" : [{"path" : "tests/reports"},{"name" : {"$match" : "*.csv"}}]}]}
        |)
        |.include("name","repo","path")
        |.offset(4)
        |.limit(10)""".stripMargin)
    }
  )
