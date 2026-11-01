package com.lordcodes.kotlinproblems.sort

/**
 * Returns the elements of [array] sorted in ascending order using insertion sort.
 * Preserves the original order of elements that compare as equal.
 * T: O(n) best case, O(n²) average and worst case. Additional space: O(1).
 *
 * @param array the array to sort. Empty arrays and duplicate values are supported; the input may be modified.
 * @return an array containing every original element in sorted order.
 */
fun insertionSort(array: IntArray): IntArray {
  if (array.size < 2) {
    return array
  }
  for (index in 1 until array.size) {
    val insertValue = array[index]
    var insertIndex = index - 1
    while (insertIndex >= 0 && array[insertIndex] > insertValue) {
      array[insertIndex + 1] = array[insertIndex]
      insertIndex--
    }
    array[insertIndex + 1] = insertValue
  }
  return array
}
