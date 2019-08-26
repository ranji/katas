fun main() {
    var word: String? = ""
    val generator = AnagramGenerator()
    while (word?.startsWith(":q")==false) {
        println("enter word (:q to quit):")
        word = readLine()
        word?.let { w ->
            val anagrams = generator.generate(w) ?: "no anagrams found"
            println(anagrams)
        }
    }
}