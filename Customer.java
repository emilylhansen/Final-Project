//This program creates the customer node.
//Our Netflix program handles more than one customer.

//serializes the program
public class Customer implements java.io.Serializable{

	//instance variables
	private String name;
	private int card;
	private String email;
	private Customer next;
	private Customer left;
	private Customer right;
	private WishList wishList;

	//constructor that takes in the name, credict card, email & wishlist of the user
	public Customer(String name0, int card0, String email0, WishList wishList0){
		name = name0;
		card = card0;
		email = email0;
		wishList = wishList0;
	}

	public String getName(){ //gets the name of the user
		return name;
	}

	public int getCard(){ //gets the credit card of the user
		return card;
	}

	public String getEmail(){ //gets the email of the user
		return email;
	}

	public WishList getWishList(){ //gets the user's wishlist
		return wishList;
	}

	public void setName(String name0){ //sets the name of the user
		name = name0;
	}

	public void setCard(int card0){ //sets the credit card number of the user
		card = card0;
	}

	public void setEmail(String email0){ //sets the email of the user
		email = email0;
	}

	public void setWishList(WishList wishList0){ //sets the wishlist of the user
		//each user has their own wishlist
		wishList = wishList0;
	}

	public void setLeft(Customer left0){
		left = left0;
	}

	public void setRight(Customer right0){
		 right = right0;
	}

	public void  setNext(Customer next0){
		next = next0;
	}

	public Customer getLeft(){
		return left;
	}

	public Customer getRight(){
		return right;
	}

	public Customer getNext(){
		return next;
	}
}
