import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Traversal {
  public static void main(String[] args) {
    /* Start with root of tree */
    TreeNode<Integer> root = new TreeNode<>(10, null, null);

    /* To print value in that root */
    //System.out.println(root.value);

    //TreeNode node2 = new TreeNode(15);
    //System.out.println(node2.value);

    root.left = new TreeNode<>(15);
    root.left.left = new TreeNode<>(39);
    root.left.right = new TreeNode<>(21);

    root.right = new TreeNode<>(20);
    root.right.left = new TreeNode<>(72);
    root.right.left.right = new TreeNode<>(42);
    
    //System.out.println(root);             // @372f7a8d
    //System.out.println(root.right.left);  // @372f7a8d

    //System.out.println("--PRE--");
    //preOrder(root);

    //System.out.println("--POST--");
    //postOrder(root);

    //System.out.println("--IN--");
    //inOrder(root);

    /* NEW TREE (DAY 2 OF TREES) with root of tree */
    TreeNode<String> stringRoot = new TreeNode<>("hello", null, null);

    // alt shift
    stringRoot.left = new TreeNode<>("cat");
    stringRoot.left.left = new TreeNode<>("miku");
    stringRoot.left.right = new TreeNode<>("dog");

    stringRoot.right = new TreeNode<>("cyborg");
    stringRoot.right.left = new TreeNode<>("jays");
    stringRoot.right.left.right = new TreeNode<>("robocop");

    //inOrder(stringRoot);
    //greaterThan(root, 12);

    //int result = countNodes(root);
    //System.out.println(result);

    TreeNode<Integer> megaRoot = new TreeNode<>(1);
    TreeNode<Integer> current = megaRoot;
    for(int i = 2; i < 30001; i++)
    {
      //System.out.println(i);
      TreeNode<Integer> node = new TreeNode<>(i);
      current.right = node;
      current = current.right; // could also write: current = node;
    }
    //preOrderIter(megaRoot);
    //preOrder(root);
    //System.out.println("****************");
    //preOrderIter(root);

    //levelOrder(root);

    Set<Integer> set = convertToSet(root);
    System.out.println(set);
  }

  public static int countDistinctValues(TreeNode<?> root)
  {
    Set<?> values = convertToSet(root);
    
    return values.size();
  }

  public static <T> Set<T> convertToSet(TreeNode<T> root)
  {
    Set<T> set = new HashSet<>();

    // Recursively add everything to set

    convertToSetHelper(root, set);
    
    return set;
  }

  public static <T> void convertToSetHelper(TreeNode<T> current, Set<T> set)
  {
    if (current == null) return;

    set.add(current.value);
    convertToSetHelper(current.left, set);
    convertToSetHelper(current.right, set);
  }

  public static void preOrderIter(TreeNode<?> current)
  {
    // i need to make my own stack because java doesnt cut it for me
    // so.. stack = []
    Stack<TreeNode<?>> stack = new Stack<>();
    // stack.push(current)
    stack.push(current);

    // while !stack.empty()
    while (!stack.empty())
    {
      TreeNode<?> node = stack.pop();
      if (node == null) continue;

      System.out.println(node.value);
      stack.push(node.right);
      stack.push(node.left);

      // can also do
      // if (node != null)
      // {
      //   System.out.println(node.value);
      //   stack.push(node.right);
      //   stack.push(node.left);
      // };
    }
    //   node = stack.pop()
    //   if null: continue
    //
    //   otherwise: print node.value
    // then put the children in the stack
    //   stack.push(node.right)
    //   stack.push(node.left)
  }

  public static void levelOrder(TreeNode<?> current)
  {
    Queue<TreeNode<?>> queue = new LinkedList<>();
    queue.add(current);

    while (!queue.isEmpty())
    {
      TreeNode<?> node = queue.poll();
      if (node == null) continue;

      System.out.println(node.value);
      queue.add(node.left);
      queue.add(node.right);
    }
  }

  public static void preOrder(TreeNode<?> current) // ? = whatever you want in there, mystery
  {
    // if null return
    if (current == null) return;

    // cant do this because question mark
    //? heldValue = current.value;

    // write current
    System.out.println(current.value);

    // search left
    preOrder(current.left);

    // search right
    preOrder(current.right);
  }

  public static <T> void postOrder(TreeNode<T> current) // adding <E> before return type (void in this case) says we're going to have a generic method
  {
    if (current == null) return;

    // can do this because added <E> to method name
    //E heldValue = current.value;
    TreeNode<T> duplicate = new TreeNode<>(current.value); // adding something, 

    postOrder(current.left);
    postOrder(current.right);
    System.out.println(current.value);
  }

 public static void inOrder(TreeNode<?> current) // put question mark 
 {
  if (current == null) return;
  inOrder(current.left);
  System.out.println(current.value);
  inOrder(current.right);
 }

 public static void greaterThan(TreeNode<Integer> current, int limit) // if were specifically interested in ints and not comparing something like cats to ints -- put integer
 {                                                         // i dont want any T, it has to be an Integer, we could put String, Person, if we want to specify its something else
    if (current == null) return;
    if (current.value > limit) System.out.println(current.value);

    greaterThan(current.left, limit);
    greaterThan(current.right, limit);
 } // challenge: write a method that has a treenode of people, then checks if person.age is greater than and returns the person?
   // arguments vs parameters

  public static int countNodes(TreeNode<?> current) // if just counting number of nodes, it DOESNT matter what type it is, we want to count nodes regardless of whats being held
  {
    if (current == null) return 0; // step 1: thought of a base case first

    int leftCount = countNodes(current.left);
    int rightCount = countNodes(current.right);

    int totalCount = leftCount + rightCount + 1;
    
    return totalCount;
  }
  // challenge q: write method countLevels
}

// we "refactored" -- code is better made, makes unit tests easy because we can see if anything broke (find bugs), and confidence when doing refactors
