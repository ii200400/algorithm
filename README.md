## 2021년 11월 3일

#### 프로그래머스 - 코딩테스트 고득점 Kit - 동적계획법(Dynamic Programming)

1. [N으로 표현](https://programmers.co.kr/learn/courses/30/lessons/42895)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1062.kt)
	+ 일반적인 동적계획법(점화식을 코딩으로 구현하는 듯한) 방식으로 풀었다. 

2. [정수 삼각형](https://programmers.co.kr/learn/courses/30/lessons/43105)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/%EB%8F%99%EC%A0%81%EA%B3%84%ED%9A%8D%EB%B2%95/%EC%A0%95%EC%88%98%20%EC%82%BC%EA%B0%81%ED%98%95.py)
	+ 위의 문제를 풀면서 한 번 더 공부하였다, 예전에 코드를 잘 짜놓아서 딱히 변경한 점은 없었다.

## 2021년 11월 2일

#### 백준

1. [가르침](https://www.acmicpc.net/problem/1062)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1062.kt)
	+ [백준 공유 링크](http://boj.kr/b57cd096a921468f99d15eb512f9a28e)
	+ 일반적인 브루트 포스, 백트래킹을 구현하여 해결하는 문제이나   
	  문제조건과 관련하여 개인적으로 조금 더 효율적인 코드를 작성하였다. 

2. [오큰수](https://www.acmicpc.net/problem/17298)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/17298.kt)
	+ [백준 공유 링크](http://boj.kr/aeaf2462588d41d5bb099de2b3a765d6)
	+ 스택을 활용한 큰 수 찾기 문제이다.
	+ 스택 대신 포인터를 활용하는 느낌으로 해결한 사람도 있었다.

## 2021년 10월 27일

면접에 쌍수 수술까지 하니 3주가 날아가있는 마법이..

#### 프로그래머스 - 코딩테스트 고득점 Kit -탐욕법

1. [섬 연결하기](https://programmers.co.kr/learn/courses/30/lessons/42861)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42861.kt)
	+ Union-Find(유니온 파인드)를 활용하여 Kruskal 알고리즘을 구현하여 해결
	+ 이전에 백준 문제 풀이([13244번 Tree](https://github.com/ii200400/algorithm#2021%EB%85%84-8%EC%9B%94-25%EC%9D%BC))를 참고하여 만들었기 때문에 풀이가 비슷하다.

2. [단속카메라](https://programmers.co.kr/learn/courses/30/lessons/42884)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/%ED%83%90%EC%9A%95%EB%B2%95(greedy)/%EB%8B%A8%EC%86%8D%EC%B9%B4%EB%A9%94%EB%9D%BC.py)
	+ 정렬과 우선순위 큐를 활용하여 탐욕법으로 해결

## 2021년 10월 6일

#### 프로그래머스 - 코딩테스트 고득점 Kit - 정렬

1. [K번째수](https://programmers.co.kr/learn/courses/30/lessons/42748)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42748.kt)
	+ 정렬을 할 수 있는지 확인하는 문제로 유추되는 매우 간단한 문제

2. [가장 큰 수](https://programmers.co.kr/learn/courses/30/lessons/42746)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42746.kt)
	+ 정렬 방식을 어떻게 해야할지 고려하는 것이 가장 핵심인 문제   
	  문제는 크게 어렵지 않으나 정렬 방식을 고안하는 것이 꽤 어렵다.

3. [H-Index](https://programmers.co.kr/learn/courses/30/lessons/42747)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42747.kt)
	+ 문제 이해가 조금 난해하여 문제에서 나오는 조건의 특징과 정렬을 이용하여 해결   
	  조건을 파악하는 것이 훨씬 까다로운 문제이며 정렬은 크게 어렵지 않은 문제이다.

#### 프로그래머스 - 코딩테스트 고득점 Kit - 완전탐색

1. [모의고사](https://programmers.co.kr/learn/courses/30/lessons/42840)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42840.kt)
	+ 간단한 완전탐색 문제, 다른 알고리즘 기법은 사용하지 않았다.

2. [소수 찾기](https://programmers.co.kr/learn/courses/30/lessons/42839)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42839.kt)
	+ 에라토스테네스의 체와 완전탐색을 활용하여 해결
	  중복인 수가 많을수록 효율이 크게 떨어지는 알고리즘이지만, 시간초과는 나지 않았다.

3. [카펫](https://programmers.co.kr/learn/courses/30/lessons/42842)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42842.kt)
	+ '모의고사' 문제와 비슷한 간단한 완전탐색 문제

## 2021년 9월 29일

#### 프로그래머스 - 코딩테스트 고득점 Kit - 힙

1. [더 맵게](https://programmers.co.kr/learn/courses/30/lessons/42626)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/%ED%9E%99(heap)/%EB%8D%94%20%EB%A7%B5%EA%B2%8C.py)
	+ 우선순위 큐를 이용하여 풀 수 있는 간단한 문제
	+ 코틀린으로 풀이할 수 있는 방법이 없어 파이썬으로 대체한다.

2. [디스크 컨트롤러](https://programmers.co.kr/learn/courses/30/lessons/42627)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42627.kt)
	+ PriorityQueue를 사용하여 힙을 구현하여 해결

3. [이중우선순위큐](https://programmers.co.kr/learn/courses/30/lessons/42628)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42628.kt)
	+ PriorityQueue를 사용하여 힙을 구현하고 해당 자료형의 함수를 사용하여 간단하게 해결


## 2021년 9월 15일

#### 프로그래머스 - 코딩테스트 고득점 Kit - 스택/큐

1. [기능개발](https://programmers.co.kr/learn/courses/30/lessons/42586)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42586.kt)
	+ 스택을 활용하여 해결

2. [프린터](https://programmers.co.kr/learn/courses/30/lessons/42587)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42587.kt)
	+ 큐를 사용해야 하는 문제 같았지만, 큐의 개념을 사용하되 큐 자료구조를 사용하지는 않았다.

3. [다리를 지나는 트럭](https://programmers.co.kr/learn/courses/30/lessons/42583)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42583.kt)
	+ 큐(bridgeTrucks)를 이용하여 해결

4. [주식가격](https://programmers.co.kr/learn/courses/30/lessons/42584)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/%EC%8A%A4%ED%83%9D%EA%B3%BC%20%ED%81%90/%EC%A3%BC%EC%8B%9D%EA%B0%80%EA%B2%A9.py)
	+ 브루트포스와 큐를 이용하여 두 가지 방식으로 각각 해결
	+ 이전에 풀었던 내용이나 크게 수정할 점이 없어서 그대로 올렷다.

</br>

#### 백준

1. [트리](https://www.acmicpc.net/problem/1068)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1068.kt)
	+ [백준 공유 링크](http://boj.kr/365b2835f3ac40249d01f3f1a31181cb)
	+ 기본적인 트리 구조를 만들어 해결

2. [부분수열의 합](https://www.acmicpc.net/problem/1182)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1182.kt)
	+ [백준 공유 링크](http://boj.kr/cd73038bbfe4447db9886fbc2dd664f6)
	+ 재귀함수를 이용한 백트래킹 + 부르트포스 구현

3. [에디터](https://www.acmicpc.net/problem/1406)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1406.kt)
	+ [백준 공유 링크](http://boj.kr/b806e0de7dc346978494e96857f3fb4d)
	+ 연결리스트로 두개의 스택을 구현하여 커서의 왼쪽/오른쪽 문자열들을 넣고 빼며 해결

4. [카드 정렬하기](https://www.acmicpc.net/problem/1715)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1715.kt)
	+ [백준 공유 링크](https://www.acmicpc.net/source/share/9ea6de9e7bd04fcc83eee14454aa903f)
	+ 우선순위 큐 통해 최소힙으로 풀이, 최소힙으로 풀수 있는 간단한 문제 중 하나

5. [피보나치 수의 확장](https://www.acmicpc.net/problem/1788)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1788.kt)
	+ [백준 공유 링크](http://boj.kr/09e6aa8c0bc642cbb94e7d15c90d3100)
	+ 일반화된 피보나치 수열의 특징을 찾아내어 해결, 분류는 다이나믹 프로그래밍 / 수학


6. [알파벳](https://www.acmicpc.net/problem/1987)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1987.kt)
	+ [백준 공유 링크](http://boj.kr/79700c91e73f41e48be5e8e64217fe05)
	+ 재귀함수를 활용하여 DFS를 구현하여 해결

7. [소수의 곱](https://www.acmicpc.net/problem/2014)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/2014.kt)
	+ [백준 공유 링크](https://www.acmicpc.net/source/share/d1ce5692cb0745199e28e4d7287e2f3a)
	+ 재귀함수를 활용한 완전탐색 구현 + 중복 방지 알고리즘으로 해결

8. [별 찍기 - 10](https://www.acmicpc.net/problem/2447)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/2447.kt)
	+ [백준 공유 링크](http://boj.kr/78b4370e92f645baaf84dc7ee75687b2)
	+ 언제 공백을 출력하고 별을 출력할지 조건을 찾아 해결   
	  알고리즘 분류에는 분할정복과 재귀가 있지만, 본인은 생각도 못했다.

9. [피보나치 수 3](https://www.acmicpc.net/problem/2749)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/2749.kt)
	+ [백준 공유 링크](http://boj.kr/130e3509865040dcb788ecf9d8c21886)
	+ 피보나치 수열의 피사노 주기 특징 숙지 후 해결

10. [토마토](https://www.acmicpc.net/problem/7576)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/7576.kt)
	+ [백준 공유 링크](https://www.acmicpc.net/source/share/cb904e3883ec4fef92efe79204314ce4)
	+ BFS를 이용하여 해결, BFS로 풀 수 있는 간단한 문제이다.

</br>

#### 2022 카카오 신입공채 1차 온라인 코딩테스트

1. 문제1 (링크 추가 요망)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/challenges1.kt)
	+ 해시 2개로 해결

2. 문제2 (링크 추가 요망)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/challenges2.kt)
	+ K진법 변환 알고리즘 및 소수 확인 알고리즘 사용

3. 문제3 (링크 추가 요망)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/challenges3.kt)
	+ 해시 및 간단한 계산 코드로 해결

4. 문제4 (링크 추가 요망)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/challenges4.kt)
	+ 재귀를 통한 완전탐색으로 풀이   
		화살을 어느 과녁에 쏘는지에 탐색하면 최대 10^10 번의 탐색으로 인한 시간초과가 생겨   
		해당 과녁의 점수를 가져가는지 아닌지의 여부로 2^10 번의 탐색으로 바꾸었다.
	  추가로 두 선수의 점수 차이가 가장 크면서 가장 점수가 낮은 과녁을 더 많이 맞춘 배열을 반환하는 독특한 조건으로 인하여   
		재귀의 탐색 순서와 약간의 예외처리를 신경써서 구현하였다.
		
</br>

## 2021년 9월 1일

#### 프로그래머스 - 코딩테스트 고득점 Kit - 해시(Hash) 4문제 중 kotlin 언어를 지원하는 두 문제

1. [위장](https://programmers.co.kr/learn/courses/30/lessons/42586?language=kotlin)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42578.kt)
	+ 순열/조합 수학식을 사용하여 해결
  
2. [베스트앨범](https://programmers.co.kr/learn/courses/30/lessons/42579)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/programmers/kotlin/src/42579.kt)
	+ 해시와 정렬(내림차순)을 사용하여 해결   
    변수의 자료형을 조금 복잡하게 썼다.
  
</br>	
	
## 2021년 8월 25일

#### 백준

1. [1197번 최소 스패닝 트리](https://www.acmicpc.net/problem/1197)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/1197.kt)
	+ [백준 공유 링크](http://boj.kr/d341a35ed1604dcbb430f76004b9b20f)
	+ Prim 알고리즘을 활용하여 최소 스패닝 트리 구현

2. [13244번 Tree](https://www.acmicpc.net/problem/13244)
	+ [풀이](https://github.com/ii200400/algorithm/blob/master/Baekjoon/kotlin/src/13244.kt)
	+ [백준 공유 코드](https://www.acmicpc.net/source/share/9d290605611f4b0ea933b35ab7d8d38c)
	+ Union-Find(유니온 파인드 혹은 Disjoint-set)를 활용하여 Kruskal 알고리즘을 구현하여 해결

  
