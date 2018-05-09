
import java.util.Arrays;

public class PsychometricTesting {
    public static void main(String[] args) {

    /*    int[] scores = new int[]{1, 3, 5, 6, 8}; // 1st set of Input
        int[] lowerLimits = new int[]{2};
        int[] upperLimits = new int[]{6};
        int q = 1;*/

        int[] scores = new int[]{4, 8, 7};  // 2nd set of Input
        int[] lowerLimits = new int[]{2, 4};
        int[] upperLimits = new int[]{8, 4};

        int[] results = jobOffers(scores, lowerLimits, upperLimits);

        Arrays.stream(results).forEach(System.out::println);

    }

    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
        int q = upperLimits.length;

        int limit = 0;
        int[] results = new int[q];

        while (q > 0) {
            int lower = lowerLimits[limit];
            int upper = upperLimits[limit];
            results[limit] = Arrays.stream(scores).filter(num -> num >= lower && num <= upper).toArray().length;
            limit++;
            q--;
        }
        return results;
    }
}
