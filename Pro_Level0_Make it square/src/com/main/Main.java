package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	이차원 정수 배열 arr이 매개변수로 주어집니다. 
	arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고, 
	열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 
	각 열의 끝에 0을 추가한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.
	[제한사항]
	1 ≤ arr의 길이 ≤ 100
	1 ≤ arr의 원소의 길이 ≤ 100
		arr의 모든 원소의 길이는 같습니다.
	1 ≤ arr의 원소의 원소 ≤ 1,000
	[입출력 예]
	arr																								result
	[[572, 22, 37], [287, 726, 384], [85, 137, 292], [487, 13, 876]]	[[572, 22, 37, 0], [287, 726, 384, 0], [85, 137, 292, 0], [487, 13, 876, 0]]
	[[57, 192, 534, 2], [9, 345, 192, 999]]											[[57, 192, 534, 2], [9, 345, 192, 999], [0, 0, 0, 0], [0, 0, 0, 0]]
	[[1, 2], [3, 4]]																				[[1, 2], [3, 4]]
	[입출력 예 설명]
	입출력 예 #1
		예제 1번의 arr은 행의 수가 4, 열의 수가 3입니다. 
		행의 수가 더 많으므로 열의 수를 4로 만들기 위해 arr의 각 행의 끝에 0을 추가한 이차원 배열 
		[[572, 22, 37, 0], [287, 726, 384, 0], [85, 137, 292, 0], [487, 13, 876, 0]]를 return 합니다.
	입출력 예 #2
		예제 2번의 arr은 행의 수가 2, 열의 수가 4입니다. 
		열의 수가 더 많으므로 행의 수를 4로 만들기 위해 arr의 각 열의 끝에 0을 추가한 이차원 배열 
		[[57, 192, 534, 2], [9, 345, 192, 999], [0, 0, 0, 0], [0, 0, 0, 0]]을 return 합니다.
	입출력 예 #3
		예제 3번의 arr은 행의 수와 열의 수가 2로 같습니다. 
		따라서 0을 추가하지 않고 [[1, 2], [3, 4]]을 return 합니다.
	*/
	public static void main(String[] args) {
		int[][] arr1 = {{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}};
		int[][] arr2 = {{57, 192, 534, 2}, {9, 345, 192, 999}};
		int[][] arr3 = {{1, 2}, {3, 4}};
		
		System.out.print(Arrays.deepToString(arr1)+" ");
		System.out.println(Arrays.deepToString(solution(arr1)));
		System.out.print(Arrays.deepToString(arr2)+" ");
		System.out.println(Arrays.deepToString(solution(arr2)));
		System.out.print(Arrays.deepToString(arr3)+" ");
		System.out.println(Arrays.deepToString(solution(arr3)));
	}
	public static int[][] solution(int[][] arr) {
		// answer 배열의 길이가 유동적이라 List 2차원 배열 생성
		List<List<Integer>> lists = new ArrayList<>();
		// arr의 길이와 arr[]의 길이를 비교하여 각각 다른 반복문을 돌린다.
		if(arr.length>arr[0].length) {
			int[][] temp = new int[arr.length][arr.length];
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			// temp배열에 담긴 값을 List배열에 담으며 2차원 배열로 저장한다.
			for(int i=0; i<temp.length; i++) {
				List<Integer> list = new ArrayList<>();
				for(int j=0; j<temp[i].length; j++) {
					list.add(temp[i][j]);
				}
				lists.add(list);
			}
		}else if(arr.length<arr[0].length) {
			int[][] temp = new int[arr[0].length][arr[0].length];
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for(int i=0; i<temp.length; i++) {
				List<Integer> list = new ArrayList<>();
				for(int j=0; j<temp[i].length; j++) {
					list.add(temp[i][j]);
				}
				lists.add(list);
			}
		}else {
			int[][] temp = new int[arr.length][arr[0].length];
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for(int i=0; i<temp.length; i++) {
				List<Integer> list = new ArrayList<>();
				for(int j=0; j<temp[i].length; j++) {
					list.add(temp[i][j]);
				}
				lists.add(list);
			}
		}
		// List의 size로 answer배열의 길이를 설정한다.
		int[][] answer = new int[lists.size()][lists.get(0).size()];
		// List 2차원 배열을 answer 2차원 배열로 저장한다.
		for(int i=0; i<lists.size(); i++) {
			for(int j=0; j<lists.get(i).size(); j++) {
				answer[i][j] = lists.get(i).get(j);
			}
		}
        return answer;
    }
}
