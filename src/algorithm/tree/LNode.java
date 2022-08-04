package algorithm.tree;

public class LNode {
    private int num;
    private LNode prevNode;

    public LNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(LNode nextNode) {
        this.nextNode = nextNode;
    }

    private LNode nextNode;

    public int getNum() {
        return num;
    }
    public void setNum(int k) {
        num = k;
    }

    public LNode getPrevNode() {
        return prevNode;
    }
    public void setPrevNode(LNode prevNode) {
        this.prevNode = prevNode;
    }

}
