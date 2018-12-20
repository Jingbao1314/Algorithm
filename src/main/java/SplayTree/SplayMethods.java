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
        }else if (flag<0){
            node.setLift(insert(element,node.getLift()));

        }
        return node;
    }


    private static int compares(int comparator,int comparative){
        return new Integer(comparator).compareTo(comparative);


    }


    public static void find(int element,SplayTree node){


    }

    public static SplayTree splay(SplayTree node,int element){
        if (node.getElement()==element){
            return node;
        }
        if (node.getLift().getRight().getElement()==element){
            node=doubleWithLeft(node);

        }else if (node.getRight().getLift().getElement()==element){
            node=doubleWithRight(node);
        }else if (node.getLift().getLift().getElement()==element){

        }else if (node.getRight().getRight().getElement()==element){

        }else {

        }
        return node;
    }

    private static SplayTree rotateWithLeft(SplayTree node){
        SplayTree temp=node.getLift();
        node.setLift(temp.getRight());
        temp.setRight(node);
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
        return temp;

    }

    private static SplayTree doubleWithRight(SplayTree node){
        node.setRight(rotateWithLeft(node.getRight()));
        return rotateWithRight(node);
    }




}
