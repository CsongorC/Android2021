package main

import com.sun.org.apache.xpath.internal.operations.Bool

interface IDictionary {

    companion object{
        const val fileName = "bemenet.txt"
    }

    fun add(word : String) : Boolean
    fun find(word : String) : Boolean
    fun size() : Int

}