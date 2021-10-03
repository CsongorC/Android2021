package main

import extensions.joinThem
import java.time.LocalDate
import kotlin.Comparator

data class Date(val year : Int = LocalDate.now().year, val month: Int = LocalDate.now().monthValue, val day : Int = LocalDate.now().dayOfMonth) : Comparable<Date> {
    override fun compareTo(other: Date): Int {
        return when{
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> day - other.day
        }
    }
}

class Comparator : Comparator<Date>{
    override fun compare(o1: Date?, o2: Date?): Int {
        if(o1 == null || o2 == null)
            return 0
        return o1.compareTo(o2)
    }
}

fun Date.checkIfLeapYear() : Boolean{
    val leap = when {
        this.year % 4 == 0 -> {
            when {
                this.year % 100 == 0 -> this.year % 400 == 0
                else -> true
            }
        }
        else -> false
    }
    println(if (leap) "${this.year} is a leap year." else "${this.year} is not a leap year.")
    return leap
}

fun toDateFormatter(date : Date) : String{
    val stringYear : String = date.year.toString()
    val stringMonth : String = date.month.toString()
    val stringDay : String = date.day.toString()
    val datesList : List<String> = listOf(stringYear, stringMonth, stringDay)
    val stringDate : String = datesList.joinThem("/")
    return stringDate
}

fun Date.isValidDate() : Boolean {

    val valid : Boolean

    if(this.year in 400..9999)
    {

        if(this.month in 1..12)
        {
            if((this.day in 1..31) && (this.month==1 || this.month==3 || this.month==5 || this.month==7 || this.month==8 || this.month==10 || this.month==12)){
                valid = true
            }
            else if((this.day in 1..30) && (this.month==4 || this.month==6 || this.month==9 || this.month==11)) {
                valid = true
            }
            else if((this.day in 1..28) && (this.month==2)){
                valid = true
            }
            else valid = this.day==29 && this.month==2 && this.checkIfLeapYear()
        }
        else
        {
            valid = false
        }
    }
    else
    {
        valid = false
    }
    return valid
}