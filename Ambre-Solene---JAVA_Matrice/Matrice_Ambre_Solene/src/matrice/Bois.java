package matrice;

public class Bois extends Ressource implements Utilisable {
	private static final int POIDS_VALUE = 2;
	
	Bois (String identifiant){
		super(identifiant);
		setPoids(POIDS_VALUE);
	}
	
	@Override
	public ObjetManufacture utiliser(Ressource[] r) {
        if (r.length == 5) {
            for (Ressource ressource : r) {
                if (ressource == null || !(ressource instanceof Bois)) {
                    return null;
                }
            }
            return new ObjetManufacture("Feu");
        } else {
            return null;
        }
    }
}