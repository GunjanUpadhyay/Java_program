import java.util.*;
public class StackC {
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return ;
        }
        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder res=new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            res.append(curr);
        }
        return res.toString();
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int stocks[],int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=0;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && currPrice>stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else {
                int prevHigh=s.peek();
                span[i]=i-prevHigh;                
            }
            s.push(i);
        }
    }

    public static boolean Isvalid(String str){
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('|| ch=='{' || ch=='['){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='(' && ch==')') || (s.peek()=='{' && ch=='}') || (s.peek()=='[' && ch==']' ))
                {
                    s.pop();
                }
                else{
                     return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuplicate(String str){
        Stack<Character> s= new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==')'){
                int count =0;
                while(!s.isEmpty() && s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int arr[]){
        int maxArea=0;
        int nsl[]=new int[arr.length];
        int nsr[]=new int[arr.length];
        
        Stack<Integer> s=new Stack<>();
        // Nexts Smaller right
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        s=new Stack<>();
        for(int i=1;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            maxArea=Math.max(currArea,maxArea);
        }
        System.out.println("Max Area in Histogram is = "+maxArea);
    }
    public static void main(String[] args) {
        // Stack<Integer> s= new Stack<>();
        // s.push(3);
        // s.push(5);
        // s.push(6);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        // pushAtBottom(s, 40);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        // String str="Gunjan";
        // String res=reverseString(str);
        // System.out.println(res);
    //     reverseStack(s);
    //     while(!s.isEmpty()){
    //             System.out.println(s.peek());
    //             s.pop();
    //    }
        //   int stocks[]={100,80,60,70,60,85,100};
        //   int span[]=new int[stocks.length];
        //   stockSpan(stocks, span);

        //   for(int i=0;i<span.length;i++){
        //     System.out.print (span[i]);
        //   }

        // int arr[]={6,8,0,1,3};
        // Stack<Integer> s=new Stack<>();
        // int nextGreater[]=new int [arr.length];

        // for(int i=arr.length-1;i>=0;i--){
        //     while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
        //         s.pop();
        //     }
        //     if(s.isEmpty()){
        //         nextGreater[i]=-1;
        //     }else {
        //         nextGreater[i]=arr[s.peek()];
        //     }
        //     s.push(i);
        // }
        // for(int i=0;i<nextGreater.length;i++){
        //     System.out.print(nextGreater[i]+" ");
        // }

        // String str="(((a+b)+(a+b)))";
        // System.out.println(isDuplicate(str));

        int arr[]={2,1,5,6,2,3};
        maxArea(arr);


    }
}
