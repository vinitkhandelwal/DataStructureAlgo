package Level2;

import Tree.BST;
import Tree.BTreePrinter;
import Tree.Node;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by vinit.khandelwal on 1/8/2018.
 */






public class GetPairOfGivenSumInBST {

    public static void main(String[] args) {
        BST bst = new BST();
        buildTree(bst);




    }

    /**
     *
     * @param root
     * @param nodeSet
     * @param sum
     * @return
     */


    public static boolean findPairInUtil(Node root, Set<Integer> nodeSet , Integer sum){
        if(root == null){
            return false;
        }

        if(findPairInUtil(root.getLeft(),nodeSet,sum)){
            return true;
        }

        if(nodeSet.contains(sum - (Integer)root.getData())){
            System.out.println("Found pair ");
            return true;
        }

        else{
            nodeSet.add((Integer) root.getData()) ;
        }

        return findPairInUtil(root.getRight(),nodeSet,sum);




    }

    public static void checkPair(Node root,int sum){
        HashSet<Integer> set = new HashSet<>();
        if(!findPairInUtil(root,set,sum)){
            System.out.println("Not found");
        }

    }

    public static void buildTree(BST bst){
        bst.insert(10);
        bst.insert(15);
        bst.insert(16);
        bst.insert(14);
        bst.insert(21);
        bst.insert(20);
        bst.insert(5);
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(8);
        bst.insert(10);
        checkPair(bst.getRoot(),99);
        BTreePrinter.printNode(bst.getRoot());

    }
}




