public class Livre {

    private int    id;
    private String titre;
    private String auteur;
    private String genre;
    private boolean estEmprunte;

    private static int compteur = 1;

    public Livre(String titre, String auteur, String genre) {
        this.id          = compteur++;
        this.titre       = titre.trim();
        this.auteur      = auteur.trim();
        this.genre       = genre.trim();
        this.estEmprunte = false;
    }

    public int     getId()         { return id; }
    public String  getTitre()      { return titre; }
    public String  getAuteur()     { return auteur; }
    public String  getGenre()      { return genre; }
    public boolean isEstEmprunte() { return estEmprunte; }

    public void setTitre(String titre)   { this.titre  = titre; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public void setGenre(String genre)   { this.genre  = genre; }
    public void setEstEmprunte(boolean estEmprunte) {
        this.estEmprunte = estEmprunte;
    }

    public String toCSV() {
        return id + "," + titre + "," + auteur + "," + genre + "," + estEmprunte;
    }

    @Override
    public String toString() {
        String statut = estEmprunte ? "Emprunte" : "Disponible";
        return "[ID: " + id + "] " + titre +
               " | Auteur : " + auteur +
               " | Genre : "  + genre  +
               " | "          + statut;
    }
}
