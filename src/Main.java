import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner     = new Scanner(System.in);
        Bibliotheque biblio = new Bibliotheque();
        int choix;

        biblio.ajouterLivre("Le Petit Prince",  "Saint-Exupery", "Roman");
        biblio.ajouterLivre("L'Alchimiste",     "Paulo Coelho",  "Roman");
        biblio.ajouterLivre("Harry Potter",      "J.K. Rowling",  "Fantasy");
        biblio.ajouterLivre("Clean Code",        "Robert Martin", "Informatique");

        do {
            System.out.println("\n=== GESTION BIBLIOTHEQUE ===");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Afficher tous les livres");
            System.out.println("5. Emprunter un livre");
            System.out.println("6. Retourner un livre");
            System.out.println("7. Sauvegarder en CSV");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entree invalide. Reessayez : ");
                scanner.next();
            }
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> {
                    System.out.print("Titre  : "); String titre  = scanner.nextLine();
                    System.out.print("Auteur : "); String auteur = scanner.nextLine();
                    System.out.print("Genre  : "); String genre  = scanner.nextLine();
                    biblio.ajouterLivre(titre, auteur, genre);
                }
                case 2 -> {
                    biblio.afficherLivres();
                    System.out.print("ID du livre a supprimer : ");
                    biblio.supprimerLivre(scanner.nextInt());
                }
                case 3 -> {
                    System.out.print("Rechercher (titre ou auteur) : ");
                    biblio.rechercherLivre(scanner.nextLine());
                }
                case 4 -> biblio.afficherLivres();
                case 5 -> {
                    biblio.afficherLivres();
                    System.out.print("ID du livre a emprunter : ");
                    biblio.emprunterLivre(scanner.nextInt());
                }
                case 6 -> {
                    biblio.afficherLivres();
                    System.out.print("ID du livre a retourner : ");
                    biblio.retournerLivre(scanner.nextInt());
                }
                case 7 -> biblio.sauvegarderCSV("bibliotheque.csv");
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        scanner.close();
    }
}
