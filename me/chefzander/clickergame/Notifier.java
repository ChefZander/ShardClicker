package me.chefzander.clickergame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Notifier {
	public static void error(JFrame f, String content) {
		JDialog d = new JDialog(f, "Error");
		 
        // create a label
        JLabel l = new JLabel(content);

        d.add(l);

        // setsize of dialog
        d.setSize(100, 70);

        // set visibility of dialog
        d.setVisible(true);
	}
}
