//This program creates the customer's wishlist.
//Each user has their own wishlist.

//serializes the wishlist for the user
public class WishList implements java.io.Serializable{

	private int n;
	private Movie head;
	private Movie current;

	public WishList() {
		n = 0;
		head = null;
		current = head;
	}

	public int length(){ //function to find the length of the wishlist
		int count = 0;
		Movie temp = head;
		while (temp != null){
			count += 1;
			temp = temp.getNext();
		}
		return count;
	}

	public boolean isEmptyList(){ //boolean to find if the wish list is empty or not
		if (head == null){
			return true;
		}
		else {
			return false;
		}
	}

	public Movie searchWL(int id){ //searches the wishlist for the user
		Movie temp = head;
		while (temp != null){
			if (temp.getId() == id){
				temp.setHold(false);
				System.out.println(temp.getHold());
				return temp;
			}
			else {
				temp = temp.getNext();
			}
		}
		return null;
		}

	public Movie accessNext(){ //access the next movie to be watched for the user
		if (current != null){
			if (current.getHold() == true){
				System.out.println("This is the current movie: " + current.getTitle());
				Movie temp = current;
				current = current.getNext();
				return temp; //returns the current movie for the user
			}
			else{ //the movie is not available
				System.out.println("This movie is not longer available to watch.  Sorry :(");
				Movie temp = current;
				current = current.getNext();
				return temp;
			}
		}
		else{ //the wishlist is empty
			Movie temp = head;
			System.out.println("Your wishlist is empty.");
			return temp; //returns the empty wish list
		}
	}

	public Movie searchRemoveWL(int id){ //removes the movie from the wishlist
		Movie p1 = head;
		Movie p2 = head;

		if (head.getId() == id){ //if the id matches the movie id the user gave
			head = head.getNext();
			n -= 1;
			return head;
		}
		else{ //if the id does not match the movie id the user gave
			while (p1.getNext() != null){
				if (p1.getNext().getId() == id){ //if the id matches the movie id the user gave
					p2 = p2.getNext();
					p1.setNext(p1.getNext().getNext());
					n -= 1;
					return p1;

				}
				else { //if the id does not match the movie id the user gave
					p1 = p1.getNext();
					p2 = p2.getNext();
				}
			}
			return head;
		}
	}

	public void insertWL(Movie x){ //inserts a movie in the wishlist
		Movie temp = head;
		x.setNext(head);
		head = x;
		n +=1;
		current = head;
	}

	public void insertLocation(Movie x, int k){ //puts the movie in the correct location
		Movie temp = head;
		int i = 1;
		if (head == null){ //if the first spot of the wishlist is empty
			head = x;
			x.setNext(null);
			n++;
		}
		if (k == 1){ //if it is the first spot in the wishlist
			head = x;
			x.setNext(temp);
			n++;
		}
		else{
			while (i != (k-1)){ //if it is anywhere else within the wishlist
				temp = temp.getNext();
				i++;
			}
			x.setNext(temp.getNext());
			temp.setNext(x);
			n++;
			current = head;
			}
		}

	public void printWL(){ //prints the wishlist for the user
		int i = 1;
		Movie temp = head;
		System.out.println("Wish List Length: " + n);
		System.out.println("Your wishlist: ");
		for (int count = 0; count < n; count++){
			System.out.println(i + ". " + temp.getTitle() + " ID: " + temp.getId());
			temp = temp.getNext();
			i++;
		}
	}
}
