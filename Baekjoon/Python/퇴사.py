# 문제 링크 : https://www.acmicpc.net/problem/14501
# 제출 공유 링크 : http://boj.kr/547715ffc6b749a0ab81b0ee45c8a284
# 참고로 같은 내용에 데이터 범위만 다른 퇴사2도 통과하였다.

import sys
input = lambda : sys.stdin.readline().rstrip()

n = int(input())
# 기본 입력 저장 (인덱스 크기를 맞추고 예외처리를 위해 앞에 0 추가)
consuls = [0]+[tuple(map(int, input().split())) for i in range(n)]
# 해당 날짜에 가장 많은 이익을 저장
profit = [0 for _ in range(n+1)]

for i in range(1,n+1):
    day_end = consuls[i][0]+i-1
    if (day_end < n+1):
        profit[day_end] = max(profit[day_end], profit[i-1]+consuls[i][1])
    profit[i] = max(profit[i], profit[i-1])

# print(profit)
print(profit[len(profit)-1])
