/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.s4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tjoseph
 */
public class Conseiller {

    private int star, lieu, id, prix, ah, am, code, role1;
    private String name, cuisine, auteur, adresse, mail, mdp, pseudo;
    private final List<Restaurant> Resto = new ArrayList<>();
    private final List<Avis> avis = new ArrayList<>();
    private final List<Personne> Statut = new ArrayList<>();

    public Conseiller() {

    }

    public void AfficherResto() {
        // méthode qui affiche la liste de tous les restaurants
        for (int i = 0; i < getResto().size(); i++) {
            System.out.println(getResto().get(i));
        }

    }

    public void fichierPersonne() {
        try {
            try (FileWriter fichP = new FileWriter("fichierPersonnes.txt")) {
                for (int i = 0; i < Statut.size(); i++) {
                    Personne p = Statut.get(i);
                    fichP.write(p.versFichP() + System.lineSeparator());
                }
            }

        } catch (IOException ex) {

        }

    }

    public void fichierRestos() {
        try {
            try (FileWriter fich = new FileWriter("fichierRestos.txt")) {
                for (int i = 0; i < getResto().size(); i++) {
                    Restaurant r = Resto.get(i);
                    fich.write(r.versFichier() + System.lineSeparator());
                }
            }

        } catch (IOException ex) {

        }

    }

    public void lireFichierRestos() {
        BufferedReader br ;

        try {
            try (FileReader fich = new FileReader("fichierRestos.txt")) {
               br = new BufferedReader(fich);
                String identifiant = br.readLine();

                while (identifiant != null) {

                    int Id = Integer.valueOf(identifiant);
                    while (Id < 1000) {
                        String Name = br.readLine();
                        String Cuisine = br.readLine();
                        int Star = Integer.valueOf(br.readLine());
                        int Lieu = Integer.valueOf(br.readLine());//Integer.toString(lieu);

                        String Adresse = br.readLine();
                        int Prix = Integer.valueOf(br.readLine());

                        int ppe = Integer.valueOf(br.readLine());

                        //...
                        Restauration_rapide C1 ;
                        C1 = new Restauration_rapide(Id, Name, Cuisine, Lieu, Adresse, Prix, Star, ppe);

                        trierPrix();
                        System.out.println(C1);
                       


                    }
                    while (Id >= 1000 && Id <= 3000) {
                        String Name = br.readLine();
                        String Cuisine = br.readLine();
                        int Star = Integer.valueOf(br.readLine());
                        int Lieu = Integer.valueOf(br.readLine());//Integer.toString(lieu);

                        String Adresse = br.readLine();
                        int Prix = Integer.valueOf(br.readLine());

                        int Am = Integer.valueOf(br.readLine());
                        int Ah = Integer.valueOf(br.readLine());
                        //...
                        Restauration_traditionnel C2;
                        C2 = new Restauration_traditionnel(Id, Name, Cuisine, Lieu, Adresse, Prix, Star, Am, Ah);
                        getResto().add(C2);
                        trierPrix();
                        System.out.println(C2);
                        
                    }
                    while (Id > 3000) {
                        String Name = br.readLine();
                        String Cuisine = br.readLine();
                        int Star = Integer.valueOf(br.readLine());
                        int Lieu = Integer.valueOf(br.readLine());//Integer.toString(lieu);

                        String Adresse = br.readLine();
                        int Prix = Integer.valueOf(br.readLine());

                        int Am = Integer.valueOf(br.readLine());
                        int Ah = Integer.valueOf(br.readLine());
                        int recompense = Integer.valueOf(br.readLine());
                        //...
                        Restauration_traditionnel C3;
                        C3 = new Restauration_traditionnel_luxe(Id, Name, Cuisine, Lieu, Adresse, Prix, Star, Am, Ah, recompense);
                        getResto().add(C3);
                        trierPrix();
                        System.out.println(C3);
                    
                    }
                    br.readLine();
                    identifiant = br.readLine();
                    
                }
               
            }

        } catch (IOException ex) {

        }
        
    }

