while True:
    s = input()
    if (s!="END"):
        for i in range(len(s)-1,-1,-1):
            print(s[i],end="")
        print()
    else: break
