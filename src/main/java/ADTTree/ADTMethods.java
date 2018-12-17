package ADTTree;

/**
 * @author jijngbao
 * @date 18-12-17
 */
public class ADTMethods {
    /* *
     *@describe 添加NODE
     */
    public static void insert(int element,ADTNode node){
        contains(element,node);
    }


    /* *
     *@describe 删除NODE
     */
    public static boolean remove(int element,ADTNode node){
        boolean res=false;
        if (node==null){
            return res;
        }
        int flag=compares(element,node.getElement());
        if (flag>0){
            res=remove(element,node.getRight());

        }else if (flag<0){
            res=remove(element,node.getLift());
        }else {
            ADTNode rigtht=node.getRight();
            ADTNode left=node.getLift();
            if (rigtht!=null){
                ADTNode min=findMin(rigtht);
                remove(min.getElement(),rigtht);
                node.setElement(min.getElement());

            }else {
                if (left==null){
                    node=null;
                }else {
                    ADTNode max=findMax(left);
                    remove(max.getElement(),left);
                    node.setElement(max.getElement());
                }


            }
            res=true;
        }
        return res;



    }


    /* *
     *@describe 获得最小值
     */
    public static ADTNode findMin(ADTNode node){
        ADTNode res=null;
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

    /* *
     *@describe 获得最大值
     */
    public static ADTNode findMax(ADTNode node){
        ADTNode res=null;
        if (node==null){
            return null;
        }
        if (node.getRight()==null){
            return node;
        }else {
            res=findMax(node.getRight());
        }
        return res;

    }

    /* *
     *@describe 查找节点 如果有就返回true,否则返回false 并加入新的节点;
     */

    public static boolean contains(int element,ADTNode node){
        boolean res=false;
        if (node==null){
            return res;
        }
        int flag=compares(element,node.getElement());
        if (flag>0){
            res=contains(element,node.getRight());
            if (node.getRight()==null){
                ADTNode newNode=new ADTNode();
                newNode.setElement(element);
                node.setRight(newNode);
            }

        }else if (flag<0){
            res=contains(element,node.getLift());
            if (node.getLift()==null){
                ADTNode newNode=new ADTNode();
                newNode.setElement(element);
                node.setLift(newNode);
            }
        }else {
            res=true;
        }
        return res;

    }

    /* *
     *@describe 比较两个数的大小 Comparator:比较者 Comparative:被比较者
     *@describe 若Comparator>Comparative则返回 1
     * @describe 若Comparator<Comparative则返回 -1
     * @describe 若Comparator=Comparative则返回 0
     */

    public static int compares(int comparator,int comparative){
        return new Integer(comparator).compareTo(comparative);


    }


    public static void main(String[] args) {
        ADTNode node=new ADTNode();
        node.setElement(10);
        System.out.println(ADTMethods.contains(2,node));
        System.out.println(ADTMethods.contains(15,node));
        System.out.println(ADTMethods.contains(17,node));
        System.out.println(ADTMethods.contains(17,node));
        System.out.println(ADTMethods.contains(20,node));
        System.out.println(ADTMethods.contains(16,node));
        System.out.println(ADTMethods.contains(9,node));
        System.out.println(ADTMethods.contains(7,node));
        System.out.println(ADTMethods.contains(8,node));
        System.out.println(ADTMethods.contains(5,node));
        System.out.println(ADTMethods.contains(1,node));


        System.out.println(node.getRight().getRight().getRight().getElement());
        System.out.println(ADTMethods.findMin(node).getElement());
        System.out.println(ADTMethods.remove(2,node));
    }

}
