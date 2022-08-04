package algorithm.tree.binary1;

public class BasicBinary {

//    public void adding(avlNode begin, avlNode adder) {
//        int t = adder.getNum();
//        avlNode temp = begin;
//        if(t< temp.getNum()) {
//            if(temp.getLeftNode()==null) {
//                temp.setLeftNode(adder);
//            }
//            else {
//                temp = temp.getLeftNode();
//                adding(temp,adder);
//            }
//
//        }
//        else {
//            if(temp.getRightNode()==null) {
//                temp.setRightNode(adder);
//            }
//            else {
//                temp = temp.getRightNode();
//                adding(temp, adder);
//            }
//        }
//    }
//
//    public void realshow(avlNode t) {
//
//        if(t.getLeftNode()==null) {
//            System.out.println(t.getNum());
//            if(t.getRightNode()==null) {
//                return;
//            }
//            else {
//                realshow(t.getRightNode());
//            }
//        }
//        else {
//            realshow(t.getLeftNode());
//            System.out.println(t.getNum());
//            if(t.getRightNode()==null) {
//                return;
//            }
//            else {
//                realshow(t.getRightNode());
//            }
//        }
//    }
//    public void inorderTraversal(avlNode head)
//    {
//        if (head != null)
//        {
//            inorderTraversal(head.getLeftNode());
//            System.out.print(head.getNum()+" ");
//            inorderTraversal(head.getRightNode());
//        }
//    }
//    public void middleshow(avlNode t) {
//        System.out.println(t.getNum());
//        if(t.getLeftNode()==null) {
//            if(t.getRightNode()==null) {
//                return;
//            }
//            else {
//                middleshow(t.getRightNode());
//            }
//        }
//        else {
//            middleshow(t.getLeftNode());
//            if(t.getRightNode()==null) {
//                return;
//            }
//            else {
//                middleshow(t.getRightNode());
//            }
//        }
//    }
//
//    public int count(avlNode t) {
//        if(t.getRightNode()==null && t.getLeftNode()==null) {
//            return 1;
//        }
//        else if (t.getLeftNode() != null && t.getRightNode() == null) {
//            return count(t.getLeftNode()) + 1;
//        }
//        else if (t.getLeftNode() == null && t. getRightNode() != null) {
//            return count(t.getRightNode()) +1;
//        }
//        else {
//            return count(t.getRightNode()) + count(t.getLeftNode()) +1;
//        }
//    }
//
//    public int height(avlNode t) {
//        if(t.getRightNode()==null && t.getLeftNode()==null) {
//            return 0;
//        }
//        else if (t.getLeftNode() != null && t.getRightNode() == null) {
//            return height(t.getLeftNode()) + 1;
//        }
//        else if (t.getLeftNode() == null && t. getRightNode() != null) {
//            return height(t.getRightNode()) +1;
//        }
//        else {
//            return (height(t.getLeftNode())>=height(t.getRightNode())) ? height(t.getLeftNode()) +1 : height(t.getRightNode()) + 1;
//        }
//    }
//
//    public void search(avlNode t, int target) {
//        if(t.getNum() == target) {
//            System.out.println("찾았습니다! " + t.getNum());
//        }
//        else if(target>t.getNum()) {
//            if(t.getRightNode() == null) {
//                System.out.println("못찾았습니다");
//                return;
//            }
//            search(t.getRightNode(), target);
//        }
//        else {
//            if(t.getLeftNode() == null) {
//                System.out.println("못찾았습니다");
//                return;
//            }
//            search(t.getLeftNode(), target);
//        }
//    }
//
//    public void delete(avlNode t, int target) {
//    avlNode parentNode = null;
//    avlNode finding = null;
//    avlNode findParent = null;
//        while(t.getNum()!=target) {
//            parentNode = t;
//            if(target<t.getNum()) {
//                t = t.getLeftNode();
//            }
//            else if (target>t.getNum()) {
//                t = t.getRightNode();
//            }
//        }
//        int lr = (target< parentNode.getNum()) ? 0 : 1;
//        //왼쪽에 있으면 0 아니면 1
//        //이제 노드 찾음
//        //1번 노드 두개 다 있을때
//        if(t.getLeftNode()!=null && t.getRightNode()!=null) {
//            finding = t.getLeftNode();
//            findParent = t;
//            while(finding.getRightNode() != null) {
//                findParent = finding;
//                finding = finding.getRightNode();
//            }
//            //대체자가 자식 없을때
//            if(finding.getLeftNode() == null) {
//                findParent.setRightNode(null);
//                if(lr==0) {
//                    parentNode.setLeftNode(finding);
//                }
//                else {
//                    parentNode.setRightNode(finding);
//                }
//                finding.setLeftNode(t.getLeftNode());
//                finding.setRightNode(t.getRightNode());
//                t = null;
//            }
//            //대체자가 자식 있을때
//            else {
//                findParent.setRightNode(finding.getLeftNode());
//                if(lr==0) {
//                    parentNode.setLeftNode(finding);
//                }
//                else {
//                    parentNode.setRightNode(finding);
//                }
//                finding.setLeftNode(t.getLeftNode());
//                finding.setRightNode(t.getRightNode());
//                t = null;
//            }
//        }
//        //2.왼쪽에만 자식 있음
//        else if(t.getLeftNode()!=null && t.getRightNode()==null) {
//            if(lr==0) {
//                parentNode.setLeftNode(t.getLeftNode());
//            }
//            else {
//                parentNode.setRightNode(t.getLeftNode());
//            }
//            t = null;
//        }
//        //3. 오른쪽에만 자식 있음
//        else if(t.getLeftNode()==null && t.getRightNode()!=null) {
//            if(lr==0) {
//                parentNode.setLeftNode(t.getRightNode());
//            }
//            else {
//                parentNode.setRightNode(t.getRightNode());
//            }
//            t = null;
//        }
//        //4. 자식없음
//        else {
//            if(lr==0) {
//                parentNode.setLeftNode(null);
//            }
//            else {
//                parentNode.setRightNode(null);
//            }
//            t = null;
//        }


}

//    public int drawTree(BinaryNode t, int p) {
//        int h = height(t.getLeftNode()) + 1;
//        double bot = Math.pow(2,h+1);
//        int bottom = (int)bot -1;
//        int half = bottom/2;
//        for(int i = 0; i < (half + p); i++) {
//            System.out.print(" ");
//        }
//        System.out.println(t.getNum());
//
//        if(t.getLeftNode()==null) {
//            if(t.getRightNode()==null) {
//                return;
//            }
//            else {
//                middleshow(t.getRightNode());
//            }
//        }
//        else {
//            middleshow(t.getLeftNode());
//            if(t.getRightNode()==null) {
//                return;
//            }
//            else {
//                middleshow(t.getRightNode());
//            }
//        }
//    }

