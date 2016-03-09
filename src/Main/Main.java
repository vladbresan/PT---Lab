package Main;

import java.awt.EventQueue;

import GUI.GUI;

/*The main purpose of the main class is to create a new object GUI
 * and make it visible for the user.*/
public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
