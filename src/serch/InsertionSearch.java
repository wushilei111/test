package serch;

public class InsertionSearch {
    public int insertionSearch(int a[],int k,int low,int high){
        int mid = low+(k-a[low])/(a[high]-a[low])*(high-low);
        if(low>=high||k<a[low]||k>a[high])
            return -1;
        if(a[mid]==k)
            return mid;
        if(a[mid]>k)
            return insertionSearch(a,k,low,mid-1);
        else
            return insertionSearch(a,k,mid+1,high);
    }
}
