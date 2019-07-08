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
public class Restauration_traditionnel_luxe extends Restauration_traditionnel { //Restaurant traditionnel est la super classe de Restaurant traditionnel luxe

    private final int recompense; //Initialisation des attributs

    public Restauration_traditionnel_luxe(int Id, String Nom, String Tc, int Arrondissement, String Coordonnees, int Prix, int Etoiles, int Am, int Ah, int Recompense) {
        super(Id, Nom, Tc, Arrondissement, Coordonnees, Prix, Etoiles, Am, Ah); //Elements de la super classe
        this.recompense = Recompense;
    }

    @Override
    public String toString() {//permet d'afficher les éléments de la super classe plus les éléments de la classe 

        System.out.println("");
        return (super.toString() + "\nNombre de récompenses obtenues :" + recompense + "\n");
    }

    /**
     *
     * @return
     */
    @Override
    public String versFichier() {//pour ajouter/afficher les caractéristiques des restaurants dans le fichier
        return (super.versFichier()) + recompense + System.lineSeparator();

    }

}
