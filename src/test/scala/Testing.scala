import Day1.Main
import org.scalatest.FlatSpec

class Testing extends FlatSpec{

  "An empty Set" should "be empty" in {
    assert(Set.empty.isEmpty)
  }
  it should "produce NoSuchElementException when head is invoked on an empty Set" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }

  "Number Suffixes method" should "print the required suffix" in {
    assert(Main.numberSuffixes(2) == "nd")
  }


}
