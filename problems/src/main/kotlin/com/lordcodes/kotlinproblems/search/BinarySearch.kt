package com.lordcodes.kotlinproblems.search

/**
 * Returns the index of an occurrence of [value] in [list], leaving the list unchanged.
 * Time: O(log n). Additional space: O(1).
 *
 * @param list the list to search, sorted in ascending natural order. Duplicate values are allowed.
 * @param value the value to find. Elements match when their comparison returns zero.
 * @return any matching index, or null if [value] is absent or [list] is empty.
 */
fun <T : Comparable<T>> binarySearch(list: List<T>, value: T): Int? {
  var left = 0
  var right = list.lastIndex
  while (left <= right) {
    val middle = left + (right - left) / 2
    val comparison = list[middle].compareTo(value)
    when {
      comparison == 0 -> return middle
      comparison < 0 -> left = middle + 1
      else -> right = middle - 1
    }
  }
  return null
}
