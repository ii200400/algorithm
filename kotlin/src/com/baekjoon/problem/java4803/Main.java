// 문제 링크 : https://www.acmicpc.net/problem/4803
// 제출 공유 링크 : http://boj.kr/86406883477f4ef596fdbc740e888a95

// 1년 전쯤인가 반년 전쯤인가 푼 경험이 있는 문제
// 문제를 읽으니까 기억나는데, 트리문제가 아닌 서로소 집합 문제;;

// 시간 복잡도는.. 아마 O(n+m)
// union 함수를 m번 부르면서 compa어쩌구.. 라는 기법을 사용해서 깊이가 3을 초과하지 않아 am번 배열을 탐색하고
// 마지막에 각 정점을 대표자인지 탐색(n번)하기 때문

package com.baekjoon.problem.java4803;

import java.util.Scanner;

public class Main {

    static int[] jointSet;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 임의로 만든 테스트 케이스 반복문
        testCase: for(int testCase = 1; ; testCase++){
            int n = sc.nextInt();   // 정점의 수
            int m = sc.nextInt();   // 간선의 수

            // 0, 0이 입력되면 종료한다.
            if (n == 0 && m == 0)
                break;

            jointSet = new int[n+1];  // 서로소 집합, 인덱스 0을 가리킨다면 트리가 아닌 것을 의미
            // 서로소 집합 초기화
            for (int i = 1; i<n+1; i++){
                jointSet[i] = i;
            }

            // 간선의 수 만큼
            for (int i = 0; i<m; i++){
                // 입력을 받아오면서 집합을 합쳐준다.
                unionSet(sc.nextInt() , sc.nextInt());
            }

            int treeCnt = 0;    // 트리의 개수
            // 트리의 개수를 세고 (대표자의 수와 트리의 수는 같으므로)
            for (int i = 1; i<n+1; i++){
                if (jointSet[i] == i)
                    treeCnt++;
            }

            // 트리 수에 맞게 출력한다.
            if (treeCnt == 0){
                System.out.printf("Case %d: No trees.%n", testCase);
            }else if (treeCnt == 1){
                System.out.printf("Case %d: There is one tree.%n", testCase);
            }else {
                System.out.printf("Case %d: A forest of %d trees.%n", testCase, treeCnt);
            }
        }
    }

    // 트리의 루트 찾기
    static int findSet(int a){
        if (jointSet[a] == a)
            return a;

        // 압축해서 대표자(루트) 까지의 경로를 단축시킨다.
        return jointSet[a] = findSet(jointSet[a]);
    }

    // 트리 합치기
    static boolean unionSet(int a, int b){
        // 두 집합이 같거나 둘 중 하나가 트리가 아니라면
        int rootA = findSet(a);
        int rootB = findSet(b);
        if (rootA == rootB || rootA == 0 || rootB == 0) {
            // 두 집합 모두 트리가 아니라고 기록해준다.
            jointSet[findSet(a)] = 0;
            jointSet[findSet(b)] = 0;
            return false;
        }

        // 두 집합 모두 트리이면 합쳐준다.
        jointSet[rootB] = rootA;
        return true;
    }
}
