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
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Bienvenue druide ");
		chaine.append(nomVisiteur);
		System.out.println(chaine.toString());
		StringBuilder questionDruide = new StringBuilder();
		questionDruide.append("\nQuelle est votre force ?\n");
		int force = Clavier.entrerEntier(questionDruide.toString());
		int effetPotionMax;
		int effetPotionMin;
		StringBuilder qEffetPotionMin = new StringBuilder();
		StringBuilder qEffetPotionMax = new StringBuilder();
		qEffetPotionMin.append("Quelle est la force de la potion la plus faible que vous produisez ?");
		qEffetPotionMax.append("Quelle est la force de la potion la plus forte que vous produisez ?");
		do {
			effetPotionMin = Clavier.entrerEntier(qEffetPotionMin.toString());
			effetPotionMax = Clavier.entrerEntier(qEffetPotionMax.toString());
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention druide vous vous êtes trompé entre le minimum et le maximum");
			}
		}while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur,force,effetPotionMin,effetPotionMax);
	}

	private void emmenagerGaulois(String nomVisiteur) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Bienvenue gaulois ");
		chaine.append(nomVisiteur);
		System.out.println(chaine.toString());
		StringBuilder questionGaulois = new StringBuilder();
		questionGaulois.append("\nQuelle est votre force ?\n");
		int force = Clavier.entrerEntier(questionGaulois.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur,force);
	}
}

