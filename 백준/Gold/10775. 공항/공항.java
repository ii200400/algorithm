import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] disjoint;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int g = sc.nextInt();   // 게이트의 수
        int p = sc.nextInt();   // 비행기의 수
        disjoint = new int[g+1];   // 빈 게이트를 빠르게 찾기위한.. 서로소 집합?

        // 서로소 집합 초기화
        for (int i = 1; i<=g; i++){
            disjoint[i] = i;
        }

        // 게이트 도킹.. 확인 및 도킹한 게이트 개수 세기
        int cnt;
        for (cnt = 0; cnt<p; cnt++){
            // 도킹할 수 있는 게이트가 주어지면 빈 게이트를 찾는다
            int num = sc.nextInt();
            int root = find(num);

            // 빈 게이트가 없다면 반복문 탈출
            if (root == 0){
                break;
            }

            // 빈 게이트에 도킹한다.
            disjoint[root] = root-1;
        }

        // 도킹한 게이트 개수 출력
        System.out.println(cnt);
    }

    /**
     * num보다 작은 숫자의 빈 게이트 탐색
     * @param num 게이트 숫자
     * @return
     */
    static int find(int num){
        if (disjoint[num] == num)
            return num;

        return disjoint[num] = find(disjoint[num]);
    }
}