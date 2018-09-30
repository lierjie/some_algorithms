/**
  *
  * Binary Search Tree implementation.
  * By liweijie 20180929
  *
  **/
  
  import java.util.*;
  
  public class BSTree<T extends Comparable<T>> {
	  BSTNode<T> mRoot;
	  
	  public BSTree() {
		  mRoot = null;
	  }
	  
	  /**
	    *  preOrder Traversal.
	    **/
	  private void preOrder(BSTNode<T> tree) {
		  if (tree != null) {
			  System.out.println(tree.key + " ");
		      preOrder(tree.left);
		      preOrder(tree.right);
		  }
	  }
	  public void preOrder() {
		  preOrder(mRoot);
	  }
	  
	  /**
	    *  inOrder Traversal.
	    **/
	  private void inOrder(BSTNode<T> tree) {
		  if (tree != null) {
			  inOrder(tree.left);
			  System.out.println(tree.key + " ")；
			  inOrder(tree.right);
		  }
	  }
	  public void inOrder() {
		  inOrder(mRoot);
	  }
	  
	  /**
	    *  postOrder Traversal.
	    **/
	  private void postOrder(BSTNode<T> tree) {
		  if (tree != null) {
			  postOrder(tree.left);
			  postOrder(tree.right);
			  System.out.println(tree.key + " ")；
		  }
	  }
	  public void postOrder() {
		  postOrder(mRoot);
	  }
	  
	  	  /**
	    *  levelOrder Traversal.
	    **/
	  private List<List<T>> levelOrder(BSTNode<T> tree) {
		  List<List<T>> result = new ArrayList<>();
		  Queue<BSTNode> treeNode = new LinkedList<>();
		  if (tree == null)
			  return result;
		  else {
			  List<T> temp = new ArrayList<>();
			  temp.add(tree.key);
			  treeNode.offer(tree);
			  result.add(temp);
		  }
		  while (!treeNode.isEmpty()) {
			  int i = treeNode.size();
			  List<T> tempResult = new ArrayList<>();
			  while (i > 0) {
				  BSTNode<T> tNode = treeNode.poll();
				  if (tNode.left != null) {
					  tempResult.add(tNode.left.val);
					  treeNode.offer(tNode.left);
				  }
				  if (tNode.right != null) {
					  tempResult.add(tNode.right.val);
					  treeNode.offer(tNode.right);
				  }
				  i--;
			  }
			  if (!tempResult.isEmpty())
				  result.add(tempResult);
		  }
		  return result;	  
	  }
	  public List<List<T>> levelOrder() {
		  return levelOrder(mRoot);
	  }



	  /**
	    *  search(recursion)
	    **/
	  private BSTNode<T> searchRecursion(BSTNode<T> node, T key) {
		  if (node != null) {
		      int cmp = key.compareTo(node.key);
		      if (cmp == -1)
			      return search(node.left, key);
		      else if (cmp == 1)
			      return search(node.right, key);
		      else
			      return node;
		  }
		  return node;
	  }
      public BSTNode<T> searchRecursion(T key) {
		  return search(mRoot, key);
	  }

	  /**
	    *  search
	    **/
	  private BSTNode<T> search(BSTNode<T> node, T key) {
		  while (node != null) {
			  int cmp = key.compareTo(node.key);
			  if (cmp == -1)
				  node = node.left;
			  else if (cmp == 1)
				  node = node.right;
			  else
				  return node;
		  }
		  return node;
	  }
	  public BSTNode<T> search(T key) {
		  return searchRecursion(mRoot, key);
	  }

	  /**
	    * maxmium
		*
		**/
	  private BSTNode<T> maximum(BSTNode<T> node) {
		  if (node == null)
			  return null;
		  while (node.right != null)
			  node = node.right;
		  return node;
	  }
	  public T maximum() {
		  BSTNode<T> res = maximum(mRoot);
		  if (res != null) {
			  return res.key;
		  }
		  return null
	  }



      /**
	    * minimum
		*
		**/
	  private BSTNode<T> minimum(BSTNode<T> node) {
		  if (node == null)
			  return null;
		  while (node.left != null)
			  node = node.left;
		  return node;
	  }
	  public T minimum() {
		  BSTNode<T> res = minimum(mRoot);
		  if (res != null) {
			  return res.key;
		  }
		  return null
	  }
     
	  /**
	    * predecessor
		**/
	  
	  public BSTNode<T> predecessor(BSTNode<T> node) {
		  if (node == null)
			  return null;
		  if (node.left != null) 
			  return maximum(node.left);
		  BSTNode<T> y = node.parent;
		  while (y != null && node == y.left) {
			  node = y;
			  y = y.parent;
		  }
		  return y;
	  }

	  /**
	    * successor
		**/
	  public BSTNode<T> successor(BSTNode<T> node) {
		  if (node == null)
			  return null;
		  if (node.right != null)
			  return minimum(node.right)
		  BSTNode<T> y = node.parent;
		  while (y != null && node == y.right) {
			  node = y;
			  y = y.parent;  
		  }
		  return y;
	  }



      /**
	    * insert
		**/

      private void insert(BSTree<T> tree, BSTNode<T> node) {
		  BSTNode<T> y = null;
		  BSTNode<T> x = tree.mRoot;

		  while (x != null) {
			  y = x;
			  int cmp = node.key.compareTo(x.key);
			  if (cmp == -1)
				  x = x.left;
			  else
				  x = x.right;
		  }

		  node.parent = y;
		  if (y == null)
			  tree.mRoot = node;
		  else {
			  int cmp = node.key.compareTo(y.key);
			  if (cmp == -1)
				  y.left = node;
			  else
				  y.right = node;
		  }
	  }
      public void insert(T key) {
		  BSTNode<T> node = new BSTNode<>(key, null, null, null);
		  insert(this, node);
	  }



	  /**
	    * delete
		**/
      priate BSTNode<T> delete(BSTree<T> tree, BSTNode<T> node) {
		  if (node.left != null && node.right != null) {
			  BSTNode<T> successor = successor(node);
			  node.key = successor.key;
			  node = successor;
		  }
		  BSTNode<T> child;
		  if (node.left != null)
			  child = node.left;
		  else 
			  child = node.right;
		  if (child != null)
			  child.parent = node.parent;
		  if (node.parent == null)
			  tree.mRoot = child;
		  else if (node == node.parent.left)
			  node.parent.left = child;
		  else
			  node.parent.right = child;
		  return node;
	  }

	  public void delete(T key) {
		  BSTNode<T> node = search(mRoot, key);
		  if (node != null)
			  delete(this, node);
	  }

      private void print(BSTNode<T> tree, T key, int direction) {
		  if(tree != null) {
			  if(direction==0)    // tree是根节点
                  System.out.printf("%2d is root\n", tree.key);
              else                // tree是分支节点
                  System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");
			  print(tree.left, tree.key, -1);
              print(tree.right,tree.key,  1);
          }
      }

      public void print() {
          if (mRoot != null)
              print(mRoot, mRoot.key, 0);
      }



	  private void destroy(BSTNode<T> tree) {
          if (tree==null)
              return ;
          if (tree.left != null)
              destroy(tree.left);
          if (tree.right != null)
              destroy(tree.right);
          tree=null;
      }

      public void clear() {
          destroy(mRoot);
          mRoot = null;
      }

	
  }
  
  
/**
  * Binary search tree node. 
  **/  
  class BSTNode<T extends Comparable<T>> {
	  T key;
	  BSTNode<T> left;
	  BSTNode<T> right;
	  BSTNode<T> parent;
	  
	  public BSTNode(T key, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
		  this.key = key;
		  this.left = left;
		  this.right = right;
		  this.parent = parent;
	  }
	  
	  public void setKey(T key) {
		  this.key = key;
	  }
	  
	  public T getKet() {
		  return key;
	  }
	  
	  public String toString() {
		  return "key: " + key; 
	  }
	  
  }