package com.oxcarh.adventofcode2015

/*
Day 1: Not Quite Lisp
https://adventofcode.com/2015/day/1
 */

object Day1 extends App {

  val input = Tools.loadDayInputAsText(day = 1)

  // Solution 1
  val floor = input.foldLeft(0)((floor, instruction) =>
    if(instruction == '(') floor + 1
    else if(instruction == ')') floor - 1
    else floor
  )
  println(s"Solution 1: $floor")

}
