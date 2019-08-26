import java.io.File
import java.util.*
import kotlin.collections.HashMap

class AnagramGenerator {
    private var indexedDictionary: java.util.HashMap<String, MutableList<String>>
    private var dictionary: MutableSet<String>


    init {
        dictionary = getEnglishDictionary()
        indexedDictionary = indexDictionary(dictionary)
    }

    fun generate(word:String):List<String>?{
        val key = getSortedLetterSet(word)
        return indexedDictionary[key]
            ?.filter { it.length==word.length }
    }

    fun getEnglishDictionary():MutableSet<String>{
        val path = "/usr/share/dict/words"
        val words = mutableSetOf<String>()
        File(path).forEachLine { words.add(it.toLowerCase()) }
        return words
    }

    fun indexDictionary(words: Collection<String>):HashMap<String,MutableList<String>>{
        val map = HashMap<String,MutableList<String>>()
        words.forEach {w->
            val key = getSortedLetterSet(w)
            if (map[key].isNullOrEmpty()) map[key]= mutableListOf(w)
            else map[key]?.add(w)
        }
        return map
    }

    fun getSortedLetterSet(word:String): String {
        val orderedWordSet = word.toLowerCase().toSortedSet().fold(""){acc, c -> acc + c }
        return orderedWordSet
    }
}