import math

def solution(N):
    sqrt = int(math.sqrt(N))
    answer = 0
    
    if sqrt**2 == N:
        answer += 1
        sqrt -= 1
    
    for num in range(sqrt,0,-1):
        if N % num == 0:
            answer += 2
    
    return answer
