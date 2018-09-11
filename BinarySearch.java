/**
  * @This achieves binary search on a sorted array. BY LWJ 
  **/
public class BinarySearch {
    public static void main(String [] args) {
        Double [] m = new Double[12];
        for (int i = 0; i < 12; i++) {
            m[i] = new Double(i + 3.5);
        }
        System.out.println(binarySearch(m, new Double(7.5)));
        System.out.println(binarySearchRecursion(m, 0, 11, new Double(8.5)));
    }

    public static int binarySearchRecursion(Comparable [] data, int low, int high, Comparable target) {
        int mid = low + (high - low) / 2;
        if (low <= high) {
            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) == -1) {
                return binarySearchRecursion(data, mid + 1, high, target);
            } else {
                return binarySearchRecursion(data, low, mid - 1, target);
            }
        }
        return -1; 
    }

    public static int binarySearch(Comparable [] data, Comparable target) {
        int low = 0;
        int high = data.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) == -1) {
                low = mid + 1;                
            } else {
                high = mid - 1;
            }         
        }
        return -1;
    }
}