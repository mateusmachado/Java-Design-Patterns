package com.prototype;

public class HeroFactoryImpl implements HeroFactory {

	Warlord warlod;

	public HeroFactoryImpl(Warlord warlod) {
		this.warlod = warlod;
	}

	public Warlord createWarLoard() {
		try {
			return warlod.copy();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
