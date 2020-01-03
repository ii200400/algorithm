# 정확성 검사에서 한 테스트케이스에서 timeout 된 코드
# 스택은 사용 안하고  전체 리스트에서 하나씩 del하여 만들었다.

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

# 정확성 검사를 통과하는 코드
# 스택을 사용하였다.

def solution(A, B):
    C = []
    for i in range(len(A)):
        #print(C)
        if len(C) == 0 or B[i] == 1:
            C.append((B[i], A[i]))
        elif B[i] == 0:
            while True:
                l = len(C) - 1
                if len(C) == 0 or C[l][0] == 0:
                    C.append((B[i], A[i]))
                    break
                elif C[l][1] > A[i]:
                    break
                else:
                    C.pop()
    
    #print(C)
    return len(C)
