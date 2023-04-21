package matrice;

public class Matrice {

	private Ressource[][] matrice;

    public Matrice(Ressource[][] matrice) {
        this.matrice = matrice;
    }

    public Ressource[][] getMatrice() {
        return matrice;
    }
	
	
	public static void main(String args[]) {
		
		
		/*add matrice*/
		Ressource[][] matrix1 = new Ressource[10][10];
		for (int i = 0; i < 10; i++)
		{
			matrix1 [i][i] = new Ble("ble" + i);
		}
		matrix1 [0][1] = new Pierre("Paul");
		matrix1 [2][5] = new Bois("bois25");
		matrix1 [3][1] = new Bois("bois31");
		matrix1 [4][8] = new Bois("bois48");
		matrix1 [5][2] = new Bois("bois52");
		matrix1 [5][3] = new Bois("bois53");
		matrix1 [9][1] = new Bois("bois91");
		
		
		Matrice maMatrice = new Matrice(matrix1);
	}

}
