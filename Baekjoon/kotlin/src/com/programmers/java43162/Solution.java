// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/43162
// 프로그래머스 네트워크

// 서로소 집합으로 해결하려고 하는데..
// 이것도 dfs로.. 취급되나?

package com.programmers.java43162;

class Solution {
    int[] disjoint;

    public int solution(int n, int[][] computers) {
        int answer = n; // 네트워크 수
        disjoint = new int[n];    // 서로소 집합

        // 서로소 집합 초기화
        for (int i = 1; i<n; i++){
            disjoint[i] = i;
        }

        // 컴퓨터가 서로 연결되어있는지 확인하는데
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                // 자신을 탐색하는 경우, 다른 컴퓨터와 연결이 되어있지 않은 경우는 생략
                if (i == j || computers[i][j] == 0) continue;

                // 두 컴퓨터를 연결하는데 서로 다른 네트워크였다면 네트워크 수 - 1
                if(union(i, j)){
                    answer--;
                }
            }
        }

        // 네트워크 수 반환
        return answer;
    }

    // 두 집합을 합치는 함수
    boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB){
            return false;
        }

        disjoint[rootB] = rootA;
        return true;
    }

    // 특정 정점이 있는 집합의 대표자 정점을 찾는 함수
    int find(int a){
        if (disjoint[a] == a)
            return a;

        return disjoint[a] = find(disjoint[a]);
    }
}

// 정확성  테스트
//테스트 1 〉	통과 (0.03ms, 76.3MB)
//테스트 2 〉	통과 (0.02ms, 76.1MB)
//테스트 3 〉	통과 (0.04ms, 81.4MB)
//테스트 4 〉	통과 (0.05ms, 72.1MB)
//테스트 5 〉	통과 (0.01ms, 73.5MB)
//테스트 6 〉	통과 (0.17ms, 76MB)
//테스트 7 〉	통과 (0.03ms, 84.9MB)
//테스트 8 〉	통과 (0.12ms, 80.1MB)
//테스트 9 〉	통과 (0.08ms, 78MB)
//테스트 10 〉	통과 (0.09ms, 79.2MB)
//테스트 11 〉	통과 (0.53ms, 81.1MB)
//테스트 12 〉	통과 (0.31ms, 80.9MB)
//테스트 13 〉	통과 (0.18ms, 77MB)
//채점 결과
//정확성: 100.0
//합계: 100.0 / 100.0