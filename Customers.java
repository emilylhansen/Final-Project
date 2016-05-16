//This program creates the customer archive.
//Each customer has their own archive.

public class Customers implements java.io.Serializable{

  private Customer t;
	private Customer root;

	public Customers() {
    root = null;
		t = null;
	}

  //add new movie to the customer's archive
  public Customer insertBST(Customer p) {
    //set root
		if (t == null){
			t = p;
			root = t;
		}
		else {
			insert2(t, p);
		}
		return t;
	}

	private void insert2(Customer t, Customer p){
		//go left
		if (p.getCard() < t.getCard()){
			if (t.getLeft() == null){
				t.setLeft(p);
			}
			else{
				insert2(t.getLeft(), p);
			}
		}
		//go right
		else {
			if (t.getRight() == null){
				t.setRight(p);
			}
			else {
				insert2(t.getRight(), p);
			}
		}
  }

  public void traverse(){
		if (t != null){
			traverse2(t.getLeft());
			System.out.println(t.getName() + " " + t.getCard());
			traverse2(t.getRight());
		}
	}

	private void traverse2(Customer t){
		if (t != null){
			traverse2(t.getLeft());
			System.out.println(t.getName() + " " + t.getCard());
			traverse2(t.getRight());
		}
	}

  //searches through the customer archive by the credit card of the user
  public Customer searchBST(int card){
    if (t == null){
      return null;
    }
    //key is found
    else if (card == t.getCard()){
      return t;
    }
    //search left for key
    else if (card < t.getCard()){
      return search2(t.getLeft(), card);
    }
    //search right for key
    else {
      return search2(t.getRight(), card);
    }
  }

  private Customer search2(Customer t, int card){
    if (t == null){
      return null;
    }
    //key is found
    else if (card == t.getCard()){
      return t;
    }
    //search left for key
    else if (card < t.getCard()){
      return search2(t.getLeft(), card);
    }
    //search right for key
    else {
      return search2(t.getRight(), card);
    }
  }

  public Customer searchCard(int card){
    if (t == null){
      return null;
    }
    //key is found
    else if (card == t.getCard()){
      return t;
    }
    //search left for key
    else if (card < t.getCard()){
      return searchID2(t.getLeft(), card);
    }
    //search right for key
    else {
      return searchID2(t.getRight(), card);
    }
  }

  private Customer searchID2(Customer t, int card){
    if (t == null){
      return null;
    }
    //key is found
    else if (card == t.getCard()){
      return t;
    }
    //search left for key
    else if (card < t.getCard()){
      return searchID2(t.getLeft(), card);
    }
    //search right for key
    else {
      return searchID2(t.getRight(), card);
    }
  }

  //print all movies
  public void printCustomers(){
		printCustomers2(root);
		System.out.println();
	}

	private void printCustomers2(Customer tree) {
		if (tree != null) {
			System.out.print(tree.getCard() + " ");
			if (tree.getLeft() != null)
				System.out.print("Left: " + tree.getLeft().getCard() + " ");
			else
				System.out.print("Left: null ");
			if (tree.getRight() != null)
				System.out.println("Right: " + tree.getRight().getCard() + " ");
			else
				System.out.println("Right: null ");
			printCustomers2(tree.getLeft());
			printCustomers2(tree.getRight());
		}
	}

  public void deleteBST(Customer p){
    if (isEmptyTree() == false){
      //if root is p, delete
      if (root.getCard() == p.getCard()){
        deleteRoot(p);
      }
      //delete other node in bst
      else {
        delete2(root, p);
      }
    }
  }

  //return parent node of delete node
  private Customer findParent(Customer p){
    Customer temp = root;
    //parent is found
    while (temp.getLeft() != p && temp.getRight() != p){
      //key is less than, go left
      if (p.getCard() < temp.getCard()){
        temp = temp.getLeft();
      }
      //key is greater than, go right
      else{
        temp = temp.getRight();
      }
    }
    return temp;
  }

  //find successor of deleted node
  private void successor( Customer p){

    Customer temp = p;
    Customer temp2 = temp;
    //two children
    if (p.getLeft() != null && p.getRight() !=null){
      //find smallest value on right
      temp = temp.getRight();
      while (temp.getLeft() != null){
        temp = temp.getLeft();
      }
      //check if successor has children
      if (temp.getLeft() == null && temp.getRight() != null){
        //right child-set temp2 to right child
        temp2 = temp.getRight();
      }
      //left child-set temp2 to right child
      else{
        temp2 = temp.getLeft();
      }
      // if successor child is on the left
      if (temp.getLeft() != null){
        //if successor is on the left of parent
        if (findParent(temp).getLeft() == temp){
          //set parent of successor to child of successor
          p.setName(temp.getName());
          p.setCard(temp.getCard());
          p = temp;
          findParent(temp).setLeft(temp2);
        }
        //if successor is on the right of parent
        else {
          p.setName(temp.getName());
          p.setCard(temp.getCard());
          p = temp;
          findParent(temp).setRight(temp2);
        }
      }
      // if successor child is on the right
      else{
        if (findParent(temp).getLeft() == temp){
          p.setName(temp.getName());
          p.setCard(temp.getCard());
          p = temp;
          findParent(temp).setLeft(temp2);
          temp.setRight(null);
        }
        else {
          //copy data
          p.setName(temp.getName());
          p.setCard(temp.getCard());
          p = temp;
          findParent(temp).setRight(temp2);
        }
      }
    }
  }

  private void deleteRoot(Customer p){
    //root has no left subtree
    if (root.getLeft() == null){
      root = root.getRight();
      root.setLeft(root.getLeft());
      root.setRight(root.getRight());
    }
    //root has left node
    else {
      successor(root);
    }
  }

  private void delete2(Customer root, Customer p){
    Customer temp = root;
      //only one child, left/right
      if (p.getLeft() == null || p.getRight() == null){
        if (p.getLeft() == null){
          //successor
          temp = p.getRight();
        }
        else {
          temp = p.getLeft();
        }
        //if deleted node is on the left, set parent to right child
        if (findParent(p).getLeft() == p){
          findParent(p).setLeft(temp);
        }
        //of deleted node is on the right, set parent to left child
        else {
          findParent(p).setRight(temp);
        }
      }
      //no children
      else if (p.getLeft() == null && p.getRight() == null){
        //check if p is left or right of parent
        if (findParent(p).getLeft().getCard() == p.getCard()){
          p.setLeft(null);
        }
        else if (findParent(p).getRight().getCard() == p.getCard()){
          p.setRight(null);
        }
      }
      //two children
      else {
        successor(p);
      }
  }

  public boolean isEmptyTree(){ //returns if the customer's archive is empty or not
    if (t == null){
      return true;
    }
    else{
      return false;
    }
  }
}
