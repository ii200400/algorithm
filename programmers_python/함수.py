print("##################  내장함수 ##################")
#https://wikidocs.net/16044

#set(집합) - 정리요망

#https://wikidocs.net/32

#list
print('----------------- list 초기화 -----------------')
l = [i if i%2 else -1 for i in range(20) if i > 5]
print(l)

#dir
print('----------------- dir -----------------')
print('특정 자료형 관련 함수를 보여준다.')
print('dir([1, 2, 3]), dir([]), dir(list)모두 리스트 관련 함수가 나온다.')
print('아래의 help와는 다르게 print(dir(자료형)) 으로 해야 볼 수 있다.')
print(dir([1, 2, 3]))

#help
print('----------------- help -----------------')
print('특정 함수의 사용법과 매개변수의 종류와 의미를 보여준다.')
print('help(print)하면 print 함수에 대한 상세한 정보가 나온다.')
help(print)

#map
print('----------------- map -----------------')
print("['2','3','4','5']의 각 요소들을 특정 함수에 넣어주는 것")
print("list(map(int, ['2','3','4','5']))")
print(list(map(int, ['2','3','4','5'])))
print()
print("list(map(lambda x:int(x)**2, ['2','3','4','5']))")
print(list(map(lambda x:int(x)**2, ['2','3','4','5'])))
print()

#ord, chr / 아스키 코드와 문자
print('----------------- ord chr -----------------')
print("문자를 아스키 코드로(ord), 아스키 코드를 문자로(chr)")
print('a의 아스키 코드')
o = ord('a')
print('아스키 코드 97의 문자')
c = chr(o)
print(o,c)
print()

#range
print('----------------- range -----------------')
print('list(range(0,10,2))')
print(list(range(0,10,2)))
print('list(range(10,0,-1))')
print(list(range(10,0,-1)))
print()

#enumerate
print('----------------- enumerate -----------------')
print("for i, name in enumerate(['body', 'foo', 'bar']):")
for num, name in enumerate(['body', 'foo', 'bar']):
    print(num,name)

#abs
print('----------------- abs -----------------')
print('입력한 숫자의 절대값을 되돌려주는 함수')
print('print(abs(3))')
print(abs(3))
print('print(abs(-3))')
print(abs(-3))
print('print(abs(-1.2))')
print(abs(-1.2))
print()

#all
print('----------------- all -----------------')
print('반복가능한 자료형의 모든 요소가 참이면 True를 반환한다.')
print('참: "python", [1,2,3], 1,-1 등')
print('거짓: "", {}, [], (), 0, None 등')
print('all([1, 2, 3])')
print(all([1, 2, 3]))
print('all([1, 2, 3, 0])')
print(all([1, 2, 3, 0]))
print()

#any
print('----------------- any -----------------')
print('반복가능한 자료형의 어떤 요소라도 참이면 True를 반환한다.')
print('any([1, 2, 3, 0])')
print(any([1, 2, 3, 0]))
print('any([0, ""])')
print(any([0, ""]))
print()

#divmod
print('----------------- divmod -----------------')
print('앞 숫자를 뒷 숫자로 나눈 몫과 나머지를 튜플로 반환')
print('print(divmod(7,3))')
print(divmod(7,3))
print('print(7//3, 7%3)와 같다.')
print(7//3, 7%3)

#sort, sorted (튜플, 리스트를 입력받아서 정렬하고 리스트로 출력해준다.)
print('----------------- sort sorted -----------------')
arr = [3,1,2,7,4]
print('sorted(arr)는 반환값으로 정렬된 리스트를 준다')
print('입력해준 리스트는 메모리에 그대로 있다.')
print('때문에 print(arr)을 하면 정렬되지 않은 리스트가 출력된다')
print('print(sorted(arr))')
print(sorted(arr))
print()

print('print(arr)')
print(arr)
print()

print('arr.sort()는 반환값은 None이지만')
print('넣어준 리스트 자체가 정렬된다.')
print('print(arr.sort())')
print(arr.sort())
print()

print('print(arr)')
print(print(arr))
print()

#input
print('----------------- input -----------------')
print('중간에 띄어쓰기가 있어도 입력을 잘 받는 방법')
print('한 줄의 입력을 받아와서 띄어쓰기마다 나눠서 리스트로 넣는다.')
print('입력하세요:')
a = input().strip().split(' ')
print(a)

print('----------------- 자주 쓰이진 않지만 유용해보이는 함수 -----------------')

#eval
print('----------------- eval -----------------')
print('문자열을 실재로 한 줄의 코드처럼 실행하여 결과값을 보여주는 함수')
print("eval('1+2')")
print(eval('1+2'))
print("eval("'hi' + 'a'")")
print(eval("'hi' + 'a'"))
print("eval('divmod(4, 3)')")
print(eval('divmod(4, 3)'))
print()

#filter
print('----------------- filter -----------------')
print('특정 함수에 참값인 요소만 남긴 리스트를 반환한다.')
print("list(filter(lambda x: x>0, [1, -3, 2, 0, -5, 6])))")
print(list(filter(lambda x: x>0, [1, -3, 2, 0, -5, 6])))
print()

#----------------------------------------------------------------------------
#https://wikidocs.net/33
print("##################  외장함수 ##################")

#math
print('----------------- math 모듈 -----------------')
import math
print("print(dir(math))을 사용하면 math에 대한 외장함수 리스트를 볼 수 있다.")
print("물론 import math를 안 한 상태로 하면 해당변수가 없다고 에러난다.")
print()
print('-최대 공약수-')
print("print(math.gcd(24,28))")
print(math.gcd(24,28))
print()
print('-소숫점 올림-')
print("print(math.ceil(3.14))")
print(math.ceil(3.14))
print()
print("-팩토리얼-")
print("print(math.factorial(5))")
print(math.factorial(5))
print()
print("-제곱근-")
print("print(math.sqrt(25))")
print(math.sqrt(25))
print()

#순열, 조합(itertools)
print('----------------- 순열, 조합(itertools) -----------------')
import itertools
print('itertools만 기억하면 위의 dir함수로 아래의 함수를 찾아낼 수 있다.')

print('[2,3,4]의 순열')
arr = [2,3,4]
print(list(itertools.permutations(arr))) #순열
print('2개씩 조합')
print(list(itertools.combinations(arr,2))) #조합
print()
