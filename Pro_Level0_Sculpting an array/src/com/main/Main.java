package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	랜덤으로 서로 다른 k개의 수를 저장한 배열을 만드려고 합니다. 
	적절한 방법이 떠오르지 않기 때문에 일정한 범위 내에서 무작위로 수를 뽑은 후, 
	지금까지 나온적이 없는 수이면 배열 맨 뒤에 추가하는 방식으로 만들기로 합니다.
	이미 어떤 수가 무작위로 주어질지 알고 있다고 가정하고, 실제 만들어질 길이 k의 배열을 예상해봅시다.
	정수 배열 arr가 주어집니다. 문제에서의 무작위의 수는 arr에 저장된 순서대로 주어질 예정이라고 했을 때, 
	완성될 배열을 return 하는 solution 함수를 완성해 주세요.
	단, 완성될 배열의 길이가 k보다 작으면 나머지 값을 전부 -1로 채워서 return 합니다.	
	[제한사항]
	1 ≤ arr의 길이 ≤ 100,000
	0 ≤ arr의 원소 ≤ 100,000
	1 ≤ k ≤ 1,000
	[입출력 예]
	arr						k	result
	[0, 1, 1, 2, 2, 3]	3	[0, 1, 2]
	[0, 1, 1, 1, 1]		4	[0, 1, -1, -1]
	[입출력 예 설명]
	입출력 예 #1
		앞에서부터 서로 다른 k개의 수를 골라내면 [0, 1, 2]가 됩니다. 따라서 [0, 1, 2]를 return 합니다.
	입출력 예 #2
		서로 다른 수의 개수가 2개 뿐이므로 서로 다른 수들을 앞에서부터 차례대로 저장한 
		[0, 1]에서 이후 2개의 인덱스를 -1로 채워넣은 [0, 1, -1, -1]을 return 합니다.
	*/
	public static void main(String[] args) {
		int[] arr1 = {0, 1, 1, 2, 2, 3};
		int k1 = 3;
		int[] arr2 = {0, 1, 1, 1, 1};
		int k2 = 4;
		
		System.out.print(Arrays.toString(arr1)+" "+k1+" \n");
		System.out.println(Arrays.toString(solution(arr1, k1)));
		System.out.print(Arrays.toString(arr2)+" "+k2+" \n");
		System.out.println(Arrays.toString(solution(arr2, k2)));
	}
	public static int[] solution(int[] arr, int k) {
		// 배열의 길이가 유동적이므로 List 생성
		List<Integer> list = new ArrayList<>();
		// 문제를 보면 중복값이 없다는 것이므로 중복값을 제외하고 list에 담는다.
		for(int i=0; i<arr.length; i++) {
			if(!list.contains(arr[i])) {
				list.add(arr[i]);
			}
		}
		// list의 사이즈와 k를 비교하여 작으면 k길이만큼 -1을 채운다
		if(list.size()<k) {
			for(int i=list.size(); i<k; i++) {
				list.add(-1);
			}
		// list의 사이즈와 k를 비교하여 크면 k길이와 같게 나머지 요소들을 삭제한다.
		// 이때 for문과 remove()를 이용하면 런타임에러가 발생하므로 subList와 clear 메소드를 활용해서 한번에 삭제했다.
		}else if(list.size()>k) {
			list.subList(k, list.size()).clear();
		}
		// list int배열로 변환 저장
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}