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
			System.out.println("Le marché est vide, revenez plus tard.");
		} else {
			StringBuilder info = new StringBuilder();
			info.append(nomAcheteur);
			info.append(", vous trouverez au marché :");
			for (int i = 0; i < infosMarche.length; i += 3) {
				info.append("\n- ");
				info.append(infosMarche[i]);
				info.append(" qui vend ");
				info.append(infosMarche[i + 1]);
				info.append(" ");
				info.append(infosMarche[i + 2]);
			}
			System.out.println(info.toString());
		}
	}
}
