from collections import Counter

def solution(A):
    count = 0
    left_dic = Counter([])
    right_dic = Counter(A)
    
    A.pop()
    cnt = 0
    for num in A:
        left_dic[num] += 1
        right_dic[num] -= 1
        cnt += 1
        
        if left_dic
