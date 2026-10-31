package com.lordcodes.kotlinproblems.arrays

import kotlin.test.Test
import kotlin.test.assertContentEquals

class ArrayMoveZeroesTest {
  @Test
  fun `handles an empty array`() {
    val array = intArrayOf()

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(), array)
  }

  @Test
  fun `preserves a single zero`() {
    val array = intArrayOf(0)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(0), array)
  }

  @Test
  fun `preserves a single non-zero element`() {
    val array = intArrayOf(5)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(5), array)
  }

  @Test
  fun `preserves an array containing only zeroes`() {
    val array = intArrayOf(0, 0, 0, 0)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(0, 0, 0, 0), array)
  }

  @Test
  fun `preserves an array without zeroes`() {
    val array = intArrayOf(3, 1, 4, 2)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(3, 1, 4, 2), array)
  }

  @Test
  fun `moves leading zeroes to the end`() {
    val array = intArrayOf(0, 0, 0, 1, 2)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(1, 2, 0, 0, 0), array)
  }

  @Test
  fun `preserves zeroes already at the end`() {
    val array = intArrayOf(1, 2, 0, 0, 0)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(1, 2, 0, 0, 0), array)
  }

  @Test
  fun `moves consecutive zeroes from the middle to the end`() {
    val array = intArrayOf(1, 0, 0, 0, 2)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(1, 2, 0, 0, 0), array)
  }

  @Test
  fun `moves alternating zeroes while preserving non-zero order`() {
    val array = intArrayOf(0, 3, 0, 1, 0, 2)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(3, 1, 2, 0, 0, 0), array)
  }

  @Test
  fun `preserves negative values duplicates and integer limits`() {
    val array = intArrayOf(0, Int.MIN_VALUE, -2, 0, -2, Int.MAX_VALUE, 0)

    arrayMoveZeroes(array)

    assertContentEquals(intArrayOf(Int.MIN_VALUE, -2, -2, Int.MAX_VALUE, 0, 0, 0), array)
  }
}
