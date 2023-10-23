// import java.util.*;
public class LinkedList2{
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    
    public void addFirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }
    public void print(){
        Node temp=head;
        if(head==null){
            System.out.println("Linked list id empty");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static boolean iscycle(){
        Node slow =head;
        Node fast =head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean iscycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                iscycle =true;
                break;
            }
        }
        if(iscycle==false){
            return;
        }
        slow=head;
        Node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
    }

    public Node mergesort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=getmid(head);
        // Node righthead=mid.next;
        mid.next=null;
        Node newleft=mergesort(head);
        Node newright=mergesort(head);
        return merge(newleft,newright);
    }
    public Node getmid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;

        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public static void main(String[] args) {
        LinkedList2 LL=new LinkedList2();
        LL.addFirst(2);
        LL.addFirst(3);
        LL.addFirst(34);
        LL.addFirst(55);
        LL.addFirst(14);
        LL.print();
        // LL.mergesort(head);
        // LL.print();
        System.out.println(LL.mergesort(head));
        LL.print();
        LL.addFirst(24);
        LL.print();

        // System.out.println(iscycle());
        // System.out.println(removeCycle());
        // LL.removeCycle();
    }
}
