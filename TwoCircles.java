
import java.util.Arrays;

public class TwoCircles {

    public static void main(String[] args) {

       /* Scanner input = new Scanner(System.in);
        System.out.print("Enter Circle 1 center x-, y-coordinates, and radius: ");

        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();

        System.out.print("Enter Circle 2 center x-, y-coordinates, and radius: ");

        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();*/

        //String[] pos = new String[]{"0 5 9 0 9 7", "0 15 11 0 20 16", "26 0 10 39 0 23", "37 0 5 30 0 11", "41 0 0 28 0 13"};
        String[] pos = new String[]{"12 0 21 14 0 23", "0 45 8 0 94 9", "35 0 13 10 0 38", "0 26 8 0 9 25"};

        Arrays.stream(circles(pos)).forEach(a -> System.out.println(a));

    }

    static String findCirclePostion(double r1, double r2, double distance) {
        if (r2 >= r1 && distance <= (r2 - r1)) {
            return "Touching";
        } else if (r1 >= r2 && distance <= (r1 - r2)) {
            return "Disjoint‐Inside";
        } else if (distance > (r1 + r2)) {
            return "Disjoint‐Outside";
        } else {
            return "Intersecting";
        }
    }


    static String[] circles(String[] info) {
        String[] results = new String[info.length];
        int count = 0;

        for (String str : info) {
            String[] inputNumber = str.split(" ");
            double number[] = new double[inputNumber.length];
            for (int i = 0; i < inputNumber.length; i++) {
                number[i] = Double.parseDouble(inputNumber[i]);
            }

            double distance = Math.pow(
                    (number[0] - number[3]) * (number[0] - number[3]) + (number[1] - number[4]) * (number[1] - number[4]),
                    0.5);

            results[count++] = findCirclePostion(number[2], number[5], distance);
        }

        return results;
    }

}

