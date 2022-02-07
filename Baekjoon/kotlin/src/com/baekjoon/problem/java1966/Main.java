// 문제 링크 : https://www.acmicpc.net/problem/1966
// 제출 공유 링크 (Queue 미사용) : http://boj.kr/2c438f2024a449488c27d7c1d2f24b9a
// 제출 공유 링크 (Queue 사용) : http://boj.kr/f2b99223ffe4406fb4c292e12a8485de

// 왜 이렇게 대쟈뷰 일어나는지.. 분명 푼 적이 있는것 같은데..?

package com.baekjoon.problem.java1966;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        // 테스트 케이스 수 만큼 반복
        for (int t = 0; t<testCase; t++) {
            int n = sc.nextInt(), m = sc.nextInt(); // 문서 수, 확인할 문서 인덱스

            // 우선순위 별로 문서의 갯수를 저장하는 배열
            HashMap<Integer, Integer> numCounts = new HashMap<>();

            // 1번 풀이 ========================================================================
            // Queue 미사용

//            // 인쇄물의 우선순위 배열
//            int[] prints = new int[n];
//
//            // 배열들 초기화
//            for(int i = 0; i<n; i++) {
//                int priority = sc.nextInt();
//                numCounts.put(priority, numCounts.getOrDefault(priority, 0) + 1);
//                prints[i] = priority;
//            }
//
//            int idx = -1, cnt = 0; // 현재 인덱스, 출력 횟수
//            // 우선 순위 높은 것부터 문서 출력을 계산하는 작업을 반복
//            for(int priority = 9; ; priority--){
//                // 문서에 해당 우선순위가 없다면 작업 생략
//                if (numCounts.getOrDefault(priority, 0) == 0)
//                    continue;
//
//                // 찾으려는 문서와 같은 우선순위라면
//                if (priority == prints[m]){
//                    // m번째 문서를 찾을 때까지 정순으로 탐색한다.
//                    do{
//                        idx++;
//                        // 인덱스가 넘어가면 다시 0번으로 옮겨주고
//                        if (idx >= n) idx = 0;
////                        System.out.println("1"+idx);
//                        // 해당 인덱스가 현재 찾는 우선순위의 문서라면
//                        if (prints[idx] == priority){
//                            cnt++; // 출력 횟수 증가
//                        }
//                    }while (idx != m);
//
//                    break;
//                }else{ // 찾으려는 문서와 다른 우선순위라면
//                    // 해당 우선순위 문서를 찾을 때까지 역순으로 탐색한다.
//                    do{
//                        idx--;
//                        // 인덱스가 넘어가면 다시 n-1번으로 옮겨준다.
//                        if (idx <= -1) idx = n-1;
////                        System.out.println("2"+idx);
//
//                        // 해당 우선순위 문서를 찾으면
//                        if (prints[idx] == priority){
//                            cnt += numCounts.get(priority);
//                            break;
//                        }
//                    }while (true);
//                }
//            }
//
//            System.out.println(cnt);

            // 2번 풀이 ========================================================================
            // Queue 사용

            // 초기화
            Queue<Integer> printQueue = new LinkedList<>();
            for(int i = 0; i<n; i++) {
                int priority = sc.nextInt();
                printQueue.add(priority);
                numCounts.put(priority, numCounts.getOrDefault(priority, 0) + 1);
            }

            int cnt = 0;
            work: for(int priority = 9; ; priority--) {
                // 높은 우선순위를 가지는 문서가 모두 출력될 때까지 반복한다.
                while(numCounts.getOrDefault(priority, 0) > 0) {
                    // 가장 앞의 출력물이
                    int p = printQueue.poll();
                    if (priority == p){ // 존재하는 문서 중 가장 높은 우선순위라면 출력
                        numCounts.put(priority, numCounts.get(priority) - 1);
                        cnt++;

                        if (m == 0){
                            // 원하는 문서가 출력되었다면 이중 반복문을 떠난다.
                            break work;
                        }
                    }else{ // 그렇지 않다면 다시 넣는다.
                        printQueue.add(p);
                    }

                    // 문서를 출력하던 뒤로 옮기던 신경 쓰고있는 문서는 항상 한 칸씩 당겨지므로
                    if (--m < 0)
                        m = printQueue.size() - 1;
                }
            }

            System.out.println(cnt);
        }
    }

}
