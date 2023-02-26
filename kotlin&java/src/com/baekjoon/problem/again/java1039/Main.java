// 문제 링크 : https://www.acmicpc.net/problem/1039
// 제출 공유 링크 :
// 백준 교환
// 참고 블로그 : https://yabmoons.tistory.com/152

// 어후.. 그리디하게 풀었는데 아니였다;;
// 완탐인 것 같다;; 교환 회수에 따라서 교환을 해야하는 방법이 그리디하지 않게 나올 수 있기 때문..
// ... 완탐하니까 이번에는 메모리 초과 뜨는데..?
// 결국 블로그를 참고하였다. k번 교환 완탐은 맞는데 방문체크와 비슷하게 이전에 숫자를 만들었는지 확인해서
// 연산을 줄어야하는 코드가 필요하다.

package com.baekjoon.problem.again.java1039;

import java.io.IOException;
import java.util.*;

public class Main {
    static int k, answer;
    static char[] sortedNum, num;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String temp = Integer.toString(sc.nextInt());
        k = sc.nextInt();   // 총 교환 회수
        answer = 0; // 정답
        num = new char[temp.length()];   // 숫자 배열

        // 숫자 초기화
        for (int i = 0; i < temp.length(); i++) {
            num[i] = temp.charAt(i);
        }

        sortedNum = num.clone();  // 숫자 정렬을 위해 사용 
        Arrays.sort(sortedNum); // (왜 역순이 안되냐..)
//        System.out.println(Arrays.toString(sortedNum));

        // 주어진 수가 한자리 수인 경우 혹은 두자리인데 하나가 0인 경우
        if (temp.length() == 1 || (temp.length() == 2 && num[1] == '0')){
            System.out.println(-1);
            return;
        }

        // 모든 교환 수 확인


        // 교환 시 가장 큰 수 출력
        System.out.println(answer);
    }

    // dfs에 그리디를 넣은 방식 (틀렸습니다)
    // 왼쪽부터 나열을 하는데 현재 존재하는 가장 큰 수와 교환한다.
    // 가장 큰 수가 이미 배치가 되어있다면 지나간다.
//    static void dfs(int idx, int changeCnt, char[] num){
//        if (changeCnt == k || idx == num.length){   // 교환 회수를 모두 소비했거나 모든 자리수를 살펴봤다면
//            // 남은 교환회수가 홀수인 경우..?
//            if ((k-changeCnt) % 2 == 1){
//                char temp = num[num.length-1];
//                num[num.length-1] = num[num.length-2];
//                num[num.length-2] = temp;
//            }
//
//            // 만들어진 수를 숫자로 바꾸어서 적절하게 저장한다.
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i<num.length; i++){
//                sb.append(num[i]);
//            }
//            answer = Math.max(answer, Integer.parseInt(sb.toString()));
//            return;
//        }
//
//        char bigNum = sortedNum[num.length-(idx+1)];
//        if (bigNum == num[idx]) { // 이미 자리할 수 있는 가장 큰수인 경우 다음 자리수로 진행
//            dfs(idx + 1, changeCnt, num);
//        }else{
//            for (int i = idx+1; i<num.length; i++){
//                if (num[i] == bigNum){
//                    // 숫자 위치를 바꾸고 진행
//                    char temp = num[idx];
//                    num[idx] = num[i];
//                    num[i] = temp;
//                    dfs(idx+1, changeCnt+1, num);
//
//                    // 백트레킹
//                    num[i] = num[idx];
//                    num[idx] = temp;
//                }
//            }
//        }
//    }

    // dfs 완전탐색 (메모리초과)
//    static void dfs2(int changeCnt){
//        if (num[0] == '0')
//            return;
//
//        if (changeCnt == k){   // 교환 회수를 모두 소비했거나 모든 자리수를 살펴봤다면
//            // 만들어진 수를 숫자로 바꾸어서 적절하게 저장한다.
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i<num.length; i++){
//                sb.append(num[i]);
//            }
//            answer = Math.max(answer, Integer.parseInt(sb.toString()));
//            return;
//        }
//
//        for (int i = 0; i<num.length-1; i++){
//            for (int j = i+1; j<num.length; j++){
//                // 숫자 위치를 바꾸고 진행
//                char temp = num[i];
//                num[i] = num[j];
//                num[j] = temp;
//                dfs2(changeCnt+1);
//
//                // 백트레킹
//                num[j] = num[i];
//                num[i] = temp;
//            }
//        }
//    }
}
