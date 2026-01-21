import java.util.*;

public class MovieManagerProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> movies = new ArrayList<>();
        ArrayList<String> deletedHistory = new ArrayList<>(); // To be store the deleted movies

        boolean show = true;

        while (show) {
            System.out.println("\n--- MOVIE MANAGER MENU ---");
            System.out.println("1. Add Movie");
            System.out.println("2. How many movies in the list?");
            System.out.println("3. Delete Movie");
            System.out.println("4. Sort Movies (A-Z)");
            System.out.println("5. View All Movies (Forward)");
            System.out.println("6. View Deleted Movies (History)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // To be clear Buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter movie name to add: ");

                    String newMovie = sc.nextLine().trim();


                    boolean exists = false;
                    for(String m : movies) {
                        if(m.equalsIgnoreCase(newMovie)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Oops! This movie is already on your list.");
                    } else {
                        movies.add(newMovie);
                        System.out.println("Movie added successfully!");
                    }
                    break;


                case 2:
                    System.out.println("Total Movies in the List is: "+movies.size());
                    break;
                case 3:
                    System.out.print("Enter movie name to delete: ");
                    String removeMovie = sc.nextLine();
                    if (movies.contains(removeMovie)) {
                        movies.remove(removeMovie);
                        deletedHistory.add(removeMovie); // To be Add the history of deleted movies
                        System.out.println(removeMovie + " removed and moved to history.");
                    } else {
                        System.out.println("Movie not found!");
                    }
                    break;

                case 4:
                    Collections.sort(movies);
                    System.out.println("Movies sorted alphabetically!");
                    break;

                case 5:
                    System.out.println("\n--- Current Movie List ---");
                    ListIterator<String> it = movies.listIterator();
                    while (it.hasNext()) {
                        System.out.println("- " + it.next());
                    }
                    break;

                case 6:
                    System.out.println("\n--- Previously Deleted Movies ---");
                    if (deletedHistory.isEmpty()) {
                        System.out.println("No movies deleted yet.");
                    } else {
                        for (String d : deletedHistory) {
                            System.out.println("Deleted: " + d);
                        }
                    }
                    break;

                case 7:
                    show = false;
                    System.out.println("Exiting... Thank You!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}