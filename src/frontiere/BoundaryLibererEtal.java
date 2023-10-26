package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		StringBuilder chaine = new StringBuilder();
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			chaine.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
		} else {
			String[] etal = controlLibererEtal.libererEtal(nomVendeur);
			if(Boolean.parseBoolean(etal[0])) {
				chaine.append("Vous avez vendu ");
				chaine.append(etal[4]);
				chaine.append(" sur ");
				chaine.append(etal[3]);
				chaine.append(" ");
				chaine.append(etal[2]);
				chaine.append(".\n");
			}
			chaine.append("En revoir ");
			chaine.append(nomVendeur);
			chaine.append(", passez une bonne journée\n");
		}
	System.out.println(chaine);
	}

}
