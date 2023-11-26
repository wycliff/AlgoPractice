package src.main.java.searching;

class BinSearchRotated {
    public static int search(int[] nums, int target) {
        if(nums[0]<nums[nums.length-1]){
            return binSearchNormal(nums, 0, nums.length-1, target);
        }else{
            return binSearchRotated(nums, 0, nums.length-1, target);
        }
    }

    public static int binSearchRotated(int[] nums, int start, int end, int target){
        if(start>=end){
            if(nums[start]==target){
                return start;
            }else{
                return -1;
            }
        }

        int mid = start + (end - start)/ 2;


        if(nums[mid]== target){
            return mid;
        }

        if(nums[mid]>nums[end] && nums[end]>= target){
            return binSearchRotated(nums,mid+1,end, target);
        }else{
            return binSearchRotated (nums, start, mid-1, target);
        }
    }

    public static int binSearchNormal(int[] nums, int start, int end, int target){
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start)/ 2;

        if(nums[mid]== target){
            return mid;
        }

        if(target>nums[mid]){
            return binSearchNormal(nums,mid+1,end, target);
        }else{
            return binSearchNormal(nums, start, mid-1, target);
        }
    }

    public static void main(String[] args) {
        int[] testData = {3,5,1};
        System.out.println(search(testData, 3));
    }
}