    public void lireFichierPersonne() {
        try {
            try (FileReader fichP = new FileReader("fichierPersonnes.txt")) {
                BufferedReader br = new BufferedReader(fichP);

                String Role = br.readLine();

                while (Role != null) {

                    int role = Integer.valueOf(Role);
                    if (role == 1) {
                        String Mail = br.readLine();
                        String Pseudo = br.readLine();

                        String Mdp = br.readLine();

                        Utilisateur u;
                        u = new Utilisateur(role, Mail, Pseudo, Mdp);

                        System.out.println("Utilisateur simple" + "\n" + Mail + "\n" + Pseudo + "\n");

                    }

                    if (role == 2) {
                        String Mail = br.readLine();
                        String Pseudo = br.readLine();

                        String Mdp = br.readLine();

                        int rib = Integer.valueOf(br.readLine());
                        int Code = Integer.valueOf(br.readLine());
                        //...
                        Utilisateur_premium v;
                        v = new Utilisateur_premium(role, Mail, Pseudo, Mdp, rib, Code);
                        System.out.println("Utilisateur premium" + "\n" + Mail + "\n" + Pseudo + "\n" + rib + "\n");
                    }
                    if (role == 0) {
                        String Mail = br.readLine();
                        String Pseudo = br.readLine();

                        String Mdp = br.readLine();

                        int Code = Integer.valueOf(br.readLine());
                        //...
                        Administrateur a;
                        a = new Administrateur(role, Mail, Pseudo, Mdp, Code);
                        System.out.println("Administrateur" + "\n" + Mail + "\n" + Pseudo + "\n");
                    }

                    br.readLine();
                    Role = br.readLine();
                }
            }

        } catch (IOException ex) {

        }
    }

    public void fichierAvis() {
        try {
            try (FileWriter fich1 = new FileWriter("fichierAvis.txt")) {
                for (int j = 0; j < getAvis().size(); j++) {

                    Avis a = getAvis().get(j);
                    fich1.write(a.versFich() + System.lineSeparator());

                }
            }

        } catch (IOException ex) {

        }
    }

    public void AfficherAvis() {//methode qui permet d'afficher les avis sur un restaurant
        int i, j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez indiquer le nom du restaurant dont vous voulez voir les avis");
        name = sc.nextLine();
        System.out.println("Veuillez indiquer l'identifiant du restaurant dont vous voulez voir les avis");
        id = sc.nextInt();

        for (i = 0; i < getResto().size(); i++) {
            for (j = 0; j < getAvis().size(); j++) {
                if (getResto().get(i).NomComp(this) && getResto().get(i).Id(this) && getAvis().get(j).NomComp(this)) {

                    System.out.println(getAvis().get(j));

                }
            }

        }

    }

    public void avis() {//méthode qui initialise une liste d'avis 
        LocalDate date = LocalDate.of(2017, 12, 17);
        LocalDate date2 = LocalDate.of(2018, 1, 22);
        LocalDate date3 = LocalDate.of(2018, 2, 14);
        Avis a;
        a = new Avis("Nakata", "Dupont", date, 8, "Service de grande qualité");
        getAvis().add(a);
        Avis b;
        b = new Avis("L'abeille", "Azerty", date2, 9, "Un repas d'excellent qualité, une bonne ambiance malgré un prix assez excessive, l'abeille reste un must de la gastronomie française ");
        getAvis().add(b);
        Avis c;
        c = new Avis("Mc'Donalds", "BigMic", date3, 3, "Publicité mensongères, des burgers différents de ceux vus affichés et l'état des lieux laissaient a désirer");
        getAvis().add(c);
    }

    public void statut() {//méthode qui initialise une liste d'utilisateurs
        Utilisateur u;
        u = new Utilisateur(1, "cpo@epfedu.fr", "TacTic", "algo");
        getStatut().add(u);
        Utilisateur_premium v;
        v = new Utilisateur_premium(2, "theop@epfedu.fr", "zxoe", "hydro", 1234567890, 1997);
        getStatut().add(v);
        Administrateur w;
        w = new Administrateur(0, "kgm@epfedu.fr", "Zidane", "z", 1997);
        getStatut().add(w);

    }

