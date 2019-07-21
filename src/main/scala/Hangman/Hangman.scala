package Hangman

import scala.io.StdIn.readLine

object Hangman {

  def play(phrase: String, numOfLives: Int, guessWord: String): String = {

    var phraselength = phrase.length
    for(i <- 0 until phrase.length) {
      if (phrase.charAt(i) == ' ') {
        phraselength -= 1
      }
    }

    DisplayHuman.displayHuman(numOfLives)

    var phraseSeparated = phrase.split(" ").toList

    println(s"You have ${5-numOfLives} to guess this word. The phrase has ${phraselength} letters.")

    var displayGuessWord = ""
    for(i <- 0 until phrase.length) {
      displayGuessWord = displayGuessWord + guessWord.charAt(i) + " "
    }
    println(displayGuessWord)

    println("What letter will you choose?")

    val char = readLine

    Word.isLetterInPhrase(phrase,char.toUpperCase,guessWord)


  }

}
