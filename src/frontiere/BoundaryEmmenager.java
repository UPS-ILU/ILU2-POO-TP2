package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());

				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:

					StringBuilder question2 = new StringBuilder();
					question2.append("Bienvenue villagois " + nomVisiteur + "\n");
					question2.append("Quel est votre force ?\n");
					int force = Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue druide " + nomVisiteur + "\n");
		question.append("Quel est votre force ?\n");
		int force = Clavier.entrerEntier(question.toString());

		int effetPotionMax;
		int effetPotionMin;
		do {
			effetPotionMin = Clavier
					.entrerEntier("Quelle est la force de la potion la plus faible que vous produisez ?");
			effetPotionMax = Clavier
					.entrerEntier("Quelle est la force de la potion la plus forte que vous produisez ?");

			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous vous etes trompe entre le minimum et le maximum");
			}
		} while (effetPotionMax < effetPotionMin);

		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);

	}
}
