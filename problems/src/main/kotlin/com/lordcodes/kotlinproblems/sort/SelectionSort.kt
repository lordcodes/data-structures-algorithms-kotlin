package com.lordcodes.kotlinproblems.sort

/**
 * Returns the elements of [array] sorted in ascending order using selection sort.
 * Time: O(n²) in all cases. Additional space: O(1).
 *
 * @param array the array to sort. Empty arrays and duplicate values are supported; the input may be modified.
 * @return an array containing every original element in sorted order.
 */
fun selectionSort(array: IntArray): IntArray {
  for (index in 0 until array.size - 1) {
    var minIndex = index
    for (compareIndex in index + 1 until array.size) {
      if (array[compareIndex] < array[minIndex]) {
        minIndex = compareIndex
      }
    }
    if (minIndex != index) {
      val temp = array[index]
      array[index] = array[minIndex]
      array[minIndex] = temp
    }
  }
  return array
}
