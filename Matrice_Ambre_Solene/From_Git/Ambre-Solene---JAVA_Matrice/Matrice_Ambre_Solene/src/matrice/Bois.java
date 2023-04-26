package matrice;

public class Bois extends Ressource implements Utilisable {
	private static final int POIDS_VALUE = 2;
	
	Bois (String identifiant){
		super(identifiant);
		setPoids(POIDS_VALUE);
	}
	
	@Override
	public ObjetManufacture utiliser(Ressource[] r) {
	    if (r.length != 5) {
	        throw new IllegalArgumentException("Le tableau de ressources doit contenir exactement 5 éléments de bois.");
	    }
	    for (Ressource ressource : r) {
	        if (ressource instanceof Bois) {
	            throw new IllegalArgumentException("Les éléments du tableau de ressources doivent être différents.");
	        }
	    }
	    return new ObjetManufacture("Feu");
	}
}