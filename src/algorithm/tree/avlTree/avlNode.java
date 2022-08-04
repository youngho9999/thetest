package algorithm.tree.avlTree;

public class avlNode {

    private int num, height;
    private avlNode left, right, parent;

    public avlNode(int num) {
        this.num = num;
        this.height = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public avlNode getParent() {
        return parent;
    }

    public void setParent(avlNode parent) {
        this.parent = parent;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public avlNode getLeft() {
        return left;
    }

    public void setLeft(avlNode left) {
        this.left = left;
    }

    public avlNode getRight() {
        return right;
    }

    public void setRight(avlNode right) {
        this.right = right;
    }
}
