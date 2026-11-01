package com.lordcodes.kotlinproblems.sort

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertNotSame

class MergeSortTest {
  @Test
  fun `handles an empty array`() {
    assertMergeSorts(intArrayOf(), intArrayOf())
  }

  @Test
  fun `preserves a single element`() {
    assertMergeSorts(intArrayOf(5), intArrayOf(5))
  }

  @Test
  fun `sorts two reversed elements`() {
    assertMergeSorts(intArrayOf(1, 2), intArrayOf(2, 1))
  }

  @Test
  fun `preserves an already sorted array`() {
    assertMergeSorts(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5))
  }

  @Test
  fun `sorts a descending array`() {
    assertMergeSorts(intArrayOf(1, 2, 3, 4, 5), intArrayOf(5, 4, 3, 2, 1))
  }

  @Test
  fun `sorts an unsorted odd length array`() {
    assertMergeSorts(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 1, 5, 2, 3))
  }

  @Test
  fun `sorts an unsorted even length array`() {
    assertMergeSorts(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(6, 2, 5, 1, 4, 3))
  }

  @Test
  fun `preserves repeated equal values`() {
    assertMergeSorts(intArrayOf(3, 3, 3, 3), intArrayOf(3, 3, 3, 3))
  }

  @Test
  fun `sorts duplicates without losing elements`() {
    assertMergeSorts(intArrayOf(1, 1, 2, 3, 3, 3), intArrayOf(3, 1, 3, 2, 1, 3))
  }

  @Test
  fun `sorts negative values and zero`() {
    assertMergeSorts(intArrayOf(-3, -3, -1, 0, 0, 2), intArrayOf(0, -3, 2, -1, 0, -3))
  }

  @Test
  fun `sorts integer limits without overflowing comparisons`() {
    val array = intArrayOf(Int.MAX_VALUE, 0, Int.MIN_VALUE, -1, Int.MAX_VALUE)
    val expected = intArrayOf(Int.MIN_VALUE, -1, 0, Int.MAX_VALUE, Int.MAX_VALUE)

    assertMergeSorts(expected, array)
  }

  @Test
  fun `matches the standard sort for varied deterministic inputs`() {
    val random = Random(42)

    repeat(50) { iteration ->
      val array = IntArray(iteration) { random.nextInt(-20, 21) }
      val expected = array.sortedArray()

      assertMergeSorts(expected, array, "Input length $iteration")
    }
  }

  private fun assertMergeSorts(expected: IntArray, input: IntArray, message: String? = null) {
    val original = input.copyOf()
    val inPlace = input.copyOf()
    val copyInput = input.copyOf()

    mergeSort(inPlace)
    val sortedCopy = mergeSorted(copyInput)

    assertNotSame(copyInput, sortedCopy, "mergeSortedArray must return a new array")
    assertContentEquals(original, copyInput, "mergeSortedArray must preserve its input")
    assertContentEquals(expected, inPlace, "mergeSort: ${message.orEmpty()}")
    assertContentEquals(expected, sortedCopy, "mergeSortedArray: ${message.orEmpty()}")
  }
}
