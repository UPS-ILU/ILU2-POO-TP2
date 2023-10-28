package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide revenez, plus tard.");
		}else {
			System.out.println(nomAcheteur + ", vous trouverez au marché :");
			int j=0;
			for(int i = 0; i<infosMarche.length; i+=3) {
				j=i;
				System.out.print("-" + infosMarche[j]);
				j++;
			    System.out.print(" qui vend " + infosMarche[j]);
			    j++;
			    System.out.println(" " + infosMarche[j]);
			}
		}
	}
}
