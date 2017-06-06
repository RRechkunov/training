/**
*
*_______ Very simple notepad_______
* 
*	Tasks:
*	1 - interface
*	2 - windows with options
*	3 - menu - 1 -file  new/open/save file; 2 - edit font\size
* 	
*
*@author Rechkunov Roman
*@version 0.01
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Notepad extends JFrame {

	Notepad(){
		super("Notepad");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,300);
		initMenu();
		initWorkPlace();
	}

	void initMenu(){
		JMenuBar menubar = new JMenuBar();
		JMenu mfile = new JMenu("File");
		JMenuItem mfnew = new JMenuItem("New");
		JMenuItem mfopen = new JMenuItem("Open");
		JMenuItem mfsave = new JMenuItem("Save");
		mfile.add(mfopen);
		mfile.add(mfnew);
		mfile.add(mfsave);
		JMenu medit = new JMenu("Edit");


		menubar.add(mfile);
		menubar.add(medit);
		setJMenuBar(menubar);
	}

	void initWorkPlace(){

	}

	public static void main(String[] args) {
		Notepad app = new Notepad();
		app.setVisible(true);
	}
}