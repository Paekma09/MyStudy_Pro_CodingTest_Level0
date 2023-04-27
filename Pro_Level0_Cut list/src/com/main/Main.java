package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	정수 n과 정수 3개가 담긴 리스트 slicer 그리고 정수 여러 개가 담긴 리스트 num_list가 주어집니다. 
	slicer에 담긴 정수를 차례대로 a, b, c라고 할 때, n에 따라 다음과 같이 num_list를 슬라이싱 하려고 합니다.
		n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
		n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
		n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
		n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
	올바르게 슬라이싱한 리스트를 return하도록 solution 함수를 완성해주세요.
	[제한사항]
	n 은 1, 2, 3, 4 중 하나입니다.
	slicer의 길이 = 3
	slicer에 담긴 정수를 차례대로 a, b, c라고 할 때
		0 ≤ a ≤ b ≤ num_list의 길이 - 1
		1 ≤ c ≤ 3
	5 ≤ num_list의 길이 ≤ 30
	0 ≤ num_list의 원소 ≤ 100
	[입출력 예]
	n	slicer			num_list							result
	3	[1, 5, 2]	[1, 2, 3, 4, 5, 6, 7, 8, 9]	[2, 3, 4, 5, 6]
	4	[1, 5, 2]	[1, 2, 3, 4, 5, 6, 7, 8, 9]	[2, 4, 6]
	[입출력 예 설명]
	입출력 예 #1
		[1, 2, 3, 4, 5, 6, 7, 8, 9]에서 1번 인덱스부터 5번 인덱스까지 자른 리스트는 [2, 3, 4, 5, 6]입니다.
	입출력 예 #2
		[1, 2, 3, 4, 5, 6, 7, 8, 9]에서 1번 인덱스부터 5번 인덱스까지 2개 간격으로 자른 리스트는 [2, 4, 6]입니다.
	*/
	public static void main(String[] args) {
		int n1 = 3;
		int[] slicer1 = {1, 5, 2};
		int[] num_list1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int n2 = 4;
		int[] slicer2 = {1, 5, 2};
		int[] num_list2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.print(n1+" "+Arrays.toString(slicer1)+" "+Arrays.toString(num_list1)+" ");
		System.out.println(Arrays.toString(solution(n1, slicer1, num_list1)));
		System.out.print(n2+" "+Arrays.toString(slicer2)+" "+Arrays.toString(num_list2)+" ");
		System.out.println(Arrays.toString(solution(n2, slicer2, num_list2)));
	}
	public static int[] solution(int n, int[] slicer, int[] num_list) {
		// answer 배열의 크기가 유동적이므로 ArrayList 생성
		List<Integer> list = new ArrayList<>();
		// n의 경우의 수에 따라 반복문을 돌리며 ArrayList에 저장
		if(n==1) {
			for(int i=0; i<=slicer[1]; i++) {
				list.add(num_list[i]);
			}
		}else if(n==2) {
			for(int i=slicer[0]; i<num_list.length; i++) {
				list.add(num_list[i]);
			}
		}else if(n==3) {
			for(int i=slicer[0]; i<=slicer[1]; i++) {
				list.add(num_list[i]);
			}
		}else if(n==4) {			
			for(int i=slicer[0]; i<=slicer[1]; i +=slicer[2]) {
				list.add(num_list[i]);
			}			
		}
		// ArrayList를 int 배열로 변환
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
