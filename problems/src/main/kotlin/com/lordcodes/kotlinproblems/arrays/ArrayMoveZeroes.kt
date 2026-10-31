package com.lordcodes.kotlinproblems.arrays

/**
 * Moves all zeroes to the end of [array] in place, preserving the order of non-zero elements.
 * Time: O(n). Additional space: O(1).
 *
 * @param array the array to rearrange, keeping its size and the number of zeroes unchanged.
 */
fun arrayMoveZeroes(array: IntArray) {
  var writeIndex = 0
  var zeroCount = 0
  for (index in array.indices) {
    val value = array[index]
    if (value != 0) {
      array[writeIndex] = value
      writeIndex++
    } else {
      zeroCount++
    }
  }
  if (zeroCount > 0) {
    for (index in writeIndex until writeIndex + zeroCount) {
      array[index] = 0
    }
  }
}