    public void Restaurant() {//méthode qui initialise une liste de restaurants
        Restauration_rapide RR1;
        RR1 = new Restauration_rapide(151, "Mc'Donalds", "Burgers", 15, "17 rue Jean Jaurès", 10, 0, 1);
        getResto().add(RR1);
        Restauration_rapide RR2;
        RR2 = new Restauration_rapide(41, "Pizza Hut", "Pizzas", 4, "2 rue Lakanal", 7, 0, 1);
        getResto().add(RR2);
        Restauration_rapide RR3;
        RR3 = new Restauration_rapide(131, "Nakata", "Sushis", 13, "2 rue du Nouveau Ming", 15, 0, 1);
        getResto().add(RR3);
        Restauration_traditionnel RT1;
        RT1 = new Restauration_traditionnel(1011, "Chez Renault", "Belge", 1, "69 boulevard Haussmann", 80, 3, 2, 1);
        getResto().add(RT1);
        Restauration_traditionnel RT2;
        RT2 = new Restauration_traditionnel(1811, "Chez Gino", "Italienne", 8, "7 avenue Montaigne", 50, 2, 1, 2);
        getResto().add(RT2);
        Restauration_traditionnel RT3;
        RT3 = new Restauration_traditionnel(1811, "Kongossa", "Africaine", 18, "20 allée de la Reine", 30, 2, 1, 2);
        getResto().add(RT3);
        Restauration_traditionnel_luxe RTL1;
        RTL1 = new Restauration_traditionnel_luxe(3821, "Fouquet's", "Francaise", 8, "99 Avenue des Champs-Elysées", 100, 4, 2, 1, 7);
        getResto().add(RTL1);
        Restauration_traditionnel_luxe RTL2;
        RTL2 = new Restauration_traditionnel_luxe(3621, "L'abeille", "Francaise", 16, " 10 Avenue d'Iéna", 100, 5, 2, 2, 10);
        getResto().add(RTL2);

    }

    public void publication() {//méthode qui permet d'ecrire un avis
        int i, j;

        Scanner sc = new Scanner(System.in);
        auteur = pseudo;
        System.out.println("Veuillez indiquer le nom du restaurant: ");
        name = sc.nextLine();
        System.out.println("Votre commentaire:  ");
        String commentaire = sc.nextLine();
        System.out.println("Veuillez indiquer l'identifiant du restaurant: ");
        id = sc.nextInt();
        System.out.println("Veuillez lui mettre une note: ");
        int note = sc.nextInt();
        while (note < 0 || note > 10) {//oblige le client à entrer un arrondissement entre 1 et 20
            System.out.println("\nVeuillez recommencer");
            System.out.println("Veuillez entrer une note entre 0 et 10");
            note = sc.nextInt();
        }
        LocalDate date = LocalDate.now();
        Avis A;
        A = new Avis(getName(), auteur, date, note, commentaire);
        getAvis().add(A);

        for (i = 0; i < getResto().size(); i++) {
            for (j = 0; j < getAvis().size(); j++) {
                if (getResto().get(i).NomComp(this) && getResto().get(i).Id(this) && getAvis().get(j).NomComp(this)) {

                    System.out.println(getAvis().get(j));

                }
            }

        }

    }

