package Day3

object PatternMatching2 {

  def swapIntegers(numbers: Any): Tuple2[Any, Any] = numbers match {
    case numbers: Tuple2[Int, Int] => Tuple2[Int, Int](numbers._2, numbers._1)
    case numbers: List[Int] => Tuple2[Int, Int](numbers(1), numbers(0))
    case numbers: Array[Int] => Tuple2[Int, Int](numbers(1), numbers(0))
    case numbers => Tuple2[String,String]("not","valid")
  }

}
