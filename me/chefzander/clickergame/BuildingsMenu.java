package me.chefzander.clickergame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import me.chefzander.clickergame.buildings.Building;

public class BuildingsMenu {
	public static JFrame frame = new JFrame("Shard Clicker | by Zander_200 (Buildings)");
	public static void initGUI() {
		int sizeX = 700;
		int sizeY = 500;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int)(screenSize.getWidth() / 2) -sizeX/2, (int)(screenSize.getHeight() / 2) -sizeY/2);
		frame.setSize(sizeX, sizeY);
		frame.setLayout(new GridLayout());
		JPanel main = new JPanel();
		drawMoney(main);
		if(ClickerGame.goldenShard > 0) {
			drawGold(main);
		}
		if(ClickerGame.diamondShard > 0) {
			drawDiamond(main);
		}
		if(ClickerGame.emeraldShard > 0) {
			drawEmerald(main);
		}
		if(ClickerGame.rubyShard > 0) {
			drawRuby(main);
		}
		if(ClickerGame.mysticShard > 0) {
			drawMystic(main);
		}
		frame.add(main);
	}
	public static void pushGUI() {
		frame.setVisible(true);
	}
	
	
	
	
	public static void drawMoney(JPanel panel) {
		for(Building b : ClickerGame.buildings) {
			if(b.costCurrency == Currency.MONEY) {
				JButton button = new JButton(b.name + " [" + Long.toString(b.cost) + " Money]");
				button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(ClickerGame.money >= b.cost) {
							ClickerGame.money = ClickerGame.money - b.cost;
							ClickerGame.cps = ClickerGame.cps + b.cpsGain;
							b.cost *= 1.1;
							b.owned++;
							button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
							button.setText(b.name + " [" + Long.toString(b.cost) + " Money]");
						}
						else {
							Notifier.error(frame, "Not enough money :(");
						}
					}
					
				});
				panel.add(button);
			}
		}
	}
	
	public static void drawGold(JPanel panel) {
		for(Building b : ClickerGame.buildings) {
			if(b.costCurrency == Currency.GOLDEN_SHARD) {
				JButton button = new JButton(b.name + " [" + Long.toString(b.cost) + " GS]");
				button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(ClickerGame.goldenShard >= b.cost) {
							ClickerGame.goldenShard = ClickerGame.goldenShard - b.cost;
							ClickerGame.cps = ClickerGame.cps + b.cpsGain;
							b.cost *= 1.1;
							b.owned++;
							button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
							button.setText(b.name + " [" + Long.toString(b.cost) + " GS]");
						}
						else {
							Notifier.error(frame, "Not enough Golden Shards :(");
						}
					}
					
				});
				panel.add(button);
			}
		}
	}
	
	public static void drawDiamond(JPanel panel) {
		for(Building b : ClickerGame.buildings) {
			if(b.costCurrency == Currency.DIAMOND_SHARD) {
				JButton button = new JButton(b.name + " [" + Long.toString(b.cost) + " DS]");
				button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(ClickerGame.diamondShard >= b.cost) {
							ClickerGame.diamondShard = ClickerGame.diamondShard - b.cost;
							ClickerGame.cps = ClickerGame.cps + b.cpsGain;
							b.cost *= 1.1;
							b.owned++;
							button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
							button.setText(b.name + " [" + Long.toString(b.cost) + " DS]");
						}
						else {
							Notifier.error(frame, "Not enough Diamond Shards :(");
						}
					}
					
				});
				panel.add(button);
			}
		}
	}
	
	public static void drawEmerald(JPanel panel) {
		for(Building b : ClickerGame.buildings) {
			if(b.costCurrency == Currency.EMERALD_SHARD) {
				JButton button = new JButton(b.name + " [" + Long.toString(b.cost) + " ES]");
				button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(ClickerGame.emeraldShard >= b.cost) {
							ClickerGame.emeraldShard = ClickerGame.emeraldShard - b.cost;
							ClickerGame.cps = ClickerGame.cps + b.cpsGain;
							b.cost *= 1.1;
							b.owned++;
							button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
							button.setText(b.name + " [" + Long.toString(b.cost) + " ES]");
						}
						else {
							Notifier.error(frame, "Not enough Emerald Shards :(");
						}
					}
					
				});
				panel.add(button);
			}
		}
	}
	
	public static void drawRuby(JPanel panel) {
		for(Building b : ClickerGame.buildings) {
			if(b.costCurrency == Currency.RUBY_SHARD) {
				JButton button = new JButton(b.name + " [" + Long.toString(b.cost) + " RS]");
				button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(ClickerGame.rubyShard >= b.cost) {
							ClickerGame.rubyShard = ClickerGame.rubyShard - b.cost;
							ClickerGame.cps = ClickerGame.cps + b.cpsGain;
							b.cost *= 1.1;
							b.owned++;
							button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
							button.setText(b.name + " [" + Long.toString(b.cost) + " RS]");
						}
						else {
							Notifier.error(frame, "Not enough Ruby Shards :(");
						}
					}
					
				});
				panel.add(button);
			}
		}
	}
	
	public static void drawMystic(JPanel panel) {
		for(Building b : ClickerGame.buildings) {
			if(b.costCurrency == Currency.MYSTICAL_SHARD) {
				JButton button = new JButton(b.name + " [" + Long.toString(b.cost) + " MS]");
				button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(ClickerGame.mysticShard >= b.cost) {
							ClickerGame.mysticShard = ClickerGame.mysticShard - b.cost;
							ClickerGame.cps = ClickerGame.cps + b.cpsGain;
							b.cost *= 1.1;
							b.owned++;
							button.setToolTipText("<html>You Own: " + Long.toString(b.owned) + "<br>- " + b.description + "<br>+" + b.cpsGain + "CPS</html>");
							button.setText(b.name + " [" + Long.toString(b.cost) + " MS]");
						}
						else {
							Notifier.error(frame, "Not enough Mystical Shards :(");
						}
					}
					
				});
				panel.add(button);
			}
		}
	}
}
