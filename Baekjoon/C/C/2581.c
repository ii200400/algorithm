// 문제 링크 : https://www.acmicpc.net/problem/2581
// 제출 공유 링크 : http://boj.kr/0c2c59dbb5a64b028beafabbf4a639a3
// 백준 소수

// c 언어를 공부하기 위해서 풀고 있는 문제 (기본수학2)

/*
소수찾기는 평소 사용하고 있는 에라토스테네스의 체를 사용한다.
*/

#include <stdio.h>
#include <math.h>

int main(){
  // m 이상 n이하 자연수 중 소수 찾기
  int m, n;
  scanf("%d\n%d", &m, &n);

  // C언어는 bool형이 없으므로 char형에 1로 초기화한다.
  char prime[10001];
  // 0과 1은 소수가 아니므로 생략
  for(int i = 2; i<10001; i++){
    prime[i] = 1;
  }

  // m의 제곱근까지만 탐색해도 충분히 m 이내의 소수를 구할 수 있다.
  int limit = sqrt(n);
  for (int i = 2; i <= limit; i++)
  {
    for (int j = 2; i*j <= n; j++)
    {
      prime[i * j] = 0;
    }
  }

  // m~n사이의 최소 소수, m~n사이의 소수 합
  int min = -1, sum = 0;
  // 최소 소수가 가장 나중에 탐색되도록 큰 수부터 탐색한다.
  for (int i = n; i >= m; i--)
  {
    // 소수를 찾앗다면 합산해주고 min에 저장한다.
    if(prime[i]){
      sum += i;
      min = i;
    }
  }
  
  // m~n 사이에 소수가 없다면
  if (min == -1){
    printf("-1");
  }else{  // 있다면
    printf("%d\n%d", sum, min);
  }
  

  return 0;
}