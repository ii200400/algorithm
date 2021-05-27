# 문제 링크 : https://www.acmicpc.net/problem/6443
# 제출 공유 링크 : 

from itertools import permutations

for i in permutations([1,2,2], 3):
    print(i, end=" ")
