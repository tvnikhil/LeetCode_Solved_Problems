import java.util.HashMap;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            hm.put(arr2[i], i);
        }
        Integer[] temp = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            temp[i] = arr1[i];
        }
        Arrays.sort(temp, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                Integer index1 = hm.getOrDefault(num1, arr2.length + num1);
                Integer index2 = hm.getOrDefault(num2, arr2.length + num2);
                return index1.compareTo(index2);
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = temp[i];
        }
        return arr1;
    }
}