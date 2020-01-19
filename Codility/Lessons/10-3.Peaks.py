import math

def solution(A):
    peak_list = [0 for i in range(len(A)//2)]
    peak_index = 0
    isup = False
    
    for index in range(1,len(A)):
        if A[index-1] == A[index]:
            isup = False
        elif  A[index-1] < A[index]:
            isup = True
        elif isup == True:
            peak_list[peak_index] = index - 1
            peak_index += 1
            isup = False
    
    if peak_index == 0:
        return 0
    
    peak_list = peak_list[:peak_index]
    # 탐색한 길이 중 답이 될 수 없는 가장 긴 길이
    mi = (len(A)-1)//peak_index
    # 탐색한 길이 중 답이 될 수 있는 가장 짧은 길이, 변수 mi보다는 크다.
    ma = len(A)
    while mi+1 != ma:
        mid = (mi+ma)//2
        temp = -1
        for num in peak_list:
            if temp == num//mid:
                continue
            elif temp+1 == num//mid:
                temp += 1
            else:
                break
            
        # print(mi, ma, temp)
        if temp == math.ceil(len(A)/mid)-1:
            ma = mid
        else:
            mi = mid
            
    return math.ceil(len(A)/ma)
