def solution(A):
    answer, s = 0, 20001
    
    start = 0
    while start < len(A)-1:
        s_part = A[start]
        
        end = start+1
        while end < len(A):
            s_part += A[end]
            ave = s_part / (end-start+1)
            if ave < s:
                s = ave
                answer = start
                
            end += 1
        start += 1
        
    return answer
