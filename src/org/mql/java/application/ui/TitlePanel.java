package org.mql.java.application.ui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.mql.java.application.models.ContainerClass;
import org.mql.java.application.models.ContainerInterface;
import org.mql.java.application.models.ContainerPackage;
import org.mql.java.application.utils.StringUtils;


public class TitlePanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public TitlePanel(ContainerClass clz) {
		JLabel l1 = new JLabel(StringUtils.toclassQName(clz.getName()));
		add(l1);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK),   
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
	public TitlePanel(ContainerInterface interf) {
		JLabel l1 = new JLabel("<<interface>>");
		l1.setAlignmentX(CENTER_ALIGNMENT);
		add(l1);
		JLabel l2 = new JLabel(StringUtils.toInterfQName(interf.getName()));
		l2.setAlignmentX(CENTER_ALIGNMENT);
		add(l2);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK),   
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
	
	public TitlePanel(ContainerPackage pck) {
		JLabel l2 = new JLabel(pck.getPackageName());
		add(l2);
		setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK),   
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



}
