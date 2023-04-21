package matrice;

public class Pierre extends Ressource implements Utilisable  {
	private static final int POIDS_VALUE = 3;
	
	Pierre (String identifiant){
		super(identifiant);
		setPoids(POIDS_VALUE);
	}
	
	@Override
    public ObjetManufacture utiliser(Ressource[] r) {
        if (r.length == 10) {
            int nbBle = 0;
            for (Ressource ressource : r) {
                if (ressource == null || !(ressource instanceof Ble)) {
                    return null;
                }
                nbBle++;
            }
            if (nbBle == 10) {
                return new ObjetManufacture("Farine");
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
