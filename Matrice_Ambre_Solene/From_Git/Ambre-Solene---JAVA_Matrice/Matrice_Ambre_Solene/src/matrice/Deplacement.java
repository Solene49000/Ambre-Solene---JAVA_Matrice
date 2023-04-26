package matrice;

public enum Deplacement {

	    HAUT(-1, 0),
	    BAS(1, 0),
	    GAUCHE(0, -1),
	    DROITE(0, 1);

	    private final int deltaX;
	    private final int deltaY;

	    Deplacement(int deltaX, int deltaY) {
	        this.deltaX = deltaX;
	        this.deltaY = deltaY;
	    }

	    public int getDeltaX() {
	        return deltaX;
	    }

	    public int getDeltaY() {
	        return deltaY;
	    }
	
}
