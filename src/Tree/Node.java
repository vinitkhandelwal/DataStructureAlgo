package Tree;

/**
 * Created by vinit.khandelwal on 1/8/2018.
 */
public  class  Node<T extends Comparable<?>> {
    T data;
    Node left;
    Node right;

    public Node(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}
