package com.lordcodes.kotlinproblems.sort

import kotlin.random.Random

/**
 * Returns the elements of [array] sorted in ascending order using quick sort.
 * Time: O(n log n) on average, O(n²) worst case.
 * Additional space: O(log n) on average, O(n) worst case for the recursion stack.
 *
 * @param array the array to sort. Empty arrays and duplicate values are supported; the input may be modified.
 * @return an array containing every original element in sorted order.
 */
fun quickSort(array: IntArray): IntArray {
  quickSort(array, low = 0, high = array.lastIndex)
  return array
}

private fun quickSort(array: IntArray, low: Int, high: Int) {
  if (low >= high) {
    return
  }
  val pivotIndex = partition(array, low, high)
  quickSort(array, low, pivotIndex - 1)
  quickSort(array, pivotIndex + 1, high)
}

private fun partition(array: IntArray, low: Int, high: Int): Int {
  val randomIndex = Random.nextInt(low, high + 1)
  val pivotTemp = array[randomIndex]
  array[randomIndex] = array[high]
  array[high] = pivotTemp

  val pivot = array[high]
  var write = low
  for (read in low until high) {
    if (array[read] < pivot) {
      val temp = array[write]
      array[write] = array[read]
      write++
      array[read] = temp
    }
  }
  val temp = array[write]
  array[write] = array[high]
  array[high] = temp
  return write
}
