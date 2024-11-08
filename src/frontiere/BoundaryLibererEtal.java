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
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!");
		} else {
			String[] etal = controlLibererEtal.libererEtal(nomVendeur);
			if (etal[0].equals("true")) {
				System.out.println("Vous avez vendu " + etal[4] + " sur " + etal[3] + " " + etal[2] + ".");
				System.out.println("En revoir " + nomVendeur + ", passez une bonne journée.");
			}
		}
	}

}
