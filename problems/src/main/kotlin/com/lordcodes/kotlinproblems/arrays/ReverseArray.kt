package com.lordcodes.kotlinproblems.arrays

/**
 * Returns the elements of [array] in reverse order.
 * Time: O(n). Additional space: O(1).
 *
 * @param array the array to reverse.
 * @return [array] reversed in place.
 */
fun <T> reverseArray(array: Array<T>): Array<T> {
  var left = 0
  var right = array.lastIndex
  while (left < right) {
    val value = array[left]
    array[left] = array[right]
    array[right] = value
    left++
    right--
  }
  return array
}
