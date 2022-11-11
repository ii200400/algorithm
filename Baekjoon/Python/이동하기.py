# 문제 링크 : https://www.acmicpc.net/problem/11048
# 제출 공유 링크 1 : http://boj.kr/baa515e1db184402a86b1be516a09e76
# 제출 공유 링크 2 : 


# deque쓰는 것을 까먹어서 씬나게 해맷다..
from collections import deque

n, m = map(int, input().split())
# map은 입력된 사탕, candy_map은 해당 위치에서 가질 수 있는 가장 많은 사탕
map = [list(map(int, input().split())) for _ in range(n)]
candy_map = [[0 if(i==0 or j==0) else -1 for j in range(m+1)] for i in range(n+1)]

# 풀이 1
# que = deque([(1,1)])
# while(len(que)!=0):
#     r, c = que.popleft()
#     # print(r,c)
#     if (candy_map[r][c] != -1): continue
#     if (r < n): que.append((r+1, c))
#     if (c < m): que.append((r, c+1))

#     # candy_map을 참고하여 가장 많은 사탕 수를 저장(대각선은 고려 안함)
#     candy_map[r][c] = max(candy_map[r-1][c]+map[r-1][c-1], candy_map[r][c-1]+map[r-1][c-1])

# #print(candy_map)
# print(candy_map[n][m])

# 풀이 2
for r in range(1,n+1):
    for c in range(1,m+1):
        candy_map[r][c] = max(candy_map[r-1][c]+map[r-1][c-1], candy_map[r][c-1]+map[r-1][c-1])

print(candy_map[n][m])