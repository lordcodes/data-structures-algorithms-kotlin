package com.lordcodes.kotlinproblems.arrays

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotSame

class ArrayInsertTest {
  @Test
  fun `inserts into an empty array`() {
    assertContentEquals(arrayOf(5), insertIntoArray(emptyArray<Int>(), 0, 5))
  }

  @Test
  fun `inserts at the beginning and shifts existing elements`() {
    assertContentEquals(arrayOf(1, 2, 3, 4), insertIntoArray(arrayOf(2, 3, 4), 0, 1))
  }

  @Test
  fun `inserts in the middle and preserves element order`() {
    assertContentEquals(arrayOf(1, 2, 3, 4), insertIntoArray(arrayOf(1, 3, 4), 1, 2))
  }

  @Test
  fun `inserts at the end when index equals array size`() {
    assertContentEquals(arrayOf(1, 2, 3, 4), insertIntoArray(arrayOf(1, 2, 3), 3, 4))
  }

  @Test
  fun `inserts into a single element array`() {
    assertContentEquals(arrayOf(3, 5), insertIntoArray(arrayOf(5), 0, 3))
  }

  @Test
  fun `inserts generic values including duplicates`() {
    assertContentEquals(
      arrayOf("a", "b", "b", "c"),
      insertIntoArray(arrayOf("a", "b", "c"), 2, "b"),
    )
  }

  @Test
  fun `inserts null and preserves existing null values`() {
    val expected = arrayOf(null, null, "a")
    val input = arrayOf(null, "a")

    val result = insertIntoArray(input, 1, null)

    assertContentEquals(expected, result)
  }

  @Test
  fun `returns a new array one element larger and preserves the input array`() {
    val original = arrayOf(4, 1, 7)
    val expected = original.copyOf()

    val result = insertIntoArray(original, 1, 9)

    assertNotSame(original, result)
    assertEquals(original.size + 1, result.size)
    assertContentEquals(expected, original)
    assertContentEquals(arrayOf(4, 9, 1, 7), result)
  }
}
