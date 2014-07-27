import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
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
	public static JMenuBar menubar = new JMenuBar();
	public static JMenu opt = new JMenu("Options");

	public static void main(String[] args) throws FontFormatException, IOException{
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
		
		//set up option menus
		JMenuItem file = new JMenuItem("Save     ");
		menubar.add(opt);
		opt.add(file);

		//enable swing elements
		frame.setVisible(true);
		type.setVisible(true);
		menubar.setVisible(true);
                
	}//end main method
        
}//end class TextEditor

