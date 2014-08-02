
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class TextEditor {
	
	public static final int WIDTH = 16;
	public static final int HEIGHT = 9;
	public static final int SCALE = 50;
	public static JFrame frame = new JFrame("TextEdit 2.0");
	public static JTextArea type = new JTextArea();
	
	//add menu bar at top
	public static JMenuBar menubar = new JMenuBar();
	
	//add various things to menu bar	
	public static JMenu file = new JMenu("File");
	public static JMenu edit = new JMenu("Edit");
	public static JMenu format = new JMenu("Format");
	public static JMenu view = new JMenu("View");
	public static JMenu about = new JMenu("About");
	
	//create sub-options for JMenubar, for File
	public static JMenuItem newFile = new JMenuItem("New       ");	//note: only the first sub-option you're adding needs the extra spaces after its name
	public static JMenuItem openFile = new JMenuItem("Open");
	public static JMenuItem saveFile = new JMenuItem("Save");
	public static JMenuItem exitFile = new JMenuItem("Exit");
	
	//create sub-options for JMenubar, for Edit
	
	
	//create sub-options for JMenubar, for Format
	public static JMenuItem wordWrap = new JMenuItem("Word Wrap       \u2713");
	public static JMenuItem changeFont = new JMenuItem("Font...");
	

	//create sub-options for JMenubar, for View
	
	
	//create sub-options for JMenubar, for About
	
	
	
	

	public static void main(String[] args) throws FontFormatException, IOException, Exception{//start main method
		//set up jframe
		frame.setResizable(true);
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		frame.setLocation(120, 80);
		frame.add(type);
		frame.setJMenuBar(menubar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set up text area
		type.setSelectedTextColor(Color.GREEN);
		type.setBackground(Color.BLACK);
		type.setSize(frame.getSize());
		type.setCaretColor(Color.white);
		type.setTabSize(5);
		type.setSelectionColor(Color.BLUE);
		
        wordWrap.setSelected(true);
		type.setLineWrap(true);
        type.setWrapStyleWord(true);	//wraps whole words instead of just letters
                
                
		//read and set font
		InputStream is = TextEditor.class.getResourceAsStream("courbd.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, is);
		Font sizedFont = font.deriveFont(16f);
		type.setFont(sizedFont);
		
		//read and set about image
		InputStream ist = TextEditor.class.getResourceAsStream("questionmark.png");
		final BufferedImage img = ImageIO.read(ist);
	
		//flashes colors when typing
		type.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				Random rnd = new Random();
				int a = rnd.nextInt(5);
				if(a == 0){
					type.setBackground(Color.cyan);
				}
				else if(a == 1){
					type.setBackground(Color.red);
				}
				else if(a == 2){
					type.setBackground(Color.gray);
				}
				else if(a == 3){
					type.setBackground(Color.orange);
				}
				else if(a == 4){
					type.setBackground(Color.pink);
				}
				else if(a == 5){
					type.setBackground(Color.yellow);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
		
		/*
		 * Add mnemonics to sub-options in Jmenubar
		 */
		
		//for File
		newFile.setMnemonic(KeyEvent.VK_N);
		openFile.setMnemonic(KeyEvent.VK_O);
		saveFile.setMnemonic(KeyEvent.VK_S);
		exitFile.setMnemonic(KeyEvent.VK_X);
		
		//for Edit
		
		
		//for Format
		wordWrap.setMnemonic(KeyEvent.VK_W);
		changeFont.setMnemonic(KeyEvent.VK_F);
		
		//for View
		
		
		
		/*
		 * Add actions to sub-options in Jmenubar
		 */
		
		//give wordWrap actions, make it act like a toggle button
		wordWrap.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(wordWrap.isSelected() == false){
					wordWrap.setSelected(true);
					wordWrap.setText("Word Wrap       \u2713"); //\u2713 is a checkmark
					type.setLineWrap(true);			
				}else{
					wordWrap.setSelected(false);
					wordWrap.setText("Word Wrap        ");	//changes text to delete checkmark after 'Word Wrap' in menu
					type.setLineWrap(false);
				}
			}
		});
		
		//show info window on about click
		about.addMenuListener(new MenuListener(){
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void menuSelected(MenuEvent e) {
				JDialog info = new JDialog(frame, "About");
				info.setLocation((int) frame.getLocation().getX(),(int) frame.getLocation().getY());
				info.setVisible(true);
				info.setIconImage(img);
				info.setSize(200, 100);
				info.setResizable(false);
				
				//change about window text
				JTextPane inftext = new JTextPane();
				inftext.setText("Created by radbrad and JoshC \n\n     © 2014");
				inftext.setSize(info.getSize());
				inftext.setEditable(false);
				inftext.setBackground(Color.magenta);
				info.add(inftext);
			}
			
		});
		
		//close window on exit click
		exitFile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();			
			}
			
		});
		
		
		//open file
		openFile.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				//create String filename to open file name
				String filename = new String();
				
				//create variables to read in file
				FileReader fileReader;
				BufferedReader bufferedReader;
				
				//open file explorer of where to open file
				JFileChooser chooser = new JFileChooser();
				int chooserStatus = chooser.showOpenDialog(openFile);
				
				
				if (chooserStatus == JFileChooser.APPROVE_OPTION){
					
					//get a reference to the selected file
					File selectedFile = chooser.getSelectedFile();
					
					//get the path of the selected file
					filename = selectedFile.getPath();
				}
				
				
				//open the file into textEditor
				try{
					
					//open the file
					fileReader = new FileReader(filename);
					bufferedReader = new BufferedReader(fileReader);
					
					//read in file
					String lineIn = "";
					String editorString = "";
					lineIn = bufferedReader.readLine();
					
					//loop to read in each line
					while(lineIn != null){
						//group all current lines into editorString
						editorString = editorString + lineIn + "\n";
						
						//goto next line
						lineIn = bufferedReader.readLine();
					}
					
					//set textEditor text to editorString's text
					type.setText(editorString);
					
					//close buffered reader
					bufferedReader.close();
					
					//close filereader
					fileReader.close();
					
					
				}catch(Exception e1){
					
					//idk do something
				}
				
			}
			
			
		});
		
		
		
		//save file
		saveFile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//create String filename to save file name's name
				String filename = new String();
				
				//open file explorer of where to save
				JFileChooser chooser = new JFileChooser();
				int chooserStatus = chooser.showSaveDialog(saveFile);
				
				if (chooserStatus == JFileChooser.APPROVE_OPTION)
	            {
	               //get a reference to the selected file
	               File selectedFile = chooser.getSelectedFile();

	               //get the path of the selected file
	               filename = selectedFile.getPath();
	            }

				//save the file
				try{
					FileWriter fw = new FileWriter(filename + ".txt");
					PrintWriter pw = new PrintWriter(fw);
					pw.println(type.getText());
					pw.close();
				}
				catch(IOException io){
					io.printStackTrace();
				}
			}
			
		});
		
		
		
		/*
		 * Add options to JMenu Bar
		 */
		
		//add options to JMenuBar
		menubar.add(file);
		menubar.add(edit);
		menubar.add(format);
		menubar.add(view);
		menubar.add(about);
		
		
		/*
		 * Add sub-options to JMenu Bar
		 */

		//add sub-options to JMenuBar File
		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		file.add(exitFile);
		

		//add sub-options to JMenuBar Edit
		
		
		//add sub-options to JMenuBar Format

		format.add(wordWrap);
		format.add(changeFont);
		
		
		//add sub-options to JMenuBar View
		
		
		//add sub-options to JMenuBar About

		
		
		/*
		 * Enable swing elements
		 */
		
		//enable swing elements
		frame.setVisible(true);
		type.setVisible(true);
		menubar.setVisible(true);
                
	}//end main method
	
	
	
	
	//todo - add methods to sub-option buttons
	
	
	
	
	
	
	
	
	
	
	
        
}//end class TextEditor

