##사실은 up을 10**18+1(기다리는 사람 최대수 * 심사관 최대 심사시간 +1)을 해야하는데 여러번 반복해서
##10**13+1을해도 된다는 것을 알아서 그냥 저 값으로 했다.

def solution(n, times):
    up = 10000000000001
    down = 0
    while down+1 != up:
        mid = (up+down)//2
        count = 0
        for time in times: count += mid//time
            
        if count >= n: up = mid
        else: down = mid
        
    return up
