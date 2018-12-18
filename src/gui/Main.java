package gui;

import javax.swing.JFrame;


public class Main 
{
	public static void main(String[] args)
	{
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(2000,1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
