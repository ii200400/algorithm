# 쉬어가는 문제!
def solution():
    string = input()
    for i in range(len(string)//2):
        if string[i] != string[len(string)-i-1]: 
            return 0
    return 1
    
print(solution())