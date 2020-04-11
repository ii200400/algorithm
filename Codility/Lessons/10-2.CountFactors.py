# 주어진 숫자의 제곱근에서 숫자 하나씩 탐색하여 모든 약수를 구하였다.
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

# 위와 완전히 똑같은 알고리즘이지만 3항 연산자를 사용해서 길이를 조금 줄였다.
import math

def solution(N):
    sqrt = int(math.sqrt(N))
    answer = -1 if sqrt ** 2 == N else 0
    for num in range(1, sqrt + 1):
        if N % num == 0:
            answer += 2

    return answer