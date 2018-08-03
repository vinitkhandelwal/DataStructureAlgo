package Tree;

/**
 * Created by vinit.khandelwal on 1/8/2018.
 */
public class BST {

    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BST() {
        this.root = null;
    }

   public void insert(Integer data){
        root = insertKey(root,data);
    }

    Node insertKey(Node root,Integer data){
        if(root == null) {
            root = new Node(data);
            return root;
        }
        else if(root.data.compareTo(data) < 0){
          root.right = insertKey(root.right,data);

        }
        else if(root.data.compareTo(data) > 0){
            root.left = insertKey(root.left,data);

        }
        return root;
    }
}
