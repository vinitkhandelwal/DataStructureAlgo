package Level2;

import Tree.BST;
import Tree.BTreePrinter;
import Tree.Node;
import Tree.Util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by vinit.khandelwal on 1/8/2018.
 */
public class CheckFullBinaryTree {

    public static void main(String[] args) {
        BST bst = new BST();
        Util.buildTree(bst);

        if(checkFullBinary(bst.getRoot())){
            System.out.println(" Full Binary tree");
        }
        else{
            System.out.println(" Not a full binary tree");
        }

    }

    public static boolean checkFullBinary(Node root){

        Queue<Node> queue = new LinkedBlockingQueue<>();

        if(root == null) return false;

        queue.add(root);

        while(!queue.isEmpty()){
            if(root.getLeft() == null && root.getRight() == null){
                return true;
            }
            else if(root.getLeft() == null || root.getRight() == null){
                return false;
            }
            queue.add(root.getLeft());
            queue.add(root.getRight());

        }
        return false;



    }



}
