package com.oxcarh.adventofcode2015

/*
Day 2: I Was Told There Would Be No Math
https://adventofcode.com/2015/day/2
 */

object Day2 extends App {

  val input = Tools.loadDayInputAsText(day = 2)

  // Solution 1

  val wrappingPaperArea = input.split("\n")
    .map { line =>
      val dimensions = line.split("x").map(_.toInt)
      Box(dimensions(0), dimensions(1), dimensions(2))
    }
    .foldLeft(0) { (sum, box) =>
      sum + box.surfaceArea + box.extraSurfaceArea
    }
  println(s"Solution 1: $wrappingPaperArea")

  // ----------------------------------------------------------------------

  case class Box(length: Int, width: Int, height: Int) {

    private val a1 = length * width
    private val a2 = width * height
    private val a3 = height * length

    def surfaceArea: Int = 2 * a1 + 2 * a2 + 2 * a3

    def extraSurfaceArea: Int = Array(a1, a2, a3).min
  }

}
