package com.oxcarh.adventofcode2015

import scala.collection._
import java.util.concurrent.ConcurrentHashMap

/*
Day 3: Perfectly Spherical Houses in a Vacuum
https://adventofcode.com/2015/day/3
 */

object Day3 extends App {

  val input = Tools.loadDayInputAsText(day = 3)

  // Solution 1
  val houses = new mutable.HashMap[(Int, Int), Int]()
  var position = (0, 0)
  houses.put(position, 1)
  input.foreach { order =>
    val move = orderToMove(order)
    position = (position._1 + move._1, position._2 + move._2)
    if(houses.contains(position)) houses.update(position, houses(position) + 1)
    else houses.put(position, 1)
  }
  println(s"Solution 1: ${houses.size}")

  // ----------------------------------------------------------------------

  def orderToMove(order: Char): (Int, Int) = {
    order match {
      case '^' => (0, 1)
      case '>' => (1, 0)
      case '<' => (-1, 0)
      case 'v' => (0, -1)
      case _ => (0, 0)
    }
  }

}
