// 문제 링크 : https://www.acmicpc.net/problem/10757
// 제출 공유 링크 : http://boj.kr/fa98952d0c05461c8565cccecbb81875
// 백준 큰 수 A+B

// c 언어를 공부하기 위해서 풀고 있는 문제 (기본수학1)

/*
조금 독특하게 풀어서 해설을 남기겠다.
아주아주 긴 숫자이므로 숫자를 저장하는 것들로 만들기 보다는 
문자열로 만드는 것이 좋다고 생각하여 문자열을 활용하여 해결하였다.

'0'가 48, '9'가 57 이고 두 수를 더하면 최대 96~114가 나올 수 있고
이전 자리수(올림)까지 더하면 115까지 가능하다.
수가 올림이 될때('9'를 넘어가는 문자가 될 때)는 58를 빼주고 그렇지 않으면 48을 빼주어서 적절한 문자열이 나올 수 있도록 한다.
수가 올림이 되는지 변수(upper)를 활용해서 저장해준다.

입력받은 두 문자열 중 한 문자열이 더 짧다면
더 긴 문자열의 나머지 부분을 계산하여 출력을 해줄 문자열에 넣어준다.
*/

#include <stdio.h>
#include <string.h>

int main(){
  // '0'가 48, '9'가 57 이다.
  // 숫자인 문자열 3개, 2개는 입력받는 문자열이고 1개는 출력을 위한 문자열
  char a[10001], b[10001], c[10001];
  scanf("%s %s", a, b);

  // 첫번째 문자열과 두번째 문자열의 길이, strlen을 사용하기 위해 string.h 사용
  int lenA = strlen(a), lenB = strlen(b);
  // 출력할 문자열의 길이는 임의로 위의 두 문자열 중 더 깃 것으로 한다.
  int lenC, maxLen;
  char upper = 0;
  if(lenA > lenB){
    maxLen = lenA;
  }else{
    maxLen = lenB;
  }
  lenC = maxLen;

  char temp;  // 임시 문자
  // 두 문자열을 적절히 더하여 출력할 문자열을 채워나간다.
  while(1){
    // 다음 자리로 이동
    lenA--;
    lenB--;
    lenC--;

    // 두 문자열과 올림을 더한다.
    temp = a[lenA] + b[lenB] + upper;
    // 적절하게 올림을 재설정하고 결과를 저장한다.
    if (temp > 105){
      upper = 1;
      c[lenC] = temp - 58;
    }else{
      upper = 0;
      c[lenC] = temp - 48;
    }
    
    // 만약 첫번째 문자열을 모두 더했다면 
    // 두번째 문자열만 출력 문자열에 저장하도록 한다.
    if(lenA == 0){
      while(lenB--, lenC--){
        temp = b[lenB] + upper;
        if (temp > 57){
          upper = 1;
          c[lenC] = temp - 10;
        }else{
          upper = 0;
          c[lenC] = temp;
        }
      }

      break;
    }

    // 만약 두번째 문자열을 모두 더했다면 
    // 첫번째 문자열만 출력 문자열에 저장하도록 한다.
    if(lenB == 0){
      while (lenA--, lenC--){
        temp = a[lenA] + upper;
        if (temp > 57){
          upper = 1;
          c[lenC] = temp - 10;
        }else{
          upper = 0;
          c[lenC] = temp;
        }
      }

      break;
    }
  }

  // 올림이 있다면 먼저 출력을 해준다.
  if(upper){
    printf("%d", upper);
  }
  // 결과를 출력한다.
  for(int i = 0; i < maxLen; i++){
    printf("%c", c[i]);
  }

  return 0;
}