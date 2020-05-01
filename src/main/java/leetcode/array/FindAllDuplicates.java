package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

    public static void main(String[] args) {

        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.print(findDuplicates(arr));
    }

    private static List<Integer> findDuplicates(int[] arr) {

        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[ Math.abs(arr[i]) - 1] >= 0)
                arr[ Math.abs(arr[i]) - 1] = -arr[ Math.abs(arr[i]) - 1];
            else
                ans.add(Math.abs(arr[i]));
        }

        return ans;

    }

}
