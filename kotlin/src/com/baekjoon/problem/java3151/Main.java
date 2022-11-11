// 문제 링크 : https://www.acmicpc.net/problem/3151
// 제출 공유 링크 : http://boj.kr/d03251098459477ca0d052f32ffb6129

// 처음에는 이분탐색인줄 알았는데.. 마지막에 쓰여있는 3인조에, 4초의 시간제한을 보고 조합인 것을 알았다..
// 중요한 것은 가지치기.. 우선 정렬을 필수적으로 하고 진행할 수 밖에 없다.
// 아니면 1만중 3개를 고르는 조합의 개수에 시간초과를 맛볼듯;

// 해시셋을 사용했는데, 메모리 계산을 잘못했나?? 메모리초과가 떳다.
// 정말.. 중복에는 이분탐색 쓰기 싫은데.. 기수정렬쓸까, 되면 그것대로 대박인데.. 이쪽은 시간초과가 걸릴수도 있다.
// 시간이 조금 남았으므로 다시 풀어보겠다, 안되면 포기

// 기수정렬로 완료했다. 시간은 0.5초로 이상하리만치 빠르다, 왠지 잘 모르겠;;
// 원래는 어떤 알고리즘을 쓰는지 잘 모르겠다;; 수가 중복되는 상황에서는 이분탐색이 껄끄러운데..
// 게다가 해시셋을 사용했을 때는 왜 공간복잡도가 나갔는지 잘 모르겠다..

// 기수정렬에 수학론?이라고해야하나? 로 풀이완료
// 시간복잡도는.. 다 상수로 계산되어 상수로 나오는데;; 어떻게 작성을해야;; 10000C2 * 2 + 10000 이다;;

package com.baekjoon.problem.java3151;

import java.util.Scanner;

public class Main {

    // 실력이 음수인 학생 2명과 양수인 학생 1명
    // 실력이 음수인 학생 1명과 양수인 학생 2명
    // 실력이 음수인 학생 1명과 양수인 학생 1명 0인 학생 1명
    // 실력이 0인 학생 3명
    // 위의 경우의 수를 모두 더하는 방식으로 하였다.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 학생 수
        // 코딩 능력치 음수와 양수별로 다른 배열에 학생 수를 카운트하는 배열을 만든다.
        // 단 0인 경우에는 양수 배열에 저장한다.
        int[] minus = new int[10001];   // 코딩 실력이 -idx 인 학생 수 배열
        int[] plus = new int[10001];    // 코딩 실력이 idx 인 학생 수 배열

        // 초기화
        for (int i = 0; i<n; i++){
            int num = sc.nextInt();

            if (num < 0){
                minus[-num]++;
            }else if (num > 0) {
                plus[num]++;
            }else{
                plus[0]++;
            }
        }

//        System.out.println(Arrays.toString(minus));
//        System.out.println(Arrays.toString(plus));

        long answer = 0;    // 만들 수 있는 학생 조합
        boolean flag = plus[0] > 0; // 실력이 0인 학생이 존재하는지 여부

        // 실력이 음수인 학생들을 살펴본다.
        int num1Cnt;    // 첫번째로 선택한 코딩 실력
        for (int i = 1; i<10000; i++){
            // 해당 실력을 가진 학생이 없는 경우 생략
            if (minus[i] == 0)
                continue;

            // 실력이 음수인 학생 1명과 양수인 학생 1명 0인 학생 1명 조합을 계산하는 코드
            num1Cnt = minus[i];
            if (flag && plus[i] != 0){
                answer += (long) plus[0] * plus[i] * num1Cnt;
            }

           // 실력이 `같은` 음수인 학생 2명과 양수인 학생 1명 0인 학생 1명 조합을 계산하는 코드
            if (num1Cnt > 1 && i <= 5000 && plus[i*2] != 0){
                answer += (long) plus[i*2] * num1Cnt * (num1Cnt-1) /2;
            }

            // 실력이 `다른` 음수인 학생 2명과 양수인 학생 1명 0인 학생 1명 조합을 계산하는 코드
            for (int j = i+1; j+i<10001; j++){
                if (minus[j] == 0)
                    continue;

                if (plus[i+j] == 0)
                    continue;

                answer += (long) num1Cnt * minus[j] * plus[i+j];
            }
        }

        // 실력이 음수인 학생들을 살펴본다.
        for (int i = 1; i<10000; i++){
            if (plus[i] == 0)
                continue;

            num1Cnt = plus[i];

            // 실력이 음수인 학생 1명과 실력이 `같은` 양수인 학생 2명 0인 학생 1명 조합을 계산하는 코드
            if (num1Cnt > 1 && i <= 5000 && minus[i*2] != 0){
                answer += (long) minus[i*2] * num1Cnt * (num1Cnt-1) /2;
            }

            // 실력이 음수인 학생 1명과 실력이 `다른` 양수인 학생 2명 0인 학생 1명 조합을 계산하는 코드
            for (int j = i+1; j+i<10001; j++){
                if (plus[j] == 0)
                    continue;

                if (minus[i+j] == 0)
                    continue;

                answer += (long) num1Cnt * plus[j] * minus[i+j];
            }
        }

        // 실력이 0인 학생 3명을 조합을 계산하는 코드
        if (plus[0] > 2){
            answer += (long) plus[0] * (plus[0]-1) * (plus[0]-2) / 6;
        }

        // 총 학생 조합 출력
        System.out.println(answer);
    }
}
