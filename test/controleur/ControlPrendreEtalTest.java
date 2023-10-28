package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois asterix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5); 
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		asterix = new Gaulois("asterix", 2);
	}

	@Test
	void testControlPrendreEtalVendeur() {
		ControlVerifierIdentite controlId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPE = new ControlPrendreEtal(controlId,village); 
		assertNotNull(controlPE);
	}

	@Test
	void testVerifierId() {
		ControlVerifierIdentite controlId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPE = new ControlPrendreEtal(controlId,village); 
		village.installerVendeur(abraracourcix, "champions 5 cost", 10);
		assertTrue(controlPE.verifierIdentite(abraracourcix.getNom()));
		assertFalse(controlPE.verifierIdentite(asterix.getNom()));
	}
	
	@Test
	void testResteEtalTrue() {
		ControlVerifierIdentite controlId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPE = new ControlPrendreEtal(controlId,village); 
		assertTrue(controlPE.resteEtals());
	}
	
	@Test
	void testResteEtalFalse() {
		ControlVerifierIdentite controlId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPE = new ControlPrendreEtal(controlId,village); 
		Gaulois a = new Gaulois("a",5);
		Gaulois b = new Gaulois("b",5);
		Gaulois c = new Gaulois("c",5);
		Gaulois d = new Gaulois("d",5);
		Gaulois e = new Gaulois("e",5);
		village.ajouterHabitant(a);
		village.ajouterHabitant(b);
		village.ajouterHabitant(c);
		village.ajouterHabitant(d);
		village.ajouterHabitant(e);
		village.installerVendeur(a, "fleurs", 1);
		village.installerVendeur(b, "fleurs", 1);
		village.installerVendeur(c, "fleurs", 1);
		village.installerVendeur(d, "fleurs", 1);
		village.installerVendeur(e, "fleurs", 1);
		assertFalse(controlPE.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlId = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPE = new ControlPrendreEtal(controlId,village);
		Gaulois a = new Gaulois("a",5);
		Gaulois b = new Gaulois("b",5);
		Gaulois c = new Gaulois("c",5);
		Gaulois d = new Gaulois("d",5);
		Gaulois e = new Gaulois("e",5);
		village.ajouterHabitant(a);
		village.ajouterHabitant(b);
		village.ajouterHabitant(c);
		village.ajouterHabitant(d);
		village.ajouterHabitant(e);
		int abra = (controlPE.prendreEtal(abraracourcix.getNom(), "fleurs", 5));
		int f = (controlPE.prendreEtal(a.getNom(), "fleurs", 5));
		int g = (controlPE.prendreEtal(b.getNom(), "fleurs", 5));
		int h = (controlPE.prendreEtal(c.getNom(), "fleurs", 5));
		int i = (controlPE.prendreEtal(d.getNom(), "fleurs", 5));
		int j = (controlPE.prendreEtal(e.getNom(), "fleurs", 5));
		
		assertTrue(abra >= 0 && abra <5);
		assertTrue(f >= 0 && f <5);
		assertTrue(g >= 0 && g <5);
		assertTrue(h >= 0 && h <5);
		assertTrue(i >= 0 && i <5);
		assertFalse(j >= 0 && j <5);
	}
	
	

}
