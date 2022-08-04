package algorithm.tree;

public class LinkingList {

    public LNode sc(int find, LNode first) {
        LNode temp = first;
        while(temp.getNextNode() != null) {
            if(temp.getNum() == find) {
                return temp;
            }
            else {
                temp = temp.getNextNode();
            }
        }
        if(temp.getNum() == find)
            return temp;
        else
            return null;
    }

    public void afterAdd(int tar, LNode t1, LNode first) {
        LNode theT = sc(tar, first);

        if(theT.getNextNode() == null) {
            theT.setNextNode(t1);
            t1.setPrevNode(theT);
        }
        else {
            LNode nextTemp = theT.getNextNode();
            t1.setNextNode(theT.getNextNode());
            t1.setPrevNode(theT);
            theT.setNextNode(t1);
            nextTemp.setPrevNode(t1);
        }
    }

    public LNode begin(int tar) {
        LNode newone = new LNode();
        newone.setNum(tar);
        return newone;
    }

    public void readAll(LNode first) {
        LNode temp = first;
        while(true) {
            System.out.print(temp.getNum() + "  =>  ");
            temp = temp.getNextNode();
            if(temp.getNextNode()==null) {
                break;
            }
        }
        System.out.println(temp.getNum());
        System.out.println("===================");
        while(true) {
            System.out.print(temp.getNum() + "  =>  ");
            temp = temp.getPrevNode();
            if(temp.getPrevNode()==null) {
                break;
            }
        }
        System.out.println(temp.getNum());
    }

    public void add(LNode first, LNode adder) {
        LNode temp = first;
        while(temp.getNextNode()!=null) {
            temp = temp.getNextNode();
        }
        temp.setNextNode(adder);
        adder.setPrevNode(temp);
    }

    public void del(int target, LNode first) {
        LNode theT = sc(target, first);
        if(theT.getNextNode() == null) {
            theT.getPrevNode().setNextNode(null);
            theT = null;
        }
        else {
            theT.getPrevNode().setNextNode(theT.getNextNode());
            theT.getNextNode().setPrevNode(theT.getPrevNode());
            theT = null;
        }
    }

    public void update(int num1, int num2, LNode first) {
        LNode temp = sc(num1,first);
        temp.setNum(num2);
    }

}
