package org.mql.java.application.ui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelField extends JPanel{
	private static final long serialVersionUID = 1L;

	public LabelField(String item) {
		
		 setLayout(new FlowLayout(FlowLayout.LEFT)); 
		 JLabel l1 = new JLabel(item);
		 add(l1);
	}

}
