package me.chefzander.clickergame.buildings.money;

import me.chefzander.clickergame.Currency;
import me.chefzander.clickergame.buildings.Building;

public class Printer extends Building {
	public Printer() {
		super("Printer", "Prints Money indefinetly.", 3, Currency.MONEY, 120);
	}
}
