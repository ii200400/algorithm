// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH

// 재료 선택을 할 때.. 예를 들어
// 재료가 6개 있을 때
// A음식 재료를 1,2,3 / B음식 재료를 4,5,6으로 선택한 것과
// A음식 재료를 4,5,6 / B음식 재료를 1,2,3으로 선택한 것의 차이는 같은데
// 이를 통해서 첫번째 재료는 고정하고 시작해도 된다는 것을 알 수 있다!

package com.ssafy.swea.java4012;

import java.util.HashSet;
import java.util.Scanner;

public class Solution
{
	static int n;		// 재료 수
	static int[][] mix;	// 음식 시너지 배열
	static boolean[] isSelected;	// A음식 재료로 선택 여부
	static int diff;	// 두 음식의 차이의 최소값

	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스 만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 초기화
			n = sc.nextInt();	// 재료 수
			mix = new int[n][n];	// 음식 시너지 배열
			diff = Integer.MAX_VALUE; // 두 음식의 차이의 최소값
			for(int i = 0; i<n; i++){
				for(int j = 0; j<n; j++){
					mix[i][j] = sc.nextInt();
				}
			}

			//=================================================
			// 부분 집합 사용
			
//			isSelected = new boolean[n]; // A음식 재료로 선택 여부
//			isSelected[0] = true;
//			subset(1, 1, 0, 0);
			
			//=================================================
			// 집합 사용 (배열이 아닌 hashset 사용)
			// (미래의 나) 그런데 왜 집합썼었지..? 메모리도 시간도 좋을게 없는데? 호기심이었나..?
			foodIdx1 = new HashSet<>();
			foodIdx1.add(0);

			// 위와 마찬가지로 첫번째 재료는 A음식으로 고정하고 진행
			combi(1, 1);

			// 두 음식의 차이의 최소값 출력
			System.out.printf("#%d %d\n", test_case, diff);
		}
	}

	// 두 음식의 시너지를 계산해야하는 상황상 조합보다는 부분집합 선택
	// A음식 재료로 선택한 재료 수, 현재 선택할 재료의 인덱스, A음식의 시너지, B음식의 시너지
	static void subset(int cnt, int idx, int sum1, int sum2){
		// 모든 재료를 선택했다면
		if(idx == n){
			// 음식의 차이값을 적절하게 저장한 후 다른 조합을 찾아 돌아간다.
			diff = Math.min(diff, Math.abs(sum1-sum2));
			return;
		}

		// 아직 A음식의 재료를 다 못정했다면 (가지치기 1)
		int tempSum;
		if (cnt < n/2) {
			// A음식에 넣어보고
			isSelected[idx] = true;
			// A음식의 시너지를 계산한 후
			tempSum = sum1;
			for (int i = 0; i < idx; i++) {
				if (isSelected[i])
					tempSum += mix[idx][i] + mix[i][idx];
			}
			// 진행해보고
			subset(cnt + 1, idx + 1, tempSum, sum2);
		}
		// B음식에 재료를 모두 정하지 않았다면 (가지치기 2)
		if(idx - cnt < n/2) {
			// B음식에 넣어보고
			isSelected[idx] = false;
			// B음식의 시너지를 계산한 후
			tempSum = sum2;
			for (int i = 0; i < idx; i++) {
				if (!isSelected[i])
					tempSum += mix[idx][i] + mix[i][idx];
			}
			// 진행해본다.
			subset(cnt, idx + 1, sum1, tempSum);
		}
	}

	// 위와 같은 방식으로 조합으로도 해결해본다.
	static HashSet<Integer> foodIdx1;	// A음식 재료들

	static void combi(int cnt, int idx){
		if (cnt == n/2){

			HashSet<Integer> foodIdx2 = new HashSet<>();
			for (int i = 0; i<n; i++){
				if (!foodIdx1.contains(i))
					foodIdx2.add(i);
			}

			diff = Math.min(diff, Math.abs(sum(foodIdx2)-sum(foodIdx1)));
			return;
		}

		for (int i = idx; i<n; i++){
			foodIdx1.add(i);
			combi(cnt+1, i+1);

			foodIdx1.remove(i);
		}
	}

	static int sum(HashSet<Integer> set){
		int sum = 0;

		for (int idx1 : set){
			for (int idx2 : set)
				sum += mix[idx1][idx2];
		}

		return sum;
	}
}