package me.chefzander.clickergame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import me.chefzander.clickergame.buildings.gold.CentralBank;
import me.chefzander.clickergame.buildings.gold.Temple;
import me.chefzander.clickergame.buildings.money.Bank;
import me.chefzander.clickergame.buildings.money.Factory;
import me.chefzander.clickergame.buildings.money.Farm;
import me.chefzander.clickergame.buildings.money.Inspector;
import me.chefzander.clickergame.buildings.money.Mouse;
import me.chefzander.clickergame.buildings.money.Printer;

public class ClickerGame {

	public static long money = 0;
	public static long goldenShard = 1;
	public static long diamondShard = 0;
	public static long emeraldShard = 0;
	public static long rubyShard = 0;
	public static long mysticShard = 0;
	
	public static double ascentionMultiplier = 1D;
	
	public static long cps = 0;
	
	public static ArrayList<me.chefzander.clickergame.buildings.Building> buildings = new ArrayList<me.chefzander.clickergame.buildings.Building>();
	
	public static void main(String[] args) {
		initMainWindow();
	}
	
	public static void initMainWindow() {
		
		//add buildings
		
		//money
		buildings.add(new Mouse());
		buildings.add(new Printer());
		buildings.add(new Inspector());
		buildings.add(new Farm());
		buildings.add(new Factory());
		buildings.add(new Bank());
		
		//gold
		buildings.add(new CentralBank());
		buildings.add(new Temple());
		
		int sizeX = 700;
		int sizeY = 500;
		JFrame screen = new JFrame("Shard Clicker | by Zander_200 (Main)");
		screen.setSize(sizeX, sizeY);
		screen.setResizable(false);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screen.setLocation((int)(screenSize.getWidth() / 2) -sizeX/2, (int)(screenSize.getHeight() / 2) -sizeY/2);
		
		//game
		JPanel panel = new JPanel();
		JLabel moneyDisplay = new JLabel("Money: " + Long.toString(money));
		panel.add(moneyDisplay);
		
		JButton clickButton = new JButton("Make More!");
		clickButton.setToolTipText("Click here to make some cash ^^");
		clickButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ClickerGame.onClick();
			}
		});
		panel.add(clickButton);
		
		JButton buildings = new JButton("Buy Buildings");
		buildings.setToolTipText("Click here to spend your money on useless stuff ^^");
		buildings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BuildingsMenu.initGUI();
				BuildingsMenu.pushGUI();
			}
		});
		panel.add(buildings);
		
		screen.add(panel);
		screen.setVisible(true);
		
		//cps
		Thread cpsHandler = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					int truecps = (int) (cps*ascentionMultiplier);
					if(cps < 10) {
						for(int i = 0; i < truecps; i++) {
							onClick();
						}
						updateDisplay(moneyDisplay);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
						for(int i = 0; i < 10; i++) {
							
							try {
								Thread.sleep(1000 / 10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for(int y = 0; y < (truecps / 10); y++) {
								onClick();
							}
							updateDisplay(moneyDisplay);
						}
					}
				}
				
			}
			
		});
		cpsHandler.start();
	}
	
	public static int randomNumber(int min, int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}
	
	public static void onClick() {
		if(randomNumber(0, 500) == 0) {
			if(randomNumber(0, 500) == 0) {
				if(randomNumber(0, 500) == 0) {
					if(randomNumber(0, 500) == 0) {
						if(randomNumber(0, 500) == 0) {
							mysticShard++;
						}
						else {
							rubyShard++;
						}
					}
					else {
						emeraldShard++;
					}
				}
				else {
					diamondShard++;
				}
			}
			else {
				goldenShard++;
			}
		}
		else {
			money++;
		}
	}

	public static void updateDisplay(JLabel label) {
		String stringBuilder = "[";
		stringBuilder = stringBuilder + "Money: " + Long.toString(money) + " ";
		
		if(goldenShard > 0) {
			stringBuilder = stringBuilder + "Golden Shards: " + Long.toString(goldenShard) + " ";
		}
		if(diamondShard > 0) {
			stringBuilder = stringBuilder + "Diamond Shards: " + Long.toString(diamondShard) + " ";
		}
		if(emeraldShard > 0) {
			stringBuilder = stringBuilder + "Emerald Shards: " + Long.toString(emeraldShard) + " ";
		}
		if(rubyShard > 0) {
			stringBuilder = stringBuilder + "Ruby Shards: " + Long.toString(rubyShard) + " ";
		}
		if(mysticShard > 0) {
			stringBuilder = stringBuilder + "Mystic Shards: " + Long.toString(mysticShard) + " ";
		}
		stringBuilder = stringBuilder + "]";
		
		label.setText(stringBuilder);
	}
	
}
