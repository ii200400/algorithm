#include <stdio.h>

int main(){
  char str[1000000];
  // scanf("%s", str);
  gets(str);

  int cnt[26] = {0};

  // 'a' 는 97 'A'는 65이다.
  int minus;
  for(int i = 0; str[i] != 0; i++){
    // 대문자인 경우
    if(str[i] < 97){
      minus = 65;
    }else{  // 소문자인 경우
      minus = 97;
    }

    // 각 문자(대소문자 구분없이) 개수 추가
    cnt[str[i] - minus] += 1;
  }

  
  char answer = '?';  // 가장 많은 문자
  int max = 0;        // 가장 많은 문자의 수
  for(int i = 0; i<27; i++){
    // 가장 수가 많은 문자 저장
    if (max < cnt[i]){
      max = cnt[i];
      answer = i + 65;
    }else if(max == cnt[i]){
      // 가장 수가 많은 문자가 여러 개라면 answer는 '?' 
      answer = '?';
    }
  }

  // 정답 출력
  printf("%c", answer);

  return 0;
}