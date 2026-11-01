package com.lordcodes.kotlinproblems.sort

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertContentEquals

class InsertionSortTest {
  @Test
  fun `handles an empty array`() {
    assertContentEquals(intArrayOf(), insertionSort(intArrayOf()))
  }

  @Test
  fun `preserves a single element`() {
    assertContentEquals(intArrayOf(5), insertionSort(intArrayOf(5)))
  }

  @Test
  fun `sorts two reversed elements`() {
    assertContentEquals(intArrayOf(1, 2), insertionSort(intArrayOf(2, 1)))
  }

  @Test
  fun `preserves an already sorted array`() {
    assertContentEquals(intArrayOf(1, 2, 3, 4, 5), insertionSort(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun `sorts a descending array`() {
    assertContentEquals(intArrayOf(1, 2, 3, 4, 5), insertionSort(intArrayOf(5, 4, 3, 2, 1)))
  }

  @Test
  fun `sorts an unsorted odd length array`() {
    assertContentEquals(intArrayOf(1, 2, 3, 4, 5), insertionSort(intArrayOf(4, 1, 5, 2, 3)))
  }

  @Test
  fun `sorts an unsorted even length array`() {
    assertContentEquals(intArrayOf(1, 2, 3, 4, 5, 6), insertionSort(intArrayOf(6, 2, 5, 1, 4, 3)))
  }

  @Test
  fun `preserves repeated equal values`() {
    assertContentEquals(intArrayOf(3, 3, 3, 3), insertionSort(intArrayOf(3, 3, 3, 3)))
  }

  @Test
  fun `sorts duplicates without losing elements`() {
    assertContentEquals(intArrayOf(1, 1, 2, 3, 3, 3), insertionSort(intArrayOf(3, 1, 3, 2, 1, 3)))
  }

  @Test
  fun `sorts negative values and zero`() {
    assertContentEquals(intArrayOf(-3, -3, -1, 0, 0, 2), insertionSort(intArrayOf(0, -3, 2, -1, 0, -3)))
  }

  @Test
  fun `sorts integer limits without overflowing comparisons`() {
    val array = intArrayOf(Int.MAX_VALUE, 0, Int.MIN_VALUE, -1, Int.MAX_VALUE)
    val expected = intArrayOf(Int.MIN_VALUE, -1, 0, Int.MAX_VALUE, Int.MAX_VALUE)

    assertContentEquals(expected, insertionSort(array))
  }

  @Test
  fun `matches the standard sort for varied deterministic inputs`() {
    val random = Random(42)

    repeat(50) { iteration ->
      val array = IntArray(iteration) { random.nextInt(-20, 21) }
      val expected = array.sortedArray()

      assertContentEquals(expected, insertionSort(array), "Input length $iteration")
    }
  }
}
