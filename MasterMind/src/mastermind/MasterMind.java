/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastermind;

import java.util.ArrayList;



/**
 *
 * @author loicm
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // Définir les couleurs disponibles pour les combinaisons
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R'); // Rouge
        couleursDisponibles.add('B'); // Bleu
        couleursDisponibles.add('G'); // Vert
        couleursDisponibles.add('Y'); // Jaune

        // Création d'une combinaison secrète
        Combinaison combinaisonSecrete = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });
        System.out.println("Combinaison Secrete : " + combinaisonSecrete);

        // Initialisation du plateau de jeu avec 10 tours max
        PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 10);

        // Ajout de tentatives
        Combinaison tentative1 = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('G'), new Pion('B'), new Pion('Y')
        });
        plateau.proposerCombinaison(tentative1);
        plateau.afficherPlateau();

        Combinaison tentative2 = new Combinaison(new Pion[]{
            new Pion('R'), new Pion('B'), new Pion('G'), new Pion('Y')
        });
        plateau.proposerCombinaison(tentative2);
        plateau.afficherPlateau();

        // Vérification des conditions de victoire et de défaite
        System.out.println("Victoire ? " + plateau.estVictoire()); // Doit afficher true après tentative2
        System.out.println("Defaite ? " + plateau.estDefaite());   // Doit afficher false (partie pas encore perdue)
    }
}
        
    
        

    
        

    

