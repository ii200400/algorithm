// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD

// 그냥 bfs를 사용하는데 스택 오버플로우가 난다..
// 검색해서 찾아봤더니 다른 사람들도 bfs를 쓰는데..??? 뭐지..?

/*

if (!called[j] && adjMatrix[current][j]){
	~~~
}

을

if (called[j] || !adjMatrix[current][j])
	continue;

로 바꾸었더니 된다..
하하하하ㅏㅎ.ㅎ.ㅎ???
뭘까? 뭐지?? 무슨일이지?

 */

package com.ssafy.swea.java1238;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case= 1; test_case <= T; test_case++) {
			boolean[][] adjMatrix = new boolean[101][101]; // 인접행렬 부여 숫자가 1부터 시작하므로
			int linkNum = sc.nextInt();	// 간선의 수
			int maxIdx = sc.nextInt();	// 동시에 연락을 한 사람 중 가장 부여 숫자가 큰 수 (비상 연락망을 가진 사람의 부여숫자로 초기화)

			// 인접행렬 초기화
			for (int i = 0; i<linkNum; i+=2){
				adjMatrix[sc.nextInt()][sc.nextInt()] = true;
			}

			boolean[] called = new boolean[101]; // 이전에 전화를 받은 적 있는 사람인지 확인
			called[maxIdx] = true; // 비상연락망을 가진 사람은 이미 전화를 받았다고 한다.

			// bfs 시작
			Queue<Integer> q = new LinkedList<>();
			q.add(maxIdx);

			// 큐가 빌때까지 전화를 한다.
			while(!q.isEmpty()){
				maxIdx = q.peek();	// 다시 초기화를 한다.

				// 연락이 가능한 사람들에게 동시에 연락을 한다.
				int qSize = q.size();
				for (int i = 0; i<qSize; i++){
					int current = q.poll();
					// 부여 번호를 저장할지 확인한다.
					maxIdx = Math.max(maxIdx, current);

					for (int j = 1; j<101; j++){
						// 전화를 받았거나 연락처가 없다면 패스
						if (called[j] || !adjMatrix[current][j])
							continue;
						
						// 전화했다는 표시를 하고
						called[j] = true;
						// 큐에 저장한다.
						q.add(j);
					}
				}
			}

			// 전화를 받은 사람 중 가장 부여번호가 큰 사람 출력
			System.out.printf("#%d %d\n", test_case, maxIdx);
		}
	}
}
