// 문제 링크 : https://www.acmicpc.net/problem/1012
// 제출 공유 링크 (hashset 사용) : http://boj.kr/52d5ab3747b947afa523bcc895aaae8f
// 제출 공유 링크 (이중배열 사용) : http://boj.kr/312ba2d104b4453d9ef8de04f6ae1edf

// 지도를 만들어 배추가 캐어되는 부분을 기록하면서 bfs를 사용할지 아니면
// 지도 없이 Set만 사용해서 bfs를 사용할지 고민을 했는데
// 위 방법은 친구들이 만들어 줄 것 같으니 두 번째 방법으로 가서 공유하는 쪽으로 풀어보겠다.

// 시간 비교를 위해서 둚 모두 만들어보았는데
// 이중배열을 사용하는 방식이 더 빠르고 메모리도 덜 먹었다 하하하하ㅏㅎ.ㅎ..

package com.baekjoon.problem.java1012;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[][] ds = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    static int answer;

    public static void main(String[] args) {
        int T = sc.nextInt();

        for (int tCase = 0; tCase<T; tCase++){
            answer = 0;

//            useSet();
            useMap();


            System.out.println(answer);
        }
    }

    // hashset을 이용해서 푸는 방법
    static void useSet(){
        // 초기화
        sc.nextInt();
        sc.nextInt();
        int n = sc.nextInt();

        // 배추 심기
        int[][] cabbagesArr = new int[n][2]; // 배추 정보를 가지는 배열 (아래의 set이 순서가 없어서 정보를 차례대로 가져올 수 없어 생성)
        HashSet<Location> cabbages = new HashSet<>(); // 배추 정보를 가지는 set
        for (int i = 0; i<n; i++){
            int x = sc.nextInt(), y = sc.nextInt();
            cabbagesArr[i] = new int[] {x, y};
            cabbages.add(new Location(x, y));
        }

        // bfs를 통해 인접한 배추 확인하기
        for (int[] location : cabbagesArr) {
            // 이미 케어받고 있는 배추라면 생략
            if (!cabbages.contains(new Location(location[0], location[1]))){
                continue;
            }

            // 그렇지 않으면 인접한 배추를 찾는다. (bfs 사용)
            Queue<int[]> q = new LinkedList<>();
            cabbages.remove(new Location(location[0], location[1]));
            q.add(new int[]{location[0], location[1]});

            // 큐가 빌 때까지 아래의 작업을 한다. (인접한 배추들 모두 확인)
            while(!q.isEmpty()){
                // 현 위치에서
                int[] current = q.poll();

                // 사방 위에
                for (int[] d : ds){
                    int x = current[0] +d[0], y = current[1]+d[1];
                    //  다른 배추가 있다면 큐에 넣고 set에서는 뺀다.
                    if (cabbages.remove(new Location(x, y))){
                        q.add(new int[] {x, y});
                    }
                }
            }

            // 위에서 찾은 배추지역에 흰배추지렁이 추가
            answer++;
        }
    }

    // equals와 hashCode를 작성 해주어야만 해시가 다른 두 Location 객체라도 내용이 같으면 같은 객체로 간주해준다.
    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Location loc = (Location) o;

            if (x != loc.x) return false;
            return y == loc.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
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
