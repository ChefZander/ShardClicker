package me.chefzander.clickergame.buildings.money;

import me.chefzander.clickergame.Currency;
import me.chefzander.clickergame.buildings.Building;

public class Inspector extends Building{
	public Inspector() {
		super("Inspector", "Inspects the money you ... earn?", 10, Currency.MONEY, 1000);
	}
}
