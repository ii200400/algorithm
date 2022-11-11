'''
사람이 리모컨의 고장난 수를 보고 가장 큰 수와 가장 작은 수를 계산할 때와
같은 방식으로 알고리즘을 구현한 것
'''
import math

#math.floor는 소수점 이하는 버린다.
#is_up이 1이면 useable을 아래서 위로 올라가면서 ch의 현 자리의 숫자보다 큰수를
#-1이면 useable을 위에서 아래로 내려가면서 작은 수를 찾는다.
#그러한 수를 못찾으면 -1을 반환
def f(num,is_up):
    sel = -1
    le = len(useable)
    for i in range(math.floor((le-le*is_up+is_up)/2),
                   math.floor((le+le*is_up+is_up)/2),is_up):
        if ((ord(useable[i])-ord(num))*is_up>0):
            sel = useable[i]
            break
    return sel

#i_ch는 ch의 int형일 뿐이다. 쓰이는 경우가 많아서 따로 만들어 놓음.
i_ch = int(input())
ch = str(i_ch)
breaks = int(input())

#쓸 수 있는 버튼인지 확인하기 위한 dictionary, 사용 가능한 버튼만 모아놓은 useable
dic = {"0":1,"1":1,"2":1,"3":1,"4":1,"5":1,"6":1,"7":1,"8":1,"9":1}
useable = [chr(i+48) for i in range(10)]
if (breaks!=0):
    for i in list(input().split()):
        dic[i]=-1
        useable.remove(i)

if (breaks==10): print(abs(100-i_ch))
elif(breaks==9 and useable[0]=="0"):
    temp = abs(i_ch-100)
    if(temp<i_ch+1): print(temp)
    else: print(i_ch+1)
else:
    #쓸 수 있는 버튼 중에서 mi는 가장 작은 수 ma는 가장 큰 수를 담는다.
    mi = useable[0]
    ma = useable[len(useable)-1]
    #bo는 ch에 있는 숫자 중 한 가지라도 고장난 버튼이 있으면 true가 된다.
    #do는 버튼으로 만들 수 있는 ch보다 작은 수 중 가장 큰 수
    #up은 버튼으로 만들 수 있는 ch보다 크지만 가장 작은 수
    bo = False
    do,up = "",""
    
    for i in range(len(ch)):
        if (not bo):
            #키 값을 찾는데 있으면 그것의 값을, 없으면 -1을 반환하도록 한다.
            if (dic.get(ch[i],-1)==1):#누르고자 하는 버튼이 있는 경우
                do += ch[i]
                up += ch[i]
                continue #필요없어 보이는데 무서워서 못 빼겠다.
            else:#누르고자 하는 버튼이 없는 경우
                bo = True
                #do에 들어간 숫자 수정
                for o in range(i,-1,-1):
                    temp = f(ch[o],-1)
                    if (temp!=-1):
                        #수를 찾은 경우 해당 자리 숫자를 찾은 수로 바꿈
                        do = do[:o]+temp+do[o+1:]
                        break
                    else:
                        #수를 못찾은 경우 
                        if (o==0): do = do[1:]          #더이상 볼 숫자가 없으면 자리수 하나를 없앤다.
                        else: do = do[:o]+ma+do[o+1:]   #해당 자리의 숫자를 ma로 바꿈
                #up에 들어간 숫자 수정 do와 기본적으로 비슷하다.
                for o in range(i,-1,-1):
                    temp = f(ch[o],1)
                    if (temp!=-1):
                        up = up[:o]+temp+up[o+1:]
                        break
                    else:
                        #f("0",1) 대신 그냥 mi넣어도 될 것 같은데 무서워서 못 바꾸겠다.
                        if (o==0): up = f("0",1)+mi+up  #더이상 볼 숫자가 없으면 자리수 하나를 늘린다.
                        else: up = up[:o]+mi+up[o+1:]

        else:
            #do에는 누룰 수 있는 가장 큰 수를, up에는 누를 수 있는 가장 작은 수를
            do += ma
            up += mi

    #버튼으로 만들 수 있는 가장 작은 수가 없을 수도 있기 때문에 -500000을 대신 넣어서
    #절대 답이 될 수 없도록 만듦
    if (do==''): do="-500000"
    do = str(int(do))   #이유가 있던것 같은데 왜 이렇게 코딩했는지 기억이 안난다.
    up = str(int(up))
    but_do = i_ch-int(do)+len(do)
    but_up = int(up)-i_ch+len(up)
    but = abs(i_ch-100)
    if (but_do<=but_up and but_do<=but): print(but_do)
    elif (but_up<=but_do and but_up<=but): print(but_up)
    else: print(but)
