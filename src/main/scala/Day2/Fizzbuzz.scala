package Day2

object Fizzbuzz extends App{

  def fizzbuzzStandard(num: Int): String = {
    if (num % 15 == 0) {
      "Fizzbuzz"
    } else if (num % 3 == 0) {
      "Fizz"
    } else if (num % 5 == 0) {
      "Buzz"
    } else {
      num.toString()
    }
  }

  def fizzbuzzMatch(num: Int): String = num match {
    case num if num % 15 == 0 => "Fizzbuzz"
    case num if num % 3 == 0 => "Fizz"
    case num if num % 5 == 0 => "Buzz"
    case _ => num.toString()
  }

  def fizzbuzzRecursion(start: Int, end: Int): Unit = {
    if (start <= end) {
      if (start % 15 == 0) {
        println("Fizzbuzz")
      } else if (start % 3 == 0) {
        println("Fizz")
      } else if (start % 5 == 0) {
        println("Buzz")
      } else {
        println(start)
      }
      fizzbuzzRecursion(start+1,end)
    } else {
      println("That's it!")
    }
  }

//  for (i <- 1 to 100) println(fizzbuzzMatch(i))

  fizzbuzzRecursion(1,100)


}
