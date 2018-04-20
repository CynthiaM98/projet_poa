import java.util.PriorityQueue;

public class Jeu {
    private Case[][] tabCase;
    private int rocherRest;
    private boolean gameover;
    private boolean isFound;
    private int xTresor;
    private int yTresor;
    private PriorityQueue<Chasseur> listChasseur;

    public Jeu(int width, int height){
        Case[][] tabCase = new Case[width][height];
        rocherRest = 10;
        gameover = false;
        isFound = false;
        xTresor = (int)(Math.random()*width);
        yTresor = (int)(Math.random()*height);

        for (int i = 0; i<5 ; i++) {
            Chasseur c = new Chasseur(xTresor, yTresor, width, height);
            listChasseur.add(c);
        }
    }

    public void poserRocher(int x, int y){
        //pose un rocher sur la map : new rocher
    }

    public void prendreRocher(int x, int y){
        //retire le rocher d'une case
    }


}
