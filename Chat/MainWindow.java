/**
*	Main window of mychat with actionlistener
*
*
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainWindow extends JFrame implements ActionListener{
	
	JTextArea messagelist;
	JTextField message;

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
	}

	@Override
	public void actionPerformed(ActionEvent ev){
		if (message.getText().length()>0){
			messagelist.append(message.getText()+"\n");
		}
		message.setText("");
	}
}