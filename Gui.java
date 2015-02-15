import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Frame.*;

import javax.sql.*;

public class Gui implements ActionListener{
	
	public JButton Register,Login,Exit,OK,Reset,Reg,OKj5;
	public JFrame j1,j2,j3,j4,j5,j6;
	public JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,lj6;
	public JTextField t1,t2,t3;
	public JPasswordField p1,p2,p3;
	public JTextArea t4;
	
	
	public Gui(){
		
		JFrame j1 = new JFrame("Welcome");
		

		j1.setLayout(new FlowLayout());
		
		
		Register = new JButton("Register");
		Login = new JButton("Login");
		Exit = new JButton("Exit");
		OK = new JButton("OK");
		Reset = new JButton("Reset");
		Reg = new JButton("Click To Register");
		OKj5 = new JButton("OK");
		
		
		l1 = new JLabel("Username");
		l2 = new JLabel("Password");
		l3 = new JLabel("Name");
		l4 = new JLabel("\nUsername");
		l5 = new JLabel("\nPassword");
		l6 = new JLabel("\nConfirm Password");
		l7 = new JLabel("Passwords Do Not Match");
		//lj6 = new JLabel("This is The Main Editor Window");
		
		t1 = new JTextField(20);
		t4 = new JTextArea(50,50);
		p1 = new JPasswordField(15);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		p2 = new JPasswordField(15);
		p3 = new JPasswordField(15);
		
		
		
		j1.add(Register);
		j1.add(Login);
		j1.add(Exit);
		
		
		
		Register.addActionListener(this);
		Login.addActionListener(this);
		Exit.addActionListener(this);
		OK.addActionListener(this);
		Reset.addActionListener(this);
		Reg.addActionListener(this);
		OKj5.addActionListener(this);
		
		j1.setSize(500,500);
		j1.setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==Register){
			
			JFrame j3 = new JFrame("Registration Window");
			j3.setLayout(new FlowLayout());
			j3.add(l3);
			j3.add(t2);
			j3.add(l4);
			j3.add(t3);
			j3.add(l5);
			j3.add(p2);
			j3.add(l6);
			j3.add(p3);
			j3.add(Reg);
			j3.setSize(340,340);
			j3.setVisible(true);
			
	
		}
		
		if(e.getSource()==Login){
			
			JFrame j2 = new JFrame("LoginWindow");
			j2.setLayout(new FlowLayout());
			j2.add(l1);
			j2.add(t1);
			j2.add(l2);
			j2.add(p1);
			j2.add(OK);
			j2.add(Reset);
			j2.setSize(500,500);
			j2.setVisible(true);
			
			}
		
		if(e.getSource()==Exit){
			System.exit(0);
		}
		
		if(e.getSource()==Reset){
			
			t1.setText("");
			p1.setText("");
			
		}
		
		if(e.getSource()==Reg){
			String s1,s2,s3;
			char[] check1 = p2.getPassword();
			char[] check2 = p3.getPassword();
			s1 = String.valueOf(check1);
			s2 = String.valueOf(check2);
			if(!(s1.equals(s2))){
				j5 = new JFrame("Error");
				j5.setLayout(new FlowLayout());
				j5.setSize(300,300);
				j5.add(l7);
				j5.add(OKj5);
				j5.setVisible(true);
				
			}
			s1 = String.valueOf(check1);
			s2 = t2.getText();
			s3 = t3.getText();
			try{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_editor","root","root");
			Statement stmt=conn.createStatement();
			int rs = stmt.executeUpdate("INSERT INTO user_pass VALUES('"+s3+"','"+s1+"','"+s2+"');");
			}
			catch(Exception ex){
				ex.printStackTrace();
				
			}
			
		}
		if(e.getSource()==OKj5){
			j5.setVisible(false);
		}
		if(e.getSource()==OK){
			String s4=t1.getText();
			char[] check = p1.getPassword();
			String s5=String.valueOf(check);
			try{
				Connection conn1 = null;
				Class.forName("com.mysql.jdbc.Driver");
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_editor","root","root");
				Statement stmt1=conn1.createStatement();
				ResultSet rs1=stmt1.executeQuery("SELECT user,pass FROM user_pass WHERE user='"+s4+"' AND pass='"+s5+"';");
				if(rs1.next()){
					JFrame j6 = new JFrame("Editort Window");
					j6.setLayout(new FlowLayout());
					j6.setExtendedState(JFrame.MAXIMIZED_BOTH);
					j6.add(t4);
					
					j6.setVisible(true);
					
				}
				
			
		}
			catch(Exception log){
				log.printStackTrace();
				}
			
			
			
		}
		
}
}





