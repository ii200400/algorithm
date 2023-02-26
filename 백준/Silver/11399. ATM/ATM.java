import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 사람 수

        // 1. stream 이용하는 방법
//        int[] arr = Arrays.stream(sc.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .mapToInt(i -> i).sorted().toArray();

        // 2. Array 이용하는 방법
        int[] arr = new int[n]; // 인출 시간
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        // 빠르게 뽑는 사람이 먼저 뽑을수록 총 대기 시간이 줄어들기 때문에 오름차순 정렬
        Arrays.sort(arr);

        // 이렇게 더해도 된다.
        int sum = 0, temp = 0;
        for (int i = 0; i<n; i++){
            temp += arr[i];
            sum += temp;
        }

        // 출력한다.
        System.out.println(sum);
    }
}