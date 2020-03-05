package com.nttdata.areaCalc.main;

import java.awt.EventQueue;

import com.nttdata.areaCalc.util.AreaCalcUtil;

public class AreaCalculator {
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//create thread of calculator
			public void run() {
				try {
					//create calculator object
					AreaCalcUtil window = new AreaCalcUtil();
					window.initialize();
					window.frmAreaCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
