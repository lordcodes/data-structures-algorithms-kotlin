package com.lordcodes.kotlinproblems.graph

/**
 * Visits vertices reachable from [start] in breadth-first order.
 * Neighbors follow list order; missing keys have no outgoing edges.
 * Time: O(V + E). Additional space: O(V).
 */
fun <T> breadthFirstSearch(graph: Map<T, List<T>>, start: T): List<T> {
  val result = mutableListOf<T>()
  return result
}
