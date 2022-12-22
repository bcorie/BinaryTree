package base;

/**
 * @author Corie and Thibault
 */
public class BinaryTree {

    private Node root;

    public BinaryTree(){ root = null; }

    public void add(String word){
        Node node = new Node();
        node.word = word;
        if (root == null) { root = node; }
        else { root.add(node); }
    }

    public String toString() { return root.toString(); }

    class Node{
        public String word;
        public Node left;
        public int right = 1;

        public void add(Node node) {
            // if greater, add to bottom
            if (node.word.compareTo(word) > 0) {
                if (left == null) {
                    left = node;
                } else {
                    left.add(node);
                }
            }
            //if less, insert above
            else if (node.word.compareTo(word) < 0) {
                Node currNode = new Node();
                currNode.word = word;
                currNode.right = right;

                if (left != null) {
                    currNode.left = left;
                }
                word = node.word;
                left = currNode;
                right = node.right;
            }
            //if equal, don't add, just increment count
            else { right += 1; }
        }

        public String toString(){
            if (left == null) { return word + " - " + right; }
            return  word + " - " + right + "\n" + left;
        }
    }
}
