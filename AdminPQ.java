//import Movies;

public class AdminPQ implements java.io.Serializable{

	private int n;
	private Movie s [];
	private Movies o;

	public AdminPQ() {
		n = 0;
		s = new Movie [255];
	}

	//return root
	public Movie findMin(){
		return s[0];
	}

	public void setMovie(Movies x){
		o = x;
	}

	public Movie findMovieBST(){
		Movie min = findMin();
		min.setHold(false);
		Movie minDate = o.searchBST(min.getDate());
		minDate.setHold(false);
		min.setNext(minDate);
		o.deleteBST(minDate);
		deleteMin();
		return min;
		//System.out.println("hello");
		//Movies.printMovies();
	}

	public void insert(Movie x){
		if (n==255){
			System.out.println("Cannot add movie due to lack of space.");
		}
		s[n] = x;
		n ++;
		int i = n;
		//swap node while less than parent
		while (s[i-1].getScore() < s[findParent(i-1)].getScore()){
			i = swap(i-1, findParent(i-1));
		}

	}

	public Movie deleteMin(){
		int i = 0;
		n --;
		i = swap(i, n);
		//check if greater than children
		while (s[i].getScore() > s[2*i+1].getScore() || s[i].getScore() > s[2*i+2].getScore()){

			if (s[2*i+1] != null || s[2*i+2] != null ){
				//check which child is smaller
				if (s[2*i+1].getScore() < s[2*i+2].getScore()){
					//swap left child
					i = swap(i, 2*i+1);
				}
				else {
					//swap right child
					i = swap(i, 2*i+2);
				}
			}
		}
		//findMovieBST(s[n]);
		//deleteBST(s[n].getDate());
		return s[n];
	}

	//check if empty
	public boolean isEmptySet(){
		if (n == 0){
			return true;
		}
		else{
			return false;
		}
	}

	//swap position of two nodes, return new position of swapped node
	private int swap(int one, int two){
		Movie temp = s[one];
		s[one] = s[two];
		s[two] = temp;
		return one;
	}

	//find parent of node
	private int findParent(int x){
		int parent = (n-1)/2;
		return parent;
	}

	    //creates print method             
    public void printPQ() {                                                              
        
        //for item in heap
        for ( int i = 0; i < n; i++) {                                                
        
            //if i is not null
            if (s[i] != null) {                                                                                                            
        
            //prints the location of i
            System.out.print("Movie: " + s[i].getTitle() + " ID: " + s[i].getId() + "\n"); 

            }                                                
        
        //otherwise...
        else {                                
        
            //prints null if necessary
            System.out.print("null");                                                                                                      
            }                
        }                                
        
        //prints line
        System.out.println();                        
    } 
}
