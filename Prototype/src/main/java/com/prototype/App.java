package com.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		HeroFactory factory;
		Warlord warlod;
		Mage mage;

		factory = new HeroFactoryImpl(new ElfWarlord("defense"), new ElfMage("attack"));
		warlod = factory.createWarLoard();
		mage = factory.createMage();

		LOGGER.info(warlod.toString());
		LOGGER.info(mage.toString());

	}
}
