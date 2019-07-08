/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.s4;

/**
 *
 * @author tjoseph
 */
public class Restauration_rapide extends Restaurant {  //Restaurant est la super classe de Restaurant rapide

    private final int ppe; //Initialisation des attributs

    public Restauration_rapide(int Id, String Nom, String Tc, int Arrondissement, String Coordonnees, int Prix, int Etoiles, int Ppe) {
        super(Id, Nom, Tc, Arrondissement, Coordonnees, Prix, Etoiles);
        this.ppe = Ppe;
    }

    @Override
    public String toString() {//permet d'afficher les éléments de la super classe plus les éléments de la classe 

        System.out.println("");
        return (super.toString() + "\nPossibilté de commander à emporter: " + ppe + "\n");
    }

    /**
     *
     * @return
     */
    @Override
    public String versFichier() {//pour ajouter/afficher les caractéristiques des restaurants dans le fichier
        return (super.versFichier()) + ppe + System.lineSeparator();

    }

}
