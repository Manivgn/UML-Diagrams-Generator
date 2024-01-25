package org.mql.java.application.ui;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.mql.java.application.models.ContainerPackage;
import org.mql.java.application.models.ContainerProject;
import org.mql.java.application.reflection.ProjectExplorer;


public class ProjectDiagram extends JFrame{
	
	private JFrame frame ;
	JPanel main  ;
	String path ="";

	
	private static final long serialVersionUID = 1L;

	public ProjectDiagram(String project) {
		ProjectExplorer p = new ProjectExplorer(project);
		ContainerProject cp = p.getCtnpro();
		cp.generateContainerPackage();
		
		frame = new JFrame("Diagrams Generator");
		main = new JPanel();
		for(ContainerPackage ctnpck: cp.getCtnpcklist()) {
			PackagePanel pp = new PackagePanel(ctnpck);
			main.add(pp);
		}
		//main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		config();
		
	}
	
	void config(){
		JScrollPane jsp = new JScrollPane(main);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		frame.setContentPane(jsp);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


}
