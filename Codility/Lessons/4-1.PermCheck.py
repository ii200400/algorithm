def solution(A):
    dic = {}
    for num in A:
        dic[num] = dic.get(num, 0) + 1
        if dic[num] > 1:
            return 0
    
    return 1 if max(A) == len(A) else 0

#중복확인을 하지 않아서 시도를 여러번 하였다.
