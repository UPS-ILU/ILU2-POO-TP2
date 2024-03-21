package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur))
		{
			System.out.println("Mais vous n'etes pas inscrit sur notre marche aujourd'hui");
		}
		else
		{
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			if (Boolean.parseBoolean(donneesEtal[0]))
			{
				System.out
				.println("Vous avez vendu " + donneesEtal[4] + "sur " 
				+ donneesEtal[3] + " " + donneesEtal[2] + ".");
				System.out.println("Au revoir "+ nomVendeur + ", passez une bonne journée");
			}
		}
	}

}
