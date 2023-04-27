package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. 
	queries의 원소는 각각 하나의 query를 나타내며, [s, e] 꼴입니다.
	각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 arr[i]에 1을 더합니다.
	위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
	[제한사항]
	1 ≤ arr의 길이 ≤ 1,000
	0 ≤ arr의 원소 ≤ 1,000,000
	1 ≤ queries의 길이 ≤ 1,000
	0 ≤ s ≤ e < arr의 길이	
	[입출력 예]
	arr					queries						result
	[0, 1, 2, 3, 4]	[[0, 1],[1, 2],[2, 3]]	[1, 3, 4, 4, 4]
	[입출력 예 설명]
	입출력 예 #1
		각 쿼리에 따라 arr가 다음과 같이 변합니다.
		i	queries[i]	arr
		-	-				[0, 1, 2, 3, 4]
		0	[0,1]			[1, 2, 2, 3, 4]
		1	[1,2]			[1, 3, 3, 3, 4]
		2	[2,3]			[1, 3, 4, 4, 4]
		따라서 [1, 3, 4, 4, 4]를 return 합니다.
	*/
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4};
		int[][] queries = {{0, 1},{1, 2},{2, 3}};
		
		System.out.print(Arrays.toString(arr)+" ");
		System.out.print(Arrays.deepToString(queries)+" ");
		System.out.println(Arrays.toString(solution(arr, queries)));
	}
	public static int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        // arr의 인덱스가 queries s보다 크거나 같고 queries e 보다 작거나 같을때 해당 원소에 +1 해준다.
        for(int i=0; i<queries.length; i++){
            for(int j=0; j<arr.length; j++){
                if(j >= queries[i][0] && j <= queries[i][1]){
                	arr[j] +=  1;  
                }
            }
        }
        // arr배열을 answer 배열로 복사한다.
        for(int i=0; i<arr.length; i++) {
        	answer[i] = arr[i];
        }
        return answer;
    }
}
