/**
*	Main window of mychat with actionlistener
*
*
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MainWindow extends JFrame implements ActionListener{
	
	JTextArea messagelist;
	JTextField message;

	Date date;

	MainWindow(){
		super("My chat");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300,300, 400,500);

		messagelist = new JTextArea();
		messagelist.setEditable(false);
		
		JPanel bottompanel = new JPanel();
				
		message = new JTextField();
		message.addActionListener(this);
		JButton btnsend = new JButton("Send");
		btnsend.addActionListener(this);

		bottompanel.setLayout(new BoxLayout(bottompanel,BoxLayout.X_AXIS));
		bottompanel.add(message);
		bottompanel.add(btnsend);

		add(new JScrollPane(messagelist),BorderLayout.CENTER);
		add(bottompanel,BorderLayout.SOUTH);
		setVisible(true);

		date = new Date();
		message.requestFocusInWindow();
	}

	@Override
	public void actionPerformed(ActionEvent ev){
		if (message.getText().trim().length()>0){
			messagelist.append("("+date+") "+ message.getText()+"\n");
		}
		message.setText("");
		message.requestFocusInWindow();
	}
}