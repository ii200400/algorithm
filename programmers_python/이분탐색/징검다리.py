##이분탐색을 어떻게 해야할지 생각하는데 조금 시간이 걸렸던 문제이다.
##down과 up는 각각 거리를 저장하는 변수인데
##down은 해당 거리 초과하여 바위 사이의 거리를 벌릴 수 있는 경우에만 들어갈 수 있고
##up은 해당 거리 이상으로 바위 사이의 거리를 벌릴 수 없!는 경우에만 저장 가능하다.
##
##down이 5인 경우 바위 사이의 간격은 5*넘게* 벌릴 수 있다는 것을 알 수 있고
##up이 7인 경우에는 바위 사이의 간격이 7이하로 벌릴 수 있다는 의미이다.
##즉, num-1 - down , num - up인 수를 구하면 된다.


def solution(distance, rocks, n):
    rocks.sort()
    temp = 0
    for i in range(len(rocks)):
        save = rocks[i]
        rocks[i] -= temp
        temp = save

    rocks.append(distance-temp)
    
    up = 1000000001
    down = 0
    while down+1 != up:
        count = 0
        betw = 0
        mid = (up+down)//2
        for i in range(len(rocks)):
            betw += rocks[i]
            if betw <= mid: count += 1
            else: betw = 0
        
        if count <= n: down = mid
        else: up = mid
            
    return up

##정확성: 100.0
##합계: 100.0 / 100.0
