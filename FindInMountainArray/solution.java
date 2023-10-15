
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
public class solution {
    public int findPeakElement(int left, int right, MountainArray mountainArr) {
        int length = mountainArr.length();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
    public int binarySearch(int left, int right, MountainArray mountainArr, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int mid_val = mountainArr.get(mid);
            if ( mid_val == target ) {
                return mid;
            }
            if ( mid_val < target ) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    public int reverseBinarySearch(int left, int right, MountainArray mountainArr, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int mid_val = mountainArr.get(mid);
            if ( mid_val == target ) {
                return mid;
            }
            if ( mid_val > target ) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }


    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.length() < 3) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;
        int left = 0, right = mountainArr.length() - 1;
        int peak_idx = findPeakElement(left, right, mountainArr);
        int peak_element = mountainArr.get(peak_idx);
        if (peak_element == target) {
            return peak_idx;
        }

        if (peak_element > target) {
            ans = binarySearch(left, peak_idx - 1, mountainArr, target);
        }

        if ( ans != Integer.MAX_VALUE ) {
            return ans;
        }
        
        ans = reverseBinarySearch(peak_idx + 1, right, mountainArr, target);

        if ( ans != Integer.MAX_VALUE ) {
            return ans;
        }
        return -1;
        

    }
    @Override
    public String toString() {
        return "solution []";
    }
}