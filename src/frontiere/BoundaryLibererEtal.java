package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);

		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if (donneesEtal[0] == "true") {
				StringBuilder info = new StringBuilder();
				info.append("Vous avez vendu ");
				info.append(donneesEtal[4]);
				info.append(" sur ");
				info.append(donneesEtal[3]);
				info.append(" ");
				info.append(donneesEtal[2]);
				info.append(".\nEn Revoir ");
				info.append(nomVendeur);
				info.append(", passez une bonne journée.");
				System.out.println(info.toString());
			}
		}
	}
}
