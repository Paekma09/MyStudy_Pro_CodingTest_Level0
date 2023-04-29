package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	정수 배열 arr가 주어집니다. 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.
	단, arr에 2가 없는 경우 [-1]을 return 합니다.
	[제한사항]
	1 ≤ arr의 길이 ≤ 100,000
		1 ≤ arr의 원소 ≤ 10
	[입출력 예]
	arr								result
	[1, 2, 1, 4, 5, 2, 9]		[2, 1, 4, 5, 2]
	[1, 2, 1]						[2]
	[1, 1, 1]						[-1]
	[1, 2, 1, 2, 1, 10, 2, 1]	[2, 1, 2, 1, 10, 2]
	[입출력 예 설명]
	입출력 예 #1
		2가 있는 인덱스는 1번, 5번 인덱스뿐이므로 1번부터 5번 인덱스까지의 부분 배열인 [2, 1, 4, 5, 2]를 return 합니다.
	입출력 예 #2
		2가 한 개뿐이므로 [2]를 return 합니다.
	입출력 예 #3
		2가 배열에 없으므로 [-1]을 return 합니다.
	입출력 예 #4
		2가 있는 인덱스는 1번, 3번, 6번 인덱스이므로 1번부터 6번 인덱스까지의 부분 배열인 [2, 1, 2, 1, 10, 2]를 return 합니다.
	*/
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 1, 4, 5, 2, 9};
		int[] arr2 = {1, 2, 1};
		int[] arr3 = {1, 1, 1};
		int[] arr4 = {1, 2, 1, 2, 1, 10, 2, 1};
		
		System.out.print(Arrays.toString(arr1)+" ");
		System.out.println(Arrays.toString(solution(arr1)));
		System.out.print(Arrays.toString(arr2)+" ");
		System.out.println(Arrays.toString(solution(arr2)));
		System.out.print(Arrays.toString(arr3)+" ");
		System.out.println(Arrays.toString(solution(arr3)));
		System.out.print(Arrays.toString(arr4)+" ");
		System.out.println(Arrays.toString(solution(arr4)));
	}
	public static int[] solution(int[] arr) {
		// arr의 요소 중 2인 인데스를 저장 할 List 생성
		List<Integer> index = new ArrayList<>();
		// 조건에 따라 answer 배열의 길이가 유동적이므로 담을 List 생성
		List<Integer> list = new ArrayList<>();
		// 요소가 2인 인덱스 index에 저장
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==2) {
				index.add(i);
			}
		}
		// 인덱스의 사이즈에 따라 조건 분기
		if(index.size() == 0) {
			list.add(-1);
		}else if(index.size()==1) {
			list.add(arr[index.get(0)]);
		}else {
			for(int i=index.get(0); i<=index.get(index.size()-1); i++) {
				list.add(arr[i]);
			}
		}
		// list를 int 배열로 변환 저장
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
