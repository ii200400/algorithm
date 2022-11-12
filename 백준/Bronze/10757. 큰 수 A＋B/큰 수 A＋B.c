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