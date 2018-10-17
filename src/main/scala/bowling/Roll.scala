package bowling

import scala.util.Random

case class Roll(pinsKnocked: Int = 0, pinsLeft: Int = 10){
  val r : Random = Random

  /**
    * Generate int between 0 and pinsLeft
    * @return
    */
  def generateInt: Int = r.nextInt(pinsLeft) + 1
  /**
    * Launch the roll
    * @return
    */
  def launch() : Roll = {
    val npinsKnocked = generateInt
    val npinsLeft = this.pinsLeft - npinsKnocked
    this.copy(pinsKnocked = pinsKnocked+npinsKnocked, pinsLeft = npinsLeft)
  }
}
