#1. 모든 경우의 종말의 수
##count = 0
##for i in range (666,10000000):
##    num_len = 0
##    temp=i
##    while temp>=1:
##        temp=int(temp/10)
##        num_len+=1
##
##    for o in range(0,num_len-2):
##        if int(i%(10**(o+3))/(10**o))==666:
##            count+=1
##            print(count,"번째 :",i)
##            break

#2. 내가 만든 알고리즘을 부르트포스로 채점하는 코드
###비연속6보다 조건을 이해하기 쉬운편이다.
###10,000,000 미만의 숫자들로 1만번째 종말의 숫자가 나온다.
###1만번째 종말의 숫자는 2666799이다.
##
###number는 자리수를 기억하기 위한 배열, num_pos는 666의 위치이다.
###number가 [0,0,1,0,0,0,0]이고 num_pos=0이면10666
###[0,0,1,0,0,0,0] 이고 num_pos=1이면16660이다
##number = [0,0,0,0,0,0,0]
##count = 1
##six_pos = 0
##plus_pos = 1
##num_len=len(number)
##
##save_num = 666
##
###ceil은 올림이라는 의미 699->700같은 수 계산에 사용한다.
###반환하는 것은 계산을 한 마지막 자리의 위치 위의 예시에서는 2(100의자리)이다.
##def ceil(pos):
##    number[pos]=0
##    pos+=1
##
##    if number[pos]==9: return ceil(pos)
##    else:
##        number[pos]+=1
##        return pos
##    
###숫자 배열인 number를 int형으로 바꾸는 작업
##def real_number():
##    real_number = ""
##    
##    for i in range (num_len):
##        if i!=six_pos:
##            real_number=str(number[i])+real_number
##        else:
##            real_number="666"+real_number
##            
##    return int(real_number)
##    
###부르트포스에서 쓰인다. 666이 들어가있는지 알아보는 함수
##def is_number_correct(num,num_len):
##    for o in range(0,num_len-2):
##        if int(i%(10**(o+3))/(10**o))==666:
##            return True
##
##    return False
##
##n = int(input())
###True를 n!=count로 나중에 바꾸자
##while True:
##    #숫자를 더할 때 올림이 있는 경우
##    if number[plus_pos]==9:
##        temp = ceil(plus_pos)
##
##        #6669의 경우, 666999(다음 수는 667666)의 경우 등등 필요
##        if temp==six_pos:
##            for i in range(1,3):
##                if temp-i==0: break
##                else:
##                    number[temp-i+1]=6
##                    number[temp-i]=7
##            six_pos=0
##            plus_pos=1
##
##        #6659666의 경우에 사용된다.(함정은 1만번째 이내에 이런 숫자 안 나온다..)
##        elif num_len-temp>=3 and temp>six_pos and number[temp]==6 and number[temp+1]==6 and number[temp+2]==6:
##            six_pos=temp+2
##            plus_pos=0
##            number[six_pos-1]=0
##            number[six_pos-2]=0
##                
##    else: # 올림이 없는 경우
##        number[plus_pos]+=1
##        
##        if number[plus_pos]==6 and plus_pos-1==six_pos:
##            #665666에서 다음 숫자를 위한 조건식
##            if num_len-plus_pos>=3 and number[plus_pos+1]==6 and number[plus_pos+2]==6:
##                six_pos=plus_pos+2
##                number[six_pos-1]=0
##                number[six_pos-2]=0
##                plus_pos=0
##            #65666에서 다음 숫자를 위한 조건식
##            elif num_len-plus_pos>=2 and number[plus_pos+1]==6:
##                six_pos=plus_pos+1
##                number[six_pos-1]=0
##                plus_pos=0
##            #6669에서 다음 숫자를 위한 조건식
##            else:
##                six_pos=plus_pos
##            
##            plus_pos=0
##
##    count+=1
##    real_num=real_number()
##    print(count,"번째 :",real_num)
##    #1씩 올리면서 답을 구하는 방법인 무식한 방법, 채점용이다.
##    for i in range(save_num+1,10000000):
##        num_len = 0
##        temp=i
##        
##        while temp>=1:
##            temp=int(temp/10)
##            num_len+=1
##            
##        if is_number_correct(i,num_len):
##            save_num=i
##            if i==real_num: print("정답!!")
##            else: print("오답!!!!!!!!!!!!", i)
##            break

#3. 백준에 제출할 용도 / 정답!
number = [0,0,0,0,0,0,0]
count = 1
six_pos = 0
plus_pos = 1
num_len=len(number)

def ceil(pos):
    number[pos]=0
    pos+=1

    if number[pos]==9: return ceil(pos)
    else:
        number[pos]+=1
        return pos
    
def real_number():
    real_number = ""
    
    for i in range (num_len):
        if i!=six_pos:
            real_number=str(number[i])+real_number
        else:
            real_number="666"+real_number
            
    return int(real_number)

n = int(input())

while n!=count:
    if number[plus_pos]==9:
        temp = ceil(plus_pos)
        
        if temp==six_pos:
            for i in range(1,3):
                if temp-i==0: break
                else:
                    number[temp-i+1]=6
                    number[temp-i]=7
            six_pos=0
            plus_pos=1

        elif num_len-temp>=3 and temp>six_pos and number[temp]==6 and number[temp+1]==6 and number[temp+2]==6:
            six_pos=temp+2
            plus_pos=0
            number[six_pos-1]=0
            number[six_pos-2]=0
                
    else:
        number[plus_pos]+=1
        
        if number[plus_pos]==6 and plus_pos-1==six_pos:
            if num_len-plus_pos>=3 and number[plus_pos+1]==6 and number[plus_pos+2]==6:
                six_pos=plus_pos+2
                number[six_pos-1]=0
                number[six_pos-2]=0
                plus_pos=0
            
            elif num_len-plus_pos>=2 and number[plus_pos+1]==6:
                six_pos=plus_pos+1
                number[six_pos-1]=0
                plus_pos=0
            
            else:
                six_pos=plus_pos
            
            plus_pos=0

    count+=1

real_num=real_number()
print(real_num)
    
        
