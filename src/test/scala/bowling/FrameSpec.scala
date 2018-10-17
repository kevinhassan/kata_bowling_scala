package bowling

import org.scalatest.{FunSpec, Matchers}

class FrameSpec extends FunSpec with Matchers {
  describe("A Frame"){
    describe("Frame initialization "){
      it("should have a score of 0"){
        val frame = Frame(Roll())
        assert(frame.score == 0)
      }
      it("should have number of try of 0"){
        val frame = Frame(Roll())
        assert(frame.nbRoll == 0)
      }
    }
    describe("when frame is launched"){
      it("should have a number of try more than zero and strictly less than 4"){
        val frame = Frame(Roll()).launch
        assert(frame.nbRoll > 0 && frame.nbRoll < 4)
      }
    }
  }
}
