// 문제 링크 :
// [SSAFY 7기] 계절학기 알고리즘 대회 다섯번째 문제
// 나보다 나은 우리

package com.ssafy.swea.contest5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		testCase: for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();	// 사람 수
			int[] studentsAnswer = new int[n];	// 학생별 답안(비트 마스킹)
			int answer = 0;	// 정답지(비트 마스킹)
			int pCnt = 0;	// 문제 수

			// 학생별 답안 및 정답지 초기화
			for (int i = 0; i<=n; i++){
				String st = sc.next();
				pCnt = st.length();

				int sum = 0;
				for(int j = 0; j<st.length(); j++){
					if(st.charAt(j) == 'O'){
						sum += Math.pow(2.0, pCnt-j-1);
					}
				}
				
				if (i != n)
					studentsAnswer[i] = sum;
				else
					answer = sum;
			}

			// bfs에 사용할 큐와 학생 조합(방문채크, 이전에 확인했던 학생조합인지 확인한다.)
			// [학생 조합, 학생 조합으로 만든 정답지에 가장 가깝게 만든 정답배열]
			Queue<int[]> q = new LinkedList<>();
			boolean[] visited = new boolean[(int) Math.pow(2.0, pCnt)];

			// 학생 개인으로 정답지와 같게 만들 수 있다면 1 출력(예외처리, 아래의 bfs로는 1명인 경우를 처리할 수 없다;)
			// 동시에 큐와 학생 조합 초기화
			for (int i = 0; i<n; i++){
				if(studentsAnswer[i] == answer){
					System.out.printf("#%d %d%n", test_case, 1);
					continue testCase;
				}
				
				// 초기화
				int bit = 1<<i;
				q.offer(new int[] {bit, studentsAnswer[i]});
				visited[bit] = true;
			}
			
			int studentCnt = 1; // 학생 수
			while(!q.isEmpty()){
				studentCnt++;

				int size = q.size();
				for (int i = 0; i<size; i++){
					int[] current = q.poll();
					int students = current[0];
					int ansComb = current[1];

					// 비트 마스킹으로 학생 조합 진행
					for (int j = 0; j<n; j++){
						// 이미 이 학생의 도움을 받고 있다면 패스
						if ((students & 1<<j) !=0)
							continue;

						// 학생 추가
						int tempStedents = students | 1<<j;
						// 학생들의 정답지 (복사본)
						int tempAns = ansComb;
						// 정답지와 다른 부분 확인
						int diff = answer ^ ansComb;
						int diff2 = studentsAnswer[j] ^ ansComb;
						for (int k = 0; k<pCnt; k++){
							// 정답지와도 다른데 학생과도 다를 경우 해당 비트를 변화
							if ((diff & 1<<k) != 0 && (diff2 & 1<<k) != 0)
								tempAns ^= (1<<k);
						}

						// 정답지와 같다면 도움을 준 학생수 출력
						if (answer == tempAns){
							System.out.printf("#%d %d%n", test_case, studentCnt);
							continue testCase;
						}

						// 큐에 추가 및 학생 조합 체크
						q.offer(new int[] {tempStedents, tempAns});
						visited[tempStedents] = true;
					}
				}
			}

			// 학생들 모두로도 정답지를 만들수 없다면..
			System.out.printf("#%d %d%n", test_case, -1);
		}
	}
}
