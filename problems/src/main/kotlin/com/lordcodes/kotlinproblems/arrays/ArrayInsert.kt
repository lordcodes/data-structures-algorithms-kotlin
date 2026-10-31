@file:OptIn(ExperimentalStdlibApi::class)

package com.lordcodes.kotlinproblems.arrays

/**
 * Returns a new array with [value] inserted at [index], preserving the order of existing elements.
 * Time: O(n). Additional space: O(n).
 *
 * @param array the array to copy, which remains unchanged.
 * @param index the insertion position, from 0 to [array].size inclusive.
 * @param value the value to insert.
 * @return a new array containing one more element than [array].
 */
inline fun <reified T> insertIntoArrayResizing(array: Array<T>, index: Int, value: T): Array<T> {
  require(index in 0..array.size)

  if (array.isEmpty()) {
    return arrayOf(value)
  }

  val newArray = array.copyOf(array.size + 1) { array.last() }
  for (i in newArray.lastIndex downTo index + 1) {
    newArray[i] = newArray[i - 1]
  }
  newArray[index] = value
  return newArray
}
