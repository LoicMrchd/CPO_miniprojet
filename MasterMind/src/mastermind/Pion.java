/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mastermind;



/**
 *
 * @author loicm
 */
public class Pion {
     private char couleur;

    // Constructeur qui initialise le pion avec une couleur donnée
    public Pion(char couleur) {
        this.couleur = couleur;
    }

    // Accesseur pour obtenir la couleur du pion
    public char getCouleur() {
        return couleur;
    }

    // Redéfinition de la méthode toString pour afficher la couleur du pion
    @Override
    public String toString() {
        return String.valueOf(couleur);
    }

    // Méthode principale pour tester la classe
    public static void main(String[] args) {
        // Tests de la classe Pion
        Pion pionRouge = new Pion('R'); // Rouge
        Pion pionBleu = new Pion('B');  // Bleu
        Pion pionVert = new Pion('V');  // Vert

        // Affichage des pions
        System.out.println("Couleur du pion rouge : " + pionRouge.getCouleur());
        System.out.println("Pion rouge : " + pionRouge);
        
        System.out.println("Couleur du pion bleu : " + pionBleu.getCouleur());
        System.out.println("Pion bleu : " + pionBleu);
        
        System.out.println("Couleur du pion vert : " + pionVert.getCouleur());
        System.out.println("Pion vert : " + pionVert);
    }
}
