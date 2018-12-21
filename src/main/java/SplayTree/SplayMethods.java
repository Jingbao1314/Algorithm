package SplayTree;

/**
 * @author jijngbao
 * @date 18-12-20
 */
public class SplayMethods {
    /* *
     *@describe 添加node
     */
    public static SplayTree insert(int element,SplayTree node){
        if (node==null){
            return new SplayTree(element,null,null);
        }
        int flag=compares(element,node.getElement());
        if (flag>0){
            node.setRight(insert(element,node.getRight()));
            node.getRight().setParent(node);
        }else if (flag<0){
            node.setLift(insert(element,node.getLift()));
            node.getLift().setParent(node);
        }
        return node;
    }


    private static int compares(int comparator,int comparative){
        return new Integer(comparator).compareTo(comparative);


    }


    public static SplayTree find(int element,SplayTree node){
        if (node==null){
            return null;
        }
        int flag=compares(element,node.getElement());
        if (flag>0){
            node=find(element,node.getRight());

        }else if (flag<0){
            node=find(element,node.getLift());
        }else {
            node=splay(node);

        }
        return node;


    }
    private static boolean isLift(SplayTree node){
        if (node.getParent().getLift()==node){
            return true;
        }
        return false;

    }
    private static boolean isRight(SplayTree node){
        if (node.getParent().getRight()==node){
            return true;
        }
        return false;

    }
    /* *
     *@describe 一字型旋转 并且node是父亲的左儿子  P96
     */
    private static SplayTree liftOneSplay(SplayTree node){
        SplayTree temp=node.getLift();
        node.setLift(temp.getRight());
        temp.setRight(node);
        node.setParent(temp);
        SplayTree temps=temp.getLift();
        temp.setLift(temps.getRight());
        temps.setRight(temp);
        temp.setParent(temps);
        if (temp.getLift()!=null){
            temp.getLift().setParent(temp);
        }

        if (node.getLift()!=null){
            node.getLift().setParent(node);
        }
        node=temps;
        return node;


    }

    /* *
     *@describe  一字型旋转 并且node是父亲的右儿子
     */
    private static SplayTree rightOneSplay(SplayTree node){
        SplayTree temp=node.getRight();
        node.setRight(temp.getLift());
        temp.setLift(node);
        node.setParent(temp);
        SplayTree temps=temp.getRight();
        temp.setRight(temps.getLift());
        temps.setLift(temp);
        temp.setParent(temps);
        if (temp.getRight()!=null){
            temp.getRight().setParent(temp);
        }

        if (node.getRight()!=null){
            node.getRight().setParent(node);
        }
        return temps;


    }

    private static SplayTree splayTree(SplayTree node){
        if (isLift(node)){
            if (isLift(node.getParent())){
                node=liftOneSplay(node.getParent().getParent());
            }else {
                node=doubleWithLeft(node.getParent().getParent());

            }
        }

        if (isRight(node)){
            if (isRight(node.getParent())){
                node=rightOneSplay(node.getParent().getParent());
            }else {
                node=doubleWithLeft(node.getParent().getParent());
            }
        }
        return node;
    }

    public static SplayTree splay(SplayTree node){
        boolean flag=false;//lift=false  right=true;
        while (node.getParent().getParent().getParent()!=null){
            SplayTree temp=node.getParent().getParent().getParent();
            if (isLift(node.getParent().getParent())){
                flag=false;
            }else {
                flag=true;
            }
            node=splayTree(node);
            if (flag){
                temp.setRight(node);
                node.setParent(temp);
            }else {
                temp.setLift(node);
                node.setParent(temp);
            }


        }
        node=splayTree(node);
        node.setParent(null);

        return node;
    }


    private static SplayTree rotateWithLeft(SplayTree node){
        SplayTree temp=node.getLift();
        node.setLift(temp.getRight());
        temp.setRight(node);
        node.getRight().setParent(node);
        if (node.getRight().getLift()!=null){
            node.getRight().getLift().setParent(node.getRight());
        }
        return temp;

    }

    private static SplayTree doubleWithLeft(SplayTree node){
        node.setLift(rotateWithRight(node.getLift()));
        return rotateWithLeft(node);
    }



    private static SplayTree rotateWithRight(SplayTree node){
        SplayTree temp=node.getRight();
        node.setRight(temp.getLift());
        temp.setLift(node);
        node.getLift().setParent(node);
        if (node.getLift().getRight()!=null){
            node.getLift().getRight().setParent(node.getLift());
        }
        return temp;

    }

    private static SplayTree doubleWithRight(SplayTree node){
        node.setRight(rotateWithLeft(node.getRight()));
        return rotateWithRight(node);
    }

    public static void main(String[] args) {
        SplayTree node=new SplayTree(5,null,null);
        node=insert(4,node);
        node=insert(3,node);
        node=insert(2,node);
        node=insert(1,node);
        node=find(1,node);
        System.out.println(node.getElement());
    }



}
