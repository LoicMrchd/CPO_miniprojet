/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

/**
 *
 * @author loicm
 */
public class PlateauDeJeu {
    private Combinaison combinaisonSecrete;
    private Pion[][] matriceTentatives; // Matrice où chaque ligne est une tentative
    private String[] indices; // Tableau pour les indices associés à chaque tentative
    private int nbToursMax;
    private int tourActuel; // Compteur pour suivre le tour actuel

    /**
     * Constructeur pour initialiser le plateau de jeu.
     * @param combinaisonSecrete La combinaison secrète à deviner.
     * @param nbToursMax Nombre maximum de tours autorisés.
     */
    public PlateauDeJeu(Combinaison combinaisonSecrete, int nbToursMax) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.nbToursMax = nbToursMax;
        this.tourActuel = 0;
        this.matriceTentatives = new Pion[nbToursMax][4]; // nbToursMax lignes, 4 colonnes (1 ligne = 1 tentative)
        this.indices = new String[nbToursMax]; // Tableau pour stocker les réponses
    }

    public Combinaison getCombinaisonSecrete() {
        return combinaisonSecrete;
    }

    /**
     * Propose une combinaison et calcule les indices correspondants.
     * @param tentative La combinaison proposée par le joueur.
     */
    public void proposerCombinaison(Combinaison tentative) {
        if (tourActuel >= nbToursMax) {
            throw new IllegalStateException("Nombre maximum de tours atteint.");
        }
        // Ajouter la tentative à la matrice
        for (int i = 0; i < 4; i++) {
            matriceTentatives[tourActuel][i] = new Pion(tentative.toString().charAt(i));
        }

        // Calculer les indices et les stocker
        int[] resultats = combinaisonSecrete.comparer(tentative);
        indices[tourActuel] = resultats[0] + " noirs, " + resultats[1] + " blancs";

        // Incrémenter le compteur de tours
        tourActuel++;
    }

    /**
     * Affiche l'état actuel du plateau avec l'historique des tentatives et des réponses sous forme de matrice.
     */
    public void afficherPlateau() {
        System.out.println("Plateau de Jeu :");

        // Afficher les tentatives sous forme de matrice (chaque ligne est une tentative)
        for (int i = 0; i < nbToursMax; i++) {
            if (matriceTentatives[i][0] != null) { // Vérifie si la ligne est vide
                for (int j = 0; j < 4; j++) {
                    System.out.print(matriceTentatives[i][j].getCouleur() + " ");
                }
                System.out.print("| " + indices[i]); // Affiche les indices correspondants
            } else {
                // Ligne vide
                System.out.print(". . . . | .");
            }
            System.out.println(); // Nouvelle ligne après chaque ligne de la matrice
        }
    }

    /**
     * Vérifie si la dernière tentative correspond à la combinaison secrète.
     * @return true si victoire, false sinon.
     */
    public boolean estVictoire() {
        if (tourActuel == 0) return false;
        Combinaison derniereTentative = new Combinaison(matriceTentatives[tourActuel - 1]);
        int[] resultats = combinaisonSecrete.comparer(derniereTentative);
        return resultats[0] == combinaisonSecrete.toString().length(); // Tous les pions bien placés
    }

    /**
     * Vérifie si le joueur a dépassé le nombre maximum de tours autorisés.
     * @return true si défaite, false sinon.
     */
    public boolean estDefaite() {
        return tourActuel >= nbToursMax && !estVictoire();
    }
}
     
  

