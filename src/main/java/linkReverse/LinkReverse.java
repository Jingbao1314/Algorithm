package linkReverse;

import java.util.ArrayList;

/**
 * @author jijngbao
 * @date 19-3-19
 */
public class LinkReverse
{
    /* *
     *@describe 链表反转 使用栈来模拟递归过程
     */
    public static void reverse(Node node){
        int flag=1;
        Node head=node;
        while (node.next!=null){
            if (node.next!=null){
                flag++;
            }
            node=node.next;
        }
        System.out.println(flag);
        Node []barrel=new Node[flag];
        int index=0;
        while (head.next!=null){
            if (head.next.next==null){
                barrel[index+1]=head.next;
            }
            barrel[index]=head;
            head=head.next;
            index++;
        }
        for (int i=flag-1;i>0;i--){
            barrel[i].setNext(barrel[i-1]);
        }
        print(barrel[flag-1],flag);
        barrel=null;
    }
    private static void print(Node node,int flag){
        while (flag>0){
            System.out.println(node.ele);
            node=node.next;
            flag--;
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
        reverse(a);
    }
}
class Node{
    public Node next=null;
    public String ele="";

    public Node(String ele) {
        this.ele = ele;
    }

    public Node(Node next) {
        this.next = next;
    }
    public Node(){}

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
