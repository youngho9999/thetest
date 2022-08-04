package algorithm.tree;

public class TEST {

    static LinkingList l = new LinkingList();
    public static void main(String[] args) {

        LNode b = l.begin(5);
        LNode temp1 = l.begin(66);
        LNode temp2 = l.begin(1);
        LNode temp3 = l.begin(51);
        LNode temp4 = l.begin(59);
        LNode temp5 = l.begin(2525);
        LNode temp6 = l.begin(12);
        LNode temp7 = l.begin(16);

        l.add(b,temp1);
        l.add(b,temp2);

        l.afterAdd(66,temp3,b);
        l.afterAdd(5,temp4,b);
        l.afterAdd(1,temp5,b);
        l.del(51,b);
        l.del(2525,b);
        l.add(b,temp6);
        l.update(66, 66664, b);
        l.readAll(b);
    }

}
