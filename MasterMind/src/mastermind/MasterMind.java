/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastermind;


/**
 *
 * @author loicm
 */
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Test de la classe Pion
        System.out.println("Test de la classe Pion");

        // Création de pions avec différentes couleurs
        Pion pionRouge = new Pion('R');
        Pion pionBleu = new Pion('B');
        Pion pionVert = new Pion('V');

        // Test des accesseurs (getCouleur)
        System.out.println("Couleur du pionRouge : " + pionRouge.getCouleur()); // Doit afficher R
        System.out.println("Couleur du pionBleu : " + pionBleu.getCouleur());   // Doit afficher B
        System.out.println("Couleur du pionVert : " + pionVert.getCouleur());   // Doit afficher G

        // Test de la méthode toString()
        System.out.println("Affichage du pionRouge : " + pionRouge); // Doit afficher R
        System.out.println("Affichage du pionBleu : " + pionBleu);   // Doit afficher B
        System.out.println("Affichage du pionVert : " + pionVert);   // Doit afficher V
    
    }
}

        
    
        

    
        

    

