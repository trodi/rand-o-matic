package main.scala

/**
 * Quick rendition of a roman numeral to latin converter. Playing with Scala, I know this isn't the ideal implementation.
 * 
 * @author tmckinnon
 */
object RomanNumeral {

  private case class RomanNumeral(key: Char, value: Int)
  private val I = RomanNumeral('I', 1)
  private val V = RomanNumeral('V', 5)
  private val X = RomanNumeral('X', 10)
 
  def main(args: Array[String]) {
    println("Conversion: II   => " + romanToLatin("II"))
    println("Conversion: XIV  => " + romanToLatin("XIV"))
    println("Conversion: XVII => " + romanToLatin("XVII"))
    println("Conversion: XXX => " + romanToLatin("XXX"))
  }
  
  def romanToLatin(roman: String): Int = {
    // no boundry checking
    // only handles up to "XXX"
    val stack = roman.map(x => helper(x))
    println(stack.toList)
    stack.toList.foldRight(0)(helpFold)
  }
  
  def helpFold(first: Int, second: Int): Int = {
    def debug = println("first:" + first + " second:" + second)
    first match {
        case I.value => debug; if (second <= 3) first + second else second - first
        case V.value => debug; first + second
        case X.value => debug; first + second
    }
  }
  
  def helper(romanChar: Char): Int = romanChar match {
    case I.key => I.value
    case V.key => V.value
    case X.key => X.value
  }
}