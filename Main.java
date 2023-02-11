import javax.swing.*;

import static javax.swing.JFrame.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("2048");

        Logger.log("hello, world!");

        int width = 400, height = 400;

        Panel2048 panel = new Panel2048(width, height);

        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JOptionPane jOptionPane = new JOptionPane("");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(panel.width, panel.height);
        frame.setResizable(true);
	}


	public static int randInt(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min); // The maximum is inclusive and the minimum is inclusive
	}
}