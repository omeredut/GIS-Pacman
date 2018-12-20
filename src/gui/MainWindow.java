package gui;

import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import file_format.CsvReader;
import game.Fruit;
import game.Game;
import game.GameElement;
import game.Map;
import geom.Point3D;

public class MainWindow extends JFrame implements MouseListener {
	public static BufferedImage myImage;
	// private JMenuBar menuBar;
	private MenuBar menuBar;
	private Menu fileMenu, helpMenu, createGame, gameObjectsMenu, addObjects;
	private MenuItem openItem, saveItem, mapItem, pacmanItem, fruitItem;
	// private TextField textField;
	// private int textFieldSize = 10;
	private Game game=new Game();
	private File file;
	private int pacman = 0, fruit = 0;

	public MainWindow() {
		initComponents();
		// createGui();
		this.addMouseListener(this);
	}

	private void initComponents() {
		menuBar = new MenuBar();

		// Menu
		fileMenu = new Menu("File");
		helpMenu = new Menu("Help");
		createGame = new Menu("Create new game");
		gameObjectsMenu = new Menu("Game objects");
		addObjects = new Menu("Add objects");

		// Menu Items
		openItem = new MenuItem("Open game");
		saveItem = new MenuItem("Save");
		mapItem = new MenuItem("Add map image");
		pacmanItem = new MenuItem("Pacman");
		fruitItem = new MenuItem("Fruit");

		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		menuBar.add(gameObjectsMenu);

		addObjects.add(pacmanItem);
		addObjects.add(fruitItem);
		gameObjectsMenu.add(addObjects);
		createGame.add(mapItem);
		fileMenu.add(createGame);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		this.setMenuBar(menuBar);
		// textField = new TextField(textFieldSize);
		// textField = new JTextField(textFieldSize);
		// this.add(textField);

		try {
			file = new File("images\\ariel1.png");
			myImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public void createGui() {
		/*
		 * mapItem.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { file=new
		 * File("E:\\wifi\\Ariel1.png"); try { myImage = ImageIO.read(file); }
		 * catch (IOException e1) { e1.printStackTrace(); } } });
		 */
		pacmanItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fruit = 0;
				pacman = 1;

			}

		});
		fruitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pacman = 0;
				fruit=1;
			}
		});

		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					readFileDialog();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeFileDialog();
			}
		});
	}

	public void readFileDialog() throws FileNotFoundException {
		// try read from the file
		FileDialog fd = new FileDialog(this, "Open csv file", FileDialog.LOAD);
		fd.setFile("*.csv");
		fd.setDirectory("C:\\");
		fd.setFilenameFilter(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".csv");
			}
		});
		fd.setVisible(true);
		String folder = fd.getDirectory();
		String fileName = fd.getFile();
		try {
			CsvReader csvReader = new CsvReader();
			csvReader.init(folder + fileName, ",");
			game = csvReader.read(1);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void writeFileDialog() {
		// try write to the file
		FileDialog fd = new FileDialog(this, "Save the text file", FileDialog.SAVE);
		fd.setFile("*.txt");
		fd.setFilenameFilter(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		fd.setVisible(true);
		String folder = fd.getDirectory();
		String fileName = fd.getFile();
		try {
			FileWriter fw = new FileWriter(folder + fileName);
			PrintWriter outs = new PrintWriter(fw);
			outs.println("Why Java?\n" + "1. Java is small and beautiful\n" + "2. Java is object oriented\n" + "3. Java supports Internet\n" + "4. Java is platform independent\n"
					+ "5. Java has libraries");
			outs.close();
			fw.close();
		} catch (IOException ex) {
			System.out.print("Error writing file  " + ex);
		}

	}

	int x = -1;
	int y = -1;

	public void paint(Graphics g) {
		g.drawImage(myImage, 0, 0, this);

		if (x != -1 && y != -1) {
			int r = 10;
			x = x - (r / 2);
			y = y - (r / 2);
			g.fillOval(x, y, r, r);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("mouse Clicked");
		System.out.println("(" + arg.getX() + "," + arg.getY() + ")");
		x = arg.getX();
		y = arg.getY();
		if(fruit==1){
			Fruit f=new Fruit(1,Map.pixel2Polar(new Point3D(x,y,0)),1);
		
			game.add(new GameElement(f))
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("mouse entered");

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
