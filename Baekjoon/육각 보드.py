# 문제 링크 : https://www.acmicpc.net/submit/12946
# 제출 공유 링크 : 
# 외않됨?

def search(i, j):
    return 1 if board[i][j] == 'X' else 0

l = int(input())
board = [input() for _ in range(l)]

answer = 1 if board[0][0] == 'X' else 0
for i in range(l-1):
    for j in range(l-1):
        answer = max(
            search(i, j) + search(i, j+1) + search(i+1, j),
            search(i, j+1) + search(i+1, j) + search(i+1, j+1),
            answer)
        
print(answer)