
import java.util.*;

public class greedyApproach {
    public static void main(String args[]){

        // absolute difference pairs;
        int a[]={1,2,3,4};
        int b[]={2,1,3,5};
        Arrays.sort(a);
        Arrays.sort(b);
        int mindiff=0;
        for(int i=0;i<a.length;i++){
            mindiff+=Math.abs(a[i]-b[i]);
        }
        System.out.println(mindiff);


        // Fractional knapsack
        // int val[]={60,100,120};
        // int weight[]={10,20,30};
        // int W=50;
        // int cap=W;
        // int finalval=0;

        // double rotio[][]=new double [val.length][2];
        // for(int i=0;i<val.length;i++){
        //     rotio[i][0]=1;
        //     rotio[i][1]=val[i]/(double)weight[i];
        // }

        // Array.Sort(rotio,Comparator.comparingDouble(o->o[1]));
        // for(int i=rotio.length-1;i>=0;i++){
        //     int idx=(int) rotio[i][0];
        //     if(cap>=weight[idx]){
        //         finalval+=val[idx];
        //         cap-=weight[idx];
        //     }else{
        //         finalval+=(rotio[i][1]*cap);
        //         cap=0;
        //         break;
        //     }
        // }
        // System.out.println(finalval);

        // Activity Selection Problem
        // int start[]={1,3,0,5,8,5};
        // int end[]={2,4,6,7,9,9};

        // int maxAct=0;
        // ArrayList<Integer> ans=new ArrayList<>();

        // maxAct=1;
        // ans.add(0);
        // int lastEnd=end[0];
        // for(int i=1;i<end.length;i++){
        //     if(start[i]>=lastEnd){
        //         maxAct++;
        //         ans.add(i);
        //         lastEnd=end[i];
        //     }
        // }
        // System.out.println("Max activities = "+maxAct);
        // for(int i=0;i<ans.size();i++){
        //     System.out.println("A"+ans.get(i));
        // }
    }
}
