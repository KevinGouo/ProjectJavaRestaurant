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
public class Administrateur extends Personne { //Personne est la super classe de Administrateur

    private final int code; //Initialisation des attributs

    public Administrateur(int Role, String Email, String Pseudo, String Mdp, int Code) {
        super(Role, Email, Pseudo, Mdp); //Elements de la super classe
        this.code = Code;
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
        return (super.versFichP()) + code + System.lineSeparator();
    }

    @Override
    public boolean CodeComp(Conseiller C) {//méthode qui verifie le code secret

        return code == (C.getCode());
    }
}
