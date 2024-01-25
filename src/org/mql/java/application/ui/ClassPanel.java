package org.mql.java.application.ui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.mql.java.application.models.ContainerClass;

public class ClassPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JPanel container;

	public ClassPanel(ContainerClass clz) {
		if (clz.getCurrclassFields()!= null || !clz.getCurrclassFields().isEmpty()) {
		container = new JPanel();
		add(container);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		addTitlePanel(clz);
		addFieldPanel(clz);
		addMethodPanel(clz);
		}
	}
	
	void addTitlePanel(ContainerClass clz) {
		container.add(new TitlePanel(clz));
	}
	
	void addFieldPanel(ContainerClass clz) {
			container.add(new FieldPanel(clz.getCurrclassFields()));
	}
	
	void addMethodPanel(ContainerClass clz) {
			container.add(new MethodPanel(clz.getCurrclassmethods()));
	}
	
}
