package com.lordcodes.kotlinproblems.sort

/**
 * Sorts [array] in place in ascending order using merge sort.
 * Preserves the original order of elements that compare as equal.
 * Time: O(n log n). Additional space: O(n).
 *
 * @param array the array to sort in place. Empty arrays and duplicate values are supported.
 */
fun mergeSort(array: IntArray) {
  val buffer = IntArray(array.size)
  mergeSort(array, buffer, 0, array.lastIndex)
}

private fun mergeSort(array: IntArray, buffer: IntArray, left: Int, right: Int) {
  if (left >= right) {
    return
  }

  val middle = left + (right - left) / 2

  mergeSort(array, buffer, left, middle)
  mergeSort(array, buffer, middle + 1, right)
  merge(array, buffer, left, middle, right)
}

private fun merge(array: IntArray, buffer: IntArray, left: Int, middle: Int, right: Int) {
  var writeIndex = left
  var leftIndex = left
  var rightIndex = middle + 1
  while (leftIndex <= middle && rightIndex <= right) {
    if (array[leftIndex] <= array[rightIndex]) {
      buffer[writeIndex] = array[leftIndex]
      leftIndex++
    } else {
      buffer[writeIndex] = array[rightIndex]
      rightIndex++
    }
    writeIndex++
  }
  while (leftIndex <= middle) {
    buffer[writeIndex] = array[leftIndex]
    leftIndex++
    writeIndex++
  }
  while (rightIndex <= right) {
    buffer[writeIndex] = array[rightIndex]
    rightIndex++
    writeIndex++
  }
  for (index in left..right) {
    array[index] = buffer[index]
  }
}

/**
 * Returns a new array sorted in ascending order using merge sort, leaving [array] unchanged.
 * Preserves the original order of elements that compare as equal.
 * Time: O(n log n). Additional space: O(n).
 *
 * @param array the unsorted array. Empty arrays and duplicate values are supported.
 * @return a new array containing every original element in sorted order, even for empty or sorted input.
 */
fun mergeSorted(array: IntArray): IntArray {
  if (array.size <= 1) {
    return array.copyOf()
  }
  val middle = array.size / 2
  val left = mergeSorted(array.copyOfRange(0, middle))
  val right = mergeSorted(array.copyOfRange(middle, array.size))
  return merged(left, right)
}

private fun merged(left: IntArray, right: IntArray): IntArray {
  val result = IntArray(left.size + right.size)
  var writeIndex = 0
  var leftIndex = 0
  var rightIndex = 0
  while (leftIndex < left.size && rightIndex < right.size) {
    if (left[leftIndex] <= right[rightIndex]) {
      result[writeIndex] = left[leftIndex]
      leftIndex++
    } else {
      result[writeIndex] = right[rightIndex]
      rightIndex++
    }
    writeIndex++
  }
  while (leftIndex < left.size) {
    result[writeIndex] = left[leftIndex]
    leftIndex++
    writeIndex++
  }
  while (rightIndex < right.size) {
    result[writeIndex] = right[rightIndex]
    rightIndex++
    writeIndex++
  }
  return result
}
