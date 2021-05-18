package me.chefzander.clickergame.buildings;

import me.chefzander.clickergame.Currency;

public class Building {
	public String name;
	public long cpsGain;
	public long cost;
	public Currency costCurrency;
	public long owned = 0;
	public String description;
	
	public Building(String name, String description, long cpsGain, Currency costCurrency, long cost) {
		this.name = name;
		this.cpsGain = cpsGain;
		this.costCurrency = costCurrency;
		this.cost = cost;
		this.description = description;
	}
	
}
