package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	정수 배열 arr가 주어집니다. 이때 arr의 원소는 1 또는 0입니다. 
	정수 idx가 주어졌을 때, idx보다 크면서 배열의 값이 1인 가장 작은 인덱스를 찾아서 
	반환하는 solution 함수를 완성해 주세요.
	단, 만약 그러한 인덱스가 없다면 -1을 반환합니다.
	[제한사항]
	3 ≤ arr의 길이 ≤ 100'000
	arr의 원소는 전부 1 또는 0입니다.
	[입출력 예]
	arr						idx	result
	[0, 0, 0, 1]			1		3
	[1, 0, 0, 1, 0, 0]	4		-1
	[1, 1, 1, 1, 0]		3		3
	[입출력 예 설명]
	입출력 예 #1
		1보다 크면서 원소가 1인 가장 작은 인덱스는 3입니다. 따라서 3을 return 합니다.
	입출력 예 #2
		4번 인덱스 이후에 1은 등장하지 않습니다. 따라서 -1을 return 합니다.
	입출력 예 #3
		3번 인덱스의 값이 1입니다. 따라서 3을 return 합니다.
	*/
	public static void main(String[] args) {
		int[] arr1 = {0, 0, 0, 1};
		int idx1 = 1;
		int[] arr2 = {1, 0, 0, 1, 0, 0};
		int idx2 = 4;
		int[] arr3 = {1, 1, 1, 1, 0};
		int idx3 = 3;
		System.out.print(Arrays.toString(arr1)+" ");
		System.out.print(idx1+" ");
		System.out.println(solution(arr1, idx1));
		System.out.print(Arrays.toString(arr2)+" ");
		System.out.print(idx2+" ");
		System.out.println(solution(arr2, idx2));
		System.out.print(Arrays.toString(arr3)+" ");
		System.out.print(idx3+" ");
		System.out.println(solution(arr3, idx3));
	}
	public static int solution(int[] arr, int idx) {
        int answer = 0;
        // idx값을 for문의 시작값으로 설정하고 첫번째 1이 나오는 인덱스 값을 answer에 저장
        // 키포인트는 1을 찾았을때 반복문이 더 돌지 않도록 break 해준다.
        for(int i=idx; i<arr.length; i++){
            if(arr[i] == 1){
                answer = i;
                break;
            }else{
                answer = -1;
            }
        }
        return answer;
    }
}
