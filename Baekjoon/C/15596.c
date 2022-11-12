// 문제 링크 : https://www.acmicpc.net/problem/15596
// 제출 공유 링크 : http://boj.kr/16e82dba7cb847fea8c6b718ff7c3e99
// 백준 정수 N개의 합

// c 언어를 공부하기 위해서 풀고 있는 문제 (함수)

long long sum(int *a, int n){
  long long ans = 0;

  for(int i = 0; i<n; i++){
    ans += a[i];
  }

	return ans;
}