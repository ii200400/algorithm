##그냥 피보나치 수열을 만들고 사칙연산을 하면 된다.

def solution(N):
    li = [0 if i > 1 else 1 for i in range(80)]
    for i in range(2,N):
        li[i] = li[i-2] + li[i-1]
    return li[N-1]*4 + li[N-2]*2

##정확성: 66.7
##효율성: 33.3
##합계: 100.0 / 100.0
