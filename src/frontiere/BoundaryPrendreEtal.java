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
			StringBuilder erreurVendeur = new StringBuilder();
			erreurVendeur.append("Je suis désolé ");
			erreurVendeur.append(nomVendeur);
			erreurVendeur.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(erreurVendeur.toString());

		} else {
			StringBuilder message = new StringBuilder();
			message.append("Bonjour ");
			message.append(nomVendeur);
			message.append(", je vais regarder si je peux vous trouver un étal.");
			System.out.println(message.toString());

			if (!controlPrendreEtal.resteEtals()) {
				StringBuilder erreurEtal = new StringBuilder();
				erreurEtal.append("Désolé ");
				erreurEtal.append(nomVendeur);
				erreurEtal.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(erreurEtal.toString());

			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder message = new StringBuilder();

		message.append("C'est parfait, il me reste un étal pour vous !\n");
		message.append("Il me faudrait quelques renseignements :\n");
		message.append("Quel produit souhaitez-vous vendre ?");
		System.out.println(message.toString());
		String produit = scan.nextLine();

		int quantite = Clavier.entrerEntier("Combien souhaitez vous en vendre ?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);

		if (numeroEtal != -1) {
			StringBuilder successMessage = new StringBuilder();
			successMessage.append("Le vendeur ");
			successMessage.append(nomVendeur);
			successMessage.append(" s'est installé à l'étal n°");
			successMessage.append(numeroEtal);
			System.out.println(successMessage.toString());
		}
	}
}
