package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String infosMarche[] = this.controlAfficherMarche.donnerEtatMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard\n");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(nomAcheteur);
			sb.append(" vous trouverez au marché :\n");

			for (int i = 0; i < infosMarche.length; i++) {
				sb.append("- ");
				sb.append(infosMarche[i]);
				sb.append(" qui vend ");
				sb.append(infosMarche[++i]);
				sb.append(" ");
				sb.append(infosMarche[++i]);
			}

			System.out.println(sb.toString());
		}
	}
}
