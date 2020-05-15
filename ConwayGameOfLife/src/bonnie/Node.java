package bonnie;

public class Node {
	private int x;
	private int y;
	private boolean isAlive;
	private boolean isAliveNextTurn;
	private Grid g;
	
	public Node(int x, int y, Grid g){
		this.x = x;
		this.y = y;
		this.g = g;
		this.isAlive = false;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	public void determineLife(){
		int c = this.isAlive ? -1 : 0;
		for(int i = -1; i < 2; i ++){
			for(int j = -1; j < 2; j ++){
				//System.out.print("(" + (j + this.x) + ", " + (i + this.y) + ") ");
				if(g.getValue(j + this.x, i + this.y) != null && g.getValue(j + this.x, i + this.y).isAlive()){
					if(c > 2){
						//System.out.println("removing: (" + x + ", " + y + ")");
						isAliveNextTurn = false;
						return;
					}
					c ++;
				}
			}
		}
		//System.out.println("Checking: (" + x + ", " + y + ") " + c);
		//if(isAlive){
			//System.out.print("(" + x + ", " + y + ") " + c);
			//System.out.println("c = " + c);
			if(c == 3)
				isAliveNextTurn = true;
			else if(c == 2 && isAlive)
				isAliveNextTurn = true;
			else
				isAliveNextTurn = false;
		//}
	}
	
	public void nextTurn(){
		this.isAlive = this.isAliveNextTurn;
	}
	
	public void setLife(boolean isAlive){
		this.isAlive = isAlive;
	}
}
