package Controleur;

public class Professionnel 
{
	private int idClient ;
	private String nomClient, emailClient, numTelClient, cp,rue, ville, numSiret, nomContact, prenomContact; 
	private String mdpClient;
	
	public Professionnel(int idClient, String nomClient, String emailClient, 
						 String numTelClient, String cp, String rue, 
						 String ville, String mdpClient, String numSiret,
						 String nomContact, String prenomContact)
	{
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.emailClient = emailClient;
		this.numTelClient = numTelClient;
		this.cp = cp;
		this.rue = rue;
		this.ville = ville;
		this.mdpClient = mdpClient;
		this.numSiret = numSiret;
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getNumTelClient() {
		return numTelClient;
	}

	public void setNumTelClient(String numTelClient) {
		this.numTelClient = numTelClient;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public String getNomContact() {
		return nomContact;
	}

	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}

	public String getPrenomContact() {
		return prenomContact;
	}

	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}

	public String getMdpClient() {
		return mdpClient;
	}

	public void setMdpClient(String mdpClient) {
		this.mdpClient = mdpClient;
	}
	
}
