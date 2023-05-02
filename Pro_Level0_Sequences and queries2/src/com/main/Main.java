package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. 
	queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
	각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
	각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
	단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.
	[제한사항]
	1 ≤ arr의 길이 ≤ 1,000
		0 ≤ arr의 원소 ≤ 1,000,000
	1 ≤ queries의 길이 ≤ 1,000
		0 ≤ s ≤ e < arr의 길이
		0 ≤ k ≤ 1,000,000
	[입출력 예]
	arr					queries									result
	[0, 1, 2, 4, 3]	[[0, 4, 2],[0, 3, 2],[0, 2, 2]]	[3, 4, -1]
	[입출력 예 설명]
	입출력 예 #1
		첫 번째 쿼리의 범위에는 0, 1, 2, 4, 3이 있으며 이 중 2보다 크면서 가장 작은 값은 3입니다.
		두 번째 쿼리의 범위에는 0, 1, 2, 4가 있으며 이 중 2보다 크면서 가장 작은 값은 4입니다.
		세 번째 쿼리의 범위에는 0, 1, 2가 있으며 여기에는 2보다 큰 값이 없습니다.
		따라서 [3, 4, -1]을 return 합니다.
	*/
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 4, 3};
		int[][] queries = {{0, 4, 2},{0, 3, 2},{0, 2, 2}};
		
		System.out.print(Arrays.toString(arr)+" ");
		System.out.print(Arrays.deepToString(queries)+" ");
		System.out.println(Arrays.toString(solution(arr, queries)));
	}
	public static int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        // queries조건에 맞는 arr의 요소의 갯수가 유동적이기때문에 List 생성
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
            	// arr배열 요소 중 k보다 큰 요소 list에 담기
                if(arr[j]>queries[i][2]){
                    list.add(arr[j]);
                }
            }
            // 담은 list 요소중 가장 작은수를 answer배열에 넣어야하므로 오름차순으로 정렬 뒤 첫번째 요소를 answer에 저장
            if(list.size()>0) {
            	Collections.sort(list);
            	answer[i] = list.get(0);
            }else if(list.size()==0) {
            	answer[i] = -1;
            }
            // list에 담은 요소 모두 삭제
            list.removeAll(list);
        }
        return answer;
    }
}
