# 문제 링크 : https://www.acmicpc.net/problem/2156
# 제출 공유 링크 : http://boj.kr/2281f47c72c94f85bf7e1a0e95da7f3d
# 도움받은 질문 링크 : https://www.acmicpc.net/board/view/64747

import sys
input = lambda : sys.stdin.readline().rstrip()

# 포도주 양 리스트
n = int(input())
amounts = [int(input()) for i in range(n)]
max_amt = [0 for i in range(n)]

max_amt[0] = amounts[0]

if n > 1: max_amt[1] = amounts[0] + amounts[1]
if n > 2: max_amt[2] = amounts[2] + max(amounts[0], amounts[1])

for i in range(3, n):
    max_amt[i] = amounts[i] + max(max_amt[i-2], amounts[i-1] + max_amt[i-3], amounts[i-1] + max_amt[i-4])

print(max(max_amt))