package com.main;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
	정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요.
	최빈값이 여러 개면 -1을 return 합니다.
	[제한사항]
	0 < array의 길이 < 100
	0 ≤ array의 원소 < 1000
	[입출력 예]
	array						result
	[1, 2, 3, 3, 3, 4]	3
	[1, 1, 2, 2]			-1
	[1]						1
	[입출력 예 설명]
	입출력 예 #1
		[1, 2, 3, 3, 3, 4]에서 1은 1개 2는 1개 3은 3개 4는 1개로 최빈값은 3입니다.
	입출력 예 #2
		[1, 1, 2, 2]에서 1은 2개 2는 2개로 최빈값이 1, 2입니다. 최빈값이 여러 개이므로 -1을 return 합니다.
	입출력 예 #3
		[1]에는 1만 있으므로 최빈값은 1입니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] array = new int[length];
		for(int i=0; i<length; i++) {
			array[i] = sc.nextInt();
		}
		int answer = 0;
		// temp 배열에 array요소값 비교하여 각 요소별 빈도수 저장
		int[] temp = new int[array.length];
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if(array[i] == array[j]){
                    temp[i]++;
                }
            }
        }
        // 빈도수 최대값 구하기
        int max = temp[0];
        for(int i=0; i<temp.length; i++){
            if(max<temp[i]){
                max = temp[i];
            }
        }
        // 빈도수 최대값의 개수 카운트
        int count = 0;
        for(int i=0; i<temp.length; i++){
            if(max == temp[i]){
                count++;
            }
        }
        // 빈도수 최대값의 인덱스 번호 구하기
        int[] index = new int[count];
        for(int i=0, j=0; i<temp.length; i++){
            if(max == temp[i]){
                index[j] = i;
                j++;
            }
        }
        // array 배열에서 빈도수 최대값의 요소 구하기 
        int[] maxArray = new int[count];
        for(int i=0; i<maxArray.length; i++){
            maxArray[i] = array[index[i]];
        }
        // 최대값 요소의 배열 길이로 최대값이 한개 인지, 여러개 인지 판단
        if(maxArray.length == 1){	// 최대값이 한개 이면 answer에 값 저장
            answer = maxArray[0];
        // 최대값이 여러개일 경우 중복 제거 후 answer에 값 저장
        } else {	
        	// 중복 제거 방법 - LinkedHashSet의 중복을 허용하지 않는 속성을 이용
        	// 중복 제거하기 위해 최대값 요소의 배열(maxArr)을 Integer배열로 변환
        	Integer[] maxArrInt = Arrays.stream(maxArray).boxed().toArray(Integer[]::new);
        	// Integer배열을 LinkedHashSet으로 변환 - 요소값 중복 제거 완료
        	LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(maxArrInt));
        	// LinkedHashSet을 다시 Integer배열로 변환
        	Integer[] copyMaxArrInt = linkedHashSet.toArray(new Integer[] {});
        	// Integer배열을 다시 int 배열로 변환 (중복 제거 된 int 배열)
        	int[] copyMaxArr = Arrays.stream(copyMaxArrInt).mapToInt(i->i).toArray();
            // 요소값이 중복이 제거 되었음에도 여러개의 요소값이 있을 경우 answer에 -1 반환, 아닌 경우 answer에 해당 요소값 저장
            if(copyMaxArr.length == 1){
                answer = copyMaxArr[0];
            } else {
                answer = -1;
            }
        }
        System.out.println(answer);
	}
}
