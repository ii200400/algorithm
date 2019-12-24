def solution(N):
    answer = 0
    isOne = False
    
    count = 0
    while N > 0:
        N, rest = divmod(N,2)
        if rest:
            isOne = True
            
            if count > answer:
                answer = count
            count = 0
            
        elif isOne:
            count += 1
            
    return answer
