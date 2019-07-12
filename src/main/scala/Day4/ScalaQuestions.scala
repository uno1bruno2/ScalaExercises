package Day4

object ScalaQuestions {

  def helloWorld(): String = {
    "Hello World"
  }

  def validBoolean(input:Any): String = input match{
    case input:Boolean => "This is a valid Boolean"
    case input => "This is not a valid Boolean"
  }

  def yourName(firstname: String, surname: String): String = {
    s"$firstname $surname"
  }


  def stringToInt(str:String):Int = {
    str.length // Or str.length(), but isn't needed
  }




}
