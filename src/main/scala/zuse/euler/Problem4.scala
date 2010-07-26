package zuse.euler

/**
 * http://projecteuler.net/index.php?section=problems&id=4
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product
 * of two 2-digit numbers is 9009 = 91  99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
object Problem4 extends Application {
  case class Result(x: Int, y: Int, product: Int)

  def largestPalindrome: Result = {
    val palindromes = for{
      i <- (1 to 999)
      j <- (1 to i)
      product = i * j
      if product.toString == product.toString.reverse
    } yield Result(i, j, product)

    palindromes.max(Ordering.by((r: Result) => r.product))
  }

  assert(largestPalindrome == Result(993, 913, 906609))
}