/**
*
* ----- GUI ELEMENTS ------
* - window
* 
* #Swing, #JFrame, 
*
*	#JSlider, #JProgressBar  #JMenuBar   -  add it to this example later
*/
import javax.swing.*;
import java.awt.event.*;

class Window extends JFrame{
	ImageIcon cofepic = new ImageIcon("p0.png");
	ImageIcon beerpic = new ImageIcon("p1.png");
	JButton btncofe = new JButton("Cofe",cofepic);

	Window(){
		super("Another one window");
		setBounds(300,200,400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		JPanel pnl = new JPanel(); 
		add(pnl);
		JButton [] btn = new JButton[3];
		for (int i=0;i<3;i++){
			btn[i] = new JButton("click "+ i);
			pnl.add(btn[i]);	
		}
			
		btncofe.setToolTipText("Do you want some cofee???"); 
		pnl.add(btncofe);

		JLabel lblbeer = new JLabel("beer",beerpic,JLabel.CENTER);
		lblbeer.setToolTipText("It's just a picture of the beer"); 
		lblbeer.setHorizontalTextPosition(JLabel.CENTER);
		lblbeer.setVerticalTextPosition(JLabel.BOTTOM);
		pnl.add(lblbeer);

		JTextField textfield = new JTextField("enter your login",10);
		pnl.add(textfield);

		JPasswordField textpassfield = new JPasswordField(10);
		pnl.add(textpassfield);

		JTextArea textarea = new JTextArea(10,10);
		JScrollPane scroll = new JScrollPane(textarea);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ) ;
		pnl.add(scroll);

		btncofe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }); 
		
		String [] fruits = {"banana","apple","orange","coconut"};
		String [] color = {"yellow","green","orange","brown"};
		JCheckBox check1 = new JCheckBox(fruits[0]);
		JCheckBox check2 = new JCheckBox(fruits[1],true);
		JCheckBox check3 = new JCheckBox(fruits[2]);
		JCheckBox check4 = new JCheckBox(fruits[3]);
		pnl.add(check1);
		pnl.add(check2);
		pnl.add(check3);
		pnl.add(check4);

		JComboBox<String> box1 = new JComboBox<String>(color);
		box1.setSelectedIndex(3);
		pnl.add(box1);

		JList<String> lst1 = new JList<String>(fruits) ;
		pnl.add(lst1);

		JRadioButton rad1 = new JRadioButton("Sun");
		JRadioButton rad2 = new JRadioButton("Earth");
		JRadioButton rad3 = new JRadioButton("Jupiter", true);
		ButtonGroup nonplanet = new ButtonGroup();
		nonplanet.add(rad1);
		nonplanet.add(rad2);
		nonplanet.add(rad3);
		pnl.add(rad1);
		pnl.add(rad2);
		pnl.add(rad3);
	}

	public static void main(String[] args) {
		Window app = new Window();
		app.setVisible(true);
		app.pack();
	}
}