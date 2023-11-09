package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = scan.nextLine();

		StringBuilder message = new StringBuilder();
		message.append("Chez quel commerçant voulez-vous acheter des ");
		message.append(produit);
		message.append(" ?");
		System.out.println(message.toString());

		String[] vendeurs = this.controlAcheterProduit.trouverVendeurs(produit);
		if (vendeurs.length == 0) {
			System.out.println("Désolé, personne ne vend se produit au marché.");
			return;
		}

		for (int i = 0; i < vendeurs.length; i++) {
			message = new StringBuilder();
			message.append(i + 1);
			message.append(" - ");
			message.append(vendeurs[i]);
			System.out.println(message.toString());
		}

		int choix = Integer.parseInt(scan.nextLine());
		String nomVendeur = vendeurs[choix - 1];
		message = new StringBuilder();
		message.append(nomAcheteur);
		message.append(" se déplace jusqu'à l'étal du vendeur ");
		message.append(nomVendeur);
		System.out.println(message.toString());

		message = new StringBuilder();
		message.append("Bonjour ");
		message.append(nomAcheteur);
		message.append("\nCombien de ");
		message.append(produit);
		message.append(" voulez-vous acheter ?");
		System.out.println(message.toString());

		int quantite = Integer.parseInt(scan.nextLine());
		int produitAchete = this.controlAcheterProduit.acheterProduit(nomVendeur, quantite);
		message = new StringBuilder();
		message.append(nomVendeur);
		if (produitAchete == 0) {
			message.append(" veut acheter 5 fleurs, malheureusement il n'y en a plus.");
		} else if (produitAchete < quantite) {
			message.append(" veut acheter ");
			message.append(quantite);
			message.append(" ");
			message.append(produit);
			message.append(", malheuresement ");
			message.append(nomVendeur);
			message.append(" n'en a plus que ");
			message.append(produitAchete);
			message.append(".");
			message.append(nomAcheteur);
			message.append(" achète tout le stock de ");
			message.append(nomVendeur);
			message.append(".");
		} else {
			message.append(" achète ");
			message.append(produitAchete);
			message.append(" ");
			message.append(produit);
			message.append(" à ");
			message.append(nomVendeur);
			message.append(".");
		}
		System.out.println(message.toString());
	}
}
