import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Bibliotheque {

    private ArrayList<Livre> livres = new ArrayList<>();

    public void ajouterLivre(String titre, String auteur, String genre) {
        Livre livre = new Livre(titre, auteur, genre);
        livres.add(livre);
        System.out.println("Livre ajoute : " + titre);
    }

    public void supprimerLivre(int id) {
        for (Livre l : livres) {
            if (l.getId() == id) {
                if (l.isEstEmprunte()) {
                    System.out.println("Impossible : ce livre est actuellement emprunte.");
                    return;
                }
                livres.remove(l);
                System.out.println("Livre supprime : " + l.getTitre());
                return;
            }
        }
        System.out.println("Aucun livre trouve avec l'ID : " + id);
    }

    public void rechercherLivre(String motCle) {
        boolean trouve = false;
        System.out.println("\n=== Resultats pour : \"" + motCle + "\" ===");
        for (Livre l : livres) {
            if (l.getTitre().toLowerCase().contains(motCle.toLowerCase()) ||
                l.getAuteur().toLowerCase().contains(motCle.toLowerCase())) {
                System.out.println(l);
                trouve = true;
            }
        }
        if (!trouve) System.out.println("Aucun livre trouve.");
    }

    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("La bibliotheque est vide.");
            return;
        }
        System.out.println("\n=== Liste des livres (" + livres.size() + ") ===");
        for (Livre l : livres) {
            System.out.println(l);
        }
    }

    public void emprunterLivre(int id) {
        for (Livre l : livres) {
            if (l.getId() == id) {
                if (l.isEstEmprunte()) {
                    System.out.println("Ce livre est deja emprunte.");
                } else {
                    l.setEstEmprunte(true);
                    System.out.println("Livre emprunte : " + l.getTitre());
                }
                return;
            }
        }
        System.out.println("Aucun livre trouve avec l'ID : " + id);
    }

    public void retournerLivre(int id) {
        for (Livre l : livres) {
            if (l.getId() == id) {
                if (!l.isEstEmprunte()) {
                    System.out.println("Ce livre n'est pas emprunte.");
                } else {
                    l.setEstEmprunte(false);
                    System.out.println("Livre retourne : " + l.getTitre());
                }
                return;
            }
        }
        System.out.println("Aucun livre trouve avec l'ID : " + id);
    }

    public void sauvegarderCSV(String nomFichier) {
        try {
            FileWriter fw = new FileWriter(nomFichier);
            fw.write("id,titre,auteur,genre,estEmprunte\n");
            for (Livre l : livres) {
                fw.write(l.toCSV() + "\n");
            }
            fw.close();
            System.out.println("Sauvegarde reussie dans : " + nomFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}
