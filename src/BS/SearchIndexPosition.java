package BS;

public class SearchIndexPosition {
    public int searchInsert(int[] nums, int target) {
        return binarySearch( nums,0,nums.length-1,target);
    }
    public static int binarySearch(int[] arr, int left, int right, int target){
        if( left > right){
            return left;
        }
        int mid = (left+right)/2;
        if( arr[mid] == target){
            return mid;
        }
        else if( target < arr[mid] ){
            return binarySearch(arr, left, mid-1, target);
        }
        return binarySearch(arr, mid + 1, right, target);
    }
}
