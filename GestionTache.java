package sn.esp.tache;

import java.time.LocalDate;
import java.util.Scanner;

public class GestionTache {
    public static void main(String[] args) {
        int choix, choixCreation , choixEtat, retour = 0, id = 0;
        boolean etatValid = false;
        String titre = "", etat = "", date = "";
        Scanner scanner = new Scanner(System.in);
        GestionnaireTache gestionnaireTache = new GestionnaireTache(5);

        do{
            menuApp();
            choix = scanner.nextInt();

            switch (choix){
                case 1:
                    menuCreation();
                    choixCreation = scanner.nextInt();

                    switch (choixCreation){
                        case 1:
                            scanner.nextLine();
                            System.out.print("Entrer le titre de votre Tache: ");
                            titre = scanner.nextLine();
                            if(gestionnaireTache.ajouter(new Tache(titre.toUpperCase())))
                                System.out.println("Création Réussie");
                            else
                                System.out.println("Création Non Réussie");

                            System.out.print("Tapez 1 pour retourner sur la premiere page: ");
                            retour = scanner.nextInt();
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.print("Entrer le titre de votre Tache: ");
                            titre = scanner.nextLine();
                            System.out.print("Entrer l'etat de votre Tache (EN COURS , TERMINEE ou PREVU): ");

                            do{
                                etat = scanner.nextLine();
                                etatValid = isEtatValid(etat);
                                if(!etatValid)
                                    System.out.print("Les valeurs acceptées  sont (EN COURS , TERMINEE ou PREVU): ");
                            }while (!etatValid);

                            if(gestionnaireTache.ajouter(new Tache(titre.toUpperCase(),etat.toUpperCase())))
                                System.out.println("Création Réussie");
                            else
                                System.out.println("Création Non Réussie");

                            System.out.print("Tapez 1 pour retourner sur la premiere page: ");
                            retour = scanner.nextInt();
                        break;
                        case 3:
                            scanner.nextLine();

                            System.out.print("Entrer le titre de votre Tache: ");
                            titre = scanner.nextLine();
                            System.out.print("Entrer l'etat de votre Tache (En cours , Terminée ou Prevu): ");

                            do{
                                etat = scanner.nextLine();
                                etatValid = isEtatValid(etat);
                                if(!etatValid)
                                    System.out.print("Les valeurs acceptées  sont (EN COURS , TERMINEE ou PREVU): ");
                            }while (!etatValid);

                            System.out.print("Entrer la date de création (YYYY-mm-dd): ");
                            date = scanner.nextLine();

                            if(gestionnaireTache.ajouter(new Tache(titre.toUpperCase(),etat.toUpperCase(), LocalDate.parse(date))))
                                System.out.println("Création Réussie");
                            else
                                System.out.println("Création Non Réussie");

                            System.out.print("Tapez 1 pour retourner sur la premiere page: ");
                            retour = scanner.nextInt();
                        break;
                        default:
                            System.out.println("Mode de création inexistante....");
                    }
                break;
                case 2:
                    System.out.println("********************* MODIFICATION D'UNE TACHE **********************");
                    System.out.println("Voici la liste des tâches: ");
                    afficherListeTache(gestionnaireTache.lister());
                    System.out.println("Entrez l'id de la tache à modifier: ");
                    id = scanner.nextInt();
                    Tache tache = findTache(id, gestionnaireTache.lister());
                    if ( tache != null){
                        scanner.nextLine();
                        System.out.println("Voici la tache sélectionnée: ");
                        System.out.println(tache.toString());
                        System.out.print("Entrez le nouveau titre: ");
                        titre = scanner.nextLine();
                        tache.setTitre(titre.toUpperCase());
                        System.out.print("Entrez le nouveau état: ");
                        etat = scanner.nextLine();
                        tache.setEtat(etat.toUpperCase());
                        System.out.print("Entrez la nouvelle date: ");
                        date = scanner.nextLine();
                        tache.setDateCreation(date);
                        if(gestionnaireTache.modifier(tache))
                            System.out.println("Modification Réussie");
                        else
                            System.out.println("Modification Non Réussie");

                        System.out.print("Tapez 1 pour retourner sur la premiere page: ");
                        retour = scanner.nextInt();
                    }

                break;
                case 3:
                    System.out.println("********************* SUPPRESSION D'UNE TACHE **********************");

                    System.out.println("Voici la liste des tâches: ");
                    afficherListeTache(gestionnaireTache.lister());
                    System.out.print("Entrez l'id de la tache à supprimer: ");
                    id = scanner.nextInt();

                    if(gestionnaireTache.supprimer(id))
                        System.out.println("Suppression réussie....");
                    else
                        System.out.println("Cette tâche n'exite pas");

                    System.out.print("Tapez 1 pour retourner sur la premiere page : ");
                    retour = scanner.nextInt();
                break;
                case 4:
                    System.out.println("********************* LISTE DES TACHES **********************");
                    afficherListeTache(gestionnaireTache.lister());
                    System.out.print("Tapez 1 pour retourner sur la premiere page: ");
                    retour = scanner.nextInt();
                break;
                case 5:
                    do{
                        menuEtat();
                        choixEtat = scanner.nextInt();
                        switch (choixEtat){
                            case 1:
                                if(gestionnaireTache.lister("EN COURS") != null)
                                    afficherListeTache(gestionnaireTache.lister("EN COURS"));
                                else
                                    System.out.println("Y'a pas une tâche dans cet état");

                                System.out.print("Tapez 1 pour retourner sur la premiere page: ");
                                retour = scanner.nextInt();
                                break;
                            case 2:
                                if(gestionnaireTache.lister("TERMINEE") != null)
                                    afficherListeTache(gestionnaireTache.lister("TERMINEE"));
                                else
                                    System.out.println("Y'a pas une tâche dans cet état");

                                System.out.print("Tapez 1 pour retourner sur la premiere page: ");
                                retour = scanner.nextInt();
                                break;
                            case 3:
                                if(gestionnaireTache.lister("PREVU") != null)
                                    afficherListeTache(gestionnaireTache.lister("PREVU"));
                                else
                                    System.out.println("Y'a pas une tâche dans cet état");

                                System.out.print("Tapez 1 pour retourner sur la premiere page: ");
                                retour = scanner.nextInt();
                                break;
                            default:
                                System.out.println("Etat inexistant....");
                        }
                    }while (choixEtat < 1 || choixEtat > 3);
                break;
                case 6:
                    System.exit(0);
                break;
                default:
                    System.out.println("Ce choix n'existe pas !!");
            }
        }while (retour == 1 || choix < 1 || choix > 6);


    }

