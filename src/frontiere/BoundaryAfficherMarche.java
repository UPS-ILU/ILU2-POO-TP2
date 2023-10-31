package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		StringBuilder chaine = new StringBuilder();
		if(infosMarche.length==0){
			chaine.append("Le marché est vide, revenez plus tard.\n");
		} else {
			chaine.append(nomAcheteur);
			chaine.append(", vous trouverez au marché :");
			for(int i=0;i<infosMarche.length;i++){
				chaine.append("- " + infosMarche[i]);
				i++;
				chaine.append(" qui vend " + infosMarche[i]);
				i++;
				chaine.append(" " + infosMarche[i]);
			}
		}
		System.out.println(chaine);
	}
}
