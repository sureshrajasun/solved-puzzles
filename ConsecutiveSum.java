import java.util.Scanner;

public class ConsecutiveSum {

    public static void main(String[] args) {
        long givenNumber;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number : ");
        givenNumber = input.nextLong();

        System.out.println( consecutive(givenNumber));
    }

    static int consecutive(long givenNumber) {
        int numberOfConsecutiveSum = 0;
        for (int i = 1; i < givenNumber; i++) {
            int consecutiveSum = i;

            for (int j = i + 1; consecutiveSum < givenNumber; j++) {
                consecutiveSum = consecutiveSum + j;
                if (consecutiveSum == givenNumber) {
                    numberOfConsecutiveSum++;
                }
            }
        }
        return numberOfConsecutiveSum;
    }
}