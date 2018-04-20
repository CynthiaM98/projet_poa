public class Case{
	private int x;
	private int y;
	private int distanceTresor;
	private Contenu contenu;


	public Case(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getDistance(int xTresor, int yTresor){
		//calcul de la distance par rapport au trésor
		return 1;
	}

}