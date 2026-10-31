package com.lordcodes.kotlinproblems.arrays

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class ArrayRemoveTest {
  @Test
  fun `returns zero for an empty array`() {
    assertEquals(0, removeFromArray(emptyArray<Int>(), 5))
  }

  @Test
  fun `preserves all elements when the value is absent`() {
    val array = arrayOf(1, 2, 3)

    val size = removeFromArray(array, 4)

    assertEquals(3, size)
    assertContentEquals(arrayOf(1, 2, 3), array)
  }

  @Test
  fun `removes a matching single element`() {
    assertEquals(0, removeFromArray(arrayOf(5), 5))
  }

  @Test
  fun `returns zero when every element matches`() {
    assertEquals(0, removeFromArray(arrayOf(5, 5, 5), 5))
  }

  @Test
  fun `removes a value from the beginning`() {
    val array = arrayOf(1, 2, 3)

    val size = removeFromArray(array, 1)

    assertEquals(2, size)
    assertContentEquals(arrayOf(2, 3), array.sliceArray(0 until size))
  }

  @Test
  fun `removes a value from the middle`() {
    val array = arrayOf(1, 2, 3)

    val size = removeFromArray(array, 2)

    assertEquals(2, size)
    assertContentEquals(arrayOf(1, 3), array.sliceArray(0 until size))
  }

  @Test
  fun `removes a value from the end`() {
    val array = arrayOf(1, 2, 3)

    val size = removeFromArray(array, 3)

    assertEquals(2, size)
    assertContentEquals(arrayOf(1, 2), array.sliceArray(0 until size))
  }

  @Test
  fun `removes consecutive and separated occurrences while preserving retained duplicates`() {
    val array = arrayOf(2, 2, 1, 3, 2, 1, 2)

    val size = removeFromArray(array, 2)

    assertEquals(3, size)
    assertEquals(7, array.size)
    assertContentEquals(arrayOf(1, 3, 1), array.sliceArray(0 until size))
  }

  @Test
  fun `removes generic values using equality`() {
    val array = arrayOf(listOf(1), listOf(2), listOf(1), listOf(3))

    val size = removeFromArray(array, listOf(1))

    assertEquals(2, size)
    assertContentEquals(arrayOf(listOf(2), listOf(3)), array.sliceArray(0 until size))
  }

  @Test
  fun `removes null values`() {
    val array = arrayOf(null, "a", null, "b", null)

    val size = removeFromArray(array, null)

    assertEquals(2, size)
    assertContentEquals(arrayOf("a", "b"), array.sliceArray(0 until size))
  }

  @Test
  fun `preserves null values when removing another value`() {
    val array = arrayOf("a", null, "b", "a", null)

    val size = removeFromArray(array, "a")

    assertEquals(3, size)
    assertContentEquals(arrayOf(null, "b", null), array.sliceArray(0 until size))
  }
}
