package Tree;

/**
 * Created by vinit.khandelwal on 1/8/2018.
 */
public class Util {

    public static void buildTree(BST bst){
        bst.insert(10);
        bst.insert(15);
        bst.insert(16);
        bst.insert(14);
//        bst.insert(21);
//        bst.insert(20);
        bst.insert(5);
        bst.insert(7);
        bst.insert(4);
//        bst.insert(9);
//        bst.insert(8);
        bst.insert(10);
        BTreePrinter.printNode(bst.getRoot());

    }
}
