package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

import java.util.Objects;

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


	public String[] obtenirMarchand(String produit){
		Gaulois[] listeMarchands = village.rechercherVendeursProduit(produit);
		StringBuilder chaine = new StringBuilder();
		String[] marchands = null;
		if(listeMarchands == null) {
			chaine.append("Désolé personne ne vend ce produit au marché.\n");
		} else {
			marchands = new String[listeMarchands.length];
			chaine.append("Chez quel commerçant voulez-vous acheter des ");
			chaine.append(produit);
			chaine.append(" ?\n");
			for (int i = 0; i < listeMarchands.length; i++) {
				int j = i + 1;
				chaine.append(j);
				chaine.append(" - ");
				chaine.append(listeMarchands[i].getNom());
				marchands[i]=listeMarchands[i].getNom();
			}
		}
		System.out.println(chaine);
		return marchands;
	}
	public boolean verifierIdentite(String nomVendeur){
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	public int acheterProduit(String nomVendeur, int quantite){
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantite);
	}
}