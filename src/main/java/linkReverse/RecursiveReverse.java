package linkReverse;

/**
 * @author jijngbao
 * @date 19-3-25
 */
public class RecursiveReverse {
    public static Node reverse(Node list){
        Node news=null;
        if (list.next!=null){
            news=reverse(list.next);
        }else {
            news=list;
        }
        if (news!=null){
            news.next=list;
            list.next=null;
        }
        return list;
    }
    public static void print(Node node){
        boolean flag=true;
        while (flag){
            if(node.next==null){
                flag=false;
            }
            System.out.println(node.ele);
            node=node.next;

        }

    }

    public static void main(String[] args) {
        Node a=new Node("a");
        Node b=new Node("b");
        Node c=new Node("c");
        Node d=new Node("d");
        Node e=new Node("e");
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        a=reverse(a);
        print(e);

    }
}
