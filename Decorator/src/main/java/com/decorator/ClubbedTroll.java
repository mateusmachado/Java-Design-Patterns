package com.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClubbedTroll implements Troll {

  private static final Logger LOGGER = LoggerFactory.getLogger(ClubbedTroll.class);

  private Troll decorated;

  public ClubbedTroll(Troll decorated) {
    this.decorated = decorated;
  }

  public void attack() {
    decorated.attack();
    LOGGER.info("The troll swings at you with a club!");
  }

  public int getAttackPower() {
    return decorated.getAttackPower() + 10;
  }

  public void fleeBattle() {
    decorated.fleeBattle();
  }
}
