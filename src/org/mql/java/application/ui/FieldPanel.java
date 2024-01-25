package org.mql.java.application.ui;

import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.mql.java.application.models.ContainerField;


public class FieldPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public FieldPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK),   
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK), 
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK),  
                                BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK)   
                        )
                )
        );
		 setBorder(border);
		
	}
	public FieldPanel(List<ContainerField> items) {
		this();
		if (items.isEmpty()) {
			addField("");
		}
		else {
		for (ContainerField it : items) {
			addField(it.toString());
			}
		}
	}
	private void addField(String item){
		add(new LabelField(item));
	}

}
