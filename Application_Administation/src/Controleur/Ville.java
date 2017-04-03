package Controleur;

public class Ville 
{
	private int cpVille, idRegion;
	private String nomVille;
	
	public Ville(int cpVille, String nomVille, int idRegion)
	{
		this.cpVille = cpVille;
		this.nomVille = nomVille;
		this.idRegion = idRegion;
	}

	public int getCpVille() {
		return cpVille;
	}

	public void setCpVille(int cpVille) {
		this.cpVille = cpVille;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	
}
