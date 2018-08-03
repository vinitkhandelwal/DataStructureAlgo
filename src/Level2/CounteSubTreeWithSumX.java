package Level2;

import Tree.BST;
import Tree.Node;
import Tree.Util;

/**
 * Created by vinit.khandelwal on 1/9/2018.
 */
public class CounteSubTreeWithSumX {

    public static void main(String[] args) {
        BST bst = new BST();
        Util.buildTree(bst);
        int sum = 16;
        int count = 0;

        System.out.println(getCountSubTreeWithSumXUtil(bst.getRoot(),sum));

    }

    public static int getCountSubTreeWithSumX(Node root,int sum,int count){

        if(root == null) return 0;

        int ls = getCountSubTreeWithSumX(root.getLeft(),sum,count);
        int rs = getCountSubTreeWithSumX(root.getRight(),sum,count);

        int x = ls + rs+ (Integer)root.getData();

        if(sum == x){
            count = count+1;
        }
        return x;

    }

    public static int getCountSubTreeWithSumXUtil(Node root,int sum){

        if(root == null) return 0;
        int count = 0;
        int ls = getCountSubTreeWithSumX(root.getLeft(),sum,count);
        int rs = getCountSubTreeWithSumX(root.getRight(),sum,count);

        int x = ls + rs+ (Integer)root.getData();

        if(sum == x){
            count = count+1;
        }
        return count;

    }
}
