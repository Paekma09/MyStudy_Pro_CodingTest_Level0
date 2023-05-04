package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	/*
	[문제 설명]
	1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.
		네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
		세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
		주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
		어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
		네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
	네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
	[제한사항]
	a, b, c, d는 1 이상 6 이하의 정수입니다.
	[입출력 예]
	a	b	c	d	result
	2	2	2	2	2222
	4	1	4	4	1681
	6	3	3	6	27
	2	5	2	6	30
	6	4	2	5	2
	[입출력 예 설명]
	입출력 예 #1
		예제 1번에서 네 주사위 숫자가 모두 2로 같으므로 1111 × 2 = 2222점을 얻습니다. 따라서 2222를 return 합니다.
	입출력 예 #2
		예제 2번에서 세 주사위에서 나온 숫자가 4로 같고 나머지 다른 주사위에서 나온 숫자가 1이므로 
		(10 × 4 + 1)2 = 412 = 1681점을 얻습니다. 따라서 1681을 return 합니다.
	입출력 예 #3
		예제 3번에서 a, d는 6으로, b, c는 3으로 각각 같으므로 (6 + 3) × |6 - 3| = 9 × 3 = 27점을 얻습니다. 
		따라서 27을 return 합니다.
	입출력 예 #4
		예제 4번에서 두 주사위에서 2가 나오고 나머지 다른 두 주사위에서 각각 5, 6이 나왔으므로 5 × 6 = 30점을 얻습니다. 
		따라서 30을 return 합니다.
	입출력 예 #5
		예제 5번에서 네 주사위 숫자가 모두 다르고 나온 숫자 중 가장 작은 숫자가 2이므로 2점을 얻습니다. 따라서 2를 return 합니다.
	*/
	public static void main(String[] args) {
		int a1 = 2;
		int b1 = 2;
		int c1 = 2;
		int d1 = 2;
		int a2 = 4;
		int b2 = 1;
		int c2 = 4;
		int d2 = 4;
		int a3 = 6;
		int b3 = 3;
		int c3 = 3;
		int d3 = 6;
		int a4 = 2;
		int b4 = 5;
		int c4 = 2;
		int d4 = 6;
		int a5 = 6;
		int b5 = 4;
		int c5 = 2;
		int d5 = 5;
		
		System.out.print(a1+" "+b1+" "+c1+" "+d1+" ");
		System.out.println(solution(a1, b1, c1, d1));
		System.out.print(a2+" "+b2+" "+c2+" "+d2+" ");
		System.out.println(solution(a2, b2, c2, d2));
		System.out.print(a3+" "+b3+" "+c3+" "+d3+" ");
		System.out.println(solution(a3, b3, c3, d3));
		System.out.print(a4+" "+b4+" "+c4+" "+d4+" ");
		System.out.println(solution(a4, b4, c4, d4));
		System.out.print(a5+" "+b5+" "+c5+" "+d5+" ");
		System.out.println(solution(a5, b5, c5, d5));
	}
	
	public static int solution(int a, int b, int c, int d) {
		int answer = 0;
		// 4개 주사위의 요소 ArrayList에 담기
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a, b, c, d));
		// 4개 주사위 각각의 요소 중복 카운팅을 하기 위해 HashMap 생성 
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// HashMap의 key(중복 갯수)를 저장하기 위해 List생성
		List<Integer> count = new ArrayList<>();
		// HashMap의 value(요소)를 저장하기 위해 List생성
		List<Integer> num = new ArrayList<>();
		// 3종류의 주사위 요소를 저장할 변수 선언 및 초기화 - 다른 한 종류는 제일 작은 요소가 필요하여 아래의 min 변수로 대체
		int p = 0;
		int q = 0;
		int r = 0;
		// list에서 중복 key 와 빈도수 value 저장 
		for(int number : list) {
			Integer counts = map.get(number);
			if(counts == null) {
				map.put(number, 1);
			}else {
				map.put(number, counts+1);
			}
		}
		// map의 사이즈의 따라 각각의 조건 분기
		if(map.size() == 1) {	// 4개의 주사위가 모두 같을 때
			for(int key : map.keySet()) {
				p = key;
			}
			answer = 1111 * p;
		}else if(map.size() == 4) {	// 4개의 주사위가 모두 다를 때
			for(int key : map.keySet()) {
				num.add(key);
			}
			// 최소값 구하기
			int min = num.get(0);
			for(int i=0; i<num.size(); i++) {
				if(min>num.get(i)) {
					min = num.get(i);
				}
			}
			answer = min;
		}else if(map.size() == 2) {	// 3개의 주사위가 같고 1개가 다를 때 이거나 2개의 주사위가 각각 같을 때
			// key와 value 각각의 List에 저장
			for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
				count.add(pair.getValue());
				num.add(pair.getKey());
			}
			// 3개의 주사위가 같고 1개가 다를 때
			if(count.get(0) == 3 || count.get(1) == 3) {
				for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
					if(pair.getValue() == 3) {
						p = pair.getKey();
					}
					if(pair.getValue() == 1) {
						q = pair.getKey();
					}
				}
				answer = (10 * p + q) * (10 * p + q);
				// 2개의 주사위가 각각 같을 때
			}else {
				answer = (num.get(0) + num.get(1)) * Math.abs(num.get(0) - num.get(1));
			}
			// 2개의 주사위가 같고 각각 다른 1개, 1개 일 때
		}else {
			for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
				if(pair.getValue() == 1) {
					 num.add(pair.getKey());
				}
			}
			q = num.get(0);
			r = num.get(1);
			answer = q * r;
		}
        return answer;
    }
}
