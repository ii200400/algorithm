from collections import Counter

def solution(A):
    answer = 0
    left_dic = Counter([])
    right_dic = Counter(A)
    
    cnt = 0
    leng = len(A)
    A.pop()
    for num in A:
        left_dic[num] += 1
        right_dic[num] -= 1
        cnt += 1
        
        left_lead = max(list(left_dic.items()), key = lambda x: x[1])
        right_lead = max(list(right_dic.items()), key = lambda x: x[1])
        print(cnt, left_dic, right_dic, left_lead, right_lead)
        if left_lead[0] == right_lead[0] and left_lead[1] > cnt/2 and right_lead[1] > (leng-cnt)/2:
            print("Y")
            answer += 1
    
    return answer

# 이것도 timeout 된다...
def solution2(A):
    answer = 0
    left_dic = {}
    right_dic = {}
    for num in A:
        right_dic[num] = right_dic.get(num, 0) + 1
    
    cnt = 0
    leng = len(A)
    A.pop()
    
    left_lead, right_lead = None,  None
    for num in A:
        if left_dic.get(num, 0) == 0:
            left_dic[num] = 1
            
            if left_lead == None:
                left_lead = (num, 1)
        else:
            left_dic[num] += 1
            left_lead = max(list(left_dic.items()), key = lambda x: x[1])
            
        right_dic[num] -= 1
        if right_lead == None or right_lead[0] == num:
            right_lead = max(list(right_dic.items()), key = lambda x: x[1])
            
        cnt += 1
        
        print(cnt, left_dic, right_dic, left_lead, right_lead)
        if left_lead[0] == right_lead[0] and left_lead[1] > cnt/2 and right_lead[1] > (leng-cnt)/2:
            print("Y")
            answer += 1
    
    return answer


solution2([i for i in range(100000)])
