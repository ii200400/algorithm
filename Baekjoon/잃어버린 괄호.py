# 문제 링크 : https://www.acmicpc.net/problem/1541
# 제출 공유 링크 : http://boj.kr/b4e234b20539403886af5cfe935905f3
# 처음에는 머리싸맸는데 알고보니 간단한 알고리즘..

import re

input = input()
nums = list(map(int, re.split('-|\\+', input)))
ops = re.split('\d+', input)[1:-1] # 맨 앞과 뒤는 ''이므로 제외

answer, is_minus = nums.pop(0), False
for i in range(len(nums)):
    if ops[i] == '-': is_minus = True

    if is_minus: answer -= nums[i]
    else: answer += nums[i]

print(answer)