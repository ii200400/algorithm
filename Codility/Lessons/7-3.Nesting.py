def solution(S):
    if len(S) == 0:
        return 1
    
    count = 0
    for char in S:
        if char == '(':
            count += 1
        elif count == 0:
            return 0
        else:
            count -= 1

    if count == 0:
        return 1
    else:
        return 0
