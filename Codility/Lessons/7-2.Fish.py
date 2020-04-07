# 정확성 검사의 한 테스트케이스에서 timeout 된 코드
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

# 위와 같은 알고리즘이지만 표현 방법만 다른 것
def solution(A, B):
    stack = []
    for idx in range(len(A)):
        while True:
            if len(stack) == 0:
                stack.append((A[idx], B[idx]))
                break

            if B[idx] == 0 and stack[len(stack) - 1][1] == 1:
                if A[idx] > stack[len(stack) - 1][0]:
                    stack.pop()
                else:
                    break
            else:
                stack.append((A[idx], B[idx]))
                break

    return len(stack)
