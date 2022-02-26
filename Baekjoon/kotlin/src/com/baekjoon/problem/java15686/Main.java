// 문제 링크 : https://www.acmicpc.net/problem/15686
// 제출 공유 링크 : http://boj.kr/e7679f394c0647be930891ce1879c346

// np에서 부등호 하나 잘못써서 현기증난다..

package com.baekjoon.problem.java15686;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<int[]> houseLoc = new ArrayList<>();  // 집 리스트
        ArrayList<int[]> chickenLoc = new ArrayList<>();// 치킨집 리스트
        
        // 집과 치킨집 초기화
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                int num = sc.nextInt();
                if (num == 1)
                    houseLoc.add(new int[] {i, j});
                else if (num == 2)
                    chickenLoc.add(new int[] {i, j});
            }
        }

        int[] np = new int[chickenLoc.size()];
        for (int i = chickenLoc.size()-m; i<chickenLoc.size(); i++){
            np[i] = 1;
        }

        int minLen = Integer.MAX_VALUE;
        do {
            // 집에서 치킨집까지 거리 초기화
            int[] chickenLen = new int[houseLoc.size()];
            Arrays.fill(chickenLen, Integer.MAX_VALUE);

            for (int i = 0; i<np.length; i++){
                // 열기로 정한 치킨집이라면
                if (np[i] == 1){
                    // 각 집까지의 거리를 구해서
                    for (int j = 0; j<houseLoc.size(); j++){
                        // 작은 값일 때 저장한다.
                        int len = Math.abs(houseLoc.get(j)[0] - chickenLoc.get(i)[0])
                                + Math.abs(houseLoc.get(j)[1] - chickenLoc.get(i)[1]);
                        chickenLen[j] = Math.min(chickenLen[j], len);
                    }
                }
            }

            // 디버깅용 출력
//            System.out.println(Arrays.toString(np));
//            System.out.println(Arrays.toString(chickenLen));

            minLen = Math.min(minLen, Arrays.stream(chickenLen).sum());

        }while (combiNp(np));

        System.out.println(minLen);
    }

    // np를 활용하여 조합 만들기
    static boolean combiNp(int[] arr){
        int i = arr.length-1;
        while(i > 0 && arr[i-1] >= arr[i])
            i--;

        if (i == 0)
            return false;

        int j = arr.length-1;
        while (arr[i-1] >= arr[j])
            j--;

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;
        while(i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }

        return true;
    }
}
