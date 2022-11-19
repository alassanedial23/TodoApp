package sn.esp.tache;

import java.util.Arrays;

public class GestionnaireTache {

    private Tache[] taches;
    private int nombreTache;

    public GestionnaireTache(int nombreMax){
        this.nombreTache = 0;
        this.taches = new Tache[nombreMax];
    }

    public boolean ajouter(Tache tache){
        this.nombreTache++;

        if(nombreTache <= this.taches.length ){
            this.taches[this.nombreTache - 1] = tache;
            return true;
        }

        return false;
    }

    public boolean modifier(Tache tache){
        for(int i = 0 ; i < this.taches.length ; i++){
            if(this.taches[i].getIdentifiant() == tache.getIdentifiant()){
                this.taches[i].setTitre(tache.getTitre());
                this.taches[i].setEtat(tache.getEtat());
                this.taches[i].setDateCreation(tache.getDateCreation().toString());

                return true;
            }
        }
        return false;
    }

    public boolean supprimer(int id){
        for(int i = 0 ; i < this.taches.length ; i++){
            if(this.taches[i].getIdentifiant() == id){
                this.taches[i] = null;
                return true;
            }
        }
        return false;
    }

    public Tache[] lister(){
        Tache[] listTache = new Tache[this.nombreTacheEffective()];
        int e = 0;

        for (int i = 0 ; i < this.taches.length; i++){
            if(this.taches[i] == null)
                continue;
            listTache[e] = this.taches[i];
            e++;
        }
        return listTache;
    }

    public Tache[] lister(String etat){
        if(this.nombreTacheEffective(etat) == 0)
            return null;

        Tache[] listTache = new Tache[this.nombreTacheEffective(etat)];
        int e = 0;

        for (int i = 0 ; i < this.taches.length; i++){
            if(this.taches[i] == null)
                continue;
            else if (this.taches[i].getEtat().equals(etat)){
                listTache[e] = this.taches[i];
                e++;
            }

        }
        return listTache;
    }

    public int nombreTacheEffective(){
        int compteur = 0;

        for (Tache tache : this.taches) {
            if (tache != null)
                compteur++;
        }
        return compteur;
    }

    public int nombreTacheEffective(String etat){
        int compteur = 0;

        for (Tache tache : this.taches) {
            if (tache != null && tache.getEtat().equals(etat))
                compteur++;
        }
        return compteur;
    }
}
