#
def solution(S):
    if len(S) == 0:
        return 1
    
    stack = [S[0]]
    for char in S[1:]:
        if char in ['(', '[', '{']:
            stack.append(char)
        elif len(stack) > 0:
            p = stack[len(stack)-1]
            if ((char == ')' and p == '(') or (char == ']' and p == '[') or (char == '}' and p == '{')):
                stack.pop()
        else :
            return 0
    
    if len(stack) == 0:
        return 1
    else:
        return 0

# 위와 같은 코드인데 의도치 않게 짧게 구현하였다.
def solution(S):
    stack = []

    for s in S:
        if s in ['(', '[', '{']:
            stack.append(s)

        elif len(stack) == 0:
            return 0

        elif s == ')' and stack.pop() != '(':
            return 0
        elif s == ']' and stack.pop() != '[':
            return 0
        elif s == '}' and stack.pop() != '{':
            return 0

    return 1 if len(stack) == 0 else 0
