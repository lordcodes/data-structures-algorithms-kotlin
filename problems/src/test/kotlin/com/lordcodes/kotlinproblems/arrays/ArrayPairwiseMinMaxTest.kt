package com.lordcodes.kotlinproblems.arrays

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class ArrayPairwiseMinMaxTest {
  @Test
  fun `returns null minimum and maximum for an empty array`() {
    assertEquals(MinMax(null, null), findPairwiseMinMax(intArrayOf()))
  }

  @Test
  fun `returns the single element as both minimum and maximum`() {
    assertEquals(MinMax(5, 5), findPairwiseMinMax(intArrayOf(5)))
  }

  @Test
  fun `finds minimum and maximum in two ascending elements`() {
    assertEquals(MinMax(1, 9), findPairwiseMinMax(intArrayOf(1, 9)))
  }

  @Test
  fun `finds minimum and maximum in two descending elements`() {
    assertEquals(MinMax(1, 9), findPairwiseMinMax(intArrayOf(9, 1)))
  }

  @Test
  fun `finds minimum and maximum in pairs of either order`() {
    assertEquals(MinMax(-8, 9), findPairwiseMinMax(intArrayOf(0, -3, 7, 9, -8)))
  }

  @Test
  fun `finds a minimum in the remaining element`() {
    assertEquals(MinMax(-9, 7), findPairwiseMinMax(intArrayOf(0, 7, -3, -9)))
  }

  @Test
  fun `finds a maximum in the remaining element`() {
    assertEquals(MinMax(-3, 9), findPairwiseMinMax(intArrayOf(0, 7, -3, 9)))
  }

  @Test
  fun `keeps extrema when the remaining element is between them`() {
    assertEquals(MinMax(-3, 7), findPairwiseMinMax(intArrayOf(0, 7, -3, 2)))
  }

  @Test
  fun `preserves the first element as the minimum`() {
    assertEquals(MinMax(1, 5), findPairwiseMinMax(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun `preserves the first element as the maximum`() {
    assertEquals(MinMax(1, 5), findPairwiseMinMax(intArrayOf(5, 4, 3, 2, 1)))
  }

  @Test
  fun `finds minimum and maximum among negative values`() {
    assertEquals(MinMax(-9, -1), findPairwiseMinMax(intArrayOf(-4, -1, -9, -3)))
  }

  @Test
  fun `returns the repeated value as both minimum and maximum`() {
    assertEquals(MinMax(0, 0), findPairwiseMinMax(intArrayOf(0, 0, 0, 0)))
  }

  @Test
  fun `handles duplicate minimum and maximum values`() {
    assertEquals(MinMax(-2, 7), findPairwiseMinMax(intArrayOf(7, -2, 3, -2, 7)))
  }

  @Test
  fun `handles integer limits`() {
    assertEquals(
      MinMax(Int.MIN_VALUE, Int.MAX_VALUE),
      findPairwiseMinMax(intArrayOf(0, Int.MAX_VALUE, Int.MIN_VALUE)),
    )
  }

  @Test
  fun `preserves the input array`() {
    val original = intArrayOf(4, 1, 7, 9, 3, -2)
    val expected = original.copyOf()

    findPairwiseMinMax(original)

    assertContentEquals(expected, original)
  }
}
