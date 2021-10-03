package main

import java.io.File
import java.util.*
import kotlin.collections.HashSet

object HashSetDictionary : IDictionary {

    val words = HashSet<String>()

    init {
        File(IDictionary.fileName).readLines().forEach{ add(it) }
    }

    override fun add(word : String) : Boolean{
        return if( find(word)){
            false
        } else{
            words.add(word)
            true
        }
    }

    override fun find(word : String) : Boolean{
        val requiredWord = words.filter { words -> words.contains(word) }
        if (requiredWord.contains(word)) return true
        return false
    }

    override fun size() : Int {
        return words.size
    }

}