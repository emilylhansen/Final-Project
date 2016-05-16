//This program creates the movie node.

//serializes movie node for the database
public class Movie implements java.io.Serializable{

	//instance variables
	private String title; //title of the movie
	private int date; //release date of the movie
	private int id; //id of the movie
	private int score; //rotten tomato score of the movie
  private boolean hold;	//if movie is held in archive
	private Movie next;
	private Movie left;
	private Movie right;


	//constructor takes in the title, release date, id, score, and whether or not the movie is in the database
	public Movie(String title0, int date0, int id0, int score0, boolean hold0){
		title = title0;
    date = date0;
    id = id0;
    score = score0;
    hold = hold0;
	}

	public String getTitle(){ //gets the title of the movie
		return title;
	}

	public int getDate(){ //gets the release date of the movie
		return date;
	}

	public int getId(){ //gets the id of the movie
		return id;
	}

	public int getScore(){ //gets the rotten tomato score of the movie
		return score;
	}

  public boolean getHold(){ //returns whether or not the movie is in the database
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

	public void setTitle(String title0){ //sets the title of the movie
		title = title0;
	}

	public void setDate(int date0){ //sets the release date of the movie
		date = date0;
	}

	public void setId(int id0){ //sets the id of the movie
		id = id0;
	}

	public void setScore(int score0){ //sets the rotten tomato score of the movie
		score = score0;
	}

	public void setHold(boolean hold0){ //sets the true or false for the movie
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
