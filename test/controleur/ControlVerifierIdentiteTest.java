package controleur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

import static org.junit.jupiter.api.Assertions.*;

class ControlVerifierIdentiteTest {

    private Chef abraracourcix;
    private Village village;
    private Gaulois bonemine;

    @BeforeEach
    void setUp() {
        System.out.println("Initialisation...");
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("abraracourcix",10, village);
        village.setChef(abraracourcix);
        bonemine = new Gaulois("Bonemine",3);
        village.ajouterHabitant(bonemine);
    }

    @Test
    void verifierIdentite() {
        ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
        assertTrue(controlVerifierIdentite.verifierIdentite("abraracourcix"));
        assertFalse(controlVerifierIdentite.verifierIdentite("Inconnu"));
        assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));


    }

}