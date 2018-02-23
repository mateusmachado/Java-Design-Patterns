package com.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOGGER.info("A simple looking troll approaches");
		Troll troll = new SimpleTroll();
		troll.attack();
		troll.fleeBattle();
		LOGGER.info("Clubbed troll power {}.\n", troll.getAttackPower());		
	}
}
