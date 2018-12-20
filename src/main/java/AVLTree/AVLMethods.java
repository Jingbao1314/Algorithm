package AVLTree;

/**
 * @author jijngbao
 * @date 18-12-17
 */
public class AVLMethods {
    /* *
     *@describe AVLTree 的添加过程 添加成功后会返回一个新的AVLTree
     */
    public static AVLNode insert(int element,AVLNode node){
        if (node==null){
            return new AVLNode(null,null,element);
        }
        int flag=compares(element,node.getElement());
        if (flag>0){
            node.setRight(insert(element,node.getRight()));
        }else if (flag<0){
            node.setLift(insert(element,node.getLift()));
        }
        return balance(node);
    }


   private static int hight(AVLNode node){
        return node==null?-1:node.getHight();

   }

    public static AVLNode balance(AVLNode node){
        if (node==null){
            return node;
        }
        int limit=1;
        int right_hight=hight(node.getRight());
        int left_hight=hight(node.getLift());
        if ((left_hight-right_hight)>limit){
            if (hight(node.getLift().getLift())>=hight(node.getLift()
                    .getRight())){
                node=rotateWithLeft(node);
            }else {
                node=doubleWithLeft(node);
            }
        }
        if ((right_hight-left_hight)>limit){
            if (hight(node.getRight().getRight())>=hight(node.getRight()
                    .getLift())){
                node=rotateWithRight(node);
            }else {
                node=doubleWithRight(node);


            }

        }
        node.setHight(Math.max(hight(node.getLift()),hight(node.getRight())
                )+1);
        return node;

    }

    private static AVLNode rotateWithLeft(AVLNode node){
        AVLNode temp=node.getLift();
        node.setLift(temp.getRight());
        temp.setRight(node);
        node.setHight(Math.max(hight(node.getLift()),hight(node.getRight()))+1);
        temp.setHight(Math.max(hight(temp.getLift()),node.getHight())+1);
        return temp;

    }

    private static AVLNode doubleWithLeft(AVLNode node){
        node.setLift(rotateWithRight(node.getLift()));
        return rotateWithLeft(node);
    }



    private static AVLNode rotateWithRight(AVLNode node){
        AVLNode temp=node.getRight();
        node.setRight(temp.getLift());
        temp.setLift(node);
        node.setHight(Math.max(hight(node.getLift()),hight(node.getRight()))+1);
        temp.setHight(Math.max(hight(temp.getRight()),node.getHight())+1);
        return temp;

    }

    private static AVLNode doubleWithRight(AVLNode node){
        node.setRight(rotateWithLeft(node.getRight()));
        return rotateWithRight(node);
    }

    public static int compares(int comparator,int comparative){
        return new Integer(comparator).compareTo(comparative);
    }

    public static AVLNode remove(int element,AVLNode node){
        if (node==null){
            return node;
        }
        int flag=compares(element,node.getElement());
        if (flag>0){
            node.setRight(remove(element,node.getRight()));
        }else if (flag<0){
            node.setLift(remove(element,node.getLift()));
        }else if (node.getLift()!=null&&node.getRight()!=null){
            node.setElement(findMin(node.getRight()).getElement());
            node.setRight(remove(node.getElement(),node.getRight()));
        }else {
            node=(node.getLift()!=null)?node.getLift():node.getRight();
        }
        return balance(node);

    }


    public static AVLNode findMin(AVLNode node){
        AVLNode res=null;
        if (node==null){
            return null;
        }
        if (node.getLift()==null){
            return node;
        }else {
            res=findMin(node.getLift());
        }
        return res;

    }


    public static void main(String[] args) {
        AVLNode node=new AVLNode();
        node.setElement(3);
        node=AVLMethods.insert(2,node);
        node=AVLMethods.insert(1,node);
        node=AVLMethods.insert(4,node);
        node=AVLMethods.insert(5,node);
        node=AVLMethods.insert(6,node);
        node=AVLMethods.remove(4,node);
        System.out.println(node.getElement());

    }
}
