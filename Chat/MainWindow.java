/**
*	Main window of mychat with actionlistener
*
*
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;

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

		message.requestFocusInWindow();
	}

	@Override
	public void actionPerformed(ActionEvent ev){
		SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
		String s = "("+dateformat.format(new Date())+") "+ message.getText()+"\n";
		if (message.getText().trim().length()>0){
			messagelist.append(s);
			try 
			{
				PrintWriter pw = new PrintWriter(new FileWriter("Dialogs.txt",true)); 
				pw.println(s);
				//pw.flush();
				pw.close();
			}
			catch (IOException e) 
			{
				System.out.println("Output error");
			}

		}
		message.setText("");
		message.requestFocusInWindow();
	}
}