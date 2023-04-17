package com.main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	정수 배열 array와 정수 n이 매개변수로 주어질 때,
	array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.
	[제한사항]
	1 ≤ array의 길이 ≤ 100
	1 ≤ array의 원소 ≤ 100
	1 ≤ n ≤ 100
	가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
	[입출력 예]
	array					n			result
	[3, 10, 28]		20			28
	[10, 11, 12]		13			12
	[입출력 예 설명]
	입출력 예 #1
		3, 10, 28 중 20과 가장 가까운 수는 28입니다.
	입출력 예 #2
		10, 11, 12 중 13과 가장 가까운 수는 12입니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] array = new int[length];
		for(int i=0; i<length; i++) {
			array[i] = sc.nextInt();
		}
		int n = sc.nextInt();
		
		int answer = 0;
		// array의 값들을 n 빼었을때 값 저장 배열
        int[] temp = new int[array.length];
        // 각 요소값을 n으로 더하거나 뺏을 때 값이 같은 경우 작은 값을 반환해야 하므로 오름차순으로 미리 정렬해준다.
        // 정렬 부분에서 오류값 발생이 많음 (반드시 정렬 해 줘야함)
        Arrays.sort(array);
        // array의 값이 n보다 크면 array값에서 n빼기, n보다 작으면 n에서 array값 빼기
        for(int i=0; i<array.length; i++){
            if(array[i] > n){
                temp[i] = array[i] - n;
            } else if(array[i] < n){
                temp[i] = n - array[i];
            } else{
                temp[i] = 0;
            }
        }
        // 가장 최소값 구하며 그 최소값의 인덱스 같이 구하기
        int min = temp[0];
        int index = 0;
        for(int i=0; i<temp.length; i++){
            if(min>temp[i]){
                min = temp[i];
                index = i;
            }
        }
        answer = array[index];
        System.out.println(answer);;
	}
}
