package me.chefzander.clickergame.buildings.money;

import me.chefzander.clickergame.Currency;
import me.chefzander.clickergame.buildings.Building;

public class Bank extends Building {
	public Bank() {
		super("Bank", "Controlls the factoires that print money, its as simple as that!", 30, Currency.MONEY, 10000);
	}
}
