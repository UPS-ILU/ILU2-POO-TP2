package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
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
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTEV = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal control= new ControlLibererEtal(controlTEV); 
		assertNotNull(control);
		
	}

	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTEV = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal control= new ControlLibererEtal(controlTEV);
		village.installerVendeur(abraracourcix, "fleurs", 1);
		assertTrue(control.isVendeur(abraracourcix.getNom()));
		assertFalse(control.isVendeur(asterix.getNom()));
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}

}
