package com.lordcodes.kotlinproblems.search

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BinarySearchTest {
  @Test
  fun `finds strings in natural order in different list implementations`() {
    val list = listOf("apple", "banana", "pear")

    assertEquals(0, binarySearch(list, "apple"))
    assertEquals(1, binarySearch(java.util.LinkedList(list), "banana"))
    assertEquals(2, binarySearch(list, "pear"))
    assertNull(binarySearch(list, "orange"))
  }

  @Test
  fun `matches custom comparable objects using comparison rather than equality`() {
    val list = listOf(Item(1, "a"), Item(2, "b"), Item(3, "c"))

    assertEquals(1, binarySearch(list, Item(2, "different name")))
    assertNull(binarySearch(list, Item(4, "d")))
  }

  @Test
  fun `returns null for an empty list`() {
    assertNull(binarySearch(listOf(), 5))
  }

  @Test
  fun `finds a matching single element`() {
    assertEquals(0, binarySearch(listOf(5), 5))
  }

  @Test
  fun `returns null for a non-matching single element`() {
    assertNull(binarySearch(listOf(5), 3))
    assertNull(binarySearch(listOf(5), 7))
  }

  @Test
  fun `finds either element in a two element list`() {
    val list = listOf(2, 6)

    assertEquals(0, binarySearch(list, 2))
    assertEquals(1, binarySearch(list, 6))
  }

  @Test
  fun `finds every value in an odd length list`() {
    val list = listOf(1, 3, 5, 7, 9, 11, 13)

    for (index in list.indices) {
      assertEquals(index, binarySearch(list, list[index]), "Searching for ${list[index]}")
    }
  }

  @Test
  fun `finds every value in an even length list`() {
    val list = listOf(1, 3, 5, 7, 9, 11)

    for (index in list.indices) {
      assertEquals(index, binarySearch(list, list[index]), "Searching for ${list[index]}")
    }
  }

  @Test
  fun `returns null for values below and above the list range`() {
    val list = listOf(2, 4, 6, 8)

    assertNull(binarySearch(list, 1))
    assertNull(binarySearch(list, 9))
  }

  @Test
  fun `returns null for gaps between sorted values`() {
    val list = listOf(2, 4, 6, 8)

    for (value in listOf(3, 5, 7)) {
      assertNull(binarySearch(list, value), "Searching for $value")
    }
  }

  @Test
  fun `finds negative values and zero`() {
    val list = listOf(-9, -5, -1, 0, 4, 8)

    assertEquals(0, binarySearch(list, -9))
    assertEquals(2, binarySearch(list, -1))
    assertEquals(3, binarySearch(list, 0))
  }

  @Test
  fun `finds integer limits without overflowing value comparisons`() {
    val list = listOf(Int.MIN_VALUE, -1, 0, 1, Int.MAX_VALUE)

    assertEquals(0, binarySearch(list, Int.MIN_VALUE))
    assertEquals(4, binarySearch(list, Int.MAX_VALUE))
    assertNull(binarySearch(list, Int.MIN_VALUE + 1))
    assertNull(binarySearch(list, Int.MAX_VALUE - 1))
  }

  @Test
  fun `returns any matching index when duplicates are present`() {
    val list = listOf(1, 1, 2, 3, 3, 3, 5, 5)

    for (value in listOf(1, 3, 5)) {
      val index = assertNotNull(binarySearch(list, value), "Searching for $value")
      assertTrue(index in list.indices)
      assertEquals(value, list[index])
    }
  }

  @Test
  fun `handles a list containing only one repeated value`() {
    val list = listOf(4, 4, 4, 4)

    val index = assertNotNull(binarySearch(list, 4))

    assertTrue(index in list.indices)
    assertEquals(4, list[index])
    assertNull(binarySearch(list, 3))
    assertNull(binarySearch(list, 5))
  }

  @Test
  fun `preserves the input for successful and unsuccessful searches`() {
    val list = mutableListOf(1, 3, 3, 7, 9)
    val expected = list.toList()

    binarySearch(list, 3)
    assertContentEquals(expected, list)

    binarySearch(list, 5)
    assertContentEquals(expected, list)
  }
  private data class Item(val rank: Int, val name: String) : Comparable<Item> {
    override fun compareTo(other: Item): Int = rank.compareTo(other.rank)
  }
}
