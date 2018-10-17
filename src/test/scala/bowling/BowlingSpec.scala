package bowling

import bowling.Bowling._
import org.scalatest.{FunSpec, Matchers}

class BowlingSpec extends FunSpec with Matchers {
  describe("A Set") {
    describe("when empty") {
      it("should have size 0") {
        assert(Set.empty.size == 0)
      }

      it("should produce NoSuchElementException when head is invoked") {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
  }
  describe("A Bowling") {
    it("The empty frame list generated has size of ten") {
      assert(generateFrames(10).size == 10)
    }
    it("The frame played list generated has size of ten") {
      assert(play(generateFrames(10)).size == 10)
    }
    it("All roll with 0 pin down give a score of 0") {
      val bowling = Bowling
      val frames = List(Frame(Roll(), 1), Frame(Roll(), 1), Frame(Roll(), 1), Frame(Roll(), 1), Frame(Roll(), 1), Frame(Roll(), 2), Frame(Roll(), 1), Frame(Roll(), 1), Frame(Roll(), 1), Frame(Roll(), 1))
      assert(bowling.score(frames) == 0)
    }
    it("All roll with strikes give 300") {
      val bowling = Bowling
      val frames = List(Frame(Roll(), 1, 30), Frame(Roll(), 1, 30), Frame(Roll(), 1, 30), Frame(Roll(), 1, 30), Frame(Roll(), 1, 30), Frame(Roll(), 2, 30), Frame(Roll(), 1, 30), Frame(Roll(), 1, 30), Frame(Roll(), 1, 30), Frame(Roll(), 1, 30))
      assert(bowling.score(frames) == 300)
    }
  }
}