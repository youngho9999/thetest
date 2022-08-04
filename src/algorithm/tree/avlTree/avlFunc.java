package algorithm.tree.avlTree;


import java.util.LinkedList;
import java.util.Queue;

public class avlFunc {

    public static avlNode rootNode;

    public avlNode returnRoot() {
        return rootNode;
    }

    public void add(avlNode begin, avlNode adder) {
        int t = adder.getNum();
        avlNode temp = begin;
        if(t< temp.getNum()) {
            if(temp.getLeft()==null) {
                adder.setParent(temp);
                temp.setLeft(adder);
            }
            else {
                temp = temp.getLeft();
                add(temp,adder);
            }

        }
        else {
            if(temp.getRight()==null) {
                adder.setParent(temp);
                temp.setRight(adder);
            }
            else {
                temp = temp.getRight();
                add(temp, adder);
            }
        }
        refreshHeight(begin);
    }

    public void inorderTraversal(avlNode head)
    {
        if (head != null)
        {
            inorderTraversal(head.getLeft());
            System.out.print(head.getNum()+" ");
            inorderTraversal(head.getRight());
        }
    }

    public int refreshHeight(avlNode t) {
        //자식없으면 height 0
        if (t.getRight() == null && t.getLeft() == null) {
            t.setHeight(1);
            return 1;
        }
        else if (t.getRight() == null) {
            t.setHeight(refreshHeight(t.getLeft()) + 1);
            return refreshHeight(t.getLeft()) + 1;
        }
        else if (t.getLeft() == null) {
            t.setHeight(refreshHeight(t.getRight()) + 1);
            return refreshHeight(t.getRight()) + 1;
        }
        else {
            refreshHeight(t.getLeft());
            refreshHeight(t.getRight());
            int ltemp = t.getLeft().getHeight();
            int rtemp = t.getRight().getHeight();
            int htemp = (ltemp >= rtemp) ? ltemp : rtemp;
            t.setHeight(htemp+1);
            return htemp+1;
        }

    }

    public avlNode findNode(int find, avlNode rt) {

        while (true) {
            if (rt.getNum() == find) {
//                System.out.println("find를 지닌 노드를 찾았습니다!");
                return rt;
            } else if (rt.getNum() < find) {
                rt = rt.getRight();
            } else {
                rt = rt.getLeft();
            }
        }
    }



