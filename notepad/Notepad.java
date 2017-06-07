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
	private JMenuItem mfnew,mfopen,mfsave,mfsettings,mfexit,mecopy,mepaste,mecut;
	private JTextArea textarea;
	private JLabel sblabel;
	Notepad(){
		super("Notepad");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100, 500,300);
		initMenu();
		initWorkPlace();
		initListeners();
	}

	void initMenu() {
		Font font = new Font("Verdana", Font.PLAIN, 11);

		JMenuBar menubar = new JMenuBar();
		JMenu mfile = new JMenu("File");
		mfnew = new JMenuItem("New");
		mfopen = new JMenuItem("Open");
		mfsave = new JMenuItem("Save");
		mfsettings = new JMenuItem("Settings");	
		mfexit = new JMenuItem("Exit");
		mfile.add(mfopen);
		mfile.add(mfnew);
		mfile.add(mfsave);
		mfile.add(mfsettings);
		mfile.add(mfexit);
		mfile.setFont(font);
		mfopen.setFont(font);
		mfnew.setFont(font);
		mfsave.setFont(font);
		mfsettings.setFont(font);
		mfexit.setFont(font);
		JMenu medit = new JMenu("Edit");
		mecopy = new JMenuItem("Copy"); 
		mecut = new JMenuItem("Cut");
		mepaste = new JMenuItem("Paste");
		medit.add(mecopy);
		medit.add(mecut);
		medit.add(mepaste);
		medit.setFont(font);

		menubar.add(mfile);
		menubar.add(medit);
		setJMenuBar(menubar);

	}

	void initWorkPlace(){
		Font font = new Font("Verdana", Font.PLAIN, 9);

		JPanel wppanel = new JPanel(new BorderLayout());
		textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		wppanel.add(new JScrollPane(textarea),BorderLayout.CENTER);

		JPanel sbpanel = new JPanel(new BorderLayout());
		sblabel = new JLabel("New document",JLabel.LEFT);
		sblabel.setFont(font);
		wppanel.add(sblabel,BorderLayout.SOUTH);
		this.add(wppanel);
	}

	
	void initListeners(){

		mfopen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				FileDialog filedialog = new FileDialog((Frame) null,"Load file",FileDialog.LOAD); 
				filedialog.show();
				textarea.append(filedialog.getDirectory()+filedialog.getFile()+"\n");
            }
        });

   		mfnew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });      

    	mfsave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

    	mfsettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
            }
        }); 
    
    	mfexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

	}
	public static void main(String[] args) {
		Notepad app = new Notepad();
		app.setVisible(true);
	}
}