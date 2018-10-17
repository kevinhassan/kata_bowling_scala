package bowling

import scala.annotation.tailrec

object Bowling {
  def generateFrames(i: Int): List[Frame] = {
    @tailrec
    def generateFramesTailRec(y: Int, frames: List[Frame]): List[Frame] = {
      if (y == 0) frames else generateFramesTailRec(y-1, frames :+ Frame(Roll()).launch)
    }
    generateFramesTailRec(i, List())
  }

  private val genFrames = generateFrames(10)

  def play(frames: List[Frame] = genFrames): List[Frame] = {
    /**
      * Generate 10 frames for the bowling game
      * @param frames
      * @param nbFrame
      * @return
      */
    def playTailRec(frames: List[Frame], nFrames: List[Frame], nbFrame: Int = 10): List[Frame] = {
      if (nbFrame == 0) {
        nFrames
      }else{
        playTailRec(frames.tail, nFrames :+ frames.head.launch, nbFrame - 1)
      }
    }
    playTailRec(frames, List())
  }

  /**
    * Compute the score according the list of frame
    * @param frames
    * @return
    */
  def score(frames: List[Frame] = genFrames): Int = {
    @tailrec
    def scoreTailRec(sum: Int, subFrames: List[Frame]): Int = {
      if (subFrames.isEmpty) sum else scoreTailRec(sum + subFrames.head.score, subFrames.tail)
    }
    scoreTailRec(frames.head.score, frames.tail)
  }
}