    public void ajoutResto() {//méthode qui permet d'ajouter un restaurant dans la liste 
        int choix;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nom du nouveau restaurant");
        name = sc.nextLine();
        System.out.println("Entrez le type de cuisine du nouveau restaurant");
        cuisine = sc.nextLine();
        System.out.println("Entrez l'adresse du nouveau restaurant");
        adresse = sc.nextLine();
        System.out.println("Entrez l'arrondisemment du nouveau restaurant");
        lieu = sc.nextInt();
        System.out.println("Entrez le prix moyen du nouveau restaurant");
        prix = sc.nextInt();
        System.out.println("Entrez le nombre d'étoiles du nouveau restaurant");
        star = sc.nextInt();
        while (star < 0 || star > 5) {//oblige le client à entrer un nombre entre 1 et 5
            System.out.println("\nVeuillez recommencer");
            System.out.println("Veuillez indiquer un nombre d'étoiles");
            star = sc.nextInt();
        }
        System.out.println("Entrez l'Identifiant du nouveau resto");
        id = sc.nextInt();

        String ajout = ("\nQuel type de restaurant est-ce?\n1) Restauration rapide\n2) Restauration traditionnelle\n3) Restauration luxe");
        System.out.println(ajout);
        choix = sc.nextInt();
        while (choix < 1 || choix > 3) {//oblige le client à entrer un chiffre entre 1 et 3
            System.out.println("\nVeuillez recommencer");
            System.out.println(ajout);
            choix = sc.nextInt();
        }

        switch (choix) {
            case 1:
                System.out.println("Possibilté de commander à emporter ? (Répondre par 1(oui) ou 2 (non))");
                int ppe = sc.nextInt();
                Restauration_rapide C1;
                C1 = new Restauration_rapide(id, getName(), cuisine, lieu, adresse, prix, star, ppe);
                getResto().add(C1);
                trierPrix();
                break;
            case 2:
                System.out.println("Présence d'une ambiance musicale? (Répondre par 1(oui) ou 2 (non))");
                am = sc.nextInt();
                while (am < 1 || am > 2) {//oblige le client à entrer un nombre entre 1 et 2
                    System.out.println("\nVeuillez recommencer");
                    System.out.println("Veuillez indiquer un nombre entre 1 et 2");
                    am = sc.nextInt();
                }
                System.out.println("Présence d'un accés pour Handicapés ou personnes à mobilité réduite? (Répondre par 1(oui) ou 2 (non))");
                ah = sc.nextInt();
                while (ah < 1 || ah > 2) {//oblige le client à entrer un nombre entre 1 et 2
                    System.out.println("\nVeuillez recommencer");
                    System.out.println("Veuillez indiquer un nombre entre 1 et 2");
                    ah = sc.nextInt();
                }
                Restauration_traditionnel C2;
                C2 = new Restauration_traditionnel(id, getName(), cuisine, lieu, adresse, prix, star, am, ah);
                getResto().add(C2);
                trierPrix();
                break;
            case 3:
                System.out.println("Présence d'une ambiance musicale? (Répondre par 1(oui) ou 2 (non))");
                am = sc.nextInt();
                while (am < 1 || am > 2) {//oblige le client à entrer un nombre entre 1 et 2
                    System.out.println("\nVeuillez recommencer");
                    System.out.println("Veuillez indiquer un nombre entre 1 et 2");
                    am = sc.nextInt();
                }
                System.out.println("Présence d'un accés pour Handicapés ou personnes à mobilité réduite?(Répondre par 1(oui) ou 2 (non))");
                ah = sc.nextInt();
                while (ah < 1 || ah > 2) {//oblige le client à entrer un nombre entre 1 et 2
                    System.out.println("\nVeuillez recommencer");
                    System.out.println("Veuillez indiquer un nombre entre 1 et 2");
                    ah = sc.nextInt();
                }
                System.out.println("Nombre de récompenses: ");
                int recompense = sc.nextInt();
                Restauration_traditionnel C3;
                C3 = new Restauration_traditionnel_luxe(id, getName(), cuisine, lieu, adresse, prix, star, am, ah, recompense);
                getResto().add(C3);
                trierPrix();
                break;
        }

    }

