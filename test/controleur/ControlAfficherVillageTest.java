package controleur;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {

	ControlAfficherVillage caff;
	ControlEmmenager cm;

	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("leVillage", 19, 20);
		Chef chef = new Chef("chef", 4, village);
		cm = new ControlEmmenager(village);
		cm.ajouterGaulois("Bonemine", 3);
		cm.ajouterDruide("Panoramix", 4, 5, 6);
		caff = new ControlAfficherVillage(village);
		System.out.println(caff.donnerNomsVillageois());
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] nv = new String
		// assertArrayEquals(caff.donnerNomsVillageois(), null);
	}

	@Test
	void testDonnerNomVillage() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtals() {
		fail("Not yet implemented");
	}

}
