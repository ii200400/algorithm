def right(s):
    return '.'*(s-1)+'#'+' '
def left(s):
    return '#'+'.'*(s-1)+' '
def al(s):
    return '#'*s+' '
def mid(s):
    return '#'+'.'*(s-2)+'#'+' '

data_num, mod = input().strip().split(' ')
data_num = int(data_num)

li = [[0,0] for _ in range(data_num)]
size = 0
for i in range(data_num):
    s, nums = input().strip().split(' ')
    s = int(s)
    li[i][0], li[i][1] = s, nums
    if s > size: size = s

string = ['' for _ in range(size*2-1)]
for i in range(data_num):
    for num in li[i][1]:
        s = li[i][0]
        h = -1
        if mod == 'BOTTOM':
            for h in range(h+1, (size - s)*2):
                string[h] += '.'*s+' '
        elif mod == 'MIDDLE':
            for h in range(h+1, (size - s)):
                string[h] += '.'*s+' '
                
        for h in range(h+1, h+2):
            if num == '1': string[h] += right(s)
            elif num == '6': string[h] += left(s)
            elif num in ['0', '2', '3', '5', '7', '8', '9']: string[h] += al(s)
            elif num == '4': string[h] += mid(s)
                
        for h in range(h+1, h+1+(s-2)):
            if num in ['1', '2', '3', '7']: string[h] += right(s)
            elif num in ['5', '6']: string[h] += left(s)
            elif num in ['0', '4', '8', '9']: string[h] += mid(s)
                
        for h in range(h+1, h+2):
            if num in ['1', '7']: string[h] += right(s)
            elif num in ['2', '3', '4', '5', '6', '8', '9']: string[h] += al(s)
            elif num == '0': string[h] += mid(s)
                
        for h in range(h+1,  h+1+(s-2)):
            if num in ['1', '3', '4', '5', '7', '9']: string[h] += right(s)
            elif num == '2': string[h] += left(s)
            elif num in ['0', '6', '8']: string[h] += mid(s)
                
        for h in range(h+1, h+2):
            if num in ['1', '4', '7', '9']: string[h] += right(s)
            elif num in ['0', '2', '3', '5', '6', '8']: string[h] += al(s)
                
        if mod == 'TOP':
            for h in range(h+1, h+1+(size - s)*2):
                string[h] += '.'*s+' '
        elif mod == 'MIDDLE':
            for h in range(h+1, h+1+(size - s)):
                string[h] += '.'*s+' '

#테스트 케이스는 통과하지만.. 후우..
for i in range(len(string)):
    print(string[i])

##4 TOP
##5 123
##3 45
##5 7890
##3 6
