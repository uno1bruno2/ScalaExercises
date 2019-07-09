package Day1

import scala.collection.mutable.ArrayBuffer
import scala.math.sqrt
import scala.math.pow
import scala.io.StdIn.readInt

object Main extends App {

  def booleanPrimes(input: Integer): ArrayBuffer[Boolean] = {
    val squareRootInputDouble: Double = sqrt(input.toDouble)
    val squareRootInput: Integer = squareRootInputDouble.toInt


    val arrayOfBooleans = new ArrayBuffer[Boolean] ()
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



  var wantMore: Boolean = true

  var welcome = "Welcome"
  4
  while(wantMore) {

    println(s"$welcome! If you are here you must like prime numbers. There are things you might want to do!\nChoose one of the following by writing the associated number:")
    println("(1) Find a specific prime based on position")
    println("(2) Determine if a specific number is prime")
    println("(3) Number of primes less than or equal to a specific number")
    println("(4) List the primes up to a certain number")
    //    println("(5) Actually, I don't like primes")
    welcome = "Welcome Back"

    var chooseOption = readInt()
    var input: Integer = 0
    println("Give me a number")
    input = readInt()

    if (chooseOption == 1) {
      var squareInput = pow(input.toDouble,2.00).toInt
      val arrayOfPrimes = listOfPrimes(squareInput)

      var str = ""
      if (input % 10 == 1) {
        str = "st"
      } else if (input % 10 == 2) {
        str = "nd"
      } else if (input % 10 == 3) {
        str = "rd"
      } else {
        str = "th"
      }

      var result = 0
      if (input != 1) {
        result = arrayOfPrimes(input-1)
      } else {
        result = 2
      }

      println(s"The $input$str prime number is $result")
    } else if (chooseOption == 2) {
      val listOfPrimes = booleanPrimes(input)

      var response = "is not"

      if (listOfPrimes(input)) {
        response = "is"
      }

      println(s"The number $input $response a prime number")
    } else if (chooseOption == 3) {
      val numberOfPrimes = listOfPrimes(input).size

      println(s"There are $numberOfPrimes number of prime numbers less than or equal to $input")
    } else if (chooseOption == 4) {
      for (prime <- listOfPrimes(input)) println(prime)
    } else {
      wantMore = false
    }


    Thread.sleep(2000)


    var placeholder = true
    while (placeholder) {
      println("Do you want more primes? Type y or n")
      var wantMoreString = scala.io.StdIn.readLine()
      if (wantMoreString.toLowerCase == "no" || wantMoreString.toLowerCase == "n"){
        wantMore = false
        placeholder = false
      } else if (wantMoreString.toLowerCase == "yes" || wantMoreString.toLowerCase == "y"){
        placeholder = false
      }
      else {
        println("Invalid input!")
      }
    }
  }

  println("Okay, I hope you enjoyed these primes :)")


}
