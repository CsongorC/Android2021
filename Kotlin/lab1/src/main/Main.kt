package main

import java.util.*

// 1. feladat

//fun main(args: Array<String>) {
//
//    val first: Int = 2
//    val second: Int = 3
//
//    println("$first + $second = ${first + second}")
//}

// 2. feladat

//fun main(args: Array<String>) {
//    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
//
//    println("Use a for loop that iterates over the list and prints the list to the standard output")
//    for (element in daysOfWeek) {
//        println(element)
//    }
//
//    println()
//
//    println("Use a list filter to print the days starting with letter ‘T’")
//    daysOfWeek.filter { it.startsWith("T") }.forEach{ println(it)}
//
//    println()
//
//    println("Use a list filter to print the days containing the letter ‘e‘")
//    daysOfWeek.filter { it.contains("e") }.forEach{ println(it)}
//
//    println()
//
//    println("Use a list filter to print all the days of length 6 (e.g. Friday)")
//    daysOfWeek.filter { it.length == 6 }.forEach{ println(it) }
//}

// 3. feladat

//fun main(arg: Array<String>) {
//
//    val listOfPrimes: MutableList<Long> = ArrayList()
//
//    for (i in 1L..100) {
//        if (checkPrimeNumber(i)) {
//            listOfPrimes.add(i)
//        }
//    }
//
//    println("$listOfPrimes")
//}
//
//fun checkPrimeNumber(num: Long): Boolean {
//    var prime = true
//    for (i in 2..num / 2) {
//        if (num % i == 0L) {
//            prime = false
//            break
//        }
//    }
//    return prime
//}

// 4. feladat

//fun main(arg: Array<String>) {
//    val encodedString = encode("I like Kotlin.")
//    println(encodedString)
//
//    val decodedString = decode(encodedString)
//    println(decodedString)
//
//    val messageCoding = messageCoding("Kotlin", ::encode)
//    println(messageCoding)
//
//    val messageDecoding = messageCoding(messageCoding, ::decode)
//    println(messageDecoding)
//}
//
//fun messageCoding(msg: String, func: (String) -> String): String{
//    return func(msg)
//}
//
//fun encode(word : String): String{
//    val encodedString: String = Base64.getEncoder().encodeToString(word.toByteArray())
//
//    return encodedString
//}
//
//fun decode(encodedString : String): String{
//    val decodedBytes = Base64.getDecoder().decode(encodedString)
//    val decodedString = String(decodedBytes)
//
//    return decodedString
//}

// 5. feladat

//fun evenNumbers():Unit = listOf(1,2,3,4,5,6,7,8,9).filter { x -> x % 2 == 0 }.forEach{ println(it)}
//
//fun main(arg: Array<String>) {
//    evenNumbers()
//}

// 6. feladat

//fun main(arg: Array<String>) {
//    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9)
//    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
//
//    println("Double the elements of a list of integers and print it.")
//    numbers.map { it * 2 }.forEach{println(it)}
//    println()
//
//    println("Print the days of week capitalized (e.g. MONDAY for Monday)")
//    daysOfWeek.map{ it.toUpperCase()}.forEach{println(it)}
//    println()
//
//    println("Print the first character of each day capitalized (e.g. m for Monday)")
//    daysOfWeek.map{ it[0].toLowerCase()}.forEach{println(it)}
//    println()
//
//    println("Print the length of days (number of characters, e.g. Monday → 6)")
//    daysOfWeek.map{ it.length }.forEach{println(it)}
//    println()
//
//    println("Compute the average length of days (in number of characters)")
//    val average = daysOfWeek.map{ it.length}.average()
//    println(average)
//}

// 7. feladat

//fun main(arg: Array<String>) {
//
//    println("\nConvert the daysOfWeek immutable list into a mutable one. Remove all days containing\n" +
//            "the letter ‘n’, then print the mutable list. \n")
//
//    var daysOfWeek = mutableListOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
//    daysOfWeek.removeIf{ x -> x.contains("n")}
//    print(daysOfWeek)
//    println()
//
//    println("\nPrint each element of the list in a new line together with the index of the element (convert\n" +
//            "the list to list with index using the withIndex() function!).\n")
//
//    daysOfWeek.withIndex().forEach{ println("Item at " + it.index + " is " + it.value)}
//
//    println("\nSort the result list alphabetically \n")
//
//    daysOfWeek.sort()
//    print(daysOfWeek)
//}

// 8. feladat

//fun main(arg: Array<String>) {
//
//    println("Generate an array of 10 random integers between 0 and 100, and use forEach to print\n" +
//            "each element of the array in a new line. \n")
//
//    val from = 0
//    val to = 100
//    val randomNumbers = IntArray(10){ Random().nextInt(to - from) +  from}
//
//    randomNumbers.forEach { println(it) }
//
//    println("\nPrint the array sorted in ascending order!\n")
//
//    randomNumbers.sort()
//    println(Arrays.toString(randomNumbers))
//
//    println("\nCheck whether the array contains any even number\n")
//
//    if(randomNumbers.any{ it % 2 == 0}){
//        println("Yes, it contains!\n")
//    }
//    else{
//        println("No, it doesn't contain!\n")
//    }
//
//    println("Check whether all the numbers are even!\n")
//
//    if(randomNumbers.all{ it % 2 == 0}){
//        println("All numbers are even!\n")
//    }
//    else{
//        println("Not all numbers are even!\n")
//    }
//
//    println("Calculate the average of generated numbers and print it using forEach!\n")
//
//    var average = 0.0
//    randomNumbers.forEach { average += it }
//    average /= 10
//    println("Average = " + average)
//
//}