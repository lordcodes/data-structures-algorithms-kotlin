@file:Suppress("ktlint:standard:filename")

package com.lordcodes.kotlinproblems.arrays

/**
 * Returns the minimum and maximum elements of [array].
 * Time: O(n). Additional space: O(1).
 *
 * @param array the array to search.
 * @return a [MinMax] containing the minimum and maximum values, both null if [array] is empty.
 */
fun findMinMax(array: IntArray): MinMax {
  if (array.isEmpty()) {
    return MinMax(null, null)
  }
  var min = Int.MAX_VALUE
  var max = Int.MIN_VALUE
  for (number in array) {
    if (number < min) {
      min = number
    }
    if (number > max) {
      max = number
    }
  }
  return MinMax(min = min, max = max)
}

/**
 * Returns the minimum and maximum elements of [array], checking them pairwise to achieve
 * roughly 1.5 comparisons per element.
 * Time: O(n). Additional space: O(1).
 *
 * @param array the array to search.
 * @return a [MinMax] containing the minimum and maximum values, both null if [array] is empty.
 */
fun findPairwiseMinMax(array: IntArray): MinMax {
  if (array.isEmpty()) {
    return MinMax(null, null)
  }
  var min = array[0]
  var max = array[0]
  var index = 1
  while (index < array.lastIndex) {
    val first = array[index]
    val second = array[index + 1]

    val smaller: Int
    val larger: Int
    if (first < second) {
      smaller = first
      larger = second
    } else {
      smaller = second
      larger = first
    }

    if (smaller < min) {
      min = smaller
    }
    if (larger > max) {
      max = larger
    }

    index += 2
  }

  if (index < array.size) {
    val remaining = array[index]
    if (remaining < min) {
      min = remaining
    }
    if (remaining > max) {
      max = remaining
    }
  }

  return MinMax(min = min, max = max)
}

data class MinMax(val min: Int?, val max: Int?)
