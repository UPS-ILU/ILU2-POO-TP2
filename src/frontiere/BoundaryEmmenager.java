package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("\nÊtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
					case 1:
						emmenagerDruide(nomVisiteur);
						break;

					case 2:
						StringBuilder emmenager = new StringBuilder();
						emmenager.append("Bienvenue villageois ");
						emmenager.append(nomVisiteur);
						emmenager.append("\n");
						emmenager.append("Quelle est votre force ?");
						int force = Clavier.entrerEntier(emmenager.toString());
						controlEmmenager.ajouterGaulois(nomVisiteur, force);
						break;

					default:
						System.out
								.println("Vous devez choisir le chiffre 1 ou 2 !");
						break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder emmenager = new StringBuilder();
		emmenager.append("Bienvenue druide");
		emmenager.append(nomVisiteur);
		emmenager.append("\n");
		emmenager.append("Quelle est votre force ?");

		int force = Clavier.entrerEntier(emmenager.toString());
		int effetPotionMax, effetPotionMin;
		do {
			effetPotionMin = Clavier
					.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?");

			if (effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			}

		} while (effetPotionMax < effetPotionMin);

		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);

	}
}