    public void NouvCompteUtilisateurSimple(int a, String mail, String pseudo, String mdp) {//méthode qui permet de créer un compte(ajouter un utilisateur à la liste)
//        int choix;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Entrez votre email");
//        mail = sc.nextLine();
//        System.out.println("Entrez votre mot de passe");
//        mdp = sc.nextLine();
//        System.out.println("Entrez votre pseudo");
//        pseudo = sc.nextLine();
//        String nouv = ("\nSouhaitez vous devenir un simple Utilisateur(1) ou un Utilisateur Premium(2)");
//        System.out.println(nouv);
//        choix = sc.nextInt();
//        while (choix < 1 || choix > 2) {//oblige le client à entrer un chiffre entre 1 et 2
//            System.out.println("\nVeuillez recommencer");
//            System.out.println(nouv);
//            choix = sc.nextInt();
//        }
//        switch (choix) {
//            case 1:
        Utilisateur u;
        u = new Utilisateur(1, mail, pseudo, mdp);
        getStatut().add(u);
//                break;
//            case 2:
//                System.out.println("Le compte premium necessite une participation financière de 9€99/mois.Veullez indiquer votre RIB");
//                int rib = sc.nextInt();
//                System.out.println("Veuillez indiquer votre code secret");
//                code = sc.nextInt();
//                Utilisateur_premium v;
//                v = new Utilisateur_premium(2, mail, getPseudo(), mdp, rib, getCode());
//                getStatut().add(v);
//                break;
    }

    public void NouvCompteUtilisateurPremium(int a, String mail, String pseudo, String mdp, int rib, int code) {//méthode qui permet de créer un compte(ajouter un utilisateur à la liste)
//        int choix;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Entrez votre email");
//        mail = sc.nextLine();
//        System.out.println("Entrez votre mot de passe");
//        mdp = sc.nextLine();
//        System.out.println("Entrez votre pseudo");
//        pseudo = sc.nextLine();
//        String nouv = ("\nSouhaitez vous devenir un simple Utilisateur(1) ou un Utilisateur Premium(2)");
//        System.out.println(nouv);
//        choix = sc.nextInt();
//        while (choix < 1 || choix > 2) {//oblige le client à entrer un chiffre entre 1 et 2
//            System.out.println("\nVeuillez recommencer");
//            System.out.println(nouv);
//            choix = sc.nextInt();
//        }
//        switch (choix) {
//            case 1:
//                Utilisateur u;
//                u = new Utilisateur(1, mail, pseudo, mdp);
//                getStatut().add(u);
//                break;
//            case 2:
//                System.out.println("Le compte premium necessite une participation financière de 9€99/mois.Veullez indiquer votre RIB");
//                int rib = sc.nextInt();
//                System.out.println("Veuillez indiquer votre code secret");
//                code = sc.nextInt();
        Utilisateur_premium v;
        v = new Utilisateur_premium(2, mail, getPseudo(), mdp, rib, code);
        getStatut().add(v);
//                break;
    }

    public void SuppCom() {//méthode qui permet de supprimer les avis d'un utilisateur
        int i, j;

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez indiquer le pseudo responsable de commentaire indésirables");
        auteur = sc.nextLine();

        for (i = 0; i < getResto().size(); i++) {
            for (j = 0; j < getAvis().size(); j++) {
                if (getAvis().get(j).AuteurComp(this)) {
                    getAvis().remove(j);
                    System.out.println("Commentaire supprimé");
                }
            }

        }

    }

