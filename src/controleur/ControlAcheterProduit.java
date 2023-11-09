package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		int produitAchete = 0;
		if (this.controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			Etal etal = this.controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			if (etal != null) {
				produitAchete = etal.acheterProduit(quantite);
			}
		}
		return produitAchete;
	}

	public String[] trouverVendeurs(String produit) {
		int nbVendeurs = 0;
		String[] infosMarche = this.village.donnerEtatMarche();

		for (int i = 2; i < infosMarche.length; i += 3) {
			String produitsVendeur = infosMarche[i];
			if (produitsVendeur.equals(produit)) {
				nbVendeurs++;
			}
		}

		String[] vendeurs = new String[nbVendeurs];
		for (int i = 0; i < infosMarche.length; i++) {
			String nomVendeur = infosMarche[i];
			i += 2;
			String produitsVendeur = infosMarche[i];
			if (produitsVendeur.equals(produit)) {
				vendeurs[i - 2] = nomVendeur;
			}
		}

		return vendeurs;
	}
}
