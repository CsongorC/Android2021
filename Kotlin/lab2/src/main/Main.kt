package main

import kotlin.Comparator
import kotlin.random.Random

fun main(){

    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.HASH_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }

    val date1 = Date()
    date1.checkIfLeapYear()

    val date2 = Date(2020, 12, 11);
    date2.checkIfLeapYear()

    var countValidDates = 0
    var year : Int
    var month : Int
    var day : Int

    val dates : MutableList<Date> = mutableListOf<Date>()

    while (countValidDates != 10){

        year = Random.nextInt(400, 2020)
        month = Random.nextInt(1, 40)
        day = Random.nextInt(1, 40)

        val newDate = Date(year, month, day)

        if(newDate.isValidDate()){
            dates.add(newDate)
            countValidDates += 1
        }
        else{
            println(toDateFormatter(newDate))
        }

    }

    println()
    println("List: ")
    dates.forEach { println(toDateFormatter(it)) }

    println()
    println("Sorted list: ")
    dates.sort()
    dates.forEach { println(toDateFormatter(it)) }

    println()
    println("Reverse list: ")
    dates.reverse()
    dates.forEach { println(toDateFormatter(it)) }

    dates.shuffle()

    println()
    dates.sortWith(Comparator())
    println("Custom sorted list: ")
    dates.forEach { println(toDateFormatter(it)) }
}
