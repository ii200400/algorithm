def solution(A):
    dic = dict()
    
    for num in A:
        dic[num] = dic.get(num, 0) + 1
    
    for key, val in dic.items():
        if val % 2 == 1: 
            return key
