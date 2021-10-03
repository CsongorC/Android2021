package main

object DictionaryProvider{

    fun createDictionary(type : DictionaryType) : IDictionary{
        return when(type){
            DictionaryType.TREE_SET -> TreeSetDictionary
            DictionaryType.ARRAY_LIST -> ListDictionary
            DictionaryType.HASH_SET -> HashSetDictionary
        }
    }
}