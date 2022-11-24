package io.github.clechasseur.adventofcode.y2015

import io.github.clechasseur.adventofcode.y2015.data.Day19Data

object Day19 {
    private val transforms = Day19Data.transforms
    private const val molecule = Day19Data.molecule

    private val transformRegex = """^(\w+) => (\w+)$""".toRegex()

    fun part1(): Int = transforms.toTransformMap().allTransforms(molecule).distinct().size

    fun part2(): Int = transforms.toTransformMap().moleculeSequence().takeWhile { !it.contains(molecule) }.count() + 1

    private fun String.toTransformMap(): Map<Regex, List<String>> = lines().map { line ->
        val match = transformRegex.matchEntire(line) ?: error("Wrong transform: $line")
        match.groupValues[1] to match.groupValues[2]
    }.fold(mutableMapOf<Regex, MutableList<String>>()) { acc, (from, to) ->
        acc.computeIfAbsent(from.toRegex()) { mutableListOf() }.add(to)
        acc
    }

    private fun Map<Regex, List<String>>.allTransforms(mol: String): List<String> = flatMap { (from, toList) ->
        toList.flatMap { to ->
            from.findAll(mol).map { match ->
                mol.substring(0, match.range.first) + to + mol.substring(match.range.last + 1, mol.length)
            }
        }
    }

    private fun Map<Regex, List<String>>.moleculeSequence(): Sequence<List<String>> = generateSequence(listOf("e")) { l ->
        l.flatMap { allTransforms(it) }.distinct()
    }
}
