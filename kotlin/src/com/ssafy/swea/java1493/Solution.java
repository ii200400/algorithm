// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b-QGqADMBBASw

// 자잔~ 제가 이진탐색으로 아주 빠르게 해결해보겠습니다~
// 와! 정말 즐겁다!

package com.ssafy.swea.java1493;

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();

			// 각 점의 위치를 찾는다.
			int[] num1Point = searchPoint(num1);	// 첫번째 숫자의 위치
			int[] num2Point = searchPoint(num2);	// 두번째 숫자의 위치
			// 새로운 점의 위치
			int[] newPoint = new int[]{num1Point[0] + num2Point[0], num1Point[1] + num2Point[1]};
			// 새로운 점의 숫자가 포함된 대각선으로
			int temp = newPoint[0]+newPoint[1]-1;

			// 새로운 점의 위치를 찾아서 출력한다.
			System.out.printf("#%d %d\n", test_case, temp*(temp+1)/2 - (newPoint[1]-1));
		}
	}

	// 몇 번째 대각선에 포함된 숫자인지 반환한다. 2는 2, 5는 3, 18/19/20/21은 6을 반환한다.
	static int[] searchPoint(int num){
		// 1~141까지의 합은 10011 이었나? 그랫다.
		int start = 1, end = 141;

		// 이분탐색으로 진행한다. 설명은 생략
		while(start < end){
			int mid = start+end >> 1;
			if (num < mid*(mid+1)/2){
				end = mid;
			}else if (num > mid*(mid+1)/2){
				start = mid+1;
			}else{
				start = mid;
				break;
			}
		}

		// 어느 대각선에 포함되었는지 찾았다면
		// 해당 대각선의 가장 아래의 수와 주어진 수를 빼서 나오는 수를 토대로
		int bottomNum = start*(start+1)/2;
		// 위치를 반환한다.
		return new int[]{start-(bottomNum-num), 1+(bottomNum-num)};
	}
}
