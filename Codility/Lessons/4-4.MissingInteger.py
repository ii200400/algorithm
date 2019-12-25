def solution(A):
    A.sort()
    
    answer = 1
    for num in A:
        if num == answer:
            answer += 1
    
    return answer
