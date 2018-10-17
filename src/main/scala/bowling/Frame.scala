package bowling

case class Frame(roll: Roll, nbRoll : Int = 0, score: Int = 0) {
  /**
    * Launch the frame
    * The frame can contain spare, strike, nothing ...
    * @return
    */
  def launch: Frame = {
    val nRoll = roll.launch()
    //strike until 3 rolls
    if(nRoll.pinsKnocked == 10 &&  nbRoll < 2){
      val nScore = this.score + 10
      copy(roll = Roll(), score = nScore, nbRoll = nbRoll + 1).launch
      //spare
    }else if(nRoll.pinsLeft == 0){
      val nScore = this.score + nRoll.pinsKnocked
      copy(roll = Roll(), score = nScore, nbRoll = nbRoll + 1).launch
    //first roll
    }else if(nbRoll == 0){
      val nScore = this.score + nRoll.pinsKnocked
      copy(roll = nRoll, score = nScore, nbRoll = nbRoll + 1).launch
    }else{
      val nScore = this.score + nRoll.pinsKnocked
      copy(roll = nRoll, score = nScore, nbRoll = nbRoll + 1)
    }
  }
}
