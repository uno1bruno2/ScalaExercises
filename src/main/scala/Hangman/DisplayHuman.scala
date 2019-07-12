package Hangman

object DisplayHuman {

  def displayHuman(index: Int): Unit = {
    if (index == 0) {
      println("|--------------")
      println("|")
      println("|")
      println("|")
      println("|")
      println("|")
      println("|")
      println("---------------------")
    } else if (index == 1) {
      println("|--------------")
      println("|        |")
      println("|")
      println("|")
      println("|")
      println("|")
      println("|")
      println("|--------------------")
    } else if (index == 2) {
      println("|--------------")
      println("|        |")
      println("|        O")
      println("|")
      println("|")
      println("|")
      println("|")
      println("|--------------------")
    } else if (index == 3) {
      println("|--------------")
      println("|        |")
      println("|        O")
      println("|       /|\\ ")
      println("|")
      println("|")
      println("|")
      println("---------------------")
    } else if (index == 4) {
      println("|--------------")
      println("|        |")
      println("|        O")
      println("|       /|\\ ")
      println("|        |")
      println("|")
      println("|")
      println("---------------------")
    } else if (index == 5) {
      println("|--------------")
      println("|        |")
      println("|        O")
      println("|       /|\\ ")
      println("|        |")
      println("|       / \\ ")
      println("|")
      println("---------------------")
    } else {
      println("Game Over")
    }


  }

}
