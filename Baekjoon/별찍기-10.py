n=int(input())
temp=n
k=0
while temp!=1:
    temp=int(temp/3)
    k+=1
li=[0 for _ in range(k)]

i=0
while i!=n:
    ns=0
    for x in range(n):
        if ns==0:
            y=len(li)-1
            while y>-1:
                if li[y]==1 and int(x/3**y)%3==1:
                    ns=3**y
                    break
                y-=1

        if ns==0:
            print("*",end="")
        else:
            print(" ",end="")
            ns-=1
    print("")
    
    x=0
    while x<len(li):
        if li[x]!=2:
            li[x]+=1
            break
        else:
            li[x]=0
            x+=1
            
    i+=1
