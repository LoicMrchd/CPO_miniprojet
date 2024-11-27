/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



/**
 *
 * @author loicm
 */
public class Combinaison {
private Pion[] elements; // Tableau de 4 pions
    private int taille;      // Taille de la combinaison (fixée à 4 par défaut)

    /**
     * Constructeur pour initialiser une combinaison à partir d'un tableau de pions.
     * @param elements Tableau de pions représentant la combinaison.
     */
    public Combinaison(Pion[] elements) {
        if (elements.length != 4) {
            throw new IllegalArgumentException("Une combinaison doit contenir exactement 4 pions.");
        }
        this.elements = elements;
        this.taille = elements.length;
    }

    /**
     * Génère une combinaison aléatoire à partir des couleurs disponibles.
     * @param taille Taille de la combinaison (fixée ici à 4).
     * @param couleursDisponibles Liste des couleurs disponibles pour les pions.
     * @return Une combinaison générée aléatoirement.
     */
    public static Combinaison genererAleatoire(int taille, ArrayList<Character> couleursDisponibles) {
        if (taille != 4) {
            throw new IllegalArgumentException("Taille doit être 4.");
        }

        Random random = new Random();
        Pion[] aleatoire = new Pion[taille];

        for (int i = 0; i < taille; i++) {
            char couleur = couleursDisponibles.get(random.nextInt(couleursDisponibles.size()));
            aleatoire[i] = new Pion(couleur);
        }

        return new Combinaison(aleatoire);
    }

    /**
     * Compare cette combinaison avec une autre.
     * @param autre L'autre combinaison à comparer.
     * @return Un tableau de 2 entiers : [bien placés (noirs), mal placés (blancs)].
     */
    public int[] comparer(Combinaison autre) {
        if (autre.taille != this.taille) {
            throw new IllegalArgumentException("Les combinaisons doivent avoir la même taille.");
        }

        int bienPlaces = 0;
        int malPlaces = 0;

        boolean[] visitesAutre = new boolean[taille];
        boolean[] visitesCette = new boolean[taille];

        // Étape 1 : Trouver les "bien placés" (noirs)
        for (int i = 0; i < taille; i++) {
            if (this.elements[i].getCouleur() == autre.elements[i].getCouleur()) {
                bienPlaces++;
                visitesAutre[i] = true;
                visitesCette[i] = true;
            }
        }

        // Étape 2 : Trouver les "mal placés" (blancs)
        for (int i = 0; i < taille; i++) {
            if (!visitesCette[i]) {
                for (int j = 0; j < taille; j++) {
                    if (!visitesAutre[j] && this.elements[i].getCouleur() == autre.elements[j].getCouleur()) {
                        malPlaces++;
                        visitesAutre[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[]{bienPlaces, malPlaces};
    }

    /**
     * Retourne une représentation textuelle de la combinaison.
     * @return Une chaîne de caractères représentant la combinaison (ex : "RBGY").
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pion pion : elements) {
            sb.append(pion.getCouleur());
        }
        return sb.toString();
    }
}
   

