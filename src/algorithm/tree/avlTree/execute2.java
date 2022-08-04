package algorithm.tree.avlTree;

public class execute2 {

    public static avlFunc func = new avlFunc();

    public static void main(String[] args) {

        avlNode a1 = new avlNode(100);
        avlNode a2 = new avlNode(50);
        avlNode a3 = new avlNode(150);
        avlNode a4 = new avlNode(25);
        avlNode a5 = new avlNode(75);
        avlNode a6 = new avlNode(200);
        avlNode a7 = new avlNode(65);
        avlNode a8 = new avlNode(85);
        avlNode a9 = new avlNode(175);
        avlNode a10 = new avlNode(225);
        avlNode a11 = new avlNode(55);
        avlNode a12 = new avlNode(80);
        avlNode a13 = new avlNode(95);
        avlNode a14 = new avlNode(185);
        avlNode a15 = new avlNode(97);



        func.add(a1,a2);
        func.add(a1,a3);
        func.add(a1,a4);
        func.add(a1,a5);
        func.add(a1,a6);
        func.add(a1,a7);
        func.add(a1,a8);
        func.add(a1,a9);
        func.add(a1,a10);
        func.add(a1,a11);
        func.add(a1,a12);
        func.add(a1,a13);
        func.add(a1,a14);
        func.add(a1,a15);

//
//        func.deleteNode(50, a1);
////        System.out.println(func.returnRoot().getNum());
//        func.inorderTraversal(func.returnRoot());
//        System.out.println(func.returnRoot().getNum());
//        func.drawTree(a1);

//        System.out.println(a13.getRight().getNum());
//        System.out.println(a1.getHeight());
////        System.out.println(a2.getHeight());
//        System.out.println(a3.getHeight());
//        System.out.println(a4.getHeight());
//        System.out.println(a5.getHeight());
//        System.out.println(a6.getHeight());

        avlNode n1 = new avlNode(5);
        avlNode n2 = new avlNode(10);
        avlNode n3 = new avlNode(15);
        avlNode n4 = new avlNode(20);


        func.add(n1,n2);
        func.add(n1,n3);
        func.add(n1,n4);
//        func.rightRotation(n1);
        func.leftRotation(n2);
//        func.inorderTraversal(n1);
////
////        System.out.println(n1.getHeight());
////
////        System.out.println(n2.getHeight());
////        System.out.println(n3.getHeight());
//
        func.drawTree(n1);


    }

}
