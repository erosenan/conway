package bonnie;

import java.awt.Color;

import javax.swing.JPanel;

public class NodePanel extends JPanel {
	Node node;
	public NodePanel(Node current){
		this.node = current;
	}
	
	public void update(){
		setBackground(node.isAlive() ? Color.black : Color.white);
	}
}
