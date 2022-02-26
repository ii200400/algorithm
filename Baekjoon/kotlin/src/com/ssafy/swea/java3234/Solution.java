// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWAe7XSKfUUDFAUw

// 시간초과가 자꾸 난다.
// 잔머리를 굴려서 왼쪽에 올리는 경우는 그냥 순열을 계산해서 더하고 진행해 보겠다.

// 아니였다, 위의 방법은 구현이 불가능했고 퍼득 np가 생각나서 해보니 되었다.
// np 해보라고 주신 문제같다.

package com.ssafy.swea.java3234;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{

	static int n, answer;
	static int[] weights;
	static boolean[] isSelected;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 초기화
			n = sc.nextInt();	// 추의 수
			weights = new int[n];	// 각 추의 무게
			// 추 배열 초기화
			for (int i = 0; i<n; i++){
				weights[i] = sc.nextInt();
			}
			answer = 0;	// 문제의 조건에 맞는 경우의 수

			// np를 활용하여 구현
			Arrays.sort(weights);
			do{
				subset(0, 0, 0);
			}while (nextPermutation());


			// 추 시뮬레이션 시작 (시간초과)
//			isSelected = new boolean[n];	// 추 사용 여부
//			dfs(0, 0, 0);

			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	static boolean nextPermutation(){
		// 다음 교환이 필요한 숫자(i-1)를 찾고 (처음으로 수가 감소하는 구간의 왼쪽 숫자가 교환할 숫자이다, 꼭대기를 찾으라고 가르쳤다.)
		int i;
		for (i = n-1; i>0; i--){
			if (weights[i-1]<weights[i])
				break;
		}

		// 모든 순열을 탐색했다면 false 반환
		if (i == 0)
			return false;

		// 위에서 찾은 숫자보다 큰 수 하나를 해당 수보다 오른쪽에서 찾는다. (과정을 보면 무조건 나온다.)
		int j;
		for (j = n-1; i<j; j--){
			if (weights[j] > weights[i-1])
				break;
		}
		// 두 수를 교환하고
		int temp = weights[i-1];
		weights[i-1] = weights[j];
		weights[j] = temp;

		// 첫번째 찾은 수의 오른편에 있는 숫자들을 내림차순으로 바꾼다. (과정을 보면 해당 수들은 무조건 오름차순이다.)
		j = n-1;
		while(i<j){
			temp = weights[i];
			weights[i] = weights[j];
			weights[j] = temp;

			i++;
			j--;
		}

		return true;
	}

	// 부분집합을 만드는 메서드
	// 왼쪽에 올릴 추와 오른쪽에 올릴 추를 선택한다.
	static void subset(int cnt, int lWeight, int rWeight){
		if (cnt == n){
			answer++;
			return;
		}

		// 왼쪽에 추를 올려보고
		subset(cnt+1, lWeight+weights[cnt], rWeight);
		// 이번에는 추가 고장나지 않는다면 오른쪽에도 추를 올려본다.
		if (lWeight >= rWeight+weights[cnt])
			subset(cnt+1, lWeight, rWeight+weights[cnt]);
	}

	// 순열에 부분집합이 섞인듯한..? 그런.. 메서드
	// 시간초과로 통과를 못하였다.
	static void dfs(int cnt, int lWeight, int rWeight){
		// 추를 모두 올려놓았다면
		if (cnt == n){
			// 경우의 수 +1 한 후 돌아간다.
			answer++;
			return;
		}

		//
		for (int i = 0; i<n; i++){
			// 이미 선택되었다면 다른 추를 선택한다.
			if (isSelected[i])
				continue;

			// 추를 사용해보고
			isSelected[i] = true;

			// 추를 왼쪽에 올려본다.
			dfs(cnt+1, lWeight+weights[i], rWeight);
			// 오른쪽에 올려도 괜찮다면 오른쪽에도 올려본다.
			if (lWeight >= rWeight+weights[i])
				dfs(cnt+1, lWeight, rWeight+weights[i]);

			// 다시 돌려 놓는다.
			isSelected[i] = false;
		}
	}
}
