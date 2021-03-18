# https://programmers.co.kr/learn/courses/30/lessons/60063

from collections import deque

def search(loc1, loc2, board):
    can_go = []

    if loc1[0] == loc2[0]: # 드론이 가로일 때
        for m in [1,-1]:
            if board[loc1[0]+m][loc1[1]] == 0 and board[loc2[0]+m][loc2[1]] == 0:
                can_go.append( {(loc1[0]+m,loc1[1]), (loc2[0]+m,loc2[1])}) # 상하로 이동
                can_go.append( {(loc1[0],loc1[1]), (loc1[0]+m,loc1[1])} ) # 왼쪽 기준 회전
                can_go.append( {(loc2[0],loc2[1]), (loc2[0]+m,loc2[1])} ) # 오른쪽 기준 회전
            
            if board[loc1[0]][loc1[1]+m] == 0 and board[loc2[0]][loc2[1]+m] == 0:
                can_go.append( {(loc1[0],loc1[1]+m), (loc2[0],loc2[1]+m)} ) # 옆으로 이동

    else: # 드론이 세로일 때
        for m in [1,-1]:
            if board[loc1[0]][loc1[1]+m] == 0 and board[loc2[0]][loc2[1]+m] == 0:
                can_go.append( {(loc1[0],loc1[1]+m), (loc2[0],loc2[1]+m)}) # 옆으로 이동
                can_go.append( {(loc1[0],loc1[1]), (loc1[0],loc1[1]+m)} ) # 위쪽 기준 회전
                can_go.append( {(loc2[0],loc2[1]), (loc2[0],loc2[1]+m)} ) # 아래쪽 기준 회전

            if board[loc1[0]+m][loc1[1]] == 0 and board[loc2[0]+m][loc2[1]] == 0:
                can_go.append( {(loc1[0]+m,loc1[1]), (loc2[0]+m,loc2[1])} ) # 상하로 이동

    return can_go

def solution(board):
    l = len(board)
    que, visited = deque(), []
    p_board = [
        [1] + board[i-1] + [1] if i not in (0, l+1)
        else [1] * (l+2)
        for i in range(l+2)
    ]
    
    visited.append({(1,1),(1,2)}) #(y,x)
    que.append([{(1,1), (1,2)}, 0])
    while len(que)!=0:
        (loc1, loc2), dist = que.popleft()
        
        for s in search(loc1, loc2, p_board):
            if (l,l) in s: return dist+1

            if s not in visited:
                que.append([s, dist+1])
                visited.append(s) # {(0,0), (1,0)} -> (0,0,1,0)
    
    return 0

board = [[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]
print(solution(board))