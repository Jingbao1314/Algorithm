package nextNode;

/**
 * @author jijngbao
 * @date 19-3-25
 */
public class NextNode {
    public static Node next(Node ancestor,Node node){
        boolean isRight=isRight(node);
        Node res=null;
        if (isRight){
            res=seaech(ancestor,node,true);
        }else {
            res=seaech(ancestor,node,false);
        }
        return res;
    }

    private static boolean isRight(Node node){
        if (node.parent.left!=null){
            if (node.parent.left!=node){
                return true;
            }
        }
        return false;

    }


    /* *
     *@describe 在右子树中寻找最左节点
     */
    private static Node seaech(Node ancestor,Node node,boolean right){
        if (node.right!=null){
            boolean flag=true;
            Node temp=node.right;
            while (flag){
                if (temp.left==null){
                    flag=false;
                    return temp;
                }else {
                    temp=temp.left;
                }
            }
        }

        if (right){
            return ancestor;
        }
        return node.parent;
    }

    public static void main(String[] args) {
        Node a=new Node("a");
        Node b=new Node("b");
        Node c=new Node("c");
        Node d=new Node("d");
        Node e=new Node("e");
        Node f=new Node("f");
        Node g=new Node("g");
        Node h=new Node("h");
        Node i=new Node("i");
        Node j=new Node("j");
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        b.parent=a;
        c.left=f;
        c.right=g;
        c.parent=a;
        d.left=h;
        d.right=i;
        d.parent=b;
        e.left=j;
        e.parent=b;
        f.parent=c;
        g.parent=c;
        h.parent=d;
        i.parent=d;
        j.parent=e;
        System.out.println(next(a,d).ele);



    }

}
class Node{
    public Node left=null;
    public Node right=null;
    public Node parent=null;
    public String ele="";
    public Node(String ele){this.ele=ele;}
}
