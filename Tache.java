package sn.esp.tache;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Tache {

    private int identifiant;
    private static int dernierId = 1;
    private String titre;
    private String etat;
    private LocalDate dateCreation;

    public Tache(String titre){
        this.titre = titre;
        this.identifiant = dernierId++;
        this.etat = "PREVU";
        this.dateCreation = LocalDateTime.now().toLocalDate();
    }

    public Tache(String titre, String etat){
        this.titre = titre;
        this.etat = etat;
        this.identifiant = dernierId++;
        this.dateCreation = LocalDateTime.now().toLocalDate();
    }

    public Tache(String titre, String etat, LocalDate dateCreation){
        this.titre = titre;
        this.etat = etat;
        this.identifiant = dernierId++;
        this.dateCreation = dateCreation;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public static int getDernierId() {
        return dernierId;
    }

    public String getTitre() {
        return titre;
    }

    public String getEtat() {
        return etat;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public static void setDernierId(int dernierId) {
        Tache.dernierId = dernierId;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDateCreation(String dateCreation) {
        String[] date = dateCreation.split("-");

        this.dateCreation = LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
    }

    @Override
    public String toString() {
        return "Tâche : { Identifiant: " + this.getIdentifiant() + ", Titre: " + this.getTitre() + ", Etat: " + this.getEtat() + ", Date Création: " + this.getDateCreation() + " }";
    }
}
