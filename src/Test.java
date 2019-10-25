import java.util.Arrays;

public class Test {

    public static int[] mergeArrays(int[]... arrays) {
        int n = 0;

        for (int[] a : arrays){
            n += a.length;
        }

        int[] result = new int[n];

        int[] idx = new int[arrays.length];

        for (int i = 0; i < n; i++) {

            int minJ = -1, minVal = 0;

            for (int j = 0; j < arrays.length; j++) {
                if (idx[j] < arrays[j].length) {
                    int val = arrays[j][idx[j]];
                    if (minJ == -1 || val < minVal) {
                        minJ = j;
                        minVal = val;
                    }
                }
            }

            result[i] = minVal;
            idx[minJ]++;
        }
        return result;
    }

    public static void main(String[] args){
        int[] merged = mergeArrays(
                new int[] {  5, 10},
                new int[] { 30, 49},
                new int[] { 13, 25});
        System.out.println(Arrays.toString(merged));
    }

}