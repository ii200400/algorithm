def solution(A, B):
    C = [(B[i], A[i]) for i in range(len(A))]
    i = 0
    
    while len(C) > 1 and i < len(C):
        #print(C)
        if i == 0:
            i += 1
        elif C[i-1][0] == 1 and C[i][0] == 0:
            if C[i-1][1] > C[i][1]:
                del C[i]
            else:
                del C[i-1]
                i -= 1
        else:
            i += 1
            
    return len(C)
