package com.nttdata.areaCalc.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AreaCalcUtil {
	
	
	//create objects for GUI
		public JFrame frmAreaCalculator;
		public JTextField textField_Width;
		public JTextField textField_Height;
		public JTextArea txtrHeightInFeet;
		public JTextArea txtrHeightInMetres;
	
public void initialize() {
		
		//create the frame
		frmAreaCalculator = new JFrame();
		frmAreaCalculator.setTitle("Area Calculator");
		frmAreaCalculator.setBounds(100, 100, 449, 368);
		frmAreaCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAreaCalculator.getContentPane().setLayout(null);
		
		//create field to input width
		textField_Width = new JTextField();
		textField_Width.setBounds(257, 128, 100, 26);
		frmAreaCalculator.getContentPane().add(textField_Width);
		textField_Width.setColumns(10);
		
		//create field to input height
		textField_Height = new JTextField();
		textField_Height.setBounds(257, 86, 100, 26);
		frmAreaCalculator.getContentPane().add(textField_Height);
		textField_Height.setColumns(10);
		
		//create text to give instruction to input width
		JTextArea txtrEnterWidth = new JTextArea();
		txtrEnterWidth.setEditable(false);
		txtrEnterWidth.setText("Enter Width");
		txtrEnterWidth.setBounds(77, 128, 100, 26);
		frmAreaCalculator.getContentPane().add(txtrEnterWidth);
		
		//create text to give instruction to input height
		JTextArea txtrEnterHeight = new JTextArea();
		txtrEnterHeight.setEditable(false);
		txtrEnterHeight.setText("Enter Height");
		txtrEnterHeight.setBounds(77, 86, 100, 26);
		frmAreaCalculator.getContentPane().add(txtrEnterHeight);
		
		//create text to show height in feet
		txtrHeightInFeet = new JTextArea();
		txtrHeightInFeet.setEditable(false);
		txtrHeightInFeet.setText("Height in Feet");
		txtrHeightInFeet.setBounds(38, 231, 139, 26);
		frmAreaCalculator.getContentPane().add(txtrHeightInFeet);
		
		//create text to show height in metres
		txtrHeightInMetres = new JTextArea();
		txtrHeightInMetres.setEditable(false);
		txtrHeightInMetres.setText("Height in Metres");
		txtrHeightInMetres.setBounds(38, 273, 139, 26);
		frmAreaCalculator.getContentPane().add(txtrHeightInMetres);
		
		//create text field to display the answer in feet
		JTextArea txtrHeightInFeet_1 = new JTextArea();
		txtrHeightInFeet_1.setEnabled(false);
		txtrHeightInFeet_1.setText("0");
		txtrHeightInFeet_1.setBounds(218, 231, 139, 26);
		frmAreaCalculator.getContentPane().add(txtrHeightInFeet_1);
		
		//create text field to display the answer in metres
		JTextArea txtrHeightInMetres_1 = new JTextArea();
		txtrHeightInMetres_1.setEnabled(false);
		txtrHeightInMetres_1.setText("0");
		txtrHeightInMetres_1.setBounds(218, 273, 139, 26);
		frmAreaCalculator.getContentPane().add(txtrHeightInMetres_1);
		
		//create error label
		JLabel errorLabel = new JLabel(" ");
		errorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		errorLabel.setBounds(38, 159, 319, 20);
		frmAreaCalculator.getContentPane().add(errorLabel);
		
		//create button to calculate area show answer
		JButton btnCalculate = new JButton("Submit");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//create varaibles to store input
				double height = 0;
				double width = 0; 
				boolean calculateh = false;
				boolean calculatew = false;
				
				String error1 = "";
				String error2 = "";
				
				//store height and width data
				try {
				height = Double.parseDouble(textField_Height.getText());
				calculateh = true;
				}catch (Exception e1) {
					calculateh = false;
					textField_Height.setText(null);
					error1 = "height";
					txtrHeightInFeet_1.setText("0");
					txtrHeightInMetres_1.setText("0");
					errorLabel.setText("Please input value for " + error1 + " " + error2);
					
				}
				
				try {
				width = Double.parseDouble(textField_Width.getText());
				calculatew = true;
					}catch (Exception e1) {
						calculatew = false;
						textField_Width.setText(null);
						error2 = "width";
						txtrHeightInFeet_1.setText("0");
						txtrHeightInMetres_1.setText("0");
						errorLabel.setText("Please input value for " + error1 + " " + error2);
					}
								
				
				
				if (calculateh && calculatew) {
				//calculate area in feet
				double result = height * width;
				System.out.println(height + "   " + width);
				//convert to metres
				double resultInMetres = result * 0.09290304;
				
				//convert double ans to string type
				String ans = String.format("%.2f", result);
				String ansInMetres = String.format("%.2f", resultInMetres);
				//set value of text areas as value of area.
				txtrHeightInFeet_1.setText(ans);
				txtrHeightInMetres_1.setText(ansInMetres);
				//set error label to show success
				errorLabel.setText("Calculation Successful.");
				}
			}
		});
		btnCalculate.setBounds(242, 183, 115, 29);
		frmAreaCalculator.getContentPane().add(btnCalculate);
		
		
	}

}
