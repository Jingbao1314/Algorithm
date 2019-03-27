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
//        Node a=new Node("a");
//        Node b=new Node("b");
//        Node c=new Node("c");
//        Node d=new Node("d");
//        Node e=new Node("e");
//        Node f=new Node("f");
//        Node g=new Node("g");
//        a.left=b;
//        a.right=c;
//        b.left=d;
//        b.right=e;
//        c.left=f;
//        c.right=g;
//        print(a,true);
//        serialize(a);
//        Solution solution=new Solution();
//        System.out.println();
//        serialize(solution.Deserialize(solution.Serialize(a)));
        String[] pre={"1","2","4","7","3","5","6","8"};
        String[] vin={"4","7","2","1","5","3","8","6"};
        Node node=build(pre,vin);
        prePrint(node);

    }

    public static void prePrint(Node node){
        if (node==null){
            return;
        }
        System.out.println(node.ele);
        prePrint(node.left);
        prePrint(node.right);

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
    /* *
     *@describe 根据前序遍历,中序遍历的结果重建二叉树
     */
    public static Node build(String[] pre,String[] vin){
        int root_flag=0;
        for (int i=0;i<pre.length;i++){
            if(pre[0]==vin[i]){
                root_flag=i;
                break;
            }
        }
//        printList(pre);
//        System.out.println();
//        printList(vin);
//        System.out.println();
//        System.out.println(root_flag);
        Node root=new Node(pre[0]);
       if (pre.length>2){
           if (root_flag!=0){
               String[] pre_left=createList(pre,1,root_flag);
               String[] vin_left=createList(vin,0,root_flag-1);
               root.left=build(pre_left,vin_left);
           }
           if (root_flag!=vin.length-1){
               String[] pre_right=createList(pre,root_flag+1,pre.length-1);
               String[] vin_right=createList(vin,root_flag+1,vin.length-1);
//               System.out.println("right");
               root.right=build(pre_right,vin_right);
           }
       }else if (pre.length==2){
//           System.out.println("------");
           if (pre[0]==vin[0]){
               root.right=new Node(pre[1]);
           }else {
               root.left=new Node(pre[1]);
           }
       }
        return root;
    }

    private static void printList(String []list){
        for (String ele:list) {
            System.out.print(ele);

        }

    }
    private static String[] createList(String[] list,int start,int end){
//        printList(list);
//        System.out.println("pre");
//        System.out.println(start+"-----"+end);
        String[] res=new String[end-start+1];
        int flag=0;
        for (int i=start;i<=end;i++){
            res[flag]=list[i];
            flag++;
        }
//        printList(res);
//        System.out.println("res");
        return res;
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

