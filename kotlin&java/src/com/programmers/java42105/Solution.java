// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42891?language=java
// 정수 삼각형

// 그 뭐였지.. 파스칼의 삼각형? 같은 문제이다.
// 위에서 더해나가면서 더 크게 나온 값을 저장하였다.

package com.programmers.java42105;

import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i<triangle.length; i++){
            // 첫번째와 마지막 수는 위의 수가 하나 밖에 없으므로
            triangle[i][0] += triangle[i-1][0];
            triangle[i][triangle[i].length-1] += triangle[i-1][triangle[i-1].length-1];
            // 위에서 더할 수 있는 두 수 중 더 큰수와 현재 위치의 수와 합친다.
            for (int j = 1; j<triangle[i].length-1; j++){
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }

        // 마지막 줄에서 가장 큰 수를 출력한다.
        int answer = 0;
        int[] lastList = triangle[triangle.length-1];
        for (int i = 0; i<lastList.length; i++){
            answer = Math.max(answer, lastList[i]);
        }
        return answer;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (0.03ms, 77.9MB)
//테스트 2 〉	통과 (0.06ms, 77.3MB)
//테스트 3 〉	통과 (0.07ms, 72.5MB)
//테스트 4 〉	통과 (0.07ms, 73.5MB)
//테스트 5 〉	통과 (0.23ms, 78.7MB)
//테스트 6 〉	통과 (0.08ms, 75.6MB)
//테스트 7 〉	통과 (0.23ms, 76.2MB)
//테스트 8 〉	통과 (0.07ms, 73.1MB)
//테스트 9 〉	통과 (0.03ms, 73.6MB)
//테스트 10 〉	통과 (0.06ms, 76.7MB)
//효율성  테스트
//테스트 1 〉	통과 (7.93ms, 59.9MB)
//테스트 2 〉	통과 (5.80ms, 55.9MB)
//테스트 3 〉	통과 (6.90ms, 57.5MB)
//테스트 4 〉	통과 (8.39ms, 59.9MB)
//테스트 5 〉	통과 (10.81ms, 59.8MB)
//테스트 6 〉	통과 (6.42ms, 60.9MB)
//테스트 7 〉	통과 (6.68ms, 60.2MB)
//테스트 8 〉	통과 (6.84ms, 62.8MB)
//테스트 9 〉	통과 (6.19ms, 59.9MB)
//테스트 10 〉	통과 (8.17ms, 60.8MB)