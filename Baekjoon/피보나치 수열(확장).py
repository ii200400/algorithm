f=int(input())

l=[0,1,1]
get=[]
mul=0
num=1
d=False

if f==0:
    print(0)

elif f<0:
    print(-1)

else:
    print(1)

while True:
    if d==False:
        if num-1==f:
            print(l[len(l)-3]%1000000000)
            break
        elif num==f:
            print(l[len(l)-2]%1000000000)
            break
        elif num+1==f:
            print(l[len(l)-1]%1000000000)
            break
    else:
        if num-1==f:
            print(get[0]%1000000000)
            break
        elif num==f:
            print(get[1]%1000000000)
            break
        elif num+1==f:
            print(get[2]%1000000000)
            break

    num+=2**mul

    if d==False:
        leng=len(l)
        
        l.append(((l[leng-2]*l[mul*3+1]+l[leng-1]*l[mul*3+2])-(l[leng-3]*l[mul*3+1]+l[leng-2]*l[mul*3+2]))%1000000000)
        l.append((l[leng-3]*l[mul*3+1]+l[leng-2]*l[mul*3+2])%1000000000)
        l.append((l[leng-2]*l[mul*3+1]+l[leng-1]*l[mul*3+2])%1000000000)
    
        mul+=1
    else:
        get=[((get[1]*l[mul*3+1]+get[2]*l[mul*3+2]) - (get[0]*l[mul*3+1]+get[1]*l[mul*3+2])%1000000000)
             ,(get[0]*l[mul*3+1]+get[1]*l[mul*3+2])%1000000000
             ,(get[1]*l[mul*3+1]+get[2]*l[mul*3+2])%1000000000]
        
    while num+2**mul>f:
        if d==False:
            get.append(l[len(l)-3])
            get.append(l[len(l)-2])
            get.append(l[len(l)-1])   
        
        d=True
        mul-=1

