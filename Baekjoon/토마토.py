
# https://www.acmicpc.net/problem/7576

from collections import deque

def solution():
    que = deque() # 경과 일수, 최근 익은 토마토 저장 큐
    row, col = map(int, input().split(" ")) # 토마토 창고 크기 가로 줄 수, 세로 줄 수
    box = [[-1 for _ in range(row+2)] for _ in range(col+2)] # 패딩 1을 준 토마토 창고 초기화

    # 패딩 1을 준 토마토 창고 한 줄 코딩
    # box = [[-1] + list(map(int, input().split(" "))) + [-1] 
    #         if c not in (0,col+1) 
    #         else [-1] * (col+2) 
    #     for c in range(col+2)]

    # 토마토 창고 입력 넣기
    for c in range(col):
        input_box = list(map(int, input().split(" ")))
        for r in range(row):
            box[c+1][r+1] = input_box[r]
            # 이렇게 하는 것보다 박스에 바로 익은 시기를 넣는게 더 빠르다.
            if input_box[r] == 1: que.append([(r+1, c+1), 0]) #(x,y)

    # box에 모든 토마토가 익어있으면 0 반환
    if all_riped_tomato(box): return 0

    while True: # 큐가 남아있지 않을 때 까지
        (x, y), dist = que.popleft()
        for pos in detect(x, y, box):
            que.append([(pos[0], pos[1]), dist+1])

        if len(que)==0: 
            if all_riped_tomato(box): return dist
            else: return -1

def detect(x, y, box):
    # 익게 될 토마토 리스트, for문 순환 보조 변수
    riping, around = [], [(1,0), (-1,0), (0,1), (0,-1)]

    for a in around:
        temp_x, temp_y = x+a[0], y+a[1]
        if box[temp_y][temp_x] == 0:
            riping.append([temp_x, temp_y])
            box[temp_y][temp_x] = 1
    
    return riping

def all_riped_tomato(box):
    for l in box: 
        if 0 in l: return False
    return True

#print(solution())

que = {(1,1), (1,2)}
(a,b),(c,d) = que
print(a,b,c,d)