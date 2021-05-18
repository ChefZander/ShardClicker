package me.chefzander.clickergame.buildings.money;

import me.chefzander.clickergame.Currency;
import me.chefzander.clickergame.buildings.Building;

public class Factory extends Building {
	public Factory() {
		super("Factory", "Its getting industrial now!", 25, Currency.MONEY, 7000);
	}
}
