package com.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		HeroFactory factory;
		Warlord warlod;

		factory = new HeroFactoryImpl(new ElfWarlord("defense"));
		warlod = factory.createWarLoard();
		LOGGER.info(warlod.toString());
	}
}
