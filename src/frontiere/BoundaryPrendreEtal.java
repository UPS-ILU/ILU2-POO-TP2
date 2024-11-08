package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("je suis désolé " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici");
		} else {
			System.out.println("Bonjour, " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé " + nomVendeur + ", je n'ai plus d'étal qui ne soit pas déja occupé.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étale pour vous!");
		System.out.println("Il me faudrait quelques renseignements:");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étale n° " + numeroEtal);
		}
	}
}
