r,c = map(int,input().split())
min_w,min_b = 64,64

l = list(input() for i in range(r))
for u in range(r-7):
    for i in range(c-7):
        w,b = 0,0
        for o in range(u,u+8):
            for p in range(i,i+8):
                if ((o+p)%2==0):
                    if(l[o][p]=="W"): b+=1
                    else : w+=1
                else:
                    if(l[o][p]=="W"): w+=1
                    else : b+=1

        if (min_w>w): min_w = w
        if (min_b>b): min_b = b

if (min_w>min_b): min_w = min_b
print(min_w)
