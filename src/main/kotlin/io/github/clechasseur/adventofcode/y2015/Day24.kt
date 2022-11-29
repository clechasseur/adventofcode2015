package io.github.clechasseur.adventofcode.y2015

import io.github.clechasseur.adventofcode.y2015.data.Day24Data

object Day24 {
    private val input = Day24Data.input

    fun part1(): Int = configurations().filter { it.sameWeight }.sortedBy {
        it[0].weight * 100_000 + it[0].quantumEntanglement
    }.first()[0].quantumEntanglement

    private fun idxSequence(size: Int): Sequence<List<Int>> = if (size == 1) {
        (0..2).asSequence().map { i -> listOf(i) }
    } else {
        idxSequence(size - 1).flatMap { tail ->
            (0..2).asSequence().map { i -> listOf(i) + tail }
        }
    }

    private fun configurations(): Sequence<List<List<Int>>> = idxSequence(input.size).map { idxS ->
        val groups = listOf(
            mutableListOf<Int>(),
            mutableListOf(),
            mutableListOf(),
        )
        idxS.forEachIndexed { i, idx -> groups[idx].add(input[i]) }
        groups
    }

    private val List<Int>.weight: Int
        get() = sum()

    private val List<Int>.quantumEntanglement: Int
        get() = reduce { acc, i -> acc * i }

    private val List<List<Int>>.sameWeight: Boolean
        get() = if (isEmpty()) true else {
            val firstWeight = this[0].weight
            all { it.weight == firstWeight }
        }
}
