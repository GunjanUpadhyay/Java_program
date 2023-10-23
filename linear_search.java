// import java.util.Scanner;
// import java.util.*;

public class linear_search{
    public static int linearSearch(int marks[],int key){
        for(int i=0;i<=marks.length;i++){
           if(marks[i]==key){
            return i;
           } 
        }
        return -1;
        
    }
    public static void main(String args[]) {
        // int n=10;
        // int num[]=new int[100];
        // Scanner sc= new Scanner(System.in);
        // System.out.println("Enter the elemrnt of arrays");
        // for(int i=0;i<=n;i++){
        //     num[i]=sc.nextInt();
        // }
        // for(int j=0;j<=n;j++){
        //     System.out.print(num[j]);
        // }

        int marks[]={1,2,34 ,6 ,5, 7,8,14,45,23};
        int key=3;
        int index =linearSearch(marks, key);
        if(index== -1){
            System.out.println("Element is not found");
        }
        else{
            System.out.println("index is"+index);
        }
    }
}