    public void SuppResto() {//méthode qui permet de supprimer un restaurant de la liste
        int i;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez l'identifiant du restaurant que vous voulez retirer de la liste");
            id = sc.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Veuillez entrer un chiffre la prochaine fois\n");
            star = 6;
        }
        for (i = 0; i < getResto().size(); i++) {

            if (getResto().get(i).Id(this)) {
                getResto().remove(i);
                System.out.println("Restaurant supprimé de la liste");
                i = getResto().size();
            }

        }
    }

    public void trierPrix() {//permet de trier par prix les restaurants
        int i;
        Restaurant tri;
        for (i = 0; i < getResto().size() - 1; i++) {

            if (getResto().get(i).prixSup(getResto().get(i + 1)) == true) {
                tri = getResto().get(i);
                getResto().set(i, getResto().get(i + 1));
                getResto().set(i + 1, tri);
                i = -1;

            }

        }

    }

    public void Identification(String email, String mdp) {//méthode qui permet à l'utilisateur de se connecter pour accéder à son menu
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("IDENTIFICATION\n");
        System.out.println("Veuillez indiquer votre adresse mail svp");
        mail = sc.nextLine();
        System.out.println("Veuillez indiquer votre mot de passe svp");
        mdp = sc.nextLine();
        for (i = 0; i < getStatut().size(); i++) {

            if (getStatut().get(i).MailComp(this) && getStatut().get(i).MdpComp(this)) {
                System.out.println(getStatut().get(i));
            }
            role1 = Statut.get(i).getRole();
            pseudo = Statut.get(i).getPseudo();

        }

    }

    public void VerifCode() {//méthode qui verifie le code secret
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez indiquer votre pseudo: ");
        pseudo = sc.nextLine();
        System.out.println("Veuillez inscrire votre code secret: ");
        code = sc.nextInt();

        for (i = 0; i < getStatut().size(); i++) {

            if (getStatut().get(i).PseudoComp(this) && getStatut().get(i).CodeComp(this)) {
                System.out.println("Cher(e) " + getStatut().get(i).getPseudo() + " veuillez entrer votre avis");
                publication();
                break;
            }

        }

    }

    public void ChoixEtoiles() {//methode qui permet de chercher un restaurant selon son nombre d'étoiles
        int i;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez indiquer un nombre d'étoiles");
            star = sc.nextInt();

            while (star < 0 || star > 5) {//oblige le client à entrer un nombre entre 0 et 5
                System.out.println("\nVeuillez recommencer");
                System.out.println("Veuillez indiquer un nombre d'étoiles");
                star = sc.nextInt();

            }
        } catch (InputMismatchException ex) {
            System.out.println("Veuillez entrer un chiffre entre 0 et 5 la prochaine fois\n");
            star = 6;
        }
        for (i = 0; i < getResto().size(); i++) {

            if (getResto().get(i).StarSup(this)) {
                System.out.println(getResto().get(i));

            }

        }

    }

    public void ChoixNom() {//methode qui permet de chercher un restaurant selon son nom
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez indiquer le nom du restaurant");
        name = sc.nextLine();

        for (i = 0; i < getResto().size(); i++) {

            if (getResto().get(i).NomComp(this)) {
                System.out.println(getResto().get(i));
            }
        }

    }

    public void ChoixLieu() {//methode qui permet de chercher un restaurant selon son arrondissement
        int i;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez indiquer un arrondissement");
            lieu = sc.nextInt();
            while (lieu < 1 || lieu > 20) {//oblige le client à entrer un arrondissement entre 1 et 20
                System.out.println("\nVeuillez recommencer");
                System.out.println("Veuillez indiquer un arrondissement");
                lieu = sc.nextInt();
            }
        } catch (InputMismatchException ex) {
            System.out.println("Veuillez entrer un chiffre entre 1 et 20 la prochaine fois\n");
            lieu = 21;
        }
        for (i = 0; i < getResto().size(); i++) {

            if (getResto().get(i).Quartier(this)) {
                System.out.println(getResto().get(i));
            }

        }

    }

    public void ChoixCuisine() {//methode qui permet de chercher un restaurant selon son type de cuisine
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez indiquer un type de cuisine (Italienne, Pizzas,Sushis,Francaise,Burgers,Belge...)");
        cuisine = sc.nextLine();

        for (i = 0; i < getResto().size(); i++) {

            if (getResto().get(i).Cuisine(this)) {
                System.out.println(getResto().get(i));
            }

        }

    }

    /**
     * @return the star
     */
    public int getStar() {
        return star;
    }

    /**
     * @return the lieu
     */
    public int getLieu() {
        return lieu;
    }

    /**
     * @return the cuisine
     */
    public String getCuisine() {
        return cuisine;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the auteur
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @return the Statut
     */
    public List<Personne> getStatut() {
        return Statut;
    }

    /**
     * @return the Resto
     */
    public List<Restaurant> getResto() {
        return Resto;
    }

    /**
     * @return the role1
     */
    public int getRole1() {
        return role1;
    }

    /**
     * @return the avis
     */
    public List<Avis> getAvis() {
        return avis;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
