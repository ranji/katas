import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AnagramGeneratorShould {

    val generator=AnagramGenerator()

    @Test
    fun generate_anagrams(){
        val anagrams = generator.generate("care")
        assert(anagrams?.contains("race")?:false)
    }

    @Test
    fun anagram_length_should_be_same_as_original_word(){
        val word = "mars"
        val anagrams = generator.generate(word)
        anagrams?.forEach { w ->

            assert(w.length == word.length) {println("failed at :$w")}
        }
    }

    @Test
    fun generate_sorted_letter_set_from_word(){
        val word = "Rams"
        val letterSet = generator.getSortedLetterSet(word)
        assert(letterSet.equals("amrs"))
    }

    @Test
    fun should_index_dictionary_with_sorted_letter_set(){
        val dictionary = listOf("rams","mars","cars","scar")
        val indexDictionary = generator.indexDictionary(dictionary)
        assert(indexDictionary.size.equals(2))
        assert(indexDictionary["amrs"]!!.equals(mutableListOf("rams","mars")))

    }




}