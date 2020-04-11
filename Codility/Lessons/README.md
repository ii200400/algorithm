## Codility 문제 링크
모든 문제는 다른 사람의 도움을 받지 않고 최대한 해결하려고 노력하였다, 때문에 첫번째 코드가 조금 멍청할 수 있다.\

아래의 홈페이지에서 알고리즘을 참고하였다, 물론 스스로 문제를 한번 풀어본 후에만 보았다.
https://www.martinkysel.com/codility-solutions/

Lesson 01 Iterations

1. BinaryGap

+ https://app.codility.com/demo/results/trainingTNRQW5-ZGJ/ (100/100)

Lesson 02 Arrays

1. OddOccurrencesInArray
+ https://app.codility.com/demo/results/trainingSH3MWH-5GA/ (100/100)
  + {특정 값: 특정 값 등장 횟수} 딕셔너리를 만든다.\
  딕셔너리를 전부 읽으면서 홀수인 value를 가진 값을 반환한다.
+ https://app.codility.com/demo/results/trainingRZK5ZA-KQH/ (100/100)
  + 위와 같이 딕셔너리를 활용하지만 딕셔너리에 이미 key값이 존재하면 해당 값을 삭제하는 방식으로 하였다.\
  마지막에는 홀수인 key하나만이 딕셔너리에 남아있게 된다.\
  위의 방법보다 빠른 것으로 미뤄볼 때 리스트와 다르게 딕셔너리는 값을 삭제를 해도 큰 부담이 없는 것 같다.

2. CyclicRotation
+ https://app.codility.com/demo/results/trainingZPZP4F-8N3/ (100/100)
  + 원래는 return A[len(A)-K:] + A[:len(A)-K] 한줄이었다. \
  len(A)-K가 음수여도 잘 되는 것을 확인하였지만 리스트의 길이를 넘는 음수는 생각하는대로 작동하지 않았다.\
  예를들어 A = [1,2,3,4,5], K > 10이면 그냥 [1,2,3,4,5]만 나온다.\
  그래서 위의 코드로 바꾸었다.

Lesson 03 Time Complexity

1. FrogJmp
+ https://app.codility.com/demo/results/trainingCW7GMJ-KGS/ (100/100)
  + 그냥 두 값을 나누고 반올림시키면 된다. 너무 쉬워서 왜 시간복잡도 레슨에 있는지 잘 모르겠다.
  
2. PermMissingElem
+ https://app.codility.com/demo/results/training6PBYPB-ZG3/ (100/100)
  + 1~N까지 더하는 수학 공식으로 한줄에 답을 구할 수 있다.\
  하지만 공식을 몰라도 10줄 내로 구현은 가능하다.

3. TapeEquilibrium
+ https://app.codility.com/demo/results/trainingGXN8UE-5P4/ (100/100)
  + 먼저 왼쪽과 오른쪽의 합을 의미하는 변수를 만들고\
  한칸씩 이동하면서 왼쪽과 오른쪽의 차이값을 구하여 정답을 구한다.

Lesson 04 Counting Elements

1. PermCheck
+ https://app.codility.com/demo/results/training8XJUVM-UBH/ (100/100)
  + 중복이 있다는 생각을 하지 못해서 여러번 시도하였다.\
  딕셔너리에 모든 숫자를 기록하면서 중복이 생기는지 확인하고 마지막에 최대숫자와 숫자들의 갯수가 같은지 확인한다.
  
  (2개월 지나서 다시보니까 참 이런 생각은 어떻게 했나 싶다.)
  
+ https://app.codility.com/demo/results/trainingD5DC9V-M7Q/ (100/100)
  + 딕셔너리에 숫자를 넣을 때 그 숫자가 중복되는지와 주어진 리스트의 길이보다 작은 숫자인지 확인한다.
  
두 가지 모두 크게 다른 점이 없는 알고리즘이기 때문에 속도면에서 큰 차이는 없다.
  
