package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder info = new StringBuilder();
		if (!nomVendeurConnu) {
			info.append("Je suis désolée ");
			info.append(nomVendeur);
			info.append(" mais il faut être un habitant de notre village pour commencer ici.");
			System.out.println(info.toString());
		} else {
			info.append("Bonjour ");
			info.append(nomVendeur);
			info.append(", je vais regarder si je peut vous trouver un étal.");
			System.out.println(info.toString());
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				info = new StringBuilder();
				info.append("Désolée ");
				info.append(nomVendeur);
				info.append(", je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(info.toString());
			} else {
				installerVendeur(nomVendeur);
				StringBuilder question = new StringBuilder();
				// TODO finish
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		// TODO a completer
	}
}
