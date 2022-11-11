// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43165
// 프로그래머스 타겟 넘버

// 그냥.. 부분집합 문제

package com.programmers.java43165;

class Solution {
    int answer, target;
    int[] numbers;

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.target = target;
        this.numbers = numbers;
        dfs(0, 0);

        return answer;
    }

    // 부분집합(수를 더할지 뺄지 선택)을 구하는 함수
    // 연산을 진행한 숫자 수, 숫자들, 연산 합
    void dfs(int cnt, int sum){
        if (cnt == numbers.length){
            if (target == sum)
                answer++;

            return;
        }

        dfs(cnt+1, sum+numbers[cnt]);
        dfs(cnt+1, sum-numbers[cnt]);
    }
}

// 정확성  테스트
//테스트 1 〉	통과 (9.24ms, 75.7MB)
//테스트 2 〉	통과 (8.53ms, 77.7MB)
//테스트 3 〉	통과 (0.23ms, 80.3MB)
//테스트 4 〉	통과 (0.36ms, 82.1MB)
//테스트 5 〉	통과 (0.48ms, 73MB)
//테스트 6 〉	통과 (0.33ms, 78.5MB)
//테스트 7 〉	통과 (0.17ms, 77MB)
//테스트 8 〉	통과 (0.42ms, 77.9MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0