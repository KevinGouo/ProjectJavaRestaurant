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
public class Restaurant {

    //initialisation des parametres
    private final String coordonnees; //Initialisation des attributs

    private final String name;
    private final String tc;
    private final int id;
    private final int prix;
    private final int arrondissement;
    private final int etoiles;

    public Restaurant(int Id, String Nom, String Tc, int Arrondissement, String Coordonnees, int Prix, int Etoiles) {
        this.coordonnees = Coordonnees;
        this.name = Nom;
        this.arrondissement = Arrondissement;
        this.prix = Prix;
        this.id = Id;
        this.etoiles = Etoiles;
        this.tc = Tc;
    }

    @Override
    public String toString() {//pour afficher les caractéristiques des restaurants
        return ("Identifiant:" + getId() + "\nNom: " + name + "\nType de cuisine: " + tc + "\nNombre d'étoiles: " + etoiles + "\nArrondissement: " + getArrondissement() + "\nCoordonnées: " + coordonnees + "\nPrix moyen: " + getPrix() + "€");

    }

    public String versFichier() {//pour ajouter/afficher les caractéristiques des restaurants dans le fichier
        return getId() + System.lineSeparator() + name + System.lineSeparator() + tc + System.lineSeparator() + etoiles + System.lineSeparator() + getArrondissement() + System.lineSeparator() + coordonnees + System.lineSeparator() + getPrix() + System.lineSeparator();

    }

    public boolean prixSup(Restaurant R) {//méthode qui permet de comparer les prix entre restaurants

        return this.getPrix() > R.getPrix();
    }

    public boolean StarSup(Conseiller C) {//méthode qui permet de comparer le nombre d'étoiles

        return etoiles == C.getStar();
    }

    public boolean NomComp(Conseiller C) {//méthode qui permet de comparer les noms des restaurants

        return name.equals(C.getName());
    }

    public boolean Quartier(Conseiller C) {//méthode qui permet de comparer les arrondissements

        return arrondissement == C.getLieu();
    }

    public boolean Cuisine(Conseiller C) {//méthode qui permet de comparer le type de cuisine
        return tc.equals(C.getCuisine());
    }

    public boolean Id(Conseiller C) {//méthode qui permet de comparer les identifiants

        return id == C.getId();
    }

    /**
     * @return the prix
     */
    public int getPrix() {
        return prix;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the etoiles
     */
    public int getEtoiles() {
        return etoiles;
    }

    /**
     * @return the arrondissement
     */
    public int getArrondissement() {
        return arrondissement;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
