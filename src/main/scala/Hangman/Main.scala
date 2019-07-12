package Hangman

import scala.util.Random

object Main extends App {

  val phrase = "Functional Programming"

  val phrases = List("Inheritance", "Pattern Matching", "Tadas Vaidotas", "Big Jeff", "Companion Objects", "Access Modifier", "Collections", "Functional Programming")
  val rnd = new Random()
  val position = (rnd.nextFloat() * phrases.length).toInt


  var success = true
  var guessWord = ""
  var numOfLives = 5

  while(numOfLives > 0 && success) {
    guessWord = startDisplay(phrase,guessWord)
    var guess = Hangman.play(phrases(position),5 - numOfLives, guessWord)

    if(guess.toLowerCase() == guessWord.toLowerCase()) {
      numOfLives -= 1
      if (numOfLives != 0) {
        println("Letter is not in this phrase. You lose a life!")
      } else {
        println("You have lost your lives and you lose the game. Thanks for playing")
        DisplayHuman.displayHuman(5-numOfLives)
      }
    } else if (guess.toLowerCase() == phrase.toLowerCase()) {
      success = false
      println(phrase.toUpperCase())
      println("You found the word! Thanks for playing")
    } else {
      guessWord = guess
      println("That letter is there")
    }

    println("________________________________________________________________________________________________")



  }

  def startDisplay(phrase: String, guessWord: String): String = {
    var newGuessWord = ""

    if(guessWord == "") {
      for(i <- 0 until phrase.length) {
        if (phrase.charAt(i) == ' ') {
          newGuessWord = newGuessWord + " "
        } else {
          newGuessWord = newGuessWord + "_"
        }
      }
      newGuessWord
    } else {
      guessWord
    }
  }

}
