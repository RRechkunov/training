/**
*
*_______ Create windows, forms, panels ,buttons_______
* 
*
*
* #Swing, #JFrame , #JPanel, #JButton, #BorderLayout, #BoxLayout, #GridLayout
*
*@author Rechkunov Roman
*@version 31.05-1
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame implements ActionListener{
	JPanel pmenu = new JPanel();
	JPanel pdigits = new JPanel();
	JPanel poperators = new JPanel();
	JPanel pdisplay = new JPanel();

	JButton bprev = new JButton("prev");
	JButton bnext = new JButton("next");
	JButton bclose = new JButton("close");
	
 	JButton [] bdigits = new JButton[10];
	JButton [] boperators;

	JLabel display = new JLabel("0");

	final char [] OPERATORS = {'+','-','*','+','=','%','C'}; 
	
	Window(){
		super("Square form");
		setBounds(200,100,500,500);						// #setSize(int h, int w);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//poperators.setPreferredSize(new Dimension(43,43));
		setLayout(new BorderLayout());
		add(pmenu,BorderLayout.SOUTH);
		add(pdigits,BorderLayout.CENTER);
		add(poperators,BorderLayout.EAST);
		add(pdisplay,BorderLayout.NORTH);

		pdigits.setLayout(new GridLayout(4,3));
		for (int i = 9; i>=0; i--){
			bdigits[i] = new JButton(Integer.toString(i));
			pdigits.add(bdigits[i]);
		}
		boperators = new JButton[OPERATORS.length];
		poperators.setLayout(new BoxLayout(poperators, BoxLayout.Y_AXIS));
		for (int i = 0; i<OPERATORS.length;i++){
			boperators[i] = new JButton(""+OPERATORS[i]);
			boperators[i].setAlignmentX(RIGHT_ALIGNMENT);
			poperators.add(boperators[i]);
		}
		pmenu.setLayout(new BorderLayout());
		pmenu.add(bclose,BorderLayout.CENTER);
//		bclose.addActionListener(this);

		pdisplay.add(display);

		setVisible(true);
	}
//	public void actionPerformed( ActionEvent event ){
//		display.setText(""+event.getSource().getLabel());
//	}

}

class GuiElements{

	public static void main(String[] args){
		Window gui = new Window();	
	}	
}