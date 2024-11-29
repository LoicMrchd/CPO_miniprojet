/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;



/**
 *
 * @author loicm
 */
public class Partie {
    
    private PlateauDeJeu plateau; // Instance du plateau de jeu
    private ArrayList<Character> couleursDisponibles; // Couleurs possibles pour les pions

    /**
     * Constructeur pour initialiser une nouvelle partie.
     * 
     * @param tailleCombinaison Taille des combinaisons (fixée à 4).
     * @param nbToursMax        Nombre maximum de tours autorisés.
     * @param couleursDisponibles Liste des couleurs possibles.
     */
    public Partie(int tailleCombinaison, int nbToursMax, List<Character> couleursDisponibles) {
        this.couleursDisponibles = new ArrayList<>(couleursDisponibles);

        // Génération d'une combinaison secrète
        Combinaison combinaisonSecrete = Combinaison.genererAleatoire(tailleCombinaison, this.couleursDisponibles);

        // Initialisation du plateau de jeu
        this.plateau = new PlateauDeJeu(combinaisonSecrete, nbToursMax);
    }

    /**
     * Affiche les règles du jeu.
     */
    public void afficherRegles() {
        System.out.println("Bienvenue au jeu Mastermind !");
        System.out.println("Objectif : Devinez la combinaison secrete.");
        System.out.println("A chaque tour, proposez une combinaison de 4 couleurs.");
        System.out.println("Indices donnes :");
        System.out.println("- Noir : Couleur correcte et bien placee.");
        System.out.println("- Blanc : Couleur correcte mais mal placee.");
        System.out.println("Bonne chance !");
        System.out.println();
    }

    /**
     * Boucle principale pour jouer la partie.
     */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        

        while (!plateau.estVictoire() && !plateau.estDefaite()) {
            // Afficher l'état actuel du plateau
            plateau.afficherPlateau();

            // Demander une tentative au joueur
            System.out.println("Entrez une combinaison de 4 couleurs parmi : " + couleursDisponibles);
            String entree = scanner.nextLine().toUpperCase();

            // Vérifier que l'entrée est valide
            if (entree.length() != 4 || !entree.chars().allMatch(c -> couleursDisponibles.contains((char) c))) {
                System.out.println("Entrée invalide. Veuillez entrer exactement 4 couleurs valides.");
                continue;
            }

            // Créer une tentative à partir de l'entrée du joueur
            Pion[] pions = new Pion[4];
            for (int i = 0; i < 4; i++) {
                pions[i] = new Pion(entree.charAt(i));
            }
            Combinaison tentative = new Combinaison(pions);

            // Proposer la tentative au plateau
            plateau.proposerCombinaison(tentative);
        }

        // Fin de la partie
        terminerPartie();
    }

    /**
     * Affiche un message de victoire ou de défaite.
     */
    public void terminerPartie() {
        if (plateau.estVictoire()) {
            System.out.println("Felicitations ! Vous avez trouve la combinaison secrete !");
        } else {
            System.out.println("Vous avez depasse le nombre de tours maximum.");
            System.out.println("La combinaison secrete était : " + plateau.getCombinaisonSecrete());
        }
    }

    /**
     * Point d'entrée pour tester la classe Partie.
     */
    public static void main(String[] args) {
        ArrayList<Character> couleurs = new ArrayList<>();
        couleurs.add('R');
        couleurs.add('B');
        couleurs.add('G');
        couleurs.add('Y');
        couleurs.add('O');
        couleurs.add('P');

        Partie partie = new Partie(4, 10, couleurs);
        partie.lancerPartie();
    }
}
    

     

    

    

