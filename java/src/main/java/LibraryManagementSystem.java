import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class LibraryManagementSystem {

//    keeps track of how many book are available.
    HashMap<String, Integer> availability = new HashMap<>();

//    Booking requests
    HashMap<String, Queue<String>> borrowRequests = new HashMap<>();
    HashMap<String, Integer> borrowedBooks = new HashMap<>();


//    Method to add books to the inventory
    public void addBook(String book, int copies){
        availability.put(book, availability.getOrDefault(book, 0) + copies);
    }

//    Method to borrow a book
    public void borrowBook(String book) {
//        If book is available then decrement availability map, if not then add a pending request
        if(availability.getOrDefault(book, 0)>0){
            availability.put(book, availability.get(book) - 1);
            borrowedBooks.put(book, borrowedBooks.getOrDefault(book, 0)+1);
        } else {
            if(!borrowRequests.containsKey(book)){
                borrowRequests.put(book, new LinkedList<>());
            }
            borrowRequests.get(book).add(book);
        }
    }

//    Method to return a book
    public void returnBook(String book){
        if(borrowRequests.containsKey(book) && !borrowRequests.get(book).isEmpty()){
            borrowRequests.get(book).remove();
        } else {
            availability.put(book, availability.get(book)+1);
            borrowedBooks.put(book, borrowedBooks.get(book)-1);
        }
    }

    // Method to display the current status of the library (inventory and borrowed books)
    public void displayLibraryStatus() {
        System.out.println("\nLibrary Inventory:");
        for (String book : availability.keySet()) {
            System.out.println(book + " - Copies Available: " + availability.get(book));
        }

        System.out.println("\nBorrowed Books:");
        for (String book : borrowedBooks.keySet()) {
            System.out.println(book + ": " +  borrowedBooks.get(book));
        }

        System.out.println("\nPending Borrow Requests:");
        for (String book : borrowRequests.keySet()) {
            if (!borrowRequests.get(book).isEmpty()) {
                System.out.println("Borrow requests for " + book + ": " + borrowRequests.get(book).size());
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books to the library
        library.addBook("Harry Potter", 2);
        library.addBook("The Lord of the Rings", 1);
        library.addBook("The Hobbit", 3);

        // Borrowing books
        library.borrowBook("Harry Potter");
        library.borrowBook("The Hobbit");
        library.borrowBook("Harry Potter");  // Already borrowed, request will be queued
        library.displayLibraryStatus();

        // Returning a book
        library.returnBook("Harry Potter");

        // Borrowing after return
        library.borrowBook("Harry Potter");

        // Display library status
        library.displayLibraryStatus();
    }
}
