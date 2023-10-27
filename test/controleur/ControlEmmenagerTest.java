package controleur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personnages.Chef;
import villagegaulois.Village;

import static org.junit.jupiter.api.Assertions.*;

class ControlEmmenagerTest {

    private Chef abraracourcix;
    private Village village;

    @BeforeEach
    void setUp() {
        System.out.println("Initialisation...");
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("abraracourcix",10, village);
        village.setChef(abraracourcix);
    }

    @Test
    void isHabitant() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        controlEmmenager.ajouterGaulois("Bonemine",3);
        assertTrue(controlEmmenager.isHabitant("Bonemine"));
        assertFalse(controlEmmenager.isHabitant("Existe pas"));
        controlEmmenager.ajouterDruide("Panoramix",10,1,5);
        assertTrue(controlEmmenager.isHabitant("Panoramix"));
    }

    @Test
    void ajouterDruide() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        assertFalse(controlEmmenager.isHabitant("Panoramix"));
        controlEmmenager.ajouterDruide("Panoramix",10,1,5);
        assertTrue(controlEmmenager.isHabitant("Panoramix"));
    }

    @Test
    void ajouterGaulois() {
        ControlEmmenager controlEmmenager = new ControlEmmenager(village);
        assertFalse(controlEmmenager.isHabitant("Bonemine"));
        controlEmmenager.ajouterGaulois("Bonemine",3);
        assertTrue(controlEmmenager.isHabitant("Bonemine"));

    }
}