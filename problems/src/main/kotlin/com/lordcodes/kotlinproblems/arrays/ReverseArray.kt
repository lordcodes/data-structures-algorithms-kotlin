package com.lordcodes.kotlinproblems.arrays

/**
 * Returns the elements of [array] in reverse order.
 * Time: O(n). Additional space: O(1) when [inplace] is true, O(n) when [inplace] is false.
 *
 * @param array the array to reverse.
 * @param inplace whether to modify [array] in place; defaults to false.
 * @return [array] reversed in place if [inplace] is true; otherwise a reversed copy.
 */
fun <T> reverseArray(array: Array<T>, inplace: Boolean = false): Array<T> {
  val newArray = if (inplace) {
    array
  } else {
    array.clone()
  }
  var left = 0
  var right = newArray.lastIndex
  while (left < right) {
    val value = newArray[left]
    newArray[left] = newArray[right]
    newArray[right] = value
    left++
    right--
  }
  return newArray
}
