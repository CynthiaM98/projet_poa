public class Chasseur extends Contenu {

    private int x;
    private int y;


    public Chasseur(int xTresor, int yTresor, int width, int height){
        x = (int)(Math.random()*width);
        while((x < xTresor+5) && (x > xTresor -5)) {
            x = (int)(Math.random()*width);
        }
        y = (int)(Math.random()*height);
        while((y < yTresor+3) && (y > yTresor-3)) {
            y = (int)(Math.random()*height);
        }
    }

    public boolean isMin(int x1, int x2, int x3, int x4) {
        return x1 < x2 && x1 < x3 && x1 < x4;
    }

    public boolean deplacementAutorise(Case[][] tabCase, int nextX, int nextY, int width, int height){
        if(nextY<0 || nextX<0 || nextY > height-1 || nextX > width-1) {
            return false;
        }

        return !tabCase[nextX][nextY].getContenu().isRocher();
    }


    //regarde les valeurs des cases adjacentes pour choisir la direction (1 fois sur 4 va dans la direction opposé)
    public void chooseDir(Case[][] tabCase, int width, int height, int xTresor, int yTresor){

        int randomDir = (int)(Math.random()*3)+1;
        if(randomDir == 1){
            randomDir = (int)(Math.random()*3)+1;
            switch (randomDir){ //cas ou deplacement de maniere random
                case 1 :
                    if(deplacementAutorise(tabCase, x+1, y, width, height)){
                        x = x+1;
                    }
                    else{
                        x = x-1;
                    }
                    break;
                case 2 :
                    if(deplacementAutorise(tabCase, x-1, y, width, height)){
                        x = x-1;
                    }
                    else{
                        x = x+1;
                    }
                    break;
                case 3 :
                    if( deplacementAutorise(tabCase, x, y+1, width, height)){
                        y = y+1;
                    }
                    else{
                        y = y-1;
                    }
                    break;
                case 4 :
                    if(deplacementAutorise(tabCase, x, y-1, width, height)){
                        y = y-1;
                    }
                    else{
                        y = y+1;
                    }
                    break;
            }
        }else { //cas de vrai déplacement
            int n, s, e, o;
            //partie pour trouvé la direction
            if(y>0){
                n = tabCase[x][y-1].getDistance(xTresor, yTresor);
            }else {
                n = 100;
            }

            if(y<width-1){
                s = tabCase[x][y+1].getDistance(xTresor, yTresor);
            }else {
                s = 100;
            }

            if(x>0){
                o = tabCase[x-1][y].getDistance(xTresor, yTresor);
            }else {
                o = 100;
            }

            if(x<height-1){
                e = tabCase[x+1][y].getDistance(xTresor, yTresor);
            }else {
                e = 100;
            }

            if(n!=100 && s!=100 && e!=100 && o!=100){
                if(isMin(n, s, e, o)){ //nord min
                    y = y-1;
                }else if(isMin(s, n, e, o)){ //sud min
                    y = y+1;
                }else if(isMin(e, o, s, n)){ //est min
                    x=x+1;
                }else if(isMin(o, e, s, n)) { //ouest min
                    x=x-1;
                }
            }//sinon chasseur bloqué

            //verification si trésor trouvé

        }
    }
}