    public void deleteNode(int del_target, avlNode rt) {
        avlNode del_Node = findNode(del_target, rt);
        //애가 0명
        if(del_Node.getLeft() == null && del_Node.getRight() == null) {
            clearParentalRel(del_Node);
            clearNode(del_Node);
        }
        //오른쪽에만 애있음
        else if(del_Node.getLeft() == null) {
            //root 경우
            if(del_target == rt.getNum()) {
                rootNode = del_Node.getRight();
                del_Node.getRight().setParent(null);
                clearNode(del_Node);

            }
            else if(del_Node.getParent().getNum() < del_target) {
                del_Node.getParent().setRight(del_Node.getRight());
                del_Node.getRight().setParent(del_Node.getParent());
                clearNode(del_Node);

            }
            else if(del_Node.getParent().getNum() > del_target) {
                del_Node.getParent().setLeft(del_Node.getRight());
                del_Node.getRight().setParent(del_Node.getParent());
                clearNode(del_Node);

            }
        }
        //왼쪽에만 애있음
        else if(del_Node.getRight() == null) {
            //root 경우
            if(del_target == rt.getNum()) {
                rootNode = del_Node.getLeft();
                del_Node.getLeft().setParent(null);
                clearNode(del_Node);

            }
            else if(del_Node.getParent().getNum() > del_target) {
                del_Node.getParent().setLeft(del_Node.getLeft());
                del_Node.getLeft().setParent(del_Node.getParent());
                clearNode(del_Node);

            }
            else if(del_Node.getParent().getNum() < del_target) {
                del_Node.getParent().setRight(del_Node.getLeft());
                del_Node.getLeft().setParent(del_Node.getParent());
                clearNode(del_Node);

            }
        }
        //애가 2명
        else {
            //root 경우
            if(del_target == rt.getNum()) {
                avlNode replacement = findReplacement(del_Node);
                //대체자가 바로 삭제하려는거 바로 아래임
                if(replacement.getParent() == del_Node) {
                    replacement.setLeft(del_Node.getLeft());
                    del_Node.getLeft().setParent(replacement);
                    rootNode = replacement;
                    clearNode(del_Node);

                }
                //바로 아래 아님
                else {
                    //대체자가 애1명 있을때
                    if(replacement.getRight() != null) {
                        replacement.getParent().setLeft(replacement.getRight());
                        replacement.getRight().setParent(replacement.getParent());
                        replacement.setLeft(del_Node.getLeft());
                        replacement.setRight(del_Node.getRight());
                        replacement.getLeft().setParent(replacement);
                        replacement.getRight().setParent(replacement);
                        rootNode = replacement;
                        clearNode(del_Node);

                    }
                    //대체자가 애 없을때
                    else {
                        replacement.setLeft(del_Node.getLeft());
                        replacement.setRight(del_Node.getRight());
                        replacement.getLeft().setParent(replacement);
                        replacement.getRight().setParent(replacement);
                        rootNode = replacement;
                        clearNode(del_Node);

                    }
                }
            }
            else {
                //root 아닌 일반 경우
                avlNode replacement = findReplacement(del_Node);
                //대체자가 바로 아래인 경우
                if (replacement.getParent() == del_Node) {
                    //그중 애가 있을때
                    if (replacement.getRight() != null) {
                        //그중 del_Node 가 parent 오른쪽
                        if (del_target > del_Node.getParent().getNum()) {
                            del_Node.getParent().setRight(replacement);
                            replacement.setParent(del_Node.getParent());
                            replacement.setLeft(del_Node.getLeft());
                            del_Node.getLeft().setParent(replacement);
                            clearNode(del_Node);

                        }
                        //del_Node가 parent 왼쪽
                        else {
                            del_Node.getParent().setLeft(replacement);
                            replacement.setParent(del_Node.getParent());
                            replacement.setLeft(del_Node.getLeft());
                            del_Node.getLeft().setParent(replacement);
                            clearNode(del_Node);

                        }
                    }
                    //그중 애가 없을때
                    else {
                        //del_Node 가 부모보다 클때
                        if (del_target > del_Node.getParent().getNum()) {
                            del_Node.getParent().setRight(replacement);
                            replacement.setParent(del_Node.getParent());
                            replacement.setLeft(del_Node.getLeft());
                            del_Node.getLeft().setParent(replacement);
                            clearNode(del_Node);

                        } else {
                            del_Node.getParent().setLeft(replacement);
                            replacement.setParent(del_Node.getParent());
                            replacement.setLeft(del_Node.getLeft());
                            del_Node.getLeft().setParent(replacement);
                            clearNode(del_Node);

                        }
                    }
                }
                //대체자가 바로 아래아님
                else {
                    //그중 애가 있을때
                    if (replacement.getRight() != null) {
                        //그중 del_node 가 부모보다 클때
                        if (del_target > del_Node.getParent().getNum()) {
                            replacement.getParent().setLeft(replacement.getRight());
                            replacement.getRight().setParent(replacement.getParent());
                            del_Node.getParent().setRight(replacement);
                            replacement.setParent(del_Node.getParent());
                            replacement.setLeft(del_Node.getLeft());
                            del_Node.getLeft().setParent(replacement);
                            replacement.setRight(del_Node.getRight());
                            del_Node.getRight().setParent(replacement);
                            clearNode(del_Node);

                        }
                        //그 중 del_node가 부모보다 작을때
                        else {
                            replacement.getParent().setLeft(replacement.getRight());
                            replacement.getRight().setParent(replacement.getParent());
                            del_Node.getParent().setLeft(replacement);
                            replacement.setParent(del_Node.getParent());
                            replacement.setLeft(del_Node.getLeft());
                            del_Node.getLeft().setParent(replacement);
                            replacement.setRight(del_Node.getRight());
                            del_Node.getRight().setParent(replacement);
                            clearNode(del_Node);

                        }
                    }
                    //그 중 애가 없을때
                    else {
                        //그중 del_node 가 부모보다 클때
                        if (del_target > del_Node.getParent().getNum()) {
                            clearParentalRel(replacement);
                            del_Node.getParent().setRight(replacement);
                            replacement.setParent(del_Node.getParent());
                            replacement.setLeft(del_Node.getLeft());
                            del_Node.getLeft().setParent(replacement);
                            replacement.setRight(del_Node.getRight());
                            del_Node.getRight().setParent(replacement);
                            clearNode(del_Node);
                        }
                        //그 중 del_node가 부모보다 작을때
                        else {
                            clearParentalRel(replacement);
                            del_Node.getParent().setLeft(replacement);
                            replacement.setParent(del_Node.getParent());
                            replacement.setLeft(del_Node.getLeft());
                            del_Node.getLeft().setParent(replacement);
                            replacement.setRight(del_Node.getRight());
                            del_Node.getRight().setParent(replacement);
                            clearNode(del_Node);
                        }
                    }
                }
            }
        }
        refreshHeight(returnRoot());
    }

