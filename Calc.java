/**
*
*_______ Very simple Calculator_______
* 
*	float operations nor realised
*	operators % ^ not realized
* 	#OOP fail  
*
*@author Rechkunov Roman
*@version 31.05-3
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calc extends JFrame implements ActionListener{
	JPanel pmenu = new JPanel();
	JPanel pdigits = new JPanel(new GridLayout(4,3));
	JPanel poperators = new JPanel();
	JPanel pdisplay = new JPanel();

 	JButton [] bdigits;
	JButton [] boperators;
	JButton bclose = new JButton("close");

	JLabel display = new JLabel("0");

	final char [] OPERATORS = {'+','-','*','+','=','%','^','C'}; 
	final char [] DIGITS = {'<','.','0','1','2','3','4','5','6','7','8','9'};

	private int a,b;
	private char operator;
	private boolean inmemory = false;
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
		bdigits = new JButton[DIGITS.length];		
		for (int i = DIGITS.length-1; i>=0; i--){
			bdigits[i] = new JButton(""+DIGITS[i]);
			bdigits[i].addActionListener(this);
			pdigits.add(bdigits[i]);
		}
		// ----operator buttons----
		boperators = new JButton[OPERATORS.length];
		poperators.setLayout(new BoxLayout(poperators, BoxLayout.X_AXIS));
		for (int i = 0; i<OPERATORS.length;i++){
			boperators[i] = new JButton(""+OPERATORS[i]);
			boperators[i].setAlignmentX(CENTER_ALIGNMENT);
			boperators[i].addActionListener(this);
			poperators.add(boperators[i]);
		}
		poperators.add(bclose);
		
		//pdisplay.setBackground(Color.WHITE);
		pdisplay.add(display);
		bclose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); 
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String text = display.getText();
		char key = e.getActionCommand().charAt(0);
		
  		
  		switch (key) {
  			case '0': case '9': case '8': case '7':case '6'	: case '5':
  				case '4': case '3': case '2':case '1':
  				if (text.equals("0")) display.setText("");  //erase first zero
  				if (inmemory==true) {
  					display.setText("");
  					inmemory = false;	
  				}
  				display.setText(display.getText()+e.getActionCommand());
  				break;
  			case '.':
  			if (text.indexOf('.') == -1) 
  				display.setText(display.getText()+e.getActionCommand());

  			break;	
			case '-': case '+': case '/': case '*':
				a = Integer.parseInt(text);
				operator = key;
				inmemory = true;
				break;
	   		case '=':
	   			inmemory = true;
				display.setText(""+calculate(a,Integer.parseInt(text),operator));
				break;
			case 'C':
				display.setText("0");
				break;	
			case '<':
				if (text.length() == 1)
					display.setText("0");
					else display.setText(text.substring(0,text.length()-1));
				break;
			case '%':
	   			System.out.println("not realised yet");
				break;
			case '^':
	   			System.out.println("not realised yet");
				break;		
		}
    }

	static int calculate(int a,int b,char op){
		int result = 0;
		switch (op) {
			case '-':
				result = a-b;			
				break;
	   		case '+':
				result = a+b;
				break;
			case '/':
				if (b==0) {
					result = 0;
					break;
				} else result = a/b;
				break;
			case '*':
				result = a*b;
				break;	
		}
								
		System.out.printf("a = %d; b = %d ; key = %c\n",a,b,op);
		return result;
    }

	public static void main(String[] args) {
		Calc app = new Calc();
		app.setVisible(true);
//		app.pack();
	}
}

