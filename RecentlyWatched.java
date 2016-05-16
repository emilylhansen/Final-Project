//This program creates stack array class for the recently watched movie

//serializes recently watched list for the user
public class RecentlyWatched implements java.io.Serializable{

	//creates required instances variable
	private int n;
	private Movie[] s;

	//creates function to define array
	public RecentlyWatched(){
		//sets counter to 0
		n = 0;
		//defines the array maximum to 100
		s = new Movie[100];
	}

	//creates function to return the top of stack
	public Movie top(){
		//if the array is empty...
		if (n==0){
			//returns null
			return null;
		}
		//otherwise...
		else{
			//returns the last element in the array
			return s[n-1];
		}
	}

	//creates function to remove node
	public Movie pop(){
		//decreases n by 1
		n--;
		//returns n
		return s[n];
	}

	//creates function to add node to array
	public void push(Movie x){
		//places the new node in the next available space in array
		s[n] = x;
		//increases n by 1
		n++;
	}

	//creates function to test if the array if empty
	public boolean isEmpty(){
		//returns true if n is 0
		return n==0;
	}

	//printStack method for StackA
  public void printStack() {
    //prints the number items in the array
    //for each item in the array...
		for(int i = n-1; i >= 0; i--) {
		//prints the key of the node
			System.out.println("Movie: " + s[i].getTitle());
    }
  }
}
