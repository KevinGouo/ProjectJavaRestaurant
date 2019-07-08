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
public abstract class Personne {

    private final String email; //Initialisation des attributs

    private final String pseudo;
    private final String mdp;
    private final int role;

    public Personne(int Role, String Email, String Pseudo, String Mdp) {
        this.email = Email;
        this.pseudo = Pseudo;
        this.mdp = Mdp;
        this.role = Role;
    }

    @Override
    public String toString() {
        return ("\nCher(e) " + getPseudo());
    }

    public String versFichP() {//pour ajouter/afficher les caractéristiques des utilisateurs dans le fichier
        return (role + System.lineSeparator() + getEmail() + System.lineSeparator() + pseudo + System.lineSeparator() + getMdp() + System.lineSeparator());
    }

    public boolean MailComp(Conseiller C) {//méthode qui permet de comparer les emails

        return getEmail().equals(C.getMail());
    }

    public boolean MdpComp(Conseiller C) {//méthode qui permet de comparer les mots de passe

        return getMdp().equals(C.getMdp());
    }

    public boolean PseudoComp(Conseiller C) {//méthode qui permet de comparer les pseudos

        return pseudo.equals(C.getPseudo());
    }

    public boolean CodeComp(Conseiller C) {//méthode qui retourne vrai à une methode de ses sous classes

        return true;
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

}
