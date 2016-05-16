//movie node
public class Movie implements java.io.Serializable{

	//instance variables
	private String title;
	private int date;
	private int id; //
	private int score;
  private boolean hold;	//if movie is held in archive
	private Movie next;
	private Movie left;
	private Movie right;


	//constructor
	public Movie(String title0, int date0, int id0, int score0, boolean hold0){
		title = title0;
    date = date0;
    id = id0;
    score = score0;
    hold = hold0;
	}

	public String getTitle(){
		return title;
	}

	public int getDate(){
		return date;
	}

	public int getId(){
		return id;
	}

	public int getScore(){
		return score;
	}

  public boolean getHold(){
    return hold;
  }

	public Movie getLeft(){
		return left;
	}

	public Movie getRight(){
		return right;
	}

	public Movie getNext(){
		return next;
	}

	public void setTitle(String title0){
		title = title0;
	}

	public void setDate(int date0){
		date = date0;
	}

	public void setId(int id0){
		id = id0;
	}

	public void setScore(int score0){
		score = score0;
	}

	public void setHold(boolean hold0){
		hold = hold0;
	}

	public void setLeft(Movie left0){
		left = left0;
	}

	public void setRight(Movie right0){
		 right = right0;
	}

	public void  setNext(Movie next0){
		next = next0;
	}

}
