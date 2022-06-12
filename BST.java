import java.util.*;
  
public class BST{
  BinaryNode root;

  public BST(){
    this.root = null;    ///O(1),  SPACE O(1);
  }


//Insert method
private BinaryNode insert(BinaryNode currentNode, int value){
  if(currentNode == null){    ///O(1)
    BinaryNode newNode = new BinaryNode();   ///O(1)
    newNode.value = value;    ///O(1)
    System.out.println("The value was successfully inserted!");  ///O(1)
    return newNode;
     }else if(value <= currentNode.value){
    currentNode.left = insert(currentNode.left, value); //O(N/2)   }-->O(LogN)
    return currentNode;                                     //Space O(LogN), either 
     // for left subtree or right subtree, that is why it is LogN
    }else{
    currentNode.right = insert(currentNode.right, value);//O(N/2)
    return currentNode;
  }
  
}
  void insert(int value){
    root = insert(root, value);
  }

//PreOrder Traversal
  public void preOrder(BinaryNode node){
    if(node == null){
      return;
    }
    System.out.print(node.value+ " ");   ////O(N) both time and space
    preOrder(node.left);
    preOrder(node.right);
    }
  
  
  //inOrder traversal
  public void inOrder(BinaryNode node){
     if(node == null){
      return;
    } //O(N) both time and space
    inOrder(node.left);
    System.out.print(node.value+ " ");   
    inOrder(node.right);
    }

    //postOrder traversal
  public void postOrder(BinaryNode node){
     if(node == null){
      return;
    } //O(N) both time and space
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value+ " ");  
    }

  //levelOrder traversal
  void levelOrder(){
    Queue <BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryNode presentNode = queue.remove();
      System.out.print(presentNode.value +" ");
      if(presentNode.left != null){
        queue.add(presentNode.left);
      } //O(N) both time and space, queue in the memory and inqueuing and for time it is because we are passing on N elements
      if(presentNode.right!=null){
        queue.add(presentNode.right);
      }
    }
  }

  //search method

  BinaryNode search(BinaryNode node, int value){
    if(node == null){
      System.out.print("Value: "+value+" not found in the Binary Search Tree");
      return null;
    }else if(node.value == value){
       System.out.print("Value: "+value+" found in the Binary Search Tree");   //////////}----> O(LogN), space and time
      }else if(value < node.value){
      return search(node.left, value); //O(N/2)
    }else{
      return search(node.right, value); //O(N/2)
    }
    return null;
  }


  public static BinaryNode findMinimum(BinaryNode root){
    if(root.left == null){
      return root;
    }else{
      return findMinimum(root.left);
    }
  }

  public BinaryNode deleteNode(BinaryNode root, int value){
    if(root == null){
      System.out.println("Value not found in the Binary Search Tree"); //O(1)
      return null;
      } 
    if(value<root.value){  
      root.left = deleteNode(root.left, value);  //O(N/2)
    }else if(value>root.value){
      root.right = deleteNode(root.right, value);  //O(N/2)
    }else{
      if(root.left !=null && root.right!=null){   //O(1)
        BinaryNode temp = root;  //O(1)
        BinaryNode minNode = findMinimum(temp.right); //O(LogN)               }-->O(LogN), time and space
        root.value = minNode.value;
        root.right = deleteNode(root.right, minNode.value); //O(N/2)
      }else if(root.left != null){
        root = root.left;
      }else if(root.right!=null){
        root = root.right; //O(1)
      }else{
        root = null; 
    }
   
    
  }
     return root;
    
    
  
  
}
  public void deleteBST(){
    root = null; /////////////////O(1), time and space; 
    System.out.println("Binary Search Tree is successfully deleted!");
  }
}