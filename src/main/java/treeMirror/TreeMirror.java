package treeMirror;

/**
 * @author jijngbao
 * @date 19-3-19
 */
public class TreeMirror {
    public static void mirror(Node tree){
        if (tree.left.left!=null){
            mirror(tree.left);

        }
        if (tree.right.right!=null){
            mirror(tree.right);
        }
        Node left=tree.left;
        Node right=tree.right;
        tree.right=left;
        tree.left=right;
    }

    public static void print(Node tree){
        System.out.println(tree.ele);
        if (tree.left!=null){
            print(tree.left);
        }
        if (tree.right!=null){
            print(tree.right);
        }

    }

    public static void main(String[] args) {
        Node a=new Node("a");
        Node b=new Node("b");
        Node c=new Node("c");
        Node d=new Node("d");
        Node e=new Node("e");
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        mirror(a);
        print(a);
    }
}
class Node{
    public Node left=null;
    public Node right=null;
    public String ele="";

    public Node(String ele) {
        this.ele = ele;
    }
}