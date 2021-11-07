package com.example.quizapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import main.Question

object FakeRepository {

    var questions: MutableList<String> = mutableListOf(
        "Who developed Kotlin?",
        "Which extension is responsible to save Kotlin files?",
        "How to do a multi-line comment in Kotlin language?",
        "The two types of constructors in Kotlin are?",
        "What handles null exception in Kotlin?",
        "The correct function to get the length of a string in Kotlin is?",
        "In Kotlin the default visibility operator is?",
        "What defines sealed class in Kotlin?",
        "The functions in Kotlin can be divided in how many types?",
        "Which are the basic data types in Kotlin?"
    )

    var answers: MutableList<String> = mutableListOf(
        "JetBrains",
        "Google",
        "Microsoft",
        "Oracle",
        ".kt or .kts",
        ".android",
        ".kot",
        ".src",
        "/* */",
        "//",
        "$$",
        "%",
        "Primary and secondary constructor",
        "First and second constructor",
        "Constant and Parameterized constructor",
        "None of these",
        "Elvis operator",
        "The Kotlin extension",
        "Lambda functions",
        "Sealed classes",
        "str.length",
        "lengthof(str)",
        "string(length)",
        "length(str)",
        "public",
        "protected",
        "sealed",
        "private",
        "It represents restricted class hierarchies",
        "It's another name for abstract class",
        "It is used in every Kotlin program",
        "None of these",
        "2",
        "3",
        "4",
        "5",
        "All of these",
        "Arrays and Booleans",
        "Characters",
        "Strings and Numbers"
    )
}