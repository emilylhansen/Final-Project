//customer wishList

public class WishList implements java.io.Serializable{

	private int n;
	private Movie head;
	private Movie current;

	public WishList() {
		n = 0;
		head = null;
		current = head;
	}

	public int length(){
		int count = 0;
		Movie temp = head;
		while (temp != null){
			count += 1;
			temp = temp.getNext();
		}
		return count;
	}

	public boolean isEmptyList(){
		if (head == null){
			return true;
		}
		else {
			return false;
		}
	}

	public Movie searchWL(int id){
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

	public Movie accessNext(){
		//System.out.println(head);
		//System.out.println(current);
		if (current != null){
		//System.out.println("This is your current movie: " + current.getTitle());
			if (current.getHold() == true){
			
				System.out.println("This is the current movie: " + current.getTitle());
				Movie temp = current;
				current = current.getNext();
			/*if (current == null){
				current = head;
			}*/
				return temp;
				
			}
			else{
				System.out.println("This movie is not longer available to watch.  Sorry :(");
				Movie temp = current;
				current = current.getNext();
				return temp;
			}

		}
		else{
			Movie temp = head;
			System.out.println("Your wishlist is empty.");
			return temp;
		}
			
	}

	public Movie searchRemoveWL(int id){
		Movie p1 = head;
		Movie p2 = head;

		if (head.getId() == id){
			head = head.getNext();
			n -= 1;
			return head;
		}
		else{
			while (p1.getNext() != null){
				if (p1.getNext().getId() == id){
					p2 = p2.getNext();
					p1.setNext(p1.getNext().getNext());
					n -= 1;
					return p1;

				}
				else {
					p1 = p1.getNext();
					p2 = p2.getNext();
				}
			}
			return head;
		}
	}

	public void insertWL(Movie x){
		Movie temp = head;
		x.setNext(head);
		head = x;
		n +=1;
		current = head;
	}

	public void insertLocation(Movie x, int k){
		Movie temp = head;
		int i = 1;
		if (head == null){
			head = x;
			x.setNext(null);
			n++;
		}
		if (k == 1){
			head = x;
			x.setNext(temp);
			n++;
		}
		else{
			while (i != (k-1)){
				temp = temp.getNext();
				i++;
			}
			x.setNext(temp.getNext());
			temp.setNext(x);
			n++;
			current = head;
			}
		}

	public void printWL(){
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
