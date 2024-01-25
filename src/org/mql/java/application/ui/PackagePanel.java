package org.mql.java.application.ui;



import java.awt.Color;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.mql.java.application.models.ContainerClass;
import org.mql.java.application.models.ContainerInterface;
import org.mql.java.application.models.ContainerPackage;

public class PackagePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	
	public PackagePanel(ContainerPackage pck) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.white);
		add(new TitlePanel(pck));
		container = new JPanel();
		add(container);
		container.setBackground(Color.white);
		
		Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK),   
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 2, 0, 0, Color.BLACK), 
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK),  
                                BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK)   
                        )
                )
        );
		 container.setBorder(border);
		//container.setLayout(new FlowLayout(FlowLayout.LEFT));
		for (ContainerClass item : pck.getClasslist()) {
			addClassPanel(item);
		}
		for (ContainerInterface item : pck.getInterfacelist()) {
			addInterfPanel(item);
		}
	}
	public void addClassPanel(ContainerClass clzz) {
		container.add(new ClassPanel(clzz));
	}
	public void addInterfPanel(ContainerInterface inter) {
		container.add(new InterfacePanel(inter));
	}
}
