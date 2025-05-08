public class TreeNode<E> { // e is a variable name (can call "E" whatever we want to) -- e just means Element. Common convention is single letter long and capital. <E> element <T> type <-- common ones
    E value;
    TreeNode<E> left;
    TreeNode<E> right;

    /* make a simple constrcutor */
    public TreeNode(E value, TreeNode<E> left, TreeNode<E> right)
    {
        this.value = value;             // same as value = v
        this.left = left;
        this.right = right;
    }

    /* let's make a 2nd constructor so we dont have to explicitly specify null lefts and right */
    public TreeNode(E value)
    {
        //this.value = value;

        /* if you only pass a value, constructor will assume both left and right are null */
        //this.left = null;
        //this.right = null;

        /* To make a reusable constructor that's even better, you can call the first construtor with "this"*/
        this(value, null, null);
    }

    /* Overloaded constructors: same name, but take different stuff. Java decides how many arguments you're passing to choose which to use */

}