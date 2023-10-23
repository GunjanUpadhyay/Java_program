// import java.util.*;
public class LinkedList1 {
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
    public static int size;

    public Node findmid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public boolean isPallindrome(){
        if(head==null || head.next==null){
            return true;
        }
        Node midNode=findmid(head);
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left =left.next;
            right=right.next;
        }
        return true;
    }

    public void deleteNthEnd(int n){
        int size=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }

        if(n==size){
            head=head.next;
            return;
        }
        int i=1;
        int tofind=size-n;
        Node prev=head;
        while(i<tofind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;    
    }

    public void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }

    public int recuSearch(int key){
        return helper(head,key);
    }

    public int search(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public void addMiddle(int data,int idx){
        Node newnode=new Node(data);
        if(idx==0){
            newnode.next=head;
            head=newnode;
            size++;
            return;
        }
        
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
        size++;
    }

    public void addLast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            size++;
            return;
        }
        tail.next=newnode;
        tail=newnode;
        size++;
    }

    public void addFirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            size++;
            return;
        }
        newnode.next=head;
        head=newnode;
        size++;
    }

    public int removefirst(){
        if(size==0){
            System.out.println("LLis empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public void print(){
        Node temp=head;
        if(head==null){ 
            System.out.println("LLi");
        }
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public int removelast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        // int val=tail;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public static void main(String[] args) {
        LinkedList1 ll=new LinkedList1();
        // ll.head=new Node(2);
        // ll.head.next=new Node(3);
        ll.addFirst(23);
        ll.addFirst(3);
        ll.addFirst(2);
        // ll.print();
        ll.addLast(3);
        ll.addLast(2);
        ll.print();
        // ll.addMiddle(67,3 );
        // ll. print();
        // ll.addMiddle(99, 0);
        // ll.print();
        // System.out.println(ll.size);
        // System.out.println(ll.removefirst()); 
        // ll.print();
        // System.out.println(ll.removelast());
        // ll.print();
        // System.out.println(ll.size);
        // System.out.println(ll.search(44));
        // System.out.println(ll.recuSearch(287));
        // ll.reverse();
        // ll.print();
        // ll.deleteNthEnd(2);
        // ll.print();
        System.out.println(ll.isPallindrome());
    }
}
