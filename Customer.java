//customer node
public class Customer implements java.io.Serializable{

	//instance variables
	private String name;
	private int card;
	private String email;
	private Customer next;
	private Customer left;
	private Customer right;
	private WishList wishList;

	//constructor
	public Customer(String name0, int card0, String email0, WishList wishList0){
		name = name0;
		card = card0;
		email = email0;
		wishList = wishList0;
	}

	public String getName(){
		return name;
	}

	public int getCard(){
		return card;
	}

	public String getEmail(){
		return email;
	}

	public WishList getWishList(){
		return wishList;
	}

	public void setName(String name0){
		name = name0;
	}

	public void setCard(int card0){
		card = card0;
	}

	public void setEmail(String email0){
		email = email0;
	}

	public void setWishList(WishList wishList0){
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
