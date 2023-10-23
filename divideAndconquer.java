public class divideAndconquer {
    public static void mergeSort(int arr[],int si,int ei){
        if(si>ei){
            return;
        }
        int mid=si+(ei-si)/2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int [ei-si+1];

        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(int x=0,y=si;k<temp.length;x++,y++){
            arr[y]=temp[x];
        }
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,4,2,7,87,3,67,99,5,3};
        mergeSort(arr, 0, arr.length-1);
        // printArr(arr);
    }
}
