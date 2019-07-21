package Hangman

object Word {

  def isLetterInPhrase(phrase: String, char: String, guessWord: String): String = {
    val phraseSeperated = phrase.split("").toList

    var guessWordsSeperated = guessWord.split("").toList

    var newGuessWord = ""
    for (i <- 0 until phraseSeperated.length) {
      if (phraseSeperated(i).toLowerCase() == char.toLowerCase()) {
        newGuessWord = newGuessWord + char
      } else {
        newGuessWord = newGuessWord + guessWordsSeperated(i)
      }
    }

    newGuessWord
  }

}
