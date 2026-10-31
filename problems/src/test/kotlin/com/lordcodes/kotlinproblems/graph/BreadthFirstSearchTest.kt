package com.lordcodes.kotlinproblems.graph

import kotlin.test.Test
import kotlin.test.assertEquals

class BreadthFirstSearchTest {
    @Test
    fun `visits by level in neighbor order`() {
        val graph = mapOf(1 to listOf(2, 3), 2 to listOf(4, 5), 3 to listOf(6))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), breadthFirstSearch(graph, 1))
    }

    @Test
    fun `visits cycles self loops and shared neighbors only once`() {
        val graph = mapOf(1 to listOf(1, 2, 2, 3), 2 to listOf(1, 4), 3 to listOf(4), 4 to listOf(2))
        assertEquals(listOf(1, 2, 3, 4), breadthFirstSearch(graph, 1))
    }

    @Test
    fun `does not visit disconnected vertices`() {
        assertEquals(listOf(1, 2), breadthFirstSearch(mapOf(1 to listOf(2), 3 to listOf(4)), 1))
    }

    @Test
    fun `start without outgoing edges is still visited`() {
        assertEquals(listOf("A"), breadthFirstSearch(emptyMap(), "A"))
    }
}
