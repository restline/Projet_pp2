package Controleur;

public class TypeResto 
{
	private int idTypeResto, nbEtoiles;
	private String libelle, catPrix;
	
	public TypeResto(int idTypeResto, String libelle, String catPrix, int nbEtoiles)
	{
		this.idTypeResto = idTypeResto;
		this.libelle = libelle;
		this.catPrix = catPrix;
		this.nbEtoiles = nbEtoiles;
	}

	public int getIdTypeResto() {
		return idTypeResto;
	}

	public void setIdTypeResto(int idTypeResto) {
		this.idTypeResto = idTypeResto;
	}

	public int getNbEtoiles() {
		return nbEtoiles;
	}

	public void setNbEtoiles(int nbEtoiles) {
		this.nbEtoiles = nbEtoiles;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCatPrix() {
		return catPrix;
	}

	public void setCatPrix(String catPrix) {
		this.catPrix = catPrix;
	}
	
}
