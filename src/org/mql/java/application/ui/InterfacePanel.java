package org.mql.java.application.ui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.mql.java.application.models.ContainerInterface;

public class InterfacePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	public InterfacePanel(ContainerInterface interf) {
		
		container = new JPanel();
		addTitlePanel(interf);
		add(container);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		addMethodPanel(interf);
		
	}
	void addTitlePanel(ContainerInterface interf) {
		container.add(new TitlePanel(interf));
	}
	void addMethodPanel(ContainerInterface interf) {
		container.add(new MethodPanel(interf.getInnerMethods()));
	}
	
}
