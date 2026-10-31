package com.lordcodes.kotlinproblems.arrays

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class ArrayMinMaxTest {
  @Test
  fun `returns null minimum and maximum for an empty array`() {
    assertEquals(MinMax(null, null), findMinMax(intArrayOf()))
  }

  @Test
  fun `returns the single element as both minimum and maximum`() {
    assertEquals(MinMax(5, 5), findMinMax(intArrayOf(5)))
  }

  @Test
  fun `finds minimum and maximum in an unsorted array`() {
    assertEquals(MinMax(1, 9), findMinMax(intArrayOf(4, 1, 7, 9, 3)))
  }

  @Test
  fun `finds minimum and maximum in an ascending array`() {
    assertEquals(MinMax(1, 5), findMinMax(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun `finds minimum and maximum in a descending array`() {
    assertEquals(MinMax(1, 5), findMinMax(intArrayOf(5, 4, 3, 2, 1)))
  }

  @Test
  fun `finds minimum and maximum among negative values`() {
    assertEquals(MinMax(-9, -1), findMinMax(intArrayOf(-4, -1, -9, -3)))
  }

  @Test
  fun `finds minimum and maximum among positive negative and zero values`() {
    assertEquals(MinMax(-5, 8), findMinMax(intArrayOf(0, -5, 8, -2, 3)))
  }

  @Test
  fun `returns the repeated value as both minimum and maximum`() {
    assertEquals(MinMax(0, 0), findMinMax(intArrayOf(0, 0, 0)))
  }

  @Test
  fun `handles duplicate minimum and maximum values`() {
    assertEquals(MinMax(-2, 7), findMinMax(intArrayOf(7, -2, 3, -2, 7)))
  }

  @Test
  fun `handles integer limits`() {
    assertEquals(MinMax(Int.MIN_VALUE, Int.MAX_VALUE), findMinMax(intArrayOf(Int.MAX_VALUE, 0, Int.MIN_VALUE)))
  }

  @Test
  fun `preserves the input array`() {
    val original = intArrayOf(4, 1, 7, 9, 3)
    val expected = original.copyOf()

    findMinMax(original)

    assertContentEquals(expected, original)
  }
}
