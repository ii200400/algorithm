// 문제 링크 : https://www.acmicpc.net/problem/6603
// 제출 공유 링크 : http://boj.kr/ccacac93ef504da980811f35076be12a

// 부분집합 생각하고 풀었는데 잘 보니까 조합같기도 하다.
// 일단 부분집합을 구한다고 생각하면서 풀었다.

package com.baekjoon.problem.java6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 버퍼
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 초기화
        String[] inputs = br.readLine().split(" ");

        // 0 만 입력될 때까지 반복
        while(!inputs[0].equals("0")){
            // 집합 S (nums 변수) 초기화
            nums = new int[inputs.length - 1];
            for (int i = 1; i<inputs.length; i++){
                nums[i-1] = Integer.parseInt(inputs[i]);
            }
            // 선택 여부 배열 초기화
            isSelected = new boolean[nums.length];

            // 사전순으로 출력해야하기 때문에 정렬
            Arrays.sort(nums);

            dfs(0, 0);
            System.out.println();

            inputs = br.readLine().split(" ");
        }
    }

    static int[] nums;  // 집합 S (로또번호 부호들)
    static boolean[] isSelected;    // 선택 여부들

    static void dfs(int idx, int cnt){
        // 숫자 6개를 선택했다면
        if (cnt == 6){
            // 선택한 숫자들을 출력하고 돌아간다.
            for (int i = 0; i<isSelected.length; i++){
                if (isSelected[i]) System.out.print(nums[i] + " ");
            }
            System.out.println();

            return;
        }

        // 인덱스를 넘었다면 돌아간다.
        if (idx == nums.length) return;

        // idx번째 숫자를 선택하고 진행해보고
        isSelected[idx] = true;
        dfs(idx+1, cnt+1);

        // 선택하지 않고 진행해본다.
        isSelected[idx] = false;
        dfs(idx+1, cnt);
    }
}
