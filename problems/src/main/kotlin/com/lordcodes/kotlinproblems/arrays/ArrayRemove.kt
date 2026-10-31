package com.lordcodes.kotlinproblems.arrays

/**
 * Removes all occurrences of [value] from [array] in place, preserving the order of retained elements.
 * Time: O(n). Additional space: O(1).
 *
 * @param array the array to compact. Retained elements occupy the first returned-size positions;
 * values beyond those positions are unspecified, and the physical array size remains unchanged.
 * @param value the value to remove.
 * @return the number of retained elements after removing all occurrences of [value].
 */
fun <T> removeFromArray(array: Array<T>, value: T): Int {
  var writeIndex = 0
  for (index in array.indices) {
    if (array[index] != value) {
      array[writeIndex] = value
      writeIndex++
    }
  }
  return writeIndex
}
