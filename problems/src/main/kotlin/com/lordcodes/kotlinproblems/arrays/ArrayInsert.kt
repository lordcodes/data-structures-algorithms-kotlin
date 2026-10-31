@file:OptIn(ExperimentalStdlibApi::class)

package com.lordcodes.kotlinproblems.arrays

/**
 * Inserts [value] at [index] in [array] in place, shifting subsequent elements one position to the right.
 * Time: O(n). Additional space: O(1).
 *
 * @param array the backing array, which must have space for one more element.
 * @param size the number of elements currently in use, from 0 to [array].size exclusive.
 * @param index the insertion position, from 0 to [size] inclusive.
 * @param value the value to insert.
 * @return the number of elements in use after insertion, equal to [size] plus one.
 * @throws IllegalArgumentException if [size] is at least [array].size or [index] is outside 0..[size].
 */
fun <T> insertIntoArray(array: Array<T>, size: Int, index: Int, value: T): Int {
  require(size < array.size)
  require(index in 0..size)

  for (i in size downTo index + 1) {
    array[i] = array[i - 1]
  }
  array[index] = value
  return size + 1
}

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
