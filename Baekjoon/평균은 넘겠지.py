for i in range(int(input())):
    l = list(map(int,input().split()))
    ave = sum(l[1:])/l[0]

    cont = 0
    for o in range(1,len(l)):
        if(l[o]>ave): cont+=1
    print("{0:0.3f}%".format(cont*100/(len(l)-1)))
