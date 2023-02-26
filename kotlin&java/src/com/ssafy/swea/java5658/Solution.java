// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo
// [모의 SW 역량테스트] 보물상자 비밀번호

// JAVA
//언어
//21,876 kb
//메모리
//168 ms
//실행시간
//1,246
//코드길이

// 해시 셋을 이용해서 중복을 없애고
// 16진수임을 나타내는 자바 문법을 활용해서 쉽게 10진수로 바꾸고 정렬해주었다.

package com.ssafy.swea.java5658;

import java.util.Arrays;
import java.util.HashSet;
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
			int n = sc.nextInt();	// 숫자 개수
			int k = sc.nextInt();	// 크기 순서
			String nums = sc.next();	// n개의 16진수 숫자
			HashSet<Integer> set = new HashSet<>();	// 중복제거를 위한 해시셋

			// 으어.. 문자열 자르는 것 잘 못하겠다;; for 문이 최고야
			int mod = n/4;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i<mod; i++){
				for (int j = 0; j<4; j++){
					// 문자열을 잘 모아서
					for (int l = 0; l<mod; l++) {
						sb.append(nums.charAt((i + j*mod + l) % n));
					}

					// 해시셋에 10진수로 변환해서 저장해준다.
					set.add(Integer.parseInt(sb.toString(), 16));
//					System.out.println(sb);
					sb = new StringBuilder();
				}
			}

			// 해시셋에 저장된 값들을 정렬하고
			Integer[] arr = set.toArray(new Integer[0]);
			Arrays.sort(arr);
//			System.out.println(Arrays.toString(arr));
			// k번째 큰 수를 출력한다.
			System.out.printf("#%d %d%n", test_case, arr[arr.length-k]);
		}
	}
}
