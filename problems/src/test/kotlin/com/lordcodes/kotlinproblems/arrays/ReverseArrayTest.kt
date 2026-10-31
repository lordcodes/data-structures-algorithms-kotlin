package com.lordcodes.kotlinproblems.arrays

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertNotSame
import kotlin.test.assertSame

class ReverseArrayTest {
  @Test
  fun `reverses an empty array`() {
    assertContentEquals(emptyArray<Int>(), reverseArray(emptyArray<Int>()))
  }

  @Test
  fun `reverses a single element array`() {
    assertContentEquals(arrayOf(1), reverseArray(arrayOf(1)))
  }

  @Test
  fun `reverses an even number of elements without changing the original array`() {
    val original = arrayOf(1, 2, 3, 4)

    val reversed = reverseArray(original)

    assertContentEquals(arrayOf(4, 3, 2, 1), reversed)
    assertContentEquals(arrayOf(1, 2, 3, 4), original)
    assertNotSame(original, reversed)
  }

  @Test
  fun `returns a copy when inplace is false`() {
    val original = arrayOf(1, 2, 3)

    val reversed = reverseArray(original, inplace = false)

    assertContentEquals(arrayOf(3, 2, 1), reversed)
    assertContentEquals(arrayOf(1, 2, 3), original)
    assertNotSame(original, reversed)
  }

  @Test
  fun `reverses an even number of elements in place`() {
    val original = arrayOf(1, 2, 3, 4)

    val reversed = reverseArray(original, inplace = true)

    assertContentEquals(arrayOf(4, 3, 2, 1), original)
    assertSame(original, reversed)
  }

  @Test
  fun `reverses an odd number of elements in place preserving the middle element`() {
    val original = arrayOf(1, 2, 3, 4, 5)

    val reversed = reverseArray(original, inplace = true)

    assertContentEquals(arrayOf(5, 4, 3, 2, 1), original)
    assertSame(original, reversed)
  }

  @Test
  fun `reverses an empty array in place`() {
    val original = emptyArray<Int>()

    val reversed = reverseArray(original, inplace = true)

    assertContentEquals(emptyArray<Int>(), original)
    assertSame(original, reversed)
  }

  @Test
  fun `reverses a single element array in place`() {
    val original = arrayOf(1)

    val reversed = reverseArray(original, inplace = true)

    assertContentEquals(arrayOf(1), original)
    assertSame(original, reversed)
  }

  @Test
  fun `reverses an odd number of elements preserving duplicates and the middle element`() {
    assertContentEquals(
      arrayOf("b", "a", "c", "b", "a"),
      reverseArray(arrayOf("a", "b", "c", "a", "b"))
    )
  }

  @Test
  fun `preserves null elements`() {
    assertContentEquals(
      arrayOf(null, "b", null, "a"),
      reverseArray(arrayOf("a", null, "b", null))
    )
  }

  @Test
  fun `preserves references to generic elements`() {
    val first = Any()
    val second = Any()

    val reversed = reverseArray(arrayOf(first, second))

    assertSame(second, reversed[0])
    assertSame(first, reversed[1])
  }
}
