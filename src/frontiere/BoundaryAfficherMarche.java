package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infos = controlAfficherMarche.donnerInfosMarche();
		if(infos.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard");
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append(nomAcheteur + ", vous trouverez au marché: \n");
			for (int i = 0; i < infos.length;) {
				sb.append("- " + infos[i++] + " qui vend " + infos[i++] + " " + infos[i++]);
			}
			System.out.println(sb.toString());
		}
	}
}
