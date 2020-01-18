def solution(A):
    dic = dict()
    
    for num in A:
        dic[num] = dic.get(num, 0) + 1
    
    for key, val in dic.items():
        if val % 2 == 1: 
            return key

def solution(A):
    dic = dict()
    
    for num in A:
        if dic.get(num, 0) == 0:
            dic[num] = 1
        else:
            del dic[num]
    
    for key in dic.keys():
        return key