2. FrogRiverOne
+ https://app.codility.com/demo/results/trainingZC97JH-MFH/ (100/100)
  + 평소에 자주 사용하는 알고리즘 방식으로 풀었다.\
  (딕셔너리 사용해서 특정 데이터 수를 세고 조건에 부합하는지 확인하는 방식)
  
3. MaxCounters
+ https://app.codility.com/demo/results/training6KBPXV-49B/ (60/100)
  + N 크기의 리스트를 만들고 숫자를 리스트에 기록하다가 \
  N+1숫자가 나오면 리스트를 모두 0으로 초기화하고 가장 자주나온 숫자는 다른 변수에 기록해둔다.\
  시간복잡도가 너무 커서 좋지 못한 결과가 나왔다.\

+ https://app.codility.com/demo/results/trainingVZ9C3H-32W/ (100/100)
  + 위의 알고리즘 속도 해결하기 위하여 다른 사람의 코드를 참고하여 알고리즘을 구현했다.\
  위와 방법은 같은데 리스트 대신에 딕셔너리를 사용한 점만 다르다.
  
4. MissingInteger
+ https://app.codility.com/demo/results/trainingQQZ5XE-DAS/ (100/100)
  + 리스트를 정렬하고 가장 작은 정수를 찾는 방법으로 해결한 것이다.

+ https://app.codility.com/demo/results/trainingYWAHKV-TMV/ (100/100)
  +  나올 수 있는 숫자만큼의 크기를 가진 리스트를 만들고 list.index() 함수를 활용하여 해결했다.\
  정리할 숫자가 많을 때는 위의 방법보다 확실히 빠르다.
  
Lesson 05 Prefix Sums

1. PassingCars
+ https://app.codility.com/demo/results/trainingHBF72H-YT6/ (100/100)
  + 리스트를 순차적으로 탐색하면서 오른쪽으로 향하는 자동차 수를 센다.\
  왼쪽으로 가는 자동차를 발견하면 이전까지의 오른쪽으로 향하는 자동차의 수를 더한다.
  
2. GenomicRangeQuery
+ https://app.codility.com/demo/results/trainingVFXM53-A2Z/ (62/100)
  + 각 query마다 똑같은 계산을 계속하여서 장렬하게 timeout이 나온 코드이다.\
  이 당시에는 아래에서 사용한 알고리즘 방법인 prefix sum을 몰랐다.  

+ https://app.codility.com/demo/results/trainingBJG6YG-MEU/ (100/100)
  + prefix sum을 사용하였다.\
  위치별로 ACGT의 출현 횟수를 세어서 2차원배열로 기록하여 답을 도출했다.
  
3. MinAvgTwoSlice
+ https://app.codility.com/demo/results/trainingPZ9X7Z-CUW/ (60/100)
  + 모든 구간을 보면서 가장 평균이 적은 것을 찾아보는 알고리즘이다.\
  당연히 O(N\*\*2)을 찍으면서 TIMEOUT ERROR로 낮은 점수를 받았다.

