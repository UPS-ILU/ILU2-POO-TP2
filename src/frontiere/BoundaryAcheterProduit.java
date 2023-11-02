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
		System.out.println("Quel produit voulez vous achetez ?\n");
		String produit = scan.next();
		String[] marchands = controlAcheterProduit.obtenirMarchand(produit);
		if(marchands==null){return;}
		int indiceVendeur = scan.nextInt();
		indiceVendeur--;
		if(controlAcheterProduit.verifierIdentite(marchands[indiceVendeur])) {
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur"  + marchands[indiceVendeur] + "\nBonjour " + nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?\n");
			int quantite = scan.nextInt();
			int quantiteAchete = controlAcheterProduit.acheterProduit(marchands[indiceVendeur],quantite);
			if (quantiteAchete==0) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + " malheureusement il n'y en a plus.\n");
			} else if (quantite > quantiteAchete) {
				System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit +" malheureusement " + marchands[indiceVendeur]+ " n'en a plus que "+ quantiteAchete + "." + nomAcheteur + " achète tout le stock de "+ marchands[indiceVendeur]+".");
			}else {
				System.out.println(nomAcheteur+" achète "+quantiteAchete + " " + produit + " à "+ marchands[indiceVendeur]);
			}
		}
	}
}
