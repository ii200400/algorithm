def solution(A):
    left = 0
    right = sum(A)
    answer = 100000000
    A.pop()
    
    for num in A:
        left += num
        right -= num
        cal = abs(left-right)
        
        if cal < answer:
            answer = cal
            
    return answer
