package frontiere;

import java.util.InputMismatchException;
import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu) {
			System.out.println("Je suis désolé " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.\n");
		}else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Désolé " + nomVendeur + "je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignement :\n");
		System.out.println("Quel produit souhaitez-vous vendre ? :\n");
		String produit = scan.next();
		System.out.println("Combien souhaitez-vous en vendre ? :\n");
		int nbProduit = 0;
		do {
			try{
				nbProduit = scan.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Veuillez entrer un entier positif :\n");
				nbProduit = scan.nextInt();
			}
		}while(nbProduit<0);
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°"+ numEtal+1 + "\n");
		}
	}
}
