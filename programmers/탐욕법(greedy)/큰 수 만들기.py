##맨 앞 숫자부터 시작하여 해당 숫자와 다음 숫자를 비교해서
##해당 숫자가 작으면 문자열에서 해당 숫자를 빼버리고
##그렇지 않으면 다음 숫자에서 같은 방법을 적용한다.
##"7777"같은 숫자를 대비하여 return을 아래와 같이 하였다.

def solution(number, k):
    loc = 0
    while loc < len(number)-1 and k > 0:
        if number[loc] < number[loc+1]: 
            number = number[:loc] + number[loc+1:]
            k -= 1
            if loc != 0: loc -= 1
        else: loc += 1
    
    return number[:len(number)-k]
