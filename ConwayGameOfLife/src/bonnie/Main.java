package bonnie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int size = 50;
		JFrame frame= new JFrame();
		Grid g = new Grid(size, size);
		GridPanel gp = new GridPanel(g);
		frame.getContentPane().add(gp);
		frame.setTitle("All praise the holy Bonnie, woof woof");
		
		frame.setSize(600, 600);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Timer timer = new Timer(300, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				g.prepareNextTurn();
				g.nextTurn();
				gp.update();
			}
		});
		gp.update();
		timer.setInitialDelay(200);
		timer.start(); 
		
		
		/*g.getValue(2, 4).setLife(true);
		g.getValue(2, 3).setLife(true);
		g.getValue(3, 3).setLife(true);
		g.getValue(4, 3).setLife(true);
		g.getValue(3, 5).setLife(true);*/
		
		//g.print();
		/*while(true){
			g.prepareNextTurn();
			g.nextTurn();
			g.print();
			Thread.sleep(150);*/
		//}
	}
}
