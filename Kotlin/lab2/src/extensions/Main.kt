package extensions

import com.sun.org.apache.xerces.internal.xs.StringList

fun main(){
    val name = "Will Smith"
    println(name.monogram())

    val listOfStrings = listOf("apple", "pear", "strawberry", "melon")
    val joined = listOfStrings.joinThem("#")
    println(joined)

    val longest = listOfStrings.longestOf()
    println(longest)
}


fun String.monogram() : String = this.split(" ").map{ it.first() }.joinToString ("")

fun List<String>.joinThem(sep : String) : String = this.joinToString(sep){it}

fun List<String>.longestOf() : String = this.stream().max(Comparator.comparingInt(String::length)).get();