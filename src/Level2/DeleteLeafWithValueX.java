package Level2;

import Tree.BST;
import Tree.BTreePrinter;
import Tree.Node;
import Tree.Util;

/**
 * Created by vinit.khandelwal on 1/9/2018.
 */
public class DeleteLeafWithValueX {

    public static void main(String[] args) {
        BST bst = new BST();
        Util.buildTree(bst);
        deleteLeaf(bst.getRoot(),14);
        BTreePrinter.printNode(bst.getRoot());

    }

    private static Node deleteLeaf(Node root,int x){

        if(root == null) return null;

        root.setLeft(deleteLeaf(root.getLeft(),x));
        root.setRight(deleteLeaf(root.getRight(),x));

        if((Integer)root.getData() == x && root.getLeft() == null && root.getRight() == null){
            return null;
        }
        return root;
    }
}
