/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.s4;

import java.util.Scanner;

/**
 *
 * @author tjoseph
 */
public class ProjetS4 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        Conseiller C;
        int choix, i, u;

        C = new Conseiller();

        C.Restaurant();
        C.statut();
        C.avis();
        C.trierPrix();
        C.fichierRestos();
        C.fichierAvis();
        C.fichierPersonne();

        Scanner sc = new Scanner(System.in);
        String A = ("Bienvenue sur Services-Restaurant\nPossédez vous un compte (1) si oui veuillez vous identifier, si non tapez (2) pour vous créer un compte");
        System.out.println(A);
        choix = sc.nextInt();
        while (choix < 1 || choix > 2) {//oblige le client à entrer un chiffre entre 1 et 2
            System.out.println("\nVeuillez recommencer");
            System.out.println(A);
            choix = sc.nextInt();
        }
        if (choix == 1) {
            C.Identification(C.getMail(), C.getMdp());

        }
        if (choix == 2) {
//          C.NouvCompte();

            C.Identification(C.getMail(), C.getMdp());
        }

        for (i = 0; i < C.getStatut().size(); i++) {

            switch (C.getRole1()) {
                case 1:
                    C.statut();
                    do {
                        String MenuUser = ("Voici votre menu:\n"
                                + "1) Afficher la liste de tous les restaurants selon les prix\n"
                                + "2) Afficher les avis d'un restaurant\n"
                                + "3) Rechercher les restaurants selon leurs arrondissements\n"
                                + "4) Rechercher un restaurant en particulier\n"
                                + "5) Quitter");
                        System.out.println(MenuUser);
                        u = sc.nextInt();
                        while (u < 1 || u > 5) {//oblige le client à entrer un chiffre entre 1 et 5
                            System.out.println("\nVeuillez recommencer");
                            System.out.println(MenuUser);
                            u = sc.nextInt();
                        }
                        switch (u) {
                            case 1:
                                C.lireFichierRestos();
                                break;
                            case 2:
                                C.AfficherAvis();
                                break;
                            case 3:
                                C.ChoixLieu();
                                break;
                            case 4:
                                C.ChoixNom();
                                break;
                        }

                    } while (u != 5);//permet de quitter la boucle
                    break;
                case 2:
                    C.statut();

                    do {
                        String MenuP = ("Voici votre menu:\n"
                                + "1) Afficher la liste de tous les restaurants selon les prix\n"
                                + "2) Afficher les avis d'un restaurant\n"
                                + "3) Rechercher les restaurants selon leurs arrondissements\n"
                                + "4) Rechercher un restaurant en particulier\n"
                                + "5) Rechercher un restaurant selon le nombres d'étoiles\n"
                                + "6) Rechercher un restaurant selon le type de cuisine\n"
                                + "7) Laisser un avis sur un restaurant \n"
                                + "8) Quitter");
                        System.out.println(MenuP);
                        u = sc.nextInt();
                        while (u < 1 || u > 8) {//oblige le client à entrer un chiffre entre 1 et 8
                            System.out.println("\nVeuillez recommencer");
                            System.out.println(MenuP);
                            u = sc.nextInt();
                        }
                        switch (u) {
                            case 1:
                                C.lireFichierRestos();
                                break;
                            case 2:
                                C.AfficherAvis();
                                break;
                            case 3:
                                C.ChoixLieu();
                                break;
                            case 4:
                                C.ChoixNom();
                                break;
                            case 5:
                                C.ChoixEtoiles();
                                break;
                            case 6:
                                C.ChoixCuisine();
                                break;
                            case 7:
                                C.VerifCode();

                                break;
                        }

                    } while (u != 8);//permet de quitter la boucle
                    break;
                case 0:
                    C.statut();
                    do {
                        String MenuA = ("Voici votre menu:\n"
                                + "1) Afficher la liste de tous les restaurants selon les prix\n"
                                + "2) Afficher les avis d'un restaurant\n"
                                + "3) Rechercher les restaurants selon leurs arrondissements\n"
                                + "4) Rechercher un restaurant en particulier\n"
                                + "5) Rechercher un restaurant selon le nombres d'étoiles\n"
                                + "6) Rechercher un restaurant selon le type de cuisine\n"
                                + "7) Laisser un avis sur un restaurant \n"
                                + "8) Supprimer les avis d'un client\n"
                                + "9) Ajouter un nouveau restaurant à la liste\n"
                                + "10) Supprimer restaurant de la liste\n"
                                + "11) Voir la liste d'utilisateurs\n"
                                + "12) Quitter");
                        System.out.println(MenuA);
                        u = sc.nextInt();
                        while (u < 1 || u > 12) {//oblige le client à entrer un chiffre entre 1 et 11
                            System.out.println("\nVeuillez recommencer");
                            System.out.println(MenuA);
                            u = sc.nextInt();
                        }
                        switch (u) {
                            case 1:
                                C.lireFichierRestos();
                                break;
                            case 2:
                                C.AfficherAvis();
                                break;
                            case 3:
                                C.ChoixLieu();
                                break;
                            case 4:
                                C.ChoixNom();
                                break;
                            case 5:
                                C.ChoixEtoiles();
                                break;
                            case 6:
                                C.ChoixCuisine();
                                break;
                            case 7:
                                C.VerifCode();

                                break;
                            case 8:
                                C.SuppCom();
                                break;
                            case 9:
                                C.ajoutResto();
                                break;
                            case 10:
                                C.SuppResto();
                                break;
                            case 11:
                                C.lireFichierPersonne();
                                break;

                        }
                    } while (u != 12);
            }
            break;
        }

    }
}
