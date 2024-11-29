/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastermind;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author loicm
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        // Étape 1 : Définir les paramètres du jeu
        int tailleCombinaison = 4;
        int nbToursMax = 10;
        List<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R'); // Rouge
        couleursDisponibles.add('B'); // Bleu
        couleursDisponibles.add('G'); // Vert
        couleursDisponibles.add('Y'); // Jaune
        couleursDisponibles.add('O'); // Orange
        couleursDisponibles.add('P'); // Violet

        // Étape 2 : Initialiser la partie
        Partie partie = new Partie(tailleCombinaison, nbToursMax, couleursDisponibles);

        // Étape 3 : Afficher les règles une seule fois
        partie.afficherRegles();

        // Étape 4 : Lancer la partie
        partie.lancerPartie();
    }
}

        
    
        

    
        

    

