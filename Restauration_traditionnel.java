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
public class Restauration_traditionnel extends Restaurant { //Restaurant est la super classe de Restaurant traditionnel

    private final int am; //Initialisation des attributs
    private final int ah;

    public Restauration_traditionnel(int Id, String Nom, String Tc, int Arrondissement, String Coordonnees, int Prix, int Etoiles, int Am, int Ah) {
        super(Id, Nom, Tc, Arrondissement, Coordonnees, Prix, Etoiles);//Elements de la super classe
        this.am = Am;
        this.ah = Ah;
    }

    @Override
    public String toString() {//permet d'afficher les éléments de la super classe plus les éléments de la classe 

        System.out.println("");
        return (super.toString() + "\nAmbiance Musicale: " + am + "\nAccés Handicapés: " + ah+"\n");
    }

    public String versFichier() {//pour ajouter/afficher les caractéristiques des restaurants dans le fichier
        return (super.versFichier()) + am + System.lineSeparator() + ah + System.lineSeparator();

    }

}
