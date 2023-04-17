package com.main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다.
	정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.
	[제한사항]
	1 ≤ i < j ≤ 100,000
	0 ≤ k ≤ 9
	[입출력 예]
	i		j		k		result
	1		13		1		6
	10		50		5		5
	3		10		2		0
	[입출력 예 설명]
	입출력 예 #1
		본문과 동일합니다.
	입출력 예 #2
		10부터 50까지 5는 15, 25, 35, 45, 50 총 5번 등장합니다. 따라서 5를 return 합니다.
	입출력 예 #3
		3부터 10까지 2는 한 번도 등장하지 않으므로 0을 return 합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		int k = sc.nextInt();
		int answer = 0;
		// i부터 j까지의 수 배열 선언
        int[] temp = new int[j-i+1];
        // i부터 j까지의 수 배열 초기화
        for(int a=0; a<temp.length; a++){
            temp[a] = i + a;
        }
        // int 배열 -> String로 변환
        String str = Arrays.toString(temp);
        // int k를 -> String로 변환 -> 첫번째 인덱스 문자와 기존 String으로 변환한 각 인텍스로 비교하여 카운팅
        for(int b=0; b<str.length(); b++){
            if(Integer.toString(k).charAt(0) == str.charAt(b)){
                answer++;
            }
        }
        System.out.println(answer);;
	}
}
