def solution(N, A):
    array = [0 for _ in range(N)]
    
    for i in A:
        if i < N:
            array[i-1] += 1
        else:
            m = max(array)
            array = [m for _ in range(N)]
            
    return array
