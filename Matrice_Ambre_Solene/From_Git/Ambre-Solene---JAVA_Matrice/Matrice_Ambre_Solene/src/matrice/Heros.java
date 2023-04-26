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
    private int partiesJouees;
    public Pair<Integer, Integer> positionActuelle;

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
	public int getPartiesJouees() {
		return partiesJouees;
	}

	/**
	 * @param nbPartiesJouees the nbPartiesJouees to set
	 */
	public void setPartiesJouees(int partiesJouees) {
		this.partiesJouees = partiesJouees;
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

	public void Hero(String nom) {
	    this.nom = nom;
	    this.stockBle = new ArrayList<>();
	    this.stockBois = new ArrayList<>();
	    this.pierre = null;
	    this.farine = null;
	    this.feu = null;
	    this.poidsEmporte = 0;
	    this.partiesJouees = 0;
	    this.positionActuelle = new Pair<>(0,0);
	    }
	
	private void prendre(Ressource ressource) {
        if (poidsEmporte + ressource.getPoids() > 13) {
            throw new IllegalStateException("Poids maximum atteint.");
        }
        poidsEmporte += ressource.getPoids();
        if (ressource instanceof Ble) {
            stockBle.add(ressource);
        } else if (ressource instanceof Bois) {
            stockBois.add(ressource);
        } else if (ressource instanceof Pierre) {
            pierre = (Pierre) ressource;
        }
    }
	
	private void seDeplacer(Deplacement direction, Ressource[][] map) {
        int x = positionActuelle.getKey();
        int y = positionActuelle.getValue();
        switch (direction) {
            case HAUT:
                if (x == 0) {
                    throw new IllegalArgumentException("Impossible de sortir de la Matrice.");
                }
                positionActuelle = new Pair<Integer, Integer>(x - 1, y);
                break;
            case BAS:
                if (x == 9) {
                    throw new IllegalArgumentException("Impossible de sortir de la Matrice.");
                }
                positionActuelle = new Pair<Integer, Integer>(x + 1, y);
                break;
            case GAUCHE:
                if (y == 0) {
                    throw new IllegalArgumentException("Impossible de sortir de la Matrice.");
                }
                positionActuelle = new Pair<Integer, Integer>(x, y - 1);
                break;
            case DROITE:
                if (y == 9) {
                    throw new IllegalArgumentException("Impossible de sortir de la Matrice.");
                }
                positionActuelle = new Pair<Integer, Integer>(x, y + 1);
                break;
            default:
                throw new IllegalArgumentException("Direction invalide.");
        }
        Ressource ressource = map[positionActuelle.getKey()][positionActuelle.getValue()];
        if (ressource != null) {
            prendre(ressource);
            map[positionActuelle.getKey()][positionActuelle.getValue()] = null;
        }
    }
	
	private void jeter(Ressource ressource, Ressource[][] map) {
	        if (map[positionActuelle.getKey()][positionActuelle.getValue()] != null) {
	            throw new IllegalStateException("La case est déjà occupée.");
	        }
	        if (ressource instanceof Ble) {
	            stockBle.remove(ressource);
	        } else if (ressource instanceof Bois) {
	            stockBois.remove(ressource);
	        } else if (ressource instanceof Pierre) {
	            pierre = null;
	        }
	        poidsEmporte -= ressource.getPoids();
	        map[positionActuelle.getKey()][positionActuelle.getValue()] = ressource;
	    }

	public void recupererBle(Ressource[][] map) {
	    while (poidsEmporte != 13) {
	        Ressource ressource = map[positionActuelle.getKey()][positionActuelle.getValue()];
	        if (ressource instanceof Ble || ressource instanceof Pierre) {
	            prendre(ressource);
	        } else {
	            Pair<Integer, Integer> positionBle = trouverPositionRessource(Ble.class, map);
	            if (positionBle == null) {
		            Pair<Integer, Integer> positionPierre = trouverPositionRessource(Pierre.class, map);
		            if(positionPierre == null) {
		                faireFarine();
		            	break; // Toutes les ressources ont été récupérées
		            	}
		            seDeplacerVers(positionPierre, map);
	            }
	            seDeplacerVers(positionBle, map);
	        }
	    }
	}
	public void recupererBois(Ressource[][] map) {
	    while (poidsEmporte != 12) {
	        Ressource ressource = map[positionActuelle.getKey()][positionActuelle.getValue()];
	        if (ressource instanceof Bois) {
	            prendre(ressource);
	        } else {
	            Pair<Integer, Integer> positionBois = trouverPositionRessource(Bois.class, map);
	            if (positionBois == null) {
		                faireBois();
	            		break; // Toutes les ressources ont été récupérées
		            	}
	            seDeplacerVers(positionBois, map);
	        }
	    }
	}
	public void fairePain(Ressource[][] map) {	
		Pair<Integer, Integer> positionPain = new Pair<>(9, 9);
         seDeplacerVers(positionPain, map);
	}
	/**
	 * 
	 * La méthode trouverPositionRessource peut être appelée avec n'importe quelle classe qui hérite de Ressource en tant que valeur pour le paramètre type.
	 * @param type
	 * @param map
	 * @return
	 */
	private Pair<Integer, Integer> trouverPositionRessource(Class<? extends Ressource> type, Ressource[][] map) {
	    for (int i = 0; i < 10; i++) {
	        for (int j = 0; j < 10; j++) {
	            if (map[i][j] != null && type.isInstance(map[i][j])) {
	                return new Pair<>(i, j);
	            }
	        }
	    }
	    return null;
	}
	
	private void seDeplacerVers(Pair<Integer, Integer> position, Ressource[][] map) {
	    int xDiff = position.getKey() - positionActuelle.getKey();
	    int yDiff = position.getValue() - positionActuelle.getValue();
	    Deplacement direction = null;
	    if (xDiff > 0) {
	        direction = Deplacement.BAS;
	    } else if (xDiff < 0) {
	        direction = Deplacement.HAUT;
	    } else if (yDiff > 0) {
	        direction = Deplacement.DROITE;
	    } else if (yDiff < 0) {
	        direction = Deplacement.GAUCHE;
	    }
	    if (direction != null) {
	        seDeplacer(direction, map);
	    }
	}
	private void faireFarine() {
	    if (pierre == null) {
	        throw new IllegalStateException("Il faut une pierre pour faire de la farine.");
	    }
	    if (stockBle.size() < 10) {
	        throw new IllegalStateException("Il faut au moins 10 grains de blé pour faire de la farine.");
	    }
	    for (int i = 0; i < 10; i++) {
	        Ressource ressource = stockBle.get(0);
	        stockBle.remove(ressource);
	    }
	    farine = new ObjetManufacture("Farine");
	}
	private void faireBois() {
	    if (stockBois.size() < 6) {
	        throw new IllegalStateException("Il faut au moins 6 bois pour faire du feu.");
	    }
	    for (int i = 0; i < 6; i++) {
	        Ressource ressource = stockBois.get(0);
	        stockBle.remove(ressource);
	    }
	    feu = new ObjetManufacture("Feu");
	}
	
}
	
	
