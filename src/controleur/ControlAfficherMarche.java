package controleur;

import villagegaulois.Village;

import java.util.Arrays;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	public String[] donnerInfosMarche(){
		String[] marche = village.donnerEtatMarche();
		return marche;
	}
}
