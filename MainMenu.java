import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MainMenu implements java.io.Serializable{
  public AdminPQ a;
  public Movies m;
  public WishList w;
  public RecentlyWatched r;

  public MainMenu(){

  }

public void saveAdminPQ(AdminPQ a){
  try {
    FileOutputStream fileOut =
    new FileOutputStream("AdminPQ.txt");
    ObjectOutputStream out =
    new ObjectOutputStream(fileOut);
    out.writeObject(a);
    out.close();
    fileOut.close();
    System.out.println("Serialized object successfully in AdminPQ.txt");
  } catch(IOException i) {
    i.printStackTrace();
  }
}
public void saveMovies(Movies m){
  try {
    FileOutputStream fileOut =
    new FileOutputStream("Movies.txt");
    ObjectOutputStream out =
    new ObjectOutputStream(fileOut);
    out.writeObject(m);
    out.close();
    fileOut.close();
    System.out.println("Serialized object successfully in Movies.txt");
  } catch(IOException i) {
    i.printStackTrace();
  }
}
public void saveWishList(WishList w){
  try {
    FileOutputStream fileOut =
    new FileOutputStream("WishList.txt");
    ObjectOutputStream out =
    new ObjectOutputStream(fileOut);
    out.writeObject(w);
    out.close();
    fileOut.close();
    System.out.println("Serialized object successfully in WishList.txt");

  } catch(IOException i) {
    i.printStackTrace();
  }
}
public void saveRecentlyWatched(RecentlyWatched r){
  try {
    FileOutputStream fileOut =
    new FileOutputStream("RecentlyWatched.txt");
    ObjectOutputStream out =
    new ObjectOutputStream(fileOut);
    out.writeObject(r);
    out.close();
    fileOut.close();
    System.out.println("Serialized object successfully in RecentlyWatched.txt");

  } catch(IOException i) {
    i.printStackTrace();
  }
}

public void saveCustomers(Customers c){
  try {
    FileOutputStream fileOut =
    new FileOutputStream("Customers.txt");
    ObjectOutputStream out =
    new ObjectOutputStream(fileOut);
    out.writeObject(c);
    out.close();
    fileOut.close();
    System.out.println("Serialized object successfully in Customers.txt");

  } catch(IOException i) {
    i.printStackTrace();
  }
}

public RecentlyWatched loadRecentlyWatched(){
  RecentlyWatched r = null;
  try
    {
       FileInputStream fileIn = new FileInputStream("RecentlyWatched.txt");
       ObjectInputStream in = new ObjectInputStream(fileIn);
       r = (RecentlyWatched) in.readObject();
       in.close();
       fileIn.close();
       return r;
    }catch(IOException i)
    {
       i.printStackTrace();
       return null;
    }catch(ClassNotFoundException v)
    {
       System.out.println("RecentlyWatched class not found");
       v.printStackTrace();
       return null;
    }
}

public AdminPQ loadAdminPQ(){
  AdminPQ a = null;
  try
    {
       FileInputStream fileIn = new FileInputStream("AdminPQ.txt");
       ObjectInputStream in = new ObjectInputStream(fileIn);
       a = (AdminPQ) in.readObject();
       in.close();
       fileIn.close();
       return a;
    }catch(IOException i)
    {
       i.printStackTrace();
       return null;
    }catch(ClassNotFoundException v)
    {
       System.out.println("AdminPQ class not found");
       v.printStackTrace();
       return null;
    }
}

public Movies loadMovies(){
  Movies m = null;
  try
    {
       FileInputStream fileIn = new FileInputStream("Movies.txt");
       ObjectInputStream in = new ObjectInputStream(fileIn);
       m = (Movies) in.readObject();
       in.close();
       fileIn.close();
       return m;
    }catch(IOException i)
    {
       i.printStackTrace();
       return null;

    }catch(ClassNotFoundException v)
    {
       System.out.println("Movies class not found");
       v.printStackTrace();
       return null;

    }
}

public WishList loadWishList(){
  WishList w = null;
  try
    {
       FileInputStream fileIn = new FileInputStream("WishList.txt");
       ObjectInputStream in = new ObjectInputStream(fileIn);
       w = (WishList) in.readObject();
       in.close();
       fileIn.close();
       return w;
    }catch(IOException i)
    {
       i.printStackTrace();
       return null;
    }catch(ClassNotFoundException v)
    {
       System.out.println("WishList class not found");
       v.printStackTrace();
       return null;

    }
}

public Customers loadCustomers(){
  Customers c = null;
  try
    {
       FileInputStream fileIn = new FileInputStream("Customers.txt");
       ObjectInputStream in = new ObjectInputStream(fileIn);
       c = (Customers) in.readObject();
       in.close();
       fileIn.close();
       return c;
    }catch(IOException i)
    {
       i.printStackTrace();
       return null;
    }catch(ClassNotFoundException v)
    {
       System.out.println("Customers class not found");
       v.printStackTrace();
       return null;

    }
}



    public static void main(String[] args){
      //creates scanner
      Scanner s = new Scanner(System.in);
      int choice;
      int choice1;
      MainMenu menu = new MainMenu();

      System.out.println("\nPlease enter either 1 or 2 to continue.");
      System.out.println("1. I am a returning user");
      System.out.println("2. I am a new user");
      System.out.println("3. Start new database");
      choice = s.nextInt();
      AdminPQ a = new AdminPQ();
      Movies m = new Movies();
      WishList w = new WishList();
      RecentlyWatched r = new RecentlyWatched();
      Customers c = new Customers();


      //while (choice != 1 || choice != 2)
      if (choice == 1){
        a = menu.loadAdminPQ();
        m = menu.loadMovies();
        w = menu.loadWishList();
        r = menu.loadRecentlyWatched();
        c = menu.loadCustomers();

        System.out.println("Welcome Back!");
        System.out.println("Enter credit card number.");
        int card = s.nextInt();
        Customer customer = c.searchCard(card);
        System.out.println(customer);
        //w = customer.getWishList();

      }

      //new customer
      else if (choice == 2){

        a = menu.loadAdminPQ();
        m = menu.loadMovies();
        //w = menu.loadWishList();
        r = menu.loadRecentlyWatched();
        c = menu.loadCustomers();

        //AdminPQ a = new AdminPQ();
        //Movies m = new Movies();
        //WishList w = new WishList();
        a = new AdminPQ();
        m = new Movies();
        w = new WishList();

        a.setMovie(m);
        Movie movie1 = new Movie("movie1", 20160101, 11111, 90, true);
        Movie movie2 = new Movie("movie2", 20160102, 22222, 91, true);
        Movie movie3 = new Movie("movie3", 20160103, 33333, 92, true);
        Movie movie4 = new Movie("movie4", 20160104, 44444, 93, true);
        Movie movie5 = new Movie("movie5", 20160105, 55555, 94, true);
        Movie movie6 = new Movie("movie6", 20160106, 66666, 95, true);
        Movie movie7 = new Movie("movie7", 20160107, 77777, 96, true);

        //System.out.println("beginning");
        a.insert(movie1);
        a.insert(movie2);
        a.insert(movie3);
        a.insert(movie4);
        a.insert(movie5);
        a.insert(movie6);
        m.insertBST(movie1);
        m.insertBST(movie2);
        m.insertBST(movie3);
        m.insertBST(movie4);
        m.insertBST(movie5);
        m.insertBST(movie6);
        w.insertWL(movie1);
        w.insertWL(movie2);
        w.insertWL(movie3);
        w.insertWL(movie4);
        w.insertWL(movie5);
        //System.out.println("end");
        System.out.println("Welcome new user!");
        System.out.println("Please create a username.");
        String name = s.nextLine();
        System.out.println("What is your email?");
        String email = s.nextLine();
        System.out.println("What is your credit card number?");
        int card = s.nextInt();

      Customer customer = new Customer(name, card, email, w);
      c.insertBST(customer);

      
      }

      else if (choice == 3){

        //AdminPQ a = new AdminPQ();
        //Movies m = new Movies();
        //WishList w = new WishList();
        a = new AdminPQ();
        m = new Movies();
        w = new WishList();
        c = new Customers();

        a.setMovie(m);
        Movie movie1 = new Movie("movie1", 20160101, 11111, 90, true);
        Movie movie2 = new Movie("movie2", 20160102, 22222, 91, true);
        Movie movie3 = new Movie("movie3", 20160103, 33333, 92, true);
        Movie movie4 = new Movie("movie4", 20160104, 44444, 93, true);
        Movie movie5 = new Movie("movie5", 20160105, 55555, 94, true);
        Movie movie6 = new Movie("movie6", 20160106, 66666, 95, true);
        Movie movie7 = new Movie("movie7", 20160107, 77777, 96, true);

        //System.out.println("beginning");
        a.insert(movie1);
        a.insert(movie2);
        a.insert(movie3);
        a.insert(movie4);
        a.insert(movie5);
        a.insert(movie6);
        m.insertBST(movie1);
        m.insertBST(movie2);
        m.insertBST(movie3);
        m.insertBST(movie4);
        m.insertBST(movie5);
        m.insertBST(movie6);
        w.insertWL(movie1);
        w.insertWL(movie2);
        w.insertWL(movie3);
        w.insertWL(movie4);
        w.insertWL(movie5);
        //System.out.println("end");
      System.out.println("Welcome new user!");
      //System.out.println("Please create a username.");
      String name2 = s.nextLine();
      System.out.println("What is your email?");
      String email = s.nextLine();
      System.out.println("Please create a username.");
      String name = s.nextLine();
      System.out.println("What is your credit card number?");
      int card = s.nextInt();

      Customer customer = new Customer(name, card, email, w);
      c.insertBST(customer);

      
      }

      //Movies.printMovies();

      //System.out.println(a.deleteMin().getScore());
      //System.out.println(a.findMin().getScore());

      System.out.println("What is your credit card number to proceed?");
      int card = s.nextInt();
      Customer customer = c.searchCard(card);


    while (choice != 0) {

      //System.out.println("What is your credit card number?");
      //int card = s.nextInt();
      //Customer customer = c.searchCard(card);

  		//first main menu
  		System.out.println("\nWelcome to Netflix!\n");
  		System.out.println("If you ever wish to quit, simply type the number '0'.");
  		System.out.println("Are you proceeding as a costumer or administrator?");
  		System.out.println("Please enter either 1 or 2 to continue.");
  		System.out.println("1. Customer");
  		System.out.println("2. Administrator");

      choice = 1;

        choice = s.nextInt();
        /*if (choice != 1 || choice !=2){
          System.out.println("Error");
        }
        else{*/
    			if (choice == 1) {
            //while (choice != 0)

      				System.out.println("\nWelcome Customer!\n");
      				System.out.println("How may we assist you?");
      				System.out.println("1. See your wishlist");
      				System.out.println("2. View all movies in order of release date");
      				System.out.println("3. Access next movie in wishlist to watch");
      				System.out.println("4. Edit your wishlist");
              System.out.println("5. Insert movie at desired location in wishlist");
              System.out.println("6. View recently watched movies");
              System.out.println("7. Back to main menu");

              choice1 = s.nextInt();

      				if (choice1 == 1){
      					//print wishlist with title and ID
                //w.printWL();
                customer.getWishList().printWL();
                //customer.setWishList(w);
      				}
      				else if (choice1 == 2){
      					//print all movies in order of release date(BST)
                System.out.println("Here is all the movies on record in order of release date.");
                m.traverse();
                //customer.setWishList(w);
      				}
      				else if (choice1 == 3){
      					//gets next movie in list
      					//ask user if they would like to delete this movie
                Movie next = customer.getWishList().accessNext();
                if (next.getHold() == true){
                  System.out.println("Would you like to watch this movie?");
                  System.out.println("1. Yes");
                  System.out.println("2. No");
                  int watch = s.nextInt();
                  if (watch == 1){
                    r.push(next);
                  }
                }
                  System.out.println("Would you like to delete this movie now?");
                  System.out.println("1. Yes");
                  System.out.println("2. No");
                  int del = s.nextInt();
                  if (del == 1){
                    customer.getWishList().searchRemoveWL(next.getId());
                  }
                  customer.getWishList().printWL();
                  //customer.setWishList(w);
        				}

      				else if (choice1 == 4){
      					//deletes undesired movies in wishlist
                customer.getWishList().printWL();
                System.out.println("What is the ID of the movie you would like to delete?");
                int id = s.nextInt();
                Movie delMovie = customer.getWishList().searchWL(id);
                //search for movie
                customer.getWishList().searchRemoveWL(delMovie.getId());
                customer.getWishList().printWL();
                //customer.setWishList(w);
      				}
              else if (choice1 == 5){
                //insert
                System.out.println("Here is the list of movies on record:");
                a.printPQ();
                System.out.println("\nWhat is the ID of the movie you would like to add?");
                System.out.println("Please choose from the above list.");
                int id = s.nextInt();
                customer.getWishList().printWL();
                System.out.println("Where would you like to insert this movie?");
                int location = s.nextInt();
                Movie insertMovie = m.searchID(id);
                //search for movie
                System.out.println(insertMovie);
                customer.getWishList().insertLocation(insertMovie,location);
                customer.getWishList().printWL();
                //customer.setWishList(w);
              }

              else if (choice1 == 6){
                System.out.println("\nThis is recently watched list:");
                r.printStack();
                //customer.setWishList(w);
              }
          }

    			else if (choice == 2){
            //while (choice != 0)
      				System.out.println("\nWelcome Administrator!\n");
      				System.out.println("How may we assist you?");
      				System.out.println("1. See the least rated movie");
      				System.out.println("2. Delete the least rated movie");
      				System.out.println("3. Add new movie");
              System.out.println("4. Back to main menu");

              choice1 = s.nextInt();

      				if (choice1 == 1){
      					//find min in priority queue
                Movie min = a.findMin();
                System.out.println("\nLeast Rated Movie: " + min.getTitle() + " Score: " + min.getScore());
      				}
      				else if (choice1 == 2){
      					//delete min
                Movie deleted = a.findMovieBST();
                customer.getWishList().searchWL(deleted.getId());
                System.out.println("\nThe least rated movie has been deleted.");
                System.out.println("Here is a list of the remaining movies:");
                a.printPQ();
      				}
      				else if (choice1 == 3){
      					//insert function of priotity queue
                System.out.println("\nWhat is the title of the movie you would like to add?");
                String title = s.next();
                System.out.println("What is this movie's release date? Give year month and day. (ex.20160125)");
                int date = s.nextInt();
                System.out.println("What is this movie's ID code? (ex.99999)");
                int id = s.nextInt();
                System.out.println("What is the rotten tomato score? (ex.90)");
                int score = s.nextInt();

                Movie movieName = new Movie(title, date, id, score, true);
                m.insertBST(movieName);
                a.insert(movieName);
                System.out.println("\nHere is the updated movie list:");
                a.printPQ();
      				}

            }

    }

		System.out.println("Thank you for choosing Netflix.\nHave a great day and come again soon.\n");

    menu.saveAdminPQ(a);
    menu.saveMovies(m);
    menu.saveWishList(w);
    menu.saveRecentlyWatched(r);
    menu.saveCustomers(c);


    /*try {
			FileOutputStream fileOut =
			new FileOutputStream("output.txt");
			ObjectOutputStream out=
			new ObjectOutputStream(fileOut);
			out.writeObject(a);
      out.writeObject(m);
      out.writeObject(w);
			out.close();
			fileOut.close();
			System.out.println("serialized object successfully in output.txt");
		} catch(IOException i) {
			i.printStackTrace();
		}
		AdminPQ b = null;
    Movies n = null;
    WishList x = null;*/

}
}
