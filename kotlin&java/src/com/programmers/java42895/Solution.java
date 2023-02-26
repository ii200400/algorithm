// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
// N으로 표현

// 예전에.. 입력받은 숫자 1개로, 2개로, 3개로, ... 만들 수 있는 수를 저장하고
// 조합하여 다음 수를 계산해낸다.

// 조합은 예를 들면 아래와 같다.
// 2개의 숫자로 만들 수 있는 수들은 (1개로 만들수 있는 수들) +-/* (1개로 만들수 있는 수들)
// 3개의 숫자로 만들 수 있는 수들은
// (1개로 만들수 있는 수들) +-/* (2개로 만들수 있는 수들) 과 (2개로 만들수 있는 수들) +-/* (1개로 만들수 있는 수들)

// 아무래도 몇 년 전에 했던 해결법을 기억해내고 있는 것 같다.

package com.programmers.java42895;

import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        // 중복된 값을 저장하지 않기 위해서 해시셋 사용
        HashSet<Integer>[] numbers = new HashSet[9];
        for (int i = 0; i<=8; i++){
            numbers[i] = new HashSet<>();
        }

        int buildNum = 0;
        for (int i = 1; i<=8; i++){
            // 5, 55, 555 같은 수를 저장
            buildNum += (int) (N * Math.pow(10, i-1));
            numbers[i].add(buildNum);

            // 수를 조합해서 추가
            // 수의 조합에 대한 설명은 코드 상단 설명 참고
            for (int j = 1; j<=i/2; j++){
                for (int num1: numbers[j]) {
                    for (int num2: numbers[i-j]) {
                        numbers[i].add(num1 + num2);
                        numbers[i].add(num1 - num2);
                        numbers[i].add(num2 + num1);
                        numbers[i].add(num1 * num2);
                        if (num2 != 0)
                            numbers[i].add(num1 / num2);
                        if (num1 != 0)
                            numbers[i].add(num2 / num1);
                    }
                }
            }

            // 원하는 숫자를 찾았다면
//            System.out.println(numbers[i]);
            if (numbers[i].contains(number))
                return i;    // 사용횟수의 최솟값 반환
        }

        return -1;
    }
}

//정확성  테스트
//테스트 1 〉	통과 (1.76ms, 79.8MB)
//테스트 2 〉	통과 (0.17ms, 75.9MB)
//테스트 3 〉	통과 (0.20ms, 77.9MB)
//테스트 4 〉	통과 (15.76ms, 85.3MB)
//테스트 5 〉	통과 (12.55ms, 81.2MB)
//테스트 6 〉	통과 (0.56ms, 76.8MB)
//테스트 7 〉	통과 (0.73ms, 75.4MB)
//테스트 8 〉	통과 (11.36ms, 80.5MB)
//테스트 9 〉	통과 (0.06ms, 74.8MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0