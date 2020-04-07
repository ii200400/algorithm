# 스택 알고리즘이라고 해야할지 잘 모르겠다;
def solution(S):
    stack = 0

    for s in S:
        if s == '(':
            stack += 1
        else:
            if stack == 0:
                return 0
            stack -= 1

    return 1 if stack == 0 else 0