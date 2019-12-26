def solution(S, P, Q):
    length = len(P)
    array = [0 for _ in range(length)]
    
    for num in range(length):
        s = S[P[num]:Q[num]+1]
        
        mini = 5
        for char in s:
            if char == 'T' and mini > 4:
                mini = 4
            elif char == 'G' and mini > 3:
                mini = 3
            elif char == 'C' and mini > 2:
                mini = 2
            elif char == 'A' and mini > 1:
                mini = 1
                break
        
        array[num] = mini
        
    return array
