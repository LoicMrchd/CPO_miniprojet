/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastermind;

import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author loicm
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Test de la classe Combinaison");

        // Création de pions statiques
        Pion pion1 = new Pion('R');
        Pion pion2 = new Pion('B');
        Pion pion3 = new Pion('G');
        Pion pion4 = new Pion('Y');

        // Création d'une combinaison statique
        Pion[] elements1 = {pion1, pion2, pion3, pion4};
        Combinaison combinaison1 = new Combinaison(elements1);
        System.out.println("Combinaison 1 : " + combinaison1); // Doit afficher RBGY

        // Création d'une autre combinaison statique
        Pion[] elements2 = {new Pion('R'), new Pion('Y'), new Pion('G'), new Pion('B')};
        Combinaison combinaison2 = new Combinaison(elements2);
        System.out.println("Combinaison 2 : " + combinaison2); // Doit afficher RYGB

        // Comparaison des combinaisons
        int[] resultats = combinaison1.comparer(combinaison2);
        System.out.println("Bien places : " + resultats[0] + ", Mal places : " + resultats[1]); // Ex : Bien placés : 2, Mal placés : 2

        // Génération d'une combinaison aléatoire
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R');
        couleursDisponibles.add('B');
        couleursDisponibles.add('G');
        couleursDisponibles.add('Y');
        couleursDisponibles.add('O'); // Orange
        couleursDisponibles.add('P'); // Violet

        Combinaison combinaisonAleatoire = Combinaison.genererAleatoire(4, couleursDisponibles);
        System.out.println("Combinaison aleatoire : " + combinaisonAleatoire);

        // Comparaison avec la combinaison aléatoire
        int[] resultatsAleatoire = combinaison1.comparer(combinaisonAleatoire);
        System.out.println("Comparaison avec aleatoire - Bien places : " + resultatsAleatoire[0]
                + ", Mal places : " + resultatsAleatoire[1]);
    }
}
        
    
        

    
        

    

