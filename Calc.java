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

class Calc extends JFrame {
	JPanel pmenu = new JPanel();
	JPanel pdigits = new JPanel();
	JPanel poperators = new JPanel();
	JPanel pdisplay = new JPanel();

	JButton bclose = new JButton("close");	
 	JButton [] bdigits = new JButton[10];
	JButton [] boperators;
	JButton bpoint = new JButton(".");	

	JLabel display = new JLabel("0");

	final char [] OPERATORS = {'+','-','*','+','=','%','C'}; 
	
	Calc(){
		super("Square form");
		setBounds(200,100,400,400);						// #setSize(int h, int w);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// ---- panels ----
		setLayout(new BorderLayout());
		add(pdigits,BorderLayout.CENTER);
		add(poperators,BorderLayout.SOUTH);
		add(pdisplay,BorderLayout.NORTH);
		// ---- digit buttons ----
		pdigits.setLayout(new GridLayout(4,3));			//
		for (int i = 9; i>=0; i--){
			bdigits[i] = new JButton(Integer.toString(i));
			pdigits.add(bdigits[i]);
		}		
		pdigits.add(bpoint);
		// ----operator buttons----
		boperators = new JButton[OPERATORS.length];
		poperators.setLayout(new BoxLayout(poperators, BoxLayout.X_AXIS));
		for (int i = 0; i<OPERATORS.length;i++){
			boperators[i] = new JButton(""+OPERATORS[i]);
			boperators[i].setAlignmentX(CENTER_ALIGNMENT);
			poperators.add(boperators[i]);
		}
		poperators.add(bclose);
		
		pdisplay.add(display);
		bclose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        }); 
		
	}

	public static void main(String[] args) {
		Calc app = new Calc();
		app.setVisible(true);
//		app.pack();
	}
}

