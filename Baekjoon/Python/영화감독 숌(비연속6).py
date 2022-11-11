#6이 연속으로 3개가 나와야 하는 숫자를 구해야하는데..
#연속과 상관없이 그냥 6이 3개 들어가는 숫자를 구해버렸다.. 수박..
#놀랍게도 연속6보다 비연속6이 더 짧은 코드가 나왔다..;

#8자리 숫자에 대한 종말의 숫자는 계산하지 않겠다.
#7자리 숫자 내에서 10,000개의 종말의 숫자가 모두 나오기 때문
#일의 자리를 [0]에 넣을 것이다. 출력할 때는 편하지만 볼때는 반대로 보인다.
number = [6,6,6,0,0,0,0]
count = 1       #number가 가진 숫자가 몇 번째 종말의 숫자인지
plus_pos = 3    #숫자를 증가시킬 자리 수, 1이면 10의 자리가 된다.
save_num = 1665 #부르트포스일때 사용

#올림 시켜주는 함수, 마지막으로 계산을한 자리를 반환한다.
def ceil(pos):
    number[pos] = 0
    
    pos+=1
    if number[pos]==9: return ceil(pos)
    else: 
        number[pos]+=1
        return pos

#바뀐 숫자가 6과 관련(6이 되거나 6이였다면)되었다면 숫자를 조정해야한다.
#반환 값은 다음에 증가시킬 숫자의 위치(수정할 plus_pos의 값)
#혹은 -1(조건에 만족하지 않은 경우)
def adjust_six(pos):
    #605966(다음 수는 606006)의 경우
    if number[pos]==6:
        for i in range (pos-1,-1,-1):
            if number[i]==6:
                number[i]=0
                return i

    #60696의 경우에 사용, 666699이면(count_six(pos)>=3인 경우) 지나친다.
    elif number[pos]==7 and count_six(pos)<3:
        for i in range (0,pos):
            if number[i]==0:
                number[i]=6
                return i+1

    return -1

def count_six(pos):
    count = 0
    
    for i in range(pos+1,len(number)):
        if number[i]==6: count+=1

    return count

#
def cal(num):
    count_six = 0
    
    while num>=1:
        if num%10==6: count_six+=1
        num=int(num/10)

        if count_six>=3:
            return 1
    return 0

#n = int(input())
    
while True:
    if number[plus_pos]==9: #올림이 있는 경우
        temp = adjust_six(ceil(plus_pos))
        if temp!=-1: plus_pos=temp
        
    else: #올림이 없는 경우
        number[plus_pos]+=1
        if plus_pos!=0:
            temp = adjust_six(plus_pos)
            if temp!=-1: plus_pos=temp

    count+=1
    temp2 = 0
    for i in range(0,len(number)):
        temp2 += (10**i)*number[i]
    print(count, "번째 :",temp2)
    
##1씩 숫자를 올려서 종말의 숫자인지 확인하는 확실한 방법(브루트 포스라고 한다.)
    for i in range (save_num+1, 1000000):
        if cal(i)==1:
            save_num = i
            if temp2 ==i: print("정답!", i)
            else: print("오답!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
            break

    



