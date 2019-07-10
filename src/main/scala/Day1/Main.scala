package Day1

import scala.collection.mutable.ArrayBuffer
import scala.math.sqrt
import scala.math.pow
import scala.io.StdIn.readInt
import scala.util.Random

object Main extends App {

  def numberSuffixes (input: Integer): String = {
    if (input % 10 == 1) {
      "st"
    } else if (input % 10 == 2) {
      "nd"
    } else if (input % 10 == 3) {
      "rd"
    } else {
      "th"
    }
  }

  def booleanPrimes(input: Integer): ArrayBuffer[Boolean] = {
    val squareRootInputDouble: Double = sqrt(input.toDouble)
    val squareRootInput: Integer = squareRootInputDouble.toInt


    val arrayOfBooleans = new ArrayBuffer[Boolean]()
    arrayOfBooleans addOne false
    arrayOfBooleans addOne false
    for (i <- 2 to input) arrayOfBooleans addOne true



    for (prime <- 2 to squareRootInput) {
      if (arrayOfBooleans(prime)) {
        for (i <- 2 * prime to input by prime) arrayOfBooleans(i) = false
      }
    }
    arrayOfBooleans
  }

  def listOfPrimes(input: Int): ArrayBuffer[Integer] = {
    val arrayOfBooleans = booleanPrimes(input)
    val arrayOfPrimes = new ArrayBuffer[Integer] ()
    for (n <- 2 to input) {
      if (arrayOfBooleans(n)) {
        arrayOfPrimes.addOne(n)
      }
    }
    arrayOfPrimes
  }

  def welcomeMessage(welcome: String): Unit = {
    println(s"$welcome! If you are here you must like prime numbers. There are things you might want to do!\nChoose one of the following by writing the associated number:")
    println("(1) Find a specific prime based on position")
    println("(2) Determine if a specific number is prime")
    println("(3) Number of primes less than or equal to a specific number")
    println("(4) List the primes up to a certain number")
    println("(5) List the twin primes up to a certain number")
    println("(6) Generate a random prime number")
    //    println("(5) Actually, I don't like primes")
  }

  def optionOne(input: Int): Unit = {
    val squareInput = pow(input.toDouble,2.00).toInt
    val arrayOfPrimes = listOfPrimes(squareInput)

    var result = 0
    if (input != 1) {
      result = arrayOfPrimes(input-1)
    } else {
      result = 2
    }

    val str = numberSuffixes(input)

    println(s"The $input$str prime number is $result")
  }

  def optionTwo(input: Int): Unit = {
    val listOfPrimes = booleanPrimes(input)

    var response = "is not"
    if (listOfPrimes(input)) {
      response = "is"
    }

    println(s"The number $input $response a prime number")
  }

  def optionThree(input: Int): Unit = {
    val numberOfPrimes = listOfPrimes(input).size
    println(s"There are $numberOfPrimes number of prime numbers less than or equal to $input")
  }

  def optionFour(input: Int): Unit = {
    for (prime <- listOfPrimes(input)) println(prime)
  }

  def optionSix(input: Int): Unit = {
    val arrayOfPrimes = listOfPrimes(input)
    val rnd = new Random()
    val randomNum = {
      (rnd.nextFloat() * arrayOfPrimes.size).toInt
    }

    println(arrayOfPrimes(randomNum))
  }

  def optionFive(input: Int): Unit = {
    val arrayOfPrimes = listOfPrimes(input)
    for (i <- 1 to arrayOfPrimes.size-1) {
      if (arrayOfPrimes(i) - arrayOfPrimes(i-1) == 2) {
        val twinPrime = (arrayOfPrimes(i-1) , arrayOfPrimes(i))
        println(twinPrime)
      }
    }
  }

  def optionChoices(chooseOption: Int, input: Int): Unit = {
    if (chooseOption == 1) {
      optionOne(input)
    } else if (chooseOption == 2) {
      optionTwo(input)
    } else if (chooseOption == 3) {
      optionThree(input)
    } else if (chooseOption == 4) {
      optionFour(input)
    } else if (chooseOption == 5) {
      optionFive(input)
    } else if (chooseOption == 6) {
      optionSix(input)
    }
    Thread.sleep(2000)
  }

  def wantMoreMethod(): Boolean = {
    println("Do you want more primes? Type y or n")
    val wantMoreString = scala.io.StdIn.readLine()
    if (wantMoreString.toLowerCase == "no" || wantMoreString.toLowerCase == "n"){
      false
    } else if (wantMoreString.toLowerCase == "yes" || wantMoreString.toLowerCase == "y"){
      true
    } else {
      println("Invalid input!")
      Thread.sleep(1000)
      true
    }
  }

  var wantMore: Boolean = true
  var welcome = "Welcome"

  while(wantMore) {

    welcomeMessage(welcome)
    welcome = "Welcome Back"

    val chooseOption = readInt()
    if (chooseOption == -1) {
      wantMore == false
    } else {
      println("Give me a number")
      val input = readInt()
      optionChoices(chooseOption,input)
    }

    while (wantMore) {
      wantMore = wantMoreMethod()
    }

  }

  println("Okay, I hope you enjoyed these primes :)")


}
