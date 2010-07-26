package zuse

import org.specs.Specification

object HelloSpec extends Specification {
  "basic addition" in {
    (1 + 1) must be_==(2)
  }
}