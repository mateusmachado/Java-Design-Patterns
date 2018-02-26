package com.prototype;

public class HeroFactoryImpl implements HeroFactory {

	Warlord warlod;
	Mage mage;

	public HeroFactoryImpl(Warlord warlod, Mage mage) {
		this.warlod = warlod;
		this.mage = mage;
	}

	public Warlord createWarLoard() {
		try {
			return warlod.copy();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public Mage createMage() {
		try {
			return mage.copy();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
