package controleur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

import static org.junit.jupiter.api.Assertions.*;

class ControlPrendreEtalTest {

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
    void resteEtals() {
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
        controlPrendreEtal.prendreEtal("abraracourcix","fleurs",10);
        controlPrendreEtal.prendreEtal("Bonemine","fleurs",10);
        Gaulois asterix = new Gaulois("asterix",3);
        village.ajouterHabitant(asterix);
        controlPrendreEtal.prendreEtal("asterix","fleurs",10);
        Gaulois obelix = new Gaulois("obelix",3);
        village.ajouterHabitant(obelix);
        controlPrendreEtal.prendreEtal("obelix","fleurs",10);
        assertTrue(controlPrendreEtal.resteEtals());
        Druide panoramix = new Druide("panoramix",3,1,15);
        village.ajouterHabitant(panoramix);
        controlPrendreEtal.prendreEtal("panoramix","fleurs",10);
        assertFalse(controlPrendreEtal.resteEtals());

    }

    @Test
    void prendreEtal() {
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(new ControlVerifierIdentite(village),village);
        assertNotEquals(-1,controlPrendreEtal.prendreEtal("abraracourcix","fleurs",10));
        assertNotEquals(-1,controlPrendreEtal.prendreEtal("Bonemine","fleurs",10));
        assertEquals(-1,controlPrendreEtal.prendreEtal("Inconnu","fleurs",2));
    }

    @Test
    void verifierIdentite(){

    }
}