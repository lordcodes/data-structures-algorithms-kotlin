package com.lordcodes.kotlinproblems.search

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNull

class LinearSearchTest {
  @Test
  fun `finds strings in different list implementations`() {
    assertEquals(1, linearSearch(listOf("pear", "apple", "banana"), "apple"))
    assertEquals(2, linearSearch(java.util.LinkedList(listOf("pear", "apple", "banana")), "banana"))
    assertNull(linearSearch(listOf("pear", "apple"), "orange"))
  }

  @Test
  fun `finds non-comparable objects using equality`() {
    val list = listOf(Item("a"), Item("b"), Item("a"))

    assertEquals(0, linearSearch(list, Item("a")))
    assertEquals(1, linearSearch(list, Item("b")))
    assertNull(linearSearch(list, Item("c")))
  }

  @Test
  fun `finds null and non-null values in a nullable list`() {
    val list = listOf(null, "a", null, "b")

    assertEquals(0, linearSearch(list, null))
    assertEquals(3, linearSearch(list, "b"))
    assertNull(linearSearch(listOf("a", "b"), null))
  }

  @Test
  fun `returns null for an empty list`() {
    assertNull(linearSearch(listOf(), 5))
  }

  @Test
  fun `finds a matching single element`() {
    assertEquals(0, linearSearch(listOf(5), 5))
  }

  @Test
  fun `returns null for a non-matching single element`() {
    assertNull(linearSearch(listOf(5), 3))
  }

  @Test
  fun `finds the first element`() {
    assertEquals(0, linearSearch(listOf(7, 2, 9, 1), 7))
  }

  @Test
  fun `finds a middle element in an unsorted list`() {
    assertEquals(2, linearSearch(listOf(7, 2, 9, 1, 4), 9))
  }

  @Test
  fun `finds the last element`() {
    assertEquals(3, linearSearch(listOf(7, 2, 9, 1), 1))
  }

  @Test
  fun `returns null when the value is absent`() {
    assertNull(linearSearch(listOf(7, 2, 9, 1), 5))
  }

  @Test
  fun `returns the first index among separated duplicates`() {
    assertEquals(1, linearSearch(listOf(8, 3, 6, 3, 3), 3))
  }

  @Test
  fun `returns zero when every element matches`() {
    assertEquals(0, linearSearch(listOf(4, 4, 4, 4), 4))
  }

  @Test
  fun `finds negative values and zero`() {
    val list = listOf(3, -7, 0, -2)

    assertEquals(1, linearSearch(list, -7))
    assertEquals(2, linearSearch(list, 0))
  }

  @Test
  fun `finds integer limits`() {
    val list = listOf(0, Int.MAX_VALUE, -1, Int.MIN_VALUE)

    assertEquals(1, linearSearch(list, Int.MAX_VALUE))
    assertEquals(3, linearSearch(list, Int.MIN_VALUE))
  }

  @Test
  fun `finds a value in a descending list`() {
    assertEquals(3, linearSearch(listOf(9, 7, 5, 3, 1), 3))
  }

  @Test
  fun `preserves the input for successful and unsuccessful searches`() {
    val list = mutableListOf(4, 1, 7, 1, 3)
    val expected = list.toList()

    linearSearch(list, 1)
    assertContentEquals(expected, list)

    linearSearch(list, 9)
    assertContentEquals(expected, list)
  }
  private data class Item(val name: String)
}