+ https://app.codility.com/demo/results/training3XPJAQ-7C4/ (100/100)
  + 놀랍게도 특별한 알고리즘 없이 O(N)만에 끝내버릴 수 있다.\
  단, 가장 평균이 적은 연속된 숫자의 길이는 항상 2 혹은 3이라는 수학적 증명을 알고 있어야하는데 아래에 링크를 올려두겠다.\
  (전혀 prefix sum 알고리즘을 사용하지 않았는데 잘못된 항목에 들어간 것인지 다른 방식으로 푼 것인지 잘 모르겠다.)\
  [관련 링크](https://github.com/daotranminh/playground/blob/master/src/codibility/MinAvgTwoSlice/proof.pdf)  

4. CountDiv
+ https://app.codility.com/demo/results/trainingGKJKR2-YD3/ (100/100)
  + 특별한 알고리즘 없이 O(1)만에 끝나는데 어디를 봐야지 prefix sum 문제인지 모르겠다..;
  
Lesson 06 Sort

1. MaxProductOfThree
+ https://app.codility.com/demo/results/trainingN72AWN-Y4M/ (100/100)
  + 사실 여러번의 수정 끝에 만든 알고리즘이다.\
  파이썬의 기본 정렬 함수를 사용해서인지 속도는 O(N \* log(N))이다.
  
  + 숫자 리스트가 전부 음수이면 음수 숫자들 중 가장 큰 숫자 3개를,\
  그렇지 않은 경우에는 숫자들을 음수와 양수로 나누고 각각 절댓값이 가장 큰 수 최대 3개씩 가져온다.\
  itertools의 조합 함수를 사용하여서 모든 조합에 대하여 가장 숫자들의 곱이 적은 것을 선택하여 결과값을 도출해냈다.

2. Distinct
+ https://app.codility.com/demo/results/training4X9QYY-UQV/ (100/100)
  + O(N\*log(N)) 혹은 O(N)의 시간복잡도이다.\
  딕셔너리의 특성을 활용해서 중복이 되는 숫자는 자연스럽게 무시하고 마지막에 딕셔너리의 길이를 반환하면 결과값을 쉽게 구할 수 있다.

+ https://app.codility.com/demo/results/trainingW7S5CD-DYR/ (100/100)
  + 위의 코드를 압축하면 이와같이 한줄에 끝낼 수 있다.
  
3. Triangle
+ https://app.codility.com/demo/results/training4WSBKJ-GSN/ (100/100)
  + 입력으로 받은 리스트를 그대로 sort 함수로 정렬해서 가장 큰 숫자가 나머지의 합보다 작은지만 확인한다.
  
  + heap으로 구현하면 조금 더 빠르다.
  
4. NumberOfDiscIntersections
+ https://app.codility.com/demo/results/training82RXXU-YP6/ (100/100)
  + 원이 시작되고 끝나는 지점을 리스트에 저장하고 정렬을 한다.\
  (정렬을 할 때 한 지점에 원의 시작점과 끝점이 겹치면 시작점이 우선되도록 정렬을 한다.)
  정렬된 리스트를 하나씩 읽어오면서 정답을 구한다.
  
  + heap으로 구현하면 조금 더 빠르다.
  
Lesson 07 Stacks and Queues

1. Brackets
+ https://app.codility.com/demo/results/trainingKRE8CX-Q57/ (37/100)
  + 일반적인 스택 알고리즘을 사용해서 풀었다.\
  하지만 예외 처리를 깜빡잊고 하지 않아서 점수를 낮게 받았다.
  
+ https://app.codility.com/demo/results/trainingAXV7X3-2FU/ (100/100)
  + 위의 알고리즘의 버그를 수정한 것이다.\
  열리지도 않은 괄호를 닫으려고 하는지 괄호가 전부 닫혔는지 확인하는 코드를 추가하였다.
  
2. Fish
+ https://app.codility.com/demo/results/trainingD3PU67-W5W/ (100/100)
  + 스택 알고리즘을 기반으로 문제의 조건에 따라서 스택에 데이터를 넣거나 빼도록 하였다.
  + stack[len(stack) - 1] 과 stack[-1]은 같은 결과가 나오는데 까먹고 쓰지 않았다.
  + [참고 코드]https://www.martinkysel.com/codility-fish-solution/ 에서는 내가 쓴 알고리즘에서 추가적으로 변수를 사용하여 풀었는데 좋은 방법인 것 같다.
  
3. Nesting
+ https://app.codility.com/demo/results/training6T7SWW-W7F/ (100/100)
  + 스택이라고 하기에도 무안할 정도이다. 리스트를 사용하지 않고 쉽게 풀 수 있다.
  
4. StoneWall
+ https://app.codility.com/demo/results/trainingTGKPBP-V4E/ (100/100)
  + 처음 문제를 읽을 때는 스택으로 풀어야 할지 난감했지만, 풀고나니 깔끔하게 스택으로 풀수 있고 문제도 신선했다.
  
Lesson 08 Leader

1. Dominator
+ https://app.codility.com/demo/results/trainingD7KBVC-KQF/ (100/100)
  + 딕셔너리에 특정 수를 키로, 수의 인덱스와 출현 빈도 수를 값으로 저장하여 결과값을 구했다.

+ https://app.codility.com/demo/results/trainingJGV4PR-NW8/ (100/100)
  + 위의 알고리즘을 만들고 2달후에 싹 까먹고 다시 만든 알고리즘이다. (더 못 만든 것이 함정이다;)\
  딕셔너리로 특정 수의 출현횟수를 세고 리스트로 해당 수의 인덱스를 하나 저장하였다.
  
2. EquiLeader
+ https://app.codility.com/demo/results/trainingHZTJZJ-R8C/ (88/100)
  + 효율성은 따지지 않고 처음부터 끝까지 왼쪽과 오른쪽의 리더 숫자를 구해서 서로 같은지 확인하는 방법이다.\
  O(N)이라고 검사되었지만 O(N\*\*2)에 가깝다.
  
+ https://app.codility.com/demo/results/training8NQC3T-97X/ (100/100)
  + 전체 리스트의 리더 숫자는 리스트를 둘로 나누었을 때\
  두 부분의 리더 숫자는 전체 리스트의 리더 숫자와 같거나 없을 수 있다는 점을 깨닫고 나서 만든 알고리즘이다.\
  위의 사항을 모르면 심하게 해매고 알기만하면 알고리즘은 쉽게 만들 수 있다.\
  그래서 나도 해매었다;;
  
Lesson 09 Maximum slice problem

1. MaxProfit
+ https://app.codility.com/demo/results/trainingZPUJ8C-VHT/ (100/100)
  + 리스트를 하나씩 읽어오면서 가장 작은 값을 저장하는 동시에 현재 요소값과의 차이를 비교하여\
  가장 큰 차이값을 찾아내는 알고리즘
  
+ https://app.codility.com/demo/results/training623UGQ-7DW/ (100/100)
  + 위와 완전히 같은 알고리즘이지만 다른 사람의 코드를 보고 개행 수를 조금 줄였다.
  
2. MaxSliceSum
+ 링크 (100/100)
  + 내용 서술
  
3. MaxDoubleSliceSum
+ 링크 (100/100)
  + 내용 서술
  
Lesson 10 Prime and composite numbers

1. MinPerimeterRectangle
+ https://app.codility.com/demo/results/trainingQFE98F-9KN/ (100/100)
  + 주어진 숫자의 제곱근에서 가장 가까운 약수를 구하면 답이 빠르게 나온다.
  + 에라테스어쩌구의 체를 이용하면 더 빨라지는 것으로 알고는 있으나 값이 작아서 그냥 전부 0.036초가 나와 시도는 하지 않았다.
  
2. CountFactors
+ https://app.codility.com/demo/results/trainingT8FNEX-QB8/ (100/100)
  + 주어진 숫자의 제곱근에서 숫자 하나씩 탐색하여 모든 약수를 구하였다.
  + 약수를 빠르게 구하는 방법을 찾다가 유클리드 호제법까지 갔는데 최대공약수를 구하는 방법이였다;;
  
+ https://app.codility.com/demo/results/trainingJU3BMC-HCK/ (100/100)
  + 위와 완전히 똑같은 알고리즘이지만 3항 연산자를 사용해서 길이를 조금 줄였다.
  
3. Peaks
+ https://app.codility.com/demo/results/training7TNVRN-H7P/ (45/100)
  + 블록의 크기가 항상 같아야 하는 점을 못 이해해서 계속 틀리고 있었다;;
  
+ https://app.codility.com/demo/results/trainingGHCE7T-54U/ (100/100)
  + 먼저 peak들의 위치를 리스트로 만들고 중앙의 약수부터 위 혹은 아래로 이동하면서 되는 약수 중 가장 큰 것(정확히 말하면 길이//약수)을 반환하는 코드
