def answer(numString, repeat):
    if len(numString) == 1:
        if numString in ('3','6','9'): print(repeat, "\nYES")
        else: print(repeat, "\nNO")
        return
    
    num_sum = 0
    for i in numString: num_sum += int(i)
    return answer(str(num_sum), repeat+1)

num = answer(input(), 0)

# 처음에는 3,6,9 에 대한 고려를 하지 않아서 틀려 현재의 코드로 수정하였다.