

// import java.util.Scanner;

public class recursion{
    
    public static int optPower(int x,int n){
        if(n==0){
            return 1;
        }
        // int halfpower=optPower(x, n/2)*optPower(x, n/2);
        // if(n%2!=0){
        //     halfpower=x*halfpower;
        // }

        int halfpower=optPower(x, n/2);
        int halfpowersq=halfpower*halfpower;
        if(n%2!=0){
            halfpowersq=x*halfpowersq;
        }
        return halfpowersq;
    }
    public static int xpowern(int x,int n){
        if(n==0){
            return 1;
        }
        return x*xpowern(x, n-1);
    }
    public static int lastOccu(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isfound=lastOccu(arr, key, i+1);
        if(isfound==-1 && arr[i]==key){
            return i;
        }
        return isfound;
    }
    public static int firstOccu(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccu(arr, key, i+1);
    }
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int fibonacciNo(int n){
        if(n==0||n==1){
            return n;
        }
        return fibonacciNo(n-1)+fibonacciNo(n-2);
    }
    public static int sumofNatural(int n){
        if(n==1){
            return n;
        }
        return n+sumofNatural(n-1);
    }
    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int fat=n*fact(n-1);
        return fat;
    }
    public static void printinc(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printinc(n-1);
        System.out.println(n);
    }
    public static void printdcr(int n){
        if(n==1){
            System.out.println("1");
            return ;
        }
        System.out.println(n);
        printdcr(n-1);
    }
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // int n= sc.nextInt();
        // int n=10;
        // printdcr(n);
        // printinc(n);
        // System.out.println(fact(3)); 
        // System.out.println(sumofNatural(10));
        // System.out.println(fibonacciNo(4));
        // System.out.println("Namste");
        
        // int arr[]={1,2,3,8,5,6,7,8};
        // System.out.println(isSorted(arr, 0)); 


        // int arr[]={8,3,6,9,5,10,2,3,5};
        // int key=5;
        // for (int i=0;i<arr.length;i++){
        //     if(arr[i]==key){
        //         System.out.println(i);
        //         break;
        //     }
        // }
        // System.out.println(firstOccu(arr, key, 0));
        // System.out.println(lastOccu(arr, key, 0));

        // System.out.println(xpowern(2, 10));

        System.out.println(optPower(2, 5));
    }
}