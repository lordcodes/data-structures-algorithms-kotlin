package com.lordcodes.kotlinproblems.search

/**
 * Returns the index of the first occurrence of [value] in [list], leaving the list unchanged.
 * Time: O(n). Additional space: O(1).
 *
 * @param list the list to search, which may be unsorted.
 * @param value the value to find using equality. Null values are supported for nullable element types.
 * @return the first matching index, or null if [value] is absent or [list] is empty.
 */
fun <T> linearSearch(list: List<T>, value: T): Int? {
  for ((index, element) in list.withIndex()) {
    if (element == value) {
      return index
    }
  }
  return null
}
