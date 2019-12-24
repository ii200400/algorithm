def solution(A, K):
    if len(A) == 0:
        return []
    
    K %= len(A)
    
    return A[len(A)-K:] + A[:len(A)-K]
