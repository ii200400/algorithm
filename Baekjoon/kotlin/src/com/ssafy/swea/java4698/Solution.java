// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWRuoqCKkE0DFAXt

// 에라테스토네스의 체? 를 활용하여 소수를 구하고...
// 특정 수가 있는지 확인을 해야..한다..(귀찮;)

package com.ssafy.swea.java4698;

import java.util.Arrays;
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
			char specialNum = sc.next().charAt(0);	// 좋아하는 숫자
			int start = sc.nextInt(), end = sc.nextInt();	// 시작과 끝

			boolean[] primes = new boolean[1000001];	// 소수 여부 배열
			Arrays.fill(primes, true);	// 일단은 모두 소수라고 기록하고 아래에서 제외해나간다.
			primes[0] = false;	// 0과 1은 소수가 아니다
			primes[1] = false;

			// 소수가 아닌 숫자를 기록한다. (end 숫자 이후는 볼 필요가 없다)
			for (int i = 2; i<end; i++){
				// i가 소수라면
				if (primes[i]){

					// i를 제외한 i의 배수 모두 소수가 아니라고 기록한다.
					for (int j = i*2; j<1000001; j+=i)
						primes[j] = false;
				}
			}

			int cnt = 0;	// 좋아하는 소수 수
			for (int i = start; i<=end; i++){
				// 소수가 아니면 생략
				if (!primes[i])
					continue;

				// 숫자를 문자로 바꾸고 각 자리를 살펴보는데
				String temp = String.valueOf(i);
				for (int j = 0; j<temp.length(); j++){
					if (temp.charAt(j) == specialNum) {
						// 해당 숫자가 좋아하는 수를 담고있다면 기록한다.
						cnt++;
						break;
					}
				}
			}

			// 특별한 소수 수 출력
			System.out.printf("#%d %d\n", test_case, cnt);
		}
	}
}