    public static void menuApp(){
        System.out.println("********************* GESTION DES TACHES **********************");
        System.out.println("\n\t\t\t\t\t 1. Ajouter Une tache");
        System.out.println("\n\t\t\t\t\t 2. Modifier Une tache");
        System.out.println("\n\t\t\t\t\t 3. Supprimer Une tache");
        System.out.println("\n\t\t\t\t\t 4. Lister toutes les taches");
        System.out.println("\n\t\t\t\t\t 5. Lister les taches (en fonction de l'état)");
        System.out.println("\n\t\t\t\t\t 6. Quitter");
        System.out.print("\n\t\t\t\t\tFaites votre choix: ");
    }
    public static void menuCreation(){
        System.out.println("********************* CREATION D'UNE TACHE **********************");
        System.out.println("\n\t\t\t\t\t 1. Création Simple(On indique seulement le titre)");
        System.out.println("\n\t\t\t\t\t 2. Création avec l'état(On indique le titre et l'état)");
        System.out.println("\n\t\t\t\t\t 3. Création avec la date de création (On indique la date de création)");
        System.out.print("\n\t\t\t\t\tChoisissez votre mode de création: ");
    }
    public static void menuEtat(){
        System.out.println("********************* LISTE DES ETATS **********************");
        System.out.println("\n\t\t\t\t\t 1. EN COURS");
        System.out.println("\n\t\t\t\t\t 2. TERMINEE");
        System.out.println("\n\t\t\t\t\t 3. PREVU");
        System.out.print("\n\t\t\t\t\tChoisissez un état: ");
    }

    public static void afficherListeTache(Tache[] taches){
        for (Tache tache: taches)
            System.out.println(tache.toString());
    }

    public static Tache findTache(int id, Tache[] taches){
        for (Tache tache: taches){
            if(tache.getIdentifiant() == id)
                return tache;
        }
        return null;
    }

    public static boolean isEtatValid(String etat){
        if(!etat.equals("PREVU") && !etat.equals("TERMINEE") && !etat.equals("EN COURS"))
            return false;
        return true;
    }
}
