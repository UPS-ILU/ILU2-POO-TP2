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
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder info = new StringBuilder();
		if (!nomVendeurConnu) {
			info.append("Je suis désolée ");
			info.append(nomVendeur);
			info.append(" mais il faut être un habitant de notre village pour commencer ici.");
			System.out.println(info.toString());
		} else {
			info.append("Bonjour ");
			info.append(nomVendeur);
			info.append(", je vais regarder si je peut vous trouver un étal.");
			System.out.println(info.toString());
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				info = new StringBuilder();
				info.append("Désolée ");
				info.append(nomVendeur);
				info.append(", je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(info.toString());
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question = new StringBuilder();
		question.append("C'est parfait, il me reste un étal pour vous !\n");
		question.append("Il me faudrait quelques renseignements :\n");
		question.append("Quel produit souhaitez-vous vendre ?");
		System.out.println(question.toString());
		String produit = scan.next();

		question = new StringBuilder();
		question.append("Combien souhaitez-vous en vendre ? ");
		int nbProduit = Clavier.entrerEntier(question.toString());

		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != 1) {
			question = new StringBuilder();
			question.append("Le vendeur ");
			question.append(nomVendeur);
			question.append(" s'est installé à l'etal n°");
			question.append(numeroEtal);
			System.out.println(question.toString());
		}
	}
}
