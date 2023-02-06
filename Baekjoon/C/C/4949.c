// 문제 링크 : https://www.acmicpc.net/problem/4949
// 제출 공유 링크 : http://boj.kr/8a32930f9fb54bdc8fb67158ff788314
// 제출 공유 링크(링크드리스트) : http://boj.kr/9239bafd29534d8a947028237dd7ba66
// 백준 균형잡힌 세상

// c 언어를 공부하기 위해서 풀고 있는 문제 (스택)

/*
스택을 만들고 스택에 링크드 리스트 형식으로 데이터를 이어넣으려고 했는데..
..? 이상하게도.. 링크드리스트용으로 만든 Data 구조체가.. 

음.. 구조체를.. 동적할당하지 않아서 생긴.. 문제임은 확실한데 이해를 못하겠다.
*/


#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// 링크드리스트의 노드 구조체
struct data
{
  char ch;
  struct data *before;
};

// 스택 구조체
typedef struct
{
  struct data *tail;
  int size;
}Stack;

char pop(Stack *stack);
// void push(Stack *stack, struct Data *d);
void push(Stack *stack, char c);

int main(){
  // 스택과 입력받은 문자열 한 줄
  Stack stack;
  char str[101];

  // 종료조건이 만족할 때 까지 반복
  while(1){
    // 문자열 한 줄을 입력 받고 스택을 초기화 한다.
    gets(str);
    stack.tail = NULL;
    stack.size = 0;

    // 종료조건은 점 하나(".")
    if (strlen(str) == 1 && str[0] == '.')
    {
      break;
    }
    
    // 받은 문자열들을 살펴본다.
    int l = strlen(str);
    for (int i = 0; i < l; i++)
    {
      // 여는 괄호가 들어오면 스택에 push
      if (str[i] == '[' || str[i] == '(')
      {
        // ..? 왜 스택에서 tail로 가리키고 있던 d가 아랫줄에 의해서 다시 초기화되버린다..
        // 구조체는.. 만드는 방법이 따로 있나..?
        // Data d = {str[i], stack.tail};
        push(&stack, str[i]);
      }else if(str[i] == ']'){  // 닫는 대괄호가 나왔을 때
        char ch = pop(&stack);

        // 열리는 대괄호와 짝이 맞지 않다면 균형을 이루고 있지 않다.
        if (ch != '[')
        {
          printf("no\n");
          break;
        }
      }else if(str[i] == ')'){  // 닫는 소괄호가 나왔을 때
        char ch = pop(&stack);

        // 열리는 소괄호와 짝이 맞지 않다면 균형을 이루고 있지 않다.
        if (ch != '(')
        {
          printf("no\n");
          break;
        }
      }else if(str[i] == '.'){  // 마지막
        // 모든 괄호의 
        if (stack.size == 0)
        {
          // 짝이 맞다면
          printf("yes\n");
        }else{
          // 그렇지 않다면
          printf("no\n");
        }

        break;
      }
    }
  }

  return 0;
}

// 파라미터의 스택의 노드 값을 반환하고 해당 노드를 버린다.
char pop(Stack *stack){
  if (stack->size == 0)
  {
    return '0';
  }

  struct data *d = stack->tail;
  stack->tail = d->before;
  stack->size--;

  char result = d->ch;
  // free(d);

  return result;
}

// 스택에 노드를 추가
void push(Stack *stack, char c){
  // struct data d = {c, stack->tail};
  struct data *d = (struct data*)malloc(sizeof(struct data));
  d->ch = c;
  d->before = stack->tail;

  stack->tail = d;
  stack->size++;
}


/*
#include <stdio.h>
#include <string.h>

int main(){
  // 스택과 스택의 크기
  char stack[100];
  int size;
  // 입력받은 문자열 한 줄
  char str[101];

  // 종료조건이 만족할 때 까지 반복
  while(1){
    // 문자열 한 줄을 입력 받고 스택을 초기화 한다.
    gets(str);
    size = 0;

    // 종료조건은 점 하나(".")
    if (strlen(str) == 1 && str[0] == '.')
    {
      break;
    }
    
    // 받은 문자열들을 살펴본다.
    int l = strlen(str);
    for (int i = 0; i < l; i++)
    {
      // 여는 괄호가 들어오면 스택에 push
      if (str[i] == '[' || str[i] == '(')
      {
        stack[size] = str[i];
        size++;
      }else if(str[i] == ']'){  // 닫는 대괄호가 나왔을 때
        // 스택의 크기가 0이라면 균형을 이루고 있지 않은 것
        if (size == 0)
        {
          printf("no\n");
          break;
        }

        // 열리는 대괄호와 짝이 맞지 않다면 균형을 이루고 있지 않은 것
        char ch = stack[--size];
        if (ch != '[')
        {
          printf("no\n");
          break;
        }
      }else if(str[i] == ')'){  // 닫는 소괄호가 나왔을 때
        // 스택의 크기가 0이라면 균형을 이루고 있지 않은 것
        if (size == 0)
        {
          printf("no\n");
          break;
        }

        // 열리는 소괄호와 짝이 맞지 않다면 균형을 이루고 있지 않은 것
        char ch = stack[--size];
        if (ch != '(')
        {
          printf("no\n");
          break;
        }
      }else if(str[i] == '.'){  // 마지막
        // 모든 괄호의 
        if (size == 0)
        {
          // 짝이 맞다면
          printf("yes\n");
        }else{
          // 그렇지 않다면
          printf("no\n");
        }

        break;
      }
    }
  }

  return 0;
}
*/