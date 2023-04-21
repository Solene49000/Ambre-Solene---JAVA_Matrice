package matrice;

import java.util.ArrayList;


public class Heros {
	private String nom;
    private ArrayList<Ressource> stockBle;
    private ArrayList<Ressource> stockBois;
    private Pierre pierre;
    private ObjetManufacture farine;
    private ObjetManufacture feu;
    private int poidsEmporte;
    private int nbPartiesJouees;
    private int[] caseCourante;

    public void Hero(String nom) {
        this.setNom(nom);
        this.setStockBle(new ArrayList<Ressource>());
        this.setStockBois(new ArrayList<Ressource>());
        this.setPierre(null);
        this.setFarine(null);
        this.setFeu(null);
        this.setPoidsEmporte(0);
        this.setNbPartiesJouees(0);
        this.setCaseCourante(new int[]{0, 0});
    }

	/**
	 * @return the stockBle
	 */
	public ArrayList<Ressource> getStockBle() {
		return stockBle;
	}

	/**
	 * @param stockBle the stockBle to set
	 */
	public void setStockBle(ArrayList<Ressource> stockBle) {
		this.stockBle = stockBle;
	}

	/**
	 * @return the pierre
	 */
	public Pierre getPierre() {
		return pierre;
	}

	/**
	 * @param pierre the pierre to set
	 */
	public void setPierre(Pierre pierre) {
		this.pierre = pierre;
	}

	/**
	 * @return the farine
	 */
	public ObjetManufacture getFarine() {
		return farine;
	}

	/**
	 * @param farine the farine to set
	 */
	public void setFarine(ObjetManufacture farine) {
		this.farine = farine;
	}

	/**
	 * @return the feu
	 */
	public ObjetManufacture getFeu() {
		return feu;
	}

	/**
	 * @param feu the feu to set
	 */
	public void setFeu(ObjetManufacture feu) {
		this.feu = feu;
	}

	/**
	 * @return the poidsEmporte
	 */
	public int getPoidsEmporte() {
		return poidsEmporte;
	}

	/**
	 * @param poidsEmporte the poidsEmporte to set
	 */
	public void setPoidsEmporte(int poidsEmporte) {
		this.poidsEmporte = poidsEmporte;
	}

	/**
	 * @return the nbPartiesJouees
	 */
	public int getNbPartiesJouees() {
		return nbPartiesJouees;
	}

	/**
	 * @param nbPartiesJouees the nbPartiesJouees to set
	 */
	public void setNbPartiesJouees(int nbPartiesJouees) {
		this.nbPartiesJouees = nbPartiesJouees;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the caseCourante
	 */
	public int[] getCaseCourante() {
		return caseCourante;
	}

	/**
	 * @param caseCourante the caseCourante to set
	 */
	public void setCaseCourante(int[] caseCourante) {
		this.caseCourante = caseCourante;
	}

	/**
	 * @return the stockBois
	 */
	public ArrayList<Ressource> getStockBois() {
		return stockBois;
	}

	/**
	 * @param stockBois the stockBois to set
	 */
	public void setStockBois(ArrayList<Ressource> stockBois) {
		this.stockBois = stockBois;
	}
}
