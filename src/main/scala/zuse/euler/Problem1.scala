package zuse.euler

/**
 * http://projecteuler.net/index.php?section=problems&id=1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
object Problem1 extends Application {
  def sumMultiples: Int = {
    def multipleOf(n: Int)(x: Int) = x % n == 0
    val ms = (1 to 1000).filter(x => multipleOf(3)(x) || multipleOf(5)(x))
    ms.sum
  }

  assert(sumMultiples == 234168)
}