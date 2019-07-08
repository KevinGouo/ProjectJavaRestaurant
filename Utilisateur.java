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
public class Utilisateur extends Personne { //Personne est la super classe de Utilisateur

    public Utilisateur(int Role, String Email, String Pseudo, String Mdp) {
        super(Role, Email, Pseudo, Mdp); //Elements de la super classe
    }

    @Override
    public String toString() {//permet d'afficher les éléments de la super classe plus les éléments de la classe 

        System.out.println("");
        return (super.toString());
    }

    /**
     *
     * @return
     */
    @Override
    public String versFichP() { //pour ajouter/afficher les caractéristiques des utilisateurs dans le fichier
        return (super.versFichP());
    }

}
