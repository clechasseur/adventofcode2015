package io.github.clechasseur.adventofcode.y2015

import kotlin.test.Test
import kotlin.test.assertEquals

class AdventOfCode2015 {
    class Day1Puzzles {
        @Test
        fun `day 1, part 1`() {
            assertEquals(138, Day1.part1())
        }

        @Test
        fun `day 1, part 2`() {
            assertEquals(0, Day1.part2())
        }
    }

    class Day2Puzzles {
        @Test
        fun `day 2, part 1`() {
            assertEquals(1588178, Day2.part1())
        }

        @Test
        fun `day 2, part 2`() {
            assertEquals(3783758, Day2.part2())
        }
    }

    class Day3Puzzles {
        @Test
        fun `day 3, part 1`() {
            assertEquals(2592, Day3.part1())
        }

        @Test
        fun `day 3, part 2`() {
            assertEquals(2360, Day3.part2())
        }
    }

    class Day4Puzzles {
        @Test
        fun `day 4, part 1`() {
            assertEquals(282749, Day4.part1())
        }

        @Test
        fun `day 4, part 2`() {
            assertEquals(9962624, Day4.part2())
        }
    }
}
