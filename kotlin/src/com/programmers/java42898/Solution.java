// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42898?language=java
// 등굣길

// 중학생때 배운 그대로 작성하였다.
// 오른쪽과 아래로만 움직이므로 왼쪽과 위쪽의 값을 더해나가면 된다.

package com.programmers.java42898;

import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];    // 편의상 +1을 하여 메모이제이션 사용
        // 집인 (1, 1)위치에는 1을 세팅해준다.
        map[1][1] = 1;

        // 못가는 곳을 -1로 지정한다.
        for (int i = 0; i<puddles.length; i++){
            map[puddles[i][0]][puddles[i][1]] = -1;
        }

        // 위치별로 갈 수 있는 경로 수를 계산한다.
        for (int i = 1; i<=m; i++){
            for (int j = 1; j<=n; j++){
                // 0이 아닌 곳만(집 위치와 웅덩이 외의 곳)
                if (map[i][j] != 0) continue;
                // 계산을 한다.
                map[i][j] = ((map[i-1][j] == -1? 0:map[i-1][j]) + (map[i][j-1] == -1? 0:map[i][j-1]))%1000000007;
            }
        }

//        System.out.println(Arrays.deepToString(map));

        // 학교까지가는 경로를 출력한다.
        return map[m][n];
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.02ms, 74.8MB)
//테스트 2 〉	통과 (0.03ms, 73.8MB)
//테스트 3 〉	통과 (0.02ms, 79.2MB)
//테스트 4 〉	통과 (0.03ms, 75.3MB)
//테스트 5 〉	통과 (0.03ms, 77.9MB)
//테스트 6 〉	통과 (0.02ms, 75.2MB)
//테스트 7 〉	통과 (0.03ms, 77.8MB)
//테스트 8 〉	통과 (0.04ms, 68.8MB)
//테스트 9 〉	통과 (0.03ms, 73.3MB)
//테스트 10 〉	통과 (0.03ms, 78.3MB)
//효율성  테스트
//테스트 1 〉	통과 (0.93ms, 51.8MB)
//테스트 2 〉	통과 (0.37ms, 52.6MB)
//테스트 3 〉	통과 (0.43ms, 52.3MB)
//테스트 4 〉	통과 (0.67ms, 51.9MB)
//테스트 5 〉	통과 (0.38ms, 52.2MB)
//테스트 6 〉	통과 (0.65ms, 52.4MB)
//테스트 7 〉	통과 (0.45ms, 52MB)
//테스트 8 〉	통과 (0.75ms, 51.9MB)
//테스트 9 〉	통과 (0.63ms, 52.4MB)
//테스트 10 〉	통과 (0.65ms, 52.2MB)
//채점 결과
//정확성: 50.0
//효율성: 50.0
//합계: 100.0 / 100.0