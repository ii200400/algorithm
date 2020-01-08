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
        # print(cnt, left_dic, right_dic, left_lead, right_lead)
        if left_lead[0] == right_lead[0] and left_lead[1] > cnt/2 and right_lead[1] > (leng-cnt)/2:
            # print("Y")
            answer += 1
    
    return answer
