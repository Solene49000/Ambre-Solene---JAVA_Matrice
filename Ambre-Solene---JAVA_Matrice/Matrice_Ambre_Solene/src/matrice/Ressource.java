package matrice;

public class Ressource {
	private int poids;
	private String identifiant;
	private static final int POIDS_VALUE = 0;

	Ressource(String identifiant){
		this.setIdentifiant(identifiant);
		this.poids = POIDS_VALUE;
	}

	/**
	 * @return the poids
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * @param poids the poids to set
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

	/**
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
}
