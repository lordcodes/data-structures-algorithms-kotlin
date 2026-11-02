package com.lordcodes.kotlinproblems.strings

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestSubstringWithoutRepeatingCharactersTest {
  @Test
  fun `returns an empty string for empty input`() {
    assertEquals("", longestSubstringWithoutRepeatingCharacters(""))
  }

  @Test
  fun `returns a single character`() {
    assertEquals("a", longestSubstringWithoutRepeatingCharacters("a"))
  }

  @Test
  fun `returns the whole string when every character is unique`() {
    assertEquals("abcde", longestSubstringWithoutRepeatingCharacters("abcde"))
  }

  @Test
  fun `returns one character when all characters repeat`() {
    assertEquals("b", longestSubstringWithoutRepeatingCharacters("bbbbb"))
  }

  @Test
  fun `keeps the first longest substring when lengths tie`() {
    assertEquals("abc", longestSubstringWithoutRepeatingCharacters("abcabcbb"))
  }

  @Test
  fun `returns a contiguous substring rather than a subsequence`() {
    assertEquals("wke", longestSubstringWithoutRepeatingCharacters("pwwkew"))
  }

  @Test
  fun `shrinks past all characters before the duplicate`() {
    assertEquals("ab", longestSubstringWithoutRepeatingCharacters("abba"))
  }

  @Test
  fun `retains useful characters when a duplicate is found`() {
    assertEquals("vdf", longestSubstringWithoutRepeatingCharacters("dvdf"))
  }

  @Test
  fun `finds the longest window at the end after repeated characters`() {
    assertEquals("mzuxt", longestSubstringWithoutRepeatingCharacters("tmmzuxt"))
  }

  @Test
  fun `treats upper and lower case as distinct characters`() {
    assertEquals("aAbB", longestSubstringWithoutRepeatingCharacters("aAbBa"))
  }

  @Test
  fun `treats whitespace and punctuation as characters`() {
    assertEquals("a b", longestSubstringWithoutRepeatingCharacters("a b a"))
    assertEquals(" ", longestSubstringWithoutRepeatingCharacters("   "))
    assertEquals("a!b", longestSubstringWithoutRepeatingCharacters("a!b!c"))
  }

  @Test
  fun `supports non-ASCII characters`() {
    assertEquals("é你ß", longestSubstringWithoutRepeatingCharacters("é你ßé"))
  }
}
