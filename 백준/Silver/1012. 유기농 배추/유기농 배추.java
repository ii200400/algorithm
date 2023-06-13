import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[][] ds = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    static int answer;

    public static void main(String[] args) {
        int T = sc.nextInt();

        for (int tCase = 0; tCase<T; tCase++){
            answer = 0;
            useMap();
//            useSet();

            System.out.println(answer);
        }
    }
    
    // 지도(이중배열)를 이용해서 푸는 방법
    // 배추가 심어진 지역을 따로 담는 배열을 만들까 하다가 말았다.
    // bfs로 케어가 되는 배추가 많을수록 비효율적이고 그렇지 않을 수록 효율적인데.. 더 코딩하기 힘들었다..
    static void useMap(){
        // 배추 밭 (평소와는 다르게 가로와 세로를 바꾸었다.)
        // 배추가 없거나 지렁이가 캐어를 해주는 배추라면 false, 케어가 필요한 곳이라면 true가 저장된다.
        boolean[][] map = new boolean[sc.nextInt()+2][sc.nextInt()+2]; // 둘레를 벽으로 쳐서 +2씩 추가, sc을 []안에 넣어도 되네..?
        int n = sc.nextInt(); // 배추 수

        // 배추 심기
        for (int i = 0; i<n; i++){
            // 벽 때문에 +1씩 추가
            map[sc.nextInt()+1][sc.nextInt()+1] = true;
        }

        // 밭을 돌아보면서 (인덱스 0과 map.length 인덱스는 벽이다.)
        for (int i = 1; i<map.length-1; i++){
            for (int j = 1; j<map[0].length-1; j++){
                // 케어가 필요하지 않은 곳이라면 생략
                if (!map[i][j]) continue;

                // 그렇지 않다면 bfs 시작
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                while (!queue.isEmpty()){
                    // 배추의
                    int[] location = queue.poll();
                    // 인접한 배추를 확인한다.
                    for(int[] d : ds){
                        int x = location[0]+d[0], y = location[1]+d[1];
                        // 인접한 배추를 찾으면 큐에 넣는다.
                        if (map[x][y]){
                            queue.add(new int[]{x, y});
                            map[x][y] = false;
                        }
                    }
                }

                // 위에서 찾은 배추지역에 흰배추지렁이 추가
                answer++;
            }
        }


    }
}