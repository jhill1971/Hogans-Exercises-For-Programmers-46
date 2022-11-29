// Exercises For Programmers by Brian P. Hogan
// Exercise 46: Word Frequency Finder
// James Hill, Houston, Texas, 2022
// GitHub: jhill1971 Twitter: @count_BASIC

/**
 * Create a program that reads in a file and counts the frequency of words in the file. Then, construct a histogram
 * displaying the words and frequency. Display the histogram to console.
 */

import java.io.File

fun main(args: Array<String>) {
    val file =
        File("C:\\Users\\ikon1\\IdeaProjects\\Exercise46\\src\\main\\resources\\words.txt").readText().lowercase()
    /* A regular expression that matches any lowercase word. */
    val r = Regex("""\p{javaLowerCase}+""")
    /* Finding all the matches in the file. */
    val matches = r.findAll(file)
    /* A chain of operations that are applied to the `matches` object. */
    val wordGroups = matches.map { it.value }
        .groupBy { it }
        .map { Pair(it.key, it.value.size) }
        .sortedByDescending { it.second }
        .take(10)

    /* This is a for loop that iterates over the `wordGroups` object. The `wordGroups` object is a list of pairs.
    The first element of the pair is the word and the second element is the number of times the word appears in the
    file.The for loop iterates over the list of pairs and prints the word and the number of times it appears in the file. */
    for ((x, y) in wordGroups) {
        var hist = "*".repeat(y)
        System.out.format("%-15s%-2s", "$x : ", "${hist}\n")
    }
}