// 문제 링크 : https://www.acmicpc.net/problem/18258
// 제출 공유 링크 : http://boj.kr/74571328011e4630a367ccd2b9610c47
// 백준 큐 2

// c 언어를 공부하기 위해서 풀고 있는 문제 (큐, 덱)

/*
스택 구현할 때 문제점을 생각해서 이번에는 버그 없이 큐를 만들어보겠다.
*/

#include <stdio.h>
#include <stdlib.h>

// 큐에 들어갈 노드
struct node{
  int num;
  struct node *next;
};

// 큐
struct queue{
  struct node *head;  // 가장 오래된 들어간 노드를 가리키는 포인터
  struct node *tail;  // 가장 최근에 들어간 노드를 가리키는 포인터
  int size;
};

// 큐의 다양한 함수들
void push(struct queue *q, int num);
int pop(struct queue *q);
int size(struct queue *q);
int empty(struct queue *q);
int front(struct queue *q);
int back(struct queue *q);

int main(){
  // 명령수
  int n;
  scanf("%d", &n);

  // 큐
  struct queue q = {NULL, NULL, 0};

  // 명령
  char command[6];
  // push 명령시 들어갈 숫자
  int num;
  // 명령수 만큼 반복
  for (int i = 0; i < n; i++)
  {
    scanf("%s", &command);

    if (command[0] == 'p')
    {
      if (command[1] == 'u')
      { // push
        scanf("%d", &num);
        push(&q, num);
      }else{  // pop
        printf("%d\n", pop(&q));
      }
    }else if (command[0] == 's')
    { // size
      printf("%d\n", size(&q));
    }else if (command[0] == 'e')
    { // empty
      printf("%d\n", empty(&q));
    }else if (command[0] == 'f')
    { // front
      printf("%d\n", front(&q));
    }else{  // back
      printf("%d\n", back(&q));
    }
  }

  return 0;
}

// 큐에 노드 추가
void push(struct queue *q, int num){
  struct node *n = (struct node*)malloc(sizeof(struct node));
  n->num = num;
  n->next = NULL;
  
  if (q->size == 0)
  {
    q->head = n;
  }else{
    q->tail->next = n;
  }
  q->tail = n;
  q->size++;
  
}

// 큐에 노드 제거 후 해당 노드의 숫자 반환
int pop(struct queue *q){
  if (q->size == 0)
  {
    return -1;
  }

  struct node *n = q->head;
  int result = n->num;
  q->head = q->head->next;

  // 안넣어도 되는 것 같다.
  // if (q->size == 1)
  // {
  //   q->tail = NULL;
  // }
  
  q->size--;

  free(n);

  return result;
}

// 큐의 크기
int size(struct queue *q){
  return q->size;
}

// 큐가 빈 여부
int empty(struct queue *q){
  if (q->size == 0)
  {
    return 1;
  }else{
    return 0;
  }
}

// 가장 앞(오래된)의 노드 숫자
int front(struct queue *q){
  if (q->size == 0)
  {
    return -1;
  }
  
  return q->head->num;
}

// 가장 뒤(최근) 노드 숫자
int back(struct queue *q){
  if (q->size == 0)
  {
    return -1;
  }

  return q->tail->num;
}