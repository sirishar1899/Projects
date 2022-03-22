package com.econote;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frmRegistration;
	private JTextField txt;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frmRegistration.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistration = new JFrame();
		frmRegistration.setTitle("Registration");
		frmRegistration.setBounds(100, 100, 506, 397);
		frmRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistration.getContentPane().setLayout(null);
		
		JLabel First = new JLabel("First Name");
		First.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		First.setBounds(31, 102, 76, 16);
		frmRegistration.getContentPane().add(First);
		
		txt = new JTextField();
		txt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txt.setBounds(148, 144, 198, 16);
		frmRegistration.getContentPane().add(txt);
		txt.setColumns(10);
		
		JLabel Last = new JLabel("Last Name");
		Last.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Last.setBounds(31, 143, 76, 16);
		frmRegistration.getContentPane().add(Last);
		
		textField = new JTextField();
		textField.setBounds(148, 102, 198, 16);
		frmRegistration.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton Button = new JButton("Sumbit");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//output.setText(textField.getText());
			//	output.setText(textField.getText()+ " "+txt.getText());
				    String FirstName= textField.getText();
				    String lastName= txt.getText();
				    
				   
						try 
						{   
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							
							Connection cn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Reg","root","1234");
							
							String qry ="insert into user values(?,?)";
						PreparedStatement ps =cn.prepareStatement(qry)	;
							ps.setString(1, FirstName);
							ps.setString(2, lastName);
							
						int x= ps.executeUpdate();
						if(x==0)
						{
							JOptionPane.showMessageDialog(Button, "already exits");
						}
						else
						{
							JOptionPane.showMessageDialog(Button, "	Registraion successful");	
						}
						 
						 
							  
							ps.close();
							cn.close();
						}
						catch (ClassNotFoundException e) 
						{
							e.printStackTrace();
						}
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
			
			
				    
				
				
				
			
		});
		Button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Button.setBounds(148, 193, 124, 25);
		frmRegistration.getContentPane().add(Button);
		
		JLabel lblNewLabel = new JLabel("Registarion Page");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(127, 41, 187, 25);
		frmRegistration.getContentPane().add(lblNewLabel);
		
		JLabel success = new JLabel("");
		success.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		success.setBounds(240, 271, 163, 16);
		frmRegistration.getContentPane().add(success);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try 
				{   
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection cn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Reg","root","1234");
					//Statement stm=cn.createStatement();
					
					String qry = "select * from user where fname=? and lname=?" ;
					PreparedStatement ps =cn.prepareStatement(qry)	;
					ps.setString(1, textField.getText());
					ps.setString(2, txt.getText());
					
					ResultSet rs = ps.executeQuery();
					int count=0;
					while(rs.next())
					{
						//System.out.println(rs.getString("fname"));
				    	  //System.out.println(rs.getString("lname"));
				    	 count=count+1; 
				    	  
					}
					 
					if(count==1)
					{
						success s=new success();
				    	  s.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "incorrect names");
					}
					ps.close();
					cn.close();
				}
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
					
						
					
				
				
				
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin.setBounds(148, 249, 124, 25);
		frmRegistration.getContentPane().add(btnLogin);
	}
}
