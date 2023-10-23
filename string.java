// import java.util.*;
public class string {
    public static String compression(String str){
        String newstr="";
        for(int i=0;i<str.length();i++){
            Integer count =1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newstr +=str.charAt(i);
            if(count>1){
                newstr+=count.toString();
            }
        }
        return newstr;
    }
    public static float getshortpath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);
            if(dir=='S'){
                y--;
            }
            else if(dir=='N'){
                y++;
            }
            else if(dir=='W'){
                x--;
            }
            else{
                x++;
            }
        }
        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);
    }

    public static boolean palindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            int n =str.length();
            if(str.charAt(i)!=str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // Scanner sc =new Scanner(System.in);
        // String name=sc.nextLine();
        // System.out.println(name);
        
        // Function
        // System.out.println(name.length());

        // Concatenation
        // String firname= "Gunjan" ;
        // String lastname= "Upadhyay";
        // System.out.println(firname+" "+lastname);
        // String fullname="Sita Ram";
        // System.out.println(fullname.charAt(3));

        // printing all the characters of string
        // String str ="madam";
        // for(int i=0;i<str.length();i++){
        //     System.out.println(str.charAt(i));
        // }
        
        // ---Pallindrome---
        // palindrome(str);
        // if(palindrome(str)==true){
        //     System.out.println("string is palindrome");

        // }else{
        //     System.out.println("No string is not a pallindreome");
        // }

        // shortest path
        // String path="WNEENESENNN";
        // System.out.println(getshortpath(path));

        // String Compression
        String str="aaabbcccdd";
        System.out.println(compression(str));
    }
}
