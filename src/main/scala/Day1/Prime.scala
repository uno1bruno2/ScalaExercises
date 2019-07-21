package Day1

import scala.io.StdIn.readInt

object Prime extends App{
  var num = readInt()
  for (i <- 2 to num) {
    if (isPrime(i)) {
      println(i)
    }
  }

  def isPrime(input: Int): Boolean = {
    if (input <= 1) false
    var i = 2
    var result = true
    while (i <= Math.sqrt(input)) {
      if (input % i == 0) {
        result = false
      }
      i += 1
    }
    result
  }




}
