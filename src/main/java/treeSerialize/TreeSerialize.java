package treeSerialize;

/**
 * @author jijngbao
 * @date 19-3-26
 */
public class TreeSerialize {
    public static void serialize(Node root){
       if (root.left!=null){
           serialize(root.left);
       }
        if (root.left==null&&root.right==null){
            System.out.print(root.ele+"->");
        }else if (root.left==null){
            System.out.print("null"+"->");
            System.out.print(root.ele+"->");
        }else if (root.right==null){
            System.out.print(root.ele+"->");
            System.out.print("null"+"->");
        }else{
            System.out.print(root.ele+"->");
        }
       if (root.right!=null){
           serialize(root.right);
       }

    }


    public static void deSerialize(String tree){
        String[] list=getNode(tree);
        int index=list.length/2;
        Node root=new Node(list[index]);
        int left_index=0;
        int right_index=0;

    }

    private static void createNode(String[] list,int index,Node root,int
            differenceValue){
        int left_index=index-differenceValue;
        int right_index=index+differenceValue;
        Node left=new Node(list[left_index]);
        Node right=new Node(list[right_index]);
        root.left=left;
        root.right=right;
    }

    /* *
     *@describe 获得节点数组
     */
    private static String[] getNode(String tree){
        String[] list=tree.split("[->]");
        String[] temp=new String[list.length+1];
        temp[0]="jingbao1314";
        for (int i=0;i<list.length;i++){
            temp[i+1]=list[i];
        }
        return temp;

    }


    public static void main(String[] args) {
        Node a=new Node("a");
        Node b=new Node("b");
        Node c=new Node("c");
        Node d=new Node("d");
        Node e=new Node("e");
        Node f=new Node("f");
        Node g=new Node("g");
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;

//        serialize(a);
//        Solution solution=new Solution();
//        System.out.println();
//        serialize(solution.Deserialize(solution.Serialize(a)));

        print(a,true);

    }

    public static void print(Node tree,boolean flag){
        if (tree==null){
            return;
        }
        if (flag){
            System.out.println(tree.ele);
        }
        if (tree.left!=null){
            System.out.println(tree.left.ele);
        }else {
            System.out.println("null");
        }
        if (tree.right!=null){
            System.out.println(tree.right.ele);
        }else {
            System.out.println("null");
        }
        print(tree.left,false);
        print(tree.right,false);

    }

}
class Node {
    public Node left;
    public Node right;
    public String ele;
    public Node(String ele){
        this.ele=ele;
    }
}

class Solution
{
    public String temp = "";
    public String Serialize(Node root)
    {
        if(root==null)
        {
            temp=temp+"null?";
            return "null?";
        }
        temp=temp+root.ele+"?";
        Serialize(root.left);
        Serialize(root.right);
        return temp;
    }
    public int index=0;
    public Node create(Node z,String[] temp)
    {
        if(temp[index].equals("null"))
        {
            index++;
            return null;
        }
        z=new Node(temp[index]);
        index++;
        z.left=create(z.left,temp);
        z.right=create(z.right,temp);
        return z;
    }
    public Node Deserialize(String str)
    {
        if(str==null||str.equals(""))
            return null;
        String[] temp=str.split("\\?");
        Node root = create(null,temp);
        return root;
    }
}

