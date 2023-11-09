package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initialiserSituation() {
		this.village = new Village("Le village des irréductibles", 10, 5);
		this.chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
	}
	
	@Test 
	void testControlEmmenager() {
		ControlEmmenager ctrlEmmenager = new ControlEmmenager(village);
		assertNotNull(ctrlEmmenager, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager ctrlEmmenager = new ControlEmmenager(village);
		ctrlEmmenager.ajouterGaulois("Bonemine", 3);
		assertTrue(ctrlEmmenager.isHabitant("Bonemine"));
	}
	
	@Test 
	void testAjoutDruide() {
		ControlEmmenager ctrlEmmenager = new ControlEmmenager(village);
		ctrlEmmenager.ajouterDruide("Panoramix", 2, 5, 10);
		assertTrue(ctrlEmmenager.isHabitant("Panoramix"));
	}
	
	@Test 
	void testForce() {
		ControlEmmenager ctrlEmmenager = new ControlEmmenager(village);
		Gaulois gaulois = new Gaulois("Astérix", 2);
		assertEquals(2, gaulois.getForce());
	}
	
	@Test 
	void testPersonnageToString() {
		ControlEmmenager ctrlEmmenager = new ControlEmmenager(village);
		Gaulois gaulois = new Gaulois("Astérix", 2);
		assertEquals("Gaulois [nom=Astérix, force=2, effetPotion=1]", gaulois.toString());
	}
}






















