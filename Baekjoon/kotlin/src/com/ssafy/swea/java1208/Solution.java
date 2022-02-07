// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh

package com.ssafy.swea.java1208;

import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스가 10개로 고정
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            // 문제가.. 특이하다.? 이진탐색인 줄 알았는데 아닌것 같다..


            // 입력 및 초기화
            int dump = sc.nextInt();
            sc.nextLine();
            int[] boxs = new int[100];
            String[] inputs = sc.nextLine().split(" ");
            for(int i = 0; i<100; i++) {
                boxs[i] = Integer.parseInt(inputs[i]);
            }

            // 정렬을 한 후
            Arrays.sort(boxs);
//			System.out.println(Arrays.toString(boxs));
            int bottom = boxs[0], top = boxs[99];

            // 작업이 가능하면서 최대 높이 차가 1이 아닐 때 까지 진행한다.
            int addBoxIdx = 0, popBoxIdx = 99;
            while(dump > 0 && bottom+1 < top) {

                // 가장 높은 상자들을 낮은 곳으로 옮기는데
                // 들어올린 상자가 있는 인덱스-1 의 상자 높이가 들어올린 상자가 있는 인덱스와 원래 높이가 같았다면 그대로 작업을 진행하고
                if (boxs[popBoxIdx-1] == boxs[popBoxIdx]--) {
                    popBoxIdx--;
                }else { // 그렇지 않다면 다시 맨뒤(인덱스 99)로 돌아간다. (최대 높이가 한 칸 내려갔을 때 들어오는 블록)
                    popBoxIdx = 99;
                    top--;
                }

                // 내린 상자가 있는 인덱스+1 의 상자 높이가 내린 상자가 있는 인덱스와 원래 높이가 같았다면 그대로 작업을 진행하고
                if (boxs[addBoxIdx]++ == boxs[addBoxIdx+1]) {
                    addBoxIdx++;
                }else { // 그렇지 않다면 다시 맨앞(인덱스 0)으로 돌아간다. (최소 높이가 한 칸 올랐을 때 들어오는 블록)
                    addBoxIdx = 0;
                    bottom++;
                }

                dump--;
            }

            System.out.printf("#%d %d\n", test_case, top-bottom);
        }
    }
}


