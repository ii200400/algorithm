// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42891?language=java

// 예전에 파이썬으로 풀고.. 코틀린으로도 푼 것 같은데.. 놀랍게도 기억 안난다.
// 이 문제는 무슨 1년마다 푸는 것 같아..

// 잠깐만.. k가 조금? 10*13이.. 1000천억?인가? 큐를 사용하려고 했더니 이건 무조건 시간초과이다;;
// 이분탐색뿐이 안 남는데.. 해봐야.. 겠다..

package com.programmers.java42891;

import java.util.Arrays;

class Solution {
    public int solution(int[] food_times, long k) {
        // 몇 바퀴를 돌면서 음식들을 순서대로 먹었을 때 k 보다 작으면서 가장 큰 수를 가지는지 이분탐색으로 찾고 답을 구한다.

        // start는 회전 가능한 최대 값, end는 불가능한 최소 값
        int start = 0, end = Arrays.stream(food_times).max().getAsInt();
        long left = k;  // start 번 돌았을 때 남은 음식
        
        // 이분탐색 진행
        while(start+1 != end) {
            int mid = (start+end) / 2;
            long sum = 0;
            for (int i = 0; i < food_times.length; i++) {
                sum += Math.min(food_times[i], mid);
            }

            // mid 회전시 k 번의 음식보다
            if (sum > k){   // 더 먹으면
                end = mid;
            }else if (sum < k){ // 못 먹으면
                start = mid;
                left = k-sum;
            }else{ // sum == k
                end = mid+1;
                left = 0;
                break;
            }
        }

        // k 번째 시간 이후 탐색되는 첫번째 인덱스를 반환하기
        for (int i = 0; i < food_times.length; i++){
            if (food_times[i] >= end){
                left--;

                if (left == -1){
                    return i+1;
                }
            }
        }

        // 음식이 없다면 -1 반환
        return -1;
    }
}

// 채점을 시작합니다.
//정확성  테스트
//테스트 1 〉	통과 (0.81ms, 78.4MB)
//테스트 2 〉	통과 (0.77ms, 74.3MB)
//테스트 3 〉	통과 (0.69ms, 70.1MB)
//테스트 4 〉	통과 (1.00ms, 78.8MB)
//테스트 5 〉	통과 (1.13ms, 73.9MB)
//테스트 6 〉	통과 (0.75ms, 75.1MB)
//테스트 7 〉	통과 (0.93ms, 74.9MB)
//테스트 8 〉	통과 (0.78ms, 72.9MB)
//테스트 9 〉	통과 (0.76ms, 77MB)
//테스트 10 〉	통과 (0.68ms, 75.9MB)
//테스트 11 〉	통과 (0.81ms, 74.2MB)
//테스트 12 〉	통과 (1.05ms, 76.4MB)
//테스트 13 〉	통과 (0.89ms, 79.1MB)
//테스트 14 〉	통과 (0.76ms, 73.9MB)
//테스트 15 〉	통과 (1.15ms, 78.7MB)
//테스트 16 〉	통과 (0.94ms, 77.2MB)
//테스트 17 〉	통과 (0.67ms, 73.7MB)
//테스트 18 〉	통과 (0.78ms, 74.9MB)
//테스트 19 〉	통과 (0.99ms, 78.6MB)
//테스트 20 〉	통과 (1.20ms, 78.2MB)
//테스트 21 〉	통과 (1.18ms, 74.7MB)
//테스트 22 〉	통과 (1.21ms, 72.2MB)
//테스트 23 〉	통과 (1.08ms, 77.8MB)
//테스트 24 〉	통과 (2.04ms, 76.9MB)
//테스트 25 〉	통과 (2.21ms, 71.5MB)
//테스트 26 〉	통과 (1.66ms, 75.9MB)
//테스트 27 〉	통과 (2.45ms, 72MB)
//테스트 28 〉	통과 (1.27ms, 73.7MB)
//테스트 29 〉	통과 (0.85ms, 77.1MB)
//테스트 30 〉	통과 (0.80ms, 77.9MB)
//테스트 31 〉	통과 (1.02ms, 74.9MB)
//테스트 32 〉	통과 (0.74ms, 72.3MB)
//효율성  테스트
//테스트 1 〉	통과 (30.31ms, 61.9MB)
//테스트 2 〉	통과 (33.40ms, 62.1MB)
//테스트 3 〉	통과 (33.39ms, 61.7MB)
//테스트 4 〉	통과 (35.60ms, 61.8MB)
//테스트 5 〉	통과 (29.34ms, 62.9MB)
//테스트 6 〉	통과 (32.45ms, 62MB)
//테스트 7 〉	통과 (37.53ms, 62.9MB)
//테스트 8 〉	통과 (31.55ms, 61.7MB)
//채점 결과
//정확성: 42.9
//효율성: 57.1
//합계: 100.0 / 100.0
