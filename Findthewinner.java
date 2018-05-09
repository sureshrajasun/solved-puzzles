import java.util.stream.IntStream;

public class Findthewinner {

    public static void main(String[] args) {
        int[] andrea = new int[]{1, 2, 3};
        int[] maria = new int[]{2, 1, 3};
        System.out.println( winner(andrea, maria, "EVEN") );
    }

    static String winner(int[] andrea, int[] maria, String s) {
        int oddOrEven ;
        if("ODD".equalsIgnoreCase(s)){
            oddOrEven = 1;
        }else{
            oddOrEven = 0;
        }
        int maxNumbersGiven = andrea.length > maria.length ? andrea.length : maria.length;
        int[] andreaScores = new int[maxNumbersGiven];
        int[] mariaScores = new int[maxNumbersGiven];

        int scoreIndex = 0;
        for (int i = 0 ; i < maxNumbersGiven; i++){

            int andreaChoice = 0 ;
            int mariaChoice = 0;

            if(i < andrea.length && i % 2 == oddOrEven){
                andreaChoice =  andrea[i] ;
            }
            if(i < maria.length  && i % 2 == oddOrEven){
                mariaChoice =  maria[i] ;
            }

            if(i % 2 == oddOrEven) {
                andreaScores[scoreIndex ] = andreaChoice - mariaChoice;
                mariaScores[scoreIndex ] = mariaChoice - andreaChoice;
                scoreIndex ++;
            }
        }

        if (IntStream.of(andreaScores).sum() > IntStream.of(mariaScores).sum()){
            return "Andrea";
        }else{
            return "Maria";
        }
    }

}
