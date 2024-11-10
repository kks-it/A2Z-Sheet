package Arrays.Medium;


import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class A8_LeadersInAnArray {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        List<Integer> list = printLeadersBruteForce(arr, arr.length);
        list.forEach(num -> System.out.printf("%d\t", num));

    }

    public static List<Integer> printLeadersBruteForce(int[] arr, int n) {

        List<Integer> ans = new ArrayList<>();

        // Last element of an array is always a leader,
        // push into ans array.
        int max = arr[n - 1];

        ans.add(max);

        // Start checking from the end whether a number is greater
        // than max no. from right, hence leader.
        for (int i = n - 2; i >= 0; i--)
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }

        return ans;

    }

}


