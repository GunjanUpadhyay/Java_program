import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;            
        }
        if(root.data>key){
            return search(root.left, key);
        }else{
            return search(root.right,key);
        }

    }
    
    public static Node insert(Node root ,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static Node findInorderSuccesor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static Node delete(Node root ,int val){
        if(root.data>val){
            root.left=delete(root.left, val);
        }else if(root.data<val){
            root.right=delete(root.right,val);
        }
        else{
            // Case 1
            if(root.left==null && root.right==null){
                return null;
            }
            // Case 2
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            // Case 3
            Node IS=findInorderSuccesor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);
        }
        return root;
    }

    public static void PrintRoot2Leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            printPath(path);
        }
        PrintRoot2Leaf(root.left, path);
        PrintRoot2Leaf(root.right, path);
        path.remove(path.size()-1);

    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Node root=new Node(2);
        int val[]={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<val.length;i++){
            root=insert(root, val[i]);
        }
        inorder(root);

        System.out.println();
        // if(search(root, 9)){
        //     System.out.println("Key is found");
        // }else{
        //     System.out.println("Key is not Found");
        // }

        // inorder(delete(root, 5));
        ArrayList<Integer> path=new ArrayList<>();

        PrintRoot2Leaf(root, path);
    }
}
