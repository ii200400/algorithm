# 문제 링크 : https://www.acmicpc.net/problem/3020
# 제출 공유 링크 : http://boj.kr/28bb17486795485ebac44750ab807c88

# 친구가 풀었던 방법을 듣고 만들었다.
# 높이+1 만큼의 크기를 가진 리스트(0은 사용x)를 2개 만들고
# 각 리스트에 종유석과 석순의 높이의 갯수를 기록하도록 만든다.

# 입력을 빠르게 받을 수 있도록 돕는다. 없으면 시간초과
import sys
input = sys.stdin.readline

n, h = map(int, input().split())

# 종유석과 석순의 높이별 갯수를 저장할 리스트 생성
up_stones = [0 for i in range(0, h)]
down_stones = [0 for i in range(0, h)]

for i in range(0, n):
    # 석순부터 입력이 주어진다.
    if i % 2 == 0: down_stones[int(input())] += 1
    else: up_stones[int(input())] += 1

# 장애물 최소 갯수와 이러한 구간의 개수 저장 변수
min, count = int(n/2), 1
# 장애물 갯수
num_obstacle = min
for i in range(1, h):
    # 한칸씩 올라가면서 장애물 개수를 계산한다.
    num_obstacle = num_obstacle - down_stones[i] + up_stones[h-i]

    # 장애물 개수가 이전보다 적으면 갱신시키고
    if min > num_obstacle:
        min = num_obstacle
        count = 1
    # 같으면 count를 증가시킨다.
    elif min == num_obstacle:
        count += 1

print(min, count)