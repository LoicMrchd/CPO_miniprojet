/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;


import java.util.ArrayList;

/**
 *
 * @author loicm
 */
public class PlateauDeJeu {
    private Combinaison combinaisonSecrete;
    private ArrayList<Combinaison> tentatives;
    private ArrayList<String> reponses;
    int nbToursMax;
    
    public Combinaison getCombinaisonSecrete() {
    return combinaisonSecrete;
}

    /**
     * Constructeur pour initialiser le plateau de jeu.
     * @param combinaisonSecrete La combinaison secrète à deviner.
     * @param nbToursMax Nombre maximum de tours autorisés.
     */
    public PlateauDeJeu(Combinaison combinaisonSecrete, int nbToursMax) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.nbToursMax = nbToursMax;
        this.tentatives = new ArrayList<>();
        this.reponses = new ArrayList<>();
    }

    /**
     * Propose une combinaison et calcule les indices correspondants.
     * @param tentative La combinaison proposée par le joueur.
     */
    public void proposerCombinaison(Combinaison tentative) {
        tentatives.add(tentative);
        int[] resultats = combinaisonSecrete.comparer(tentative);
        String reponse = resultats[0] + " noirs, " + resultats[1] + " blancs";
        reponses.add(reponse);
    }

    /**
     * Affiche l'état actuel du plateau avec l'historique des tentatives et des réponses.
     */
    public void afficherPlateau() {
        System.out.println("Plateau de Jeu :");
        for (int i = 0; i < tentatives.size(); i++) {
            System.out.println("Tentative " + (i + 1) + " : " + tentatives.get(i) + " -> " + reponses.get(i));
        }
    }

    /**
     * Vérifie si la dernière tentative correspond à la combinaison secrète.
     * @return true si victoire, false sinon.
     */
    public boolean estVictoire() {
        if (tentatives.isEmpty()) return false;
        Combinaison derniereTentative = tentatives.get(tentatives.size() - 1);
        int[] resultats = combinaisonSecrete.comparer(derniereTentative);
        return resultats[0] == combinaisonSecrete.toString().length(); // Tous les pions bien placés
    }

    /**
     * Vérifie si le joueur a dépassé le nombre maximum de tours autorisés.
     * @return true si défaite, false sinon.
     */
    public boolean estDefaite() {
        return tentatives.size() >= nbToursMax && !estVictoire();
    }
}
     
  

