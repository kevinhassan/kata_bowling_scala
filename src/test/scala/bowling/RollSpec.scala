package bowling

import org.scalatest.{FunSpec, Matchers}

class RollSpec extends FunSpec with Matchers {
  describe("A Roll"){
    it("should be a roll with 0 pinsKnocked and 10 pinsLeft initially"){
      val roll: Roll = Roll()
      assert(roll.pinsKnocked == 0)
      assert(roll.pinsLeft == 10)
    }
    it("should be a value between 0 and pinsLeft"){
      val roll: Roll = Roll()
      val genInt: Int = roll.generateInt
      assert(genInt > 0 && genInt <= roll.pinsLeft)
    }
  }
}
