package com.lordcodes.kotlinproblems.strings

/**
 * Returns the longest contiguous substring of [text] containing no repeated characters.
 * Time: O(n) on average. Additional space: O(k), where k is the number of distinct characters in [text],
 * excluding the returned substring.
 *
 * @param text the string to search. Characters are case-sensitive Kotlin Char values (UTF-16 code units).
 * @return the first longest substring if lengths tie, or an empty string if [text] is empty.
 */
fun longestSubstringWithoutRepeatingCharacters(text: String): String {
  val windowCharacters = mutableSetOf<Char>()
  var windowStart = 0
  var bestStart = 0
  var bestLength = 0

  for (windowEnd in text.indices) {
    val character = text[windowEnd]

    // Shrink from the left until the new character can be added without a repeat.
    while (character in windowCharacters) {
      windowCharacters.remove(text[windowStart])
      windowStart++
    }
    windowCharacters.add(character)

    // The window now contains only unique characters. Keep the first window when lengths tie.
    val windowLength = windowEnd - windowStart + 1
    if (windowLength > bestLength) {
      bestStart = windowStart
      bestLength = windowLength
    }
  }

  // Each character enters and leaves the window at most once; only copy the winning substring.
  return text.substring(bestStart, bestStart + bestLength)
}
