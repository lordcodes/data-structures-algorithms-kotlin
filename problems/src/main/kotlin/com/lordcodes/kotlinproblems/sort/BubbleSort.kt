package com.lordcodes.kotlinproblems.sort

/**
 * Returns the elements of [array] sorted in ascending order using bubble sort.
 * Preserves the original order of elements that compare as equal.
 * Time: O(n) best case with early exit, O(n²) average and worst case. Additional space: O(1).
 *
 * @param array the array to sort. Empty arrays and duplicate values are supported; the input may be modified.
 * @return an array containing every original element in sorted order.
 */
fun bubbleSort(array: IntArray): IntArray {
  if (array.size < 2) {
    return array
  }
  for (i in 0 until array.size - 1) {
    var swapped = false
    for (j in 0 until array.size - 1 - i) {
      if (array[j] > array[j + 1]) {
        val temp = array[j]
        array[j] = array[j + 1]
        array[j + 1] = temp
        swapped = true
      }
    }
    if (!swapped) {
      break
    }
  }
  return array
}
