package bonnie;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GridPanel extends JPanel {
	private Grid g;
	private ArrayList<NodePanel> nodePanels = new ArrayList<NodePanel>();
	
	public GridPanel(Grid g){
		this.g = g;
		setLayout(new GridLayout(g.getHeight(), g.getWidth()));
		for(int y = 0; y < g.getHeight(); y++){
			for(int x = 0; x < g.getWidth(); x++){
				NodePanel panel = new NodePanel(g.getValue(x, y));
				this.add(panel);
				nodePanels.add(panel);
			}
		}
	}
	public void update(){
		for(NodePanel panel : nodePanels){
			panel.update();
		}
	}
	
}
