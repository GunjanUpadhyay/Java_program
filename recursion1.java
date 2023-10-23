// import java.util.*;
public class recursion1 {
    public static void towerOfHanoi(int n,String scr,String auxi,String dest){
        if(n==1){
            System.out.println(scr+ " to " +dest);
            return;
        }
        towerOfHanoi(n-1, scr, dest, auxi);
        System.out.println(scr+ " to " +dest);
        towerOfHanoi(n-1, auxi, scr, dest);

    }
    public static void index(int arr[],int key,int i){
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.println(i);
        }
        index(arr, key, i+1);
    }
    public static void printBstring(int n,int lastplace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        if(lastplace==0){
            printBstring(n-1, 0, str+"0");
            printBstring(n-1, 1, str+"1"); 
        }else{
            printBstring(n-1, 0, str+"0");
        }
    }
    public static int frdpair(int n){
        if(n==1 ||n==2){
            return n;
        }
        return frdpair(n-1)+(n-1)*frdpair(n-2);
    }
    public static void removedup(String str,int idx,StringBuilder newstr,boolean map[]){
        if(idx==str.length()){
            System.out.println(newstr);
            return;
        }
        char currChar=str.charAt(idx);
        if(map[currChar-'a']==true){
            removedup(str, idx+1, newstr, map);
        }else{
            map[currChar-'a']=true;
            removedup(str, idx+1, newstr.append(currChar), map);
        }

    }
    public static int tilingProblem(int n){
        if(n==0||n==1){
            return 1;
        }
        int vtile=tilingProblem(n-1);
        int htile=tilingProblem(n-2);
        return vtile+htile;
    }
    public static void main(String[] args) {
        // number of ways to filing the tile in 2*n area
        // System.out.println(tilingProblem(3));

        // String str ="GunjanUpadhyay";
        // removedup(str, 0, new StringBuilder(" "), new boolean[26]);

        // friends pairing problem
        // System.out.println(frdpair(4));
        
        // printBstring(3, 0, " ");

        // int arr[]={1,2,3,4,5,3,5,6,2,4,2};
        // index(arr, 5, 0);

        towerOfHanoi(3,"A", "B","C");
    }
}
