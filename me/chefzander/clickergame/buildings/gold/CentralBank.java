package me.chefzander.clickergame.buildings.gold;

import me.chefzander.clickergame.Currency;
import me.chefzander.clickergame.buildings.Building;

public class CentralBank extends Building{
	public CentralBank() {
		super("Central Bank", "Controls Banks, surprise?", 40, Currency.GOLDEN_SHARD, 3);
	}
}
