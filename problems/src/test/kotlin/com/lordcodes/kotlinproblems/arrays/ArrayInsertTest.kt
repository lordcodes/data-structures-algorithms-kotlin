package com.lordcodes.kotlinproblems.arrays

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ArrayInsertTest {
  @Test
  fun `inserts into an array with no elements in use`() {
    val array = arrayOf(0)

    val size = insertIntoArray(array, 0, 0, 5)

    assertEquals(1, size)
    assertContentEquals(arrayOf(5), array)
  }

  @Test
  fun `inserts at the beginning and shifts existing elements`() {
    val array = arrayOf(2, 3, 4, 0)

    val size = insertIntoArray(array, 3, 0, 1)

    assertEquals(4, size)
    assertContentEquals(arrayOf(1, 2, 3, 4), array)
  }

  @Test
  fun `inserts in the middle and preserves element order`() {
    val array = arrayOf(1, 3, 4, 0)

    val size = insertIntoArray(array, 3, 1, 2)

    assertEquals(4, size)
    assertContentEquals(arrayOf(1, 2, 3, 4), array)
  }

  @Test
  fun `inserts at the end when index equals size in use`() {
    val array = arrayOf(1, 2, 3, 0)

    val size = insertIntoArray(array, 3, 3, 4)

    assertEquals(4, size)
    assertContentEquals(arrayOf(1, 2, 3, 4), array)
  }

  @Test
  fun `inserts into an array with a single element in use`() {
    val array = arrayOf(5, 0)

    val size = insertIntoArray(array, 1, 0, 3)

    assertEquals(2, size)
    assertContentEquals(arrayOf(3, 5), array)
  }

  @Test
  fun `inserts generic values including duplicates`() {
    val array = arrayOf("a", "b", "c", "")

    val size = insertIntoArray(array, 3, 2, "b")

    assertEquals(4, size)
    assertContentEquals(arrayOf("a", "b", "b", "c"), array)
  }

  @Test
  fun `inserts null and preserves existing null values`() {
    val array = arrayOf(null, "a", "unused")

    val size = insertIntoArray(array, 2, 1, null)

    assertEquals(3, size)
    assertContentEquals(arrayOf(null, null, "a"), array)
  }

  @Test
  fun `updates the input array without changing capacity or remaining unused elements`() {
    val array = arrayOf(4, 1, 7, 99, 88, 77)

    val size = insertIntoArray(array, 3, 1, 9)

    assertEquals(4, size)
    assertEquals(6, array.size)
    assertContentEquals(arrayOf(4, 9, 1, 7, 88, 77), array)
  }

  @Test
  fun `rejects an empty backing array`() {
    assertFailsWith<IllegalArgumentException> {
      insertIntoArray(emptyArray<Int>(), 0, 0, 5)
    }
  }

  @Test
  fun `rejects a full backing array without modifying it`() {
    val array = arrayOf(1, 2, 3)

    assertFailsWith<IllegalArgumentException> {
      insertIntoArray(array, 3, 1, 4)
    }

    assertContentEquals(arrayOf(1, 2, 3), array)
  }

  @Test
  fun `rejects a negative insertion index without modifying the array`() {
    val array = arrayOf(1, 2, 0)

    assertFailsWith<IllegalArgumentException> {
      insertIntoArray(array, 2, -1, 3)
    }

    assertContentEquals(arrayOf(1, 2, 0), array)
  }

  @Test
  fun `rejects an insertion index beyond size in use without modifying the array`() {
    val array = arrayOf(1, 2, 0, 0)

    assertFailsWith<IllegalArgumentException> {
      insertIntoArray(array, 2, 3, 3)
    }

    assertContentEquals(arrayOf(1, 2, 0, 0), array)
  }
}
