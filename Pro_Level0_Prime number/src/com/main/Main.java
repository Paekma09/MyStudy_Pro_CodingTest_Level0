package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다.
	예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다.
	따라서 12의 소인수는 2와 3입니다.
	자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
	[제한사항]
	2 ≤ n ≤ 10,000
	[입출력 예]
	n			result
	12			[2, 3]
	17			[17]
	420		[2, 3, 5, 7]
	[입출력 예 설명]
	입출력 예 #1
		12를 소인수분해하면 2 * 2 * 3 입니다. 따라서 [2, 3]을 return합니다.
	입출력 예 #2
		17은 소수입니다. 따라서 [17]을 return 해야 합니다.
	입출력 예 #3
		420을 소인수분해하면 2 * 2 * 3 * 5 * 7 입니다. 따라서 [2, 3, 5, 7]을 return합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 소인수분해 요소값과 " "으로 구분하여 문자열로 저장
		String temp = "";
        for(int i=2; i<=n; i++){
            while(n%i == 0){
                n /= i;
                temp += i+" ";
            }
        }
        // " " 으로 구분하여 문자열 배열로 변환
        String[] tempString = temp.split(" ");
        // 문자열 배열을 int 배열로 변환
        int[] tempInt = new int[tempString.length];
        for(int i=0; i<tempString.length; i++) {
        	if(!tempString[i].equals("")) {
        		tempInt[i] = Integer.parseInt(tempString[i]);
        	}
        }
        // ArrayList를 이용하여 int 배열 중복값 제거
        ArrayList<Integer> list = new ArrayList<>();
        // int배열 요소값 체크하여 ArrayList에 포함되어 있지 않으면 add(추가)
        for(int checkData : tempInt) {
        	if(!list.contains(checkData)) {
        		list.add(checkData);
        	}
        }
        // answer 배열 길이 지정하여 선언
        int[] answer = new int[list.size()];
        // ArrayList의 값을 int 배열에 저장
        for(int i=0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        System.out.println(Arrays.toString(answer));
	}
}
