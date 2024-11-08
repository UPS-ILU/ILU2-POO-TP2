package controleur;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {

	ControlEmmenager cm;
	ControlAfficherVillage caff;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("leVillage", 19, 20);
		Chef chef = new Chef("chef", 1, village);
		village.setChef(chef);
		cm = new ControlEmmenager(village);
		caff = new ControlAfficherVillage(village);
	}

	@Test
	void testIsHabitant() {
		cm.ajouterGaulois("Bonemine", 3);
		cm.ajouterGaulois("Asterix", 10);
		assertTrue(cm.isHabitant("Bonemine"));
		assertFalse(cm.isHabitant("Existe Pas"));
		cm.ajouterDruide("Panoramix", 1, 5, 8);
		assertTrue(cm.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterDruide() {
		cm.ajouterDruide("Panoramix", 1, 5, 8);
		String[] villageois = caff.donnerNomsVillageois();
		assertTrue(villageois[1].contains("Panoramix"));
	}

	@Test
	void testAjouterGaulois() {
		cm.ajouterGaulois("Bonemine", 3);
		String[] villageois = caff.donnerNomsVillageois();
		assertEquals(villageois[1], "Bonemine");
	}

}
