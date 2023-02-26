// 문제 링크 : https://www.acmicpc.net/problem/16947
// 제출 공유 링크 :

// 뭐이리.. 생각보다 어렵지;;;
// 처음에는 단순히 인접 리스트로 하려고 했다가 순환 구별이 안되서
// 서로소 집합을 쓸지 hashSet을 추가한 그래프 탐색을 쓸지 생각하다가, 초기화에 그래프 탐색이 더 좋을 것 같아서 후자를 선택했다.
// 그래프 탐색으로 순환선을 찾고, 순환선 중 한 정점을 기준으로 다른 모든 정점들의 순환선으로부터의 거리를 구하는 알고리즘
// 그런데 왜 패스를 모타니..

package com.baekjoon.problem.java16947;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int n;
    static HashSet<Integer> set;
    static int[][] adjMatrix;
    static int[] disFromCircle;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adjMatrix = new int[n+1][n+1];  // 인접리스트 (편의상 +1)

        // 인접 리스트 초기화
        for(int i = 0; i<n; i++){
            int from = sc.nextInt(), to = sc.nextInt();
            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1;
        }

        disFromCircle = new int[n+1]; // 순환선으로부터 거리
        Arrays.fill(disFromCircle, -1); // -1로 초기화
        set = new HashSet<>();
        set.add(1);
        
        // 인접 리스트에서 순환정점 찾고 순환 정점의 거리는 0으로 바꿔주기
        int circleDot = Math.abs(searchCircleDot(1));  // 순환선의 한 정점

        // 
        setDistance(circleDot, 0);

        for (int i = 1; i<n+1; i++) {
            System.out.print(disFromCircle[i] + " ");
        }
    }

    // 인접 리스트에서 순환정점 찾는 함수
    // 매개변수 : 현 정점
    static int searchCircleDot(int num){
        int resNum = 0;

        for (int i = 1; i<=n; i++){
            // 연결이 되어있지 않다면 패스
            if (adjMatrix[num][i] != 1)
                continue;

            if (set.contains(i)){
                disFromCircle[num] = 0;

                if (i == num)
                    return -i;
                return i;
            }

            // 지나갔다는 표시를 해주고 진행한다.
            set.add(i);
            adjMatrix[num][i] = 2;
            adjMatrix[i][num] = 2;
            // 결과값에 따라서 순환선 내부에 있는지 확인할 수 있으므로
            // 순환선으로 부터 거리 값을 적절하게 바꿔준다.
            resNum = searchCircleDot(i);
            if (resNum > 0){
                disFromCircle[num] = 0;
                if (resNum == num){
                    return -resNum;
                }

                return resNum;
            }
        }

        return resNum;
    }

    // 순환선으로부터 거리를 구하는 함수
    // 매개변수 : 현 정점
    static void setDistance(int num, int distance){
        disFromCircle[num] = distance;

        for (int i = 1; i<=n; i++){
            // 연결되어있지 않다면 생략
            if (adjMatrix[num][i] == 0)
                continue;

            // 지나갔다는 표시를 해주고
            adjMatrix[num][i] = 0;
            adjMatrix[i][num] = 0;

            // 다음 정점이 순환선으로부터 멀어지는지 여부에 따라 적절한 값을 넘겨준다.
            if (disFromCircle[i] == 0){
                setDistance(i, 0);
            }else{
                setDistance(i, distance+1);
            }
        }
    }
}
