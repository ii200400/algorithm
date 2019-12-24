n=int(input())

cnt=0
temp=int(n/3)
while temp!=1:
    temp/=2
    cnt+=1
li=[1 for _ in range(cnt)]

i=0
while i!=n:
    string=""
    x=0
    if i%3==0:
        for y in range(len(li)):
            if li[y]==1:
                li[y]=0
                y-=1
            else:
                li[y]=1
                break

    for y in range(n-i-1):
        string+=" "
        x+=1
    if i%3==0:
        string+="*"
        x+=1
    elif i%3==1:
        string+="* *"
        x+=3
    elif i%3==2:
        string+="*****"
        x+=5
        
    y=len(li)-1
    while y>-1:
        if x==n+i:
            break
        if x%(3*2**(y+1))==3*2**y+i%(3*2**y) and li[y]==1:
            ns=6*2**y-1-2*(i%(2**(y+1)*3)-2**y*3)
            for z in range(ns):
                string+=" "
                x+=1
            if i%3==0:
                string+="*"
                x+=1
            elif i%3==1:
                string+="* *"
                x+=3
            elif i%3==2:
                string+="*****"
                x+=5
            y=len(li)-1
            continue
        y-=1
    while x!=2*n-1:
        string+=" "
        x+=1
    print(string)
    i+=1
