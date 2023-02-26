import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static int n;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        // 초기화
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        useArray();
    }

    // int[]를 사용하는 경우
    static void useArray() throws IOException {
        int[] stack = new int[n];
        int num, size = 0;
        for (int i = 0; i<n; i++){
            switch (num = Integer.parseInt(br.readLine())){
                case 0:
                    size--;
                    break;
                default:
                    stack[size++] = num;
            }
        }

        int sum = 0;
        for (int i = 0; i<size; i++){
            sum += stack[i];
        }

        System.out.println(sum);
    }
}