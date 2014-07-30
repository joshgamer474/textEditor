
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


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
	public static JMenuItem wordWrap = new JMenuItem("Word Wrap       ");
	public static JMenuItem changeFont = new JMenuItem("Font...");
	

	//create sub-options for JMenubar, for View
	
	
	//create sub-options for JMenubar, for About
	
	
	
	

	public static void main(String[] args) throws FontFormatException, IOException{//start main method
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
        
        type.setWrapStyleWord(true);	//wraps whole words instead of just letters
                
                
		//read and set font
		InputStream is = TextEditor.class.getResourceAsStream("courbd.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, is);
		Font sizedFont = font.deriveFont(16f);
		type.setFont(sizedFont);
		
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
		 * Add actions to sub-options in Jmenubar
		 */
		
		//give wordWrap actions, make it act like a toggle button
		wordWrap.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(wordWrap.isSelected() == false){
					wordWrap.setSelected(true);
					wordWrap.setText("Word Wrap       \u2713");	//changes text to add checkmark after 'Word Wrap' in menu
					type.setLineWrap(true);
				}else{
					wordWrap.setSelected(false);
					wordWrap.setText("Word Wrap       ");
					type.setLineWrap(false);
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

