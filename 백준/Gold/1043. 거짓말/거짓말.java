import java.util.Scanner;

public class Main {
    static int[] disjoint;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 사람의 수
        int m = sc.nextInt();   // 파티의 수
        int[][] partyPeople = new int[m][]; // 파티별 모인 사람들
        int num = sc.nextInt(); // 진실을 아는 사람의 수
        disjoint = new int[n+1];  // 서로소 집합 (0을 가리키는 사람은 진실을 알고 있는 사람)

        // 서로소 집합 초기화
        for (int i = 1; i<=n; i++){
            disjoint[i] = i;
        }
        for (int i = 0; i<num; i++){
            disjoint[sc.nextInt()] = 0;
        }

        // 서로소 집합으로 진실을 아는 사람끼리 집합 + partyPeople 초기화
        for (int i = 0; i<m; i++){
            int partyNum = sc.nextInt();    // 파티에 참석한 사람의 수
            int first = sc.nextInt();   // 파티에 참석하는 첫번째 사람
            partyPeople[i] = new int[partyNum];
            partyPeople[i][0] = first;
            
            // 파티에 참석하는 사람들 끼리 모아놓기
            for (int j = 1; j<partyNum; j++){
                int person = sc.nextInt();
                union(first, person);
                partyPeople[i][j] = person;
            }
        }
        
        // 파티 수만큼 둘러보면서
        int cnt = 0;
        for (int i = 0; i<m; i++){
            boolean lie = true; // 거짓말 가능 여부
            // 진실을 알게 되는 사람들이 없는 파티에서만 거짓말을 하도록 한다.
            for (int person: partyPeople[i]){
                if (find(person) == 0) {
                    lie = false;
                    break;
                }
            }

            // 거짓말을 할 수 있다면 cnt+1
            if (lie){
                cnt++;
            }
        }

        // 거짓말 회수 출력
        System.out.println(cnt);
    }

    // 두 집합을 합치는
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        // 진실을 알고있는 사람이 있다면 집합을 0으로 합치고
        if (rootA == 0){
            disjoint[rootB] = 0;
        }else if (rootB == 0){
            disjoint[rootA] = 0;
        }else{  // 그렇지 않다면 평범하게 합친다.
            disjoint[rootB] = rootA;
        }
    }

    // 서로소 집합의 루트를 찾는 함수
    static int find(int num){
        if (disjoint[num] == num){
            return num;
        }

        return disjoint[num] = find(disjoint[num]);
    }
}