    public avlNode findReplacement(avlNode del) {
        avlNode temp = del.getRight();
        while(temp.getLeft() != null)
            temp = temp.getLeft();
        return temp;
    }

    public void clearNode(avlNode a) {
        a.setParent(null);
        a.setLeft(null);
        a.setRight(null);
        a.setHeight(0);
        a.setNum(0);
        a = null;
    }

    public void clearParentalRel(avlNode del) {
        if (del.getNum() > del.getParent().getNum()) {
            del.getParent().setRight(null);
        }
        else if (del.getNum() < del.getParent().getNum()) {
            del.getParent().setLeft(null);
        }
    }

    /**
     *  old node의 parent 는 따로 반드시 설정해야함.
     */
    public void setParentalRel(avlNode old, avlNode newb) {
        if (old.getNum() > old.getParent().getNum()) {
            old.getParent().setRight(newb);
        }
        else if (old.getNum() < old.getParent().getNum()) {
            old.getParent().setLeft(newb);
        }
        newb.setParent(old.getParent());
        old.setParent(null);
    }

    public int spaceForHeight(int h) {
        if(h == 1) {
            return 1;
        }
        return spaceForHeight(h-1)*2 + 1;
    }

    public void drawCurrentNode(avlNode now, int space) {
        for(int i = 0; i< space; i++) {
            System.out.print(" ");
        }
        System.out.print(now.getNum());
    }

    public void drawTree(avlNode node) {
        int space = spaceForHeight(node.getHeight()-1);
        Queue<forTree> q = new LinkedList<>();
        forTree first = new forTree(node, space);
        q.add(first);

        while(!q.isEmpty()) {
            int tempq = q.size();
            int currentCursor = 0;
            for(int j = 0; j < tempq; j++) {
                forTree temp = q.poll();

                drawCurrentNode(temp.avlNode, temp.treeSpace-currentCursor);
                int underSpace = (int) Math.pow(2, temp.avlNode.getHeight() - 2);
                if (temp.avlNode.getLeft() != null) {
                    forTree a = new forTree(temp.avlNode.getLeft(), temp.treeSpace - underSpace);
                    q.add(a);
                }
                if (temp.avlNode.getRight() != null) {
                    forTree b = new forTree(temp.avlNode.getRight(), temp.treeSpace + underSpace);
                    q.add(b);
                }
                currentCursor = temp.treeSpace;
            }
            System.out.print("\n");
            System.out.print("\n");
            System.out.print("\r");
        }
    }

    public void rightRotation(avlNode topNode) {
        avlNode firstLeft = topNode.getLeft();
        if(topNode != rootNode) {
            setParentalRel(topNode, firstLeft);
        }
        else {
            rootNode = firstLeft;
            firstLeft.setParent(null);
        }
        topNode.setParent(firstLeft);
        if(firstLeft.getRight() != null) {
            firstLeft.getRight().setParent(topNode);
            topNode.setLeft(firstLeft.getRight());
        }
        else {
            topNode.setLeft(null);
        }
        firstLeft.setRight(topNode);
    }

    public void leftRotation(avlNode topNode) {
        avlNode firstRight = topNode.getRight();
        if(topNode != rootNode) {
            setParentalRel(topNode, firstRight);
        }
        else {
            rootNode = firstRight;
            firstRight.setParent(null);
        }
        topNode.setParent(firstRight);
        if(firstRight.getLeft() != null) {
            firstRight.getLeft().setParent(topNode);
            topNode.setRight(firstRight.getLeft());
        }
        else {
            topNode.setRight(null);
        }
        firstRight.setLeft(topNode);
    }

    static class forTree {
        avlNode avlNode;
        int treeSpace;

        public forTree(algorithm.tree.avlTree.avlNode avlNode, int treeSpace) {
            this.avlNode = avlNode;
            this.treeSpace = treeSpace;
        }
    }
}
