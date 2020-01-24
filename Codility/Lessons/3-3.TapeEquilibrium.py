def solution(A):
    left, right = 0, sum(A)
    answer = 100000000
    A.pop()
    
    for num in A:
        left += num
        right -= num
        cal = abs(left-right)
        
        if cal < answer:
            answer = cal
            
    return answer
