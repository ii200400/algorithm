import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tastcase = sc.nextInt();
        for (int i = 0; i<tastcase; i++){
            int westCnt = sc.nextInt();
            int eastCnt = sc.nextInt();

            long caseCnt = 1;
            int min = Math.min(eastCnt, eastCnt-westCnt);
            for (int j = 0; j<min; j++){
                caseCnt *= (eastCnt-j);
                caseCnt /= j+1;
            }

            System.out.println(caseCnt);
        }
    }
}