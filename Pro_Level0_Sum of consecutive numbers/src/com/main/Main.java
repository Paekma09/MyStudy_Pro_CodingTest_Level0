package com.main;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 두 정수 num과 total이 주어집니다.
	연속된 수 num개를 더한 값이 total이 될 때, 
	정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.
	[제한사항]
	1 ≤ num ≤ 100
	0 ≤ total ≤ 1000
	num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
	[입출력 예]
	num	total	result
	3		12		[3, 4, 5]
	5		15		[1, 2, 3, 4, 5]
	4		14		[2, 3, 4, 5]
	5		5		[-1, 0, 1, 2, 3]
	[입출력 예 설명]
	입출력 예 #1
		num = 3, total = 12인 경우 [3, 4, 5]를 return합니다.
	입출력 예 #2
		num = 5, total = 15인 경우 [1, 2, 3, 4, 5]를 return합니다.
	입출력 예 #3
		4개의 연속된 수를 더해 14가 되는 경우는 2, 3, 4, 5입니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int total = sc.nextInt();
		int[] answer = new int[num];
        // 이 문제의 키포인트
		// num이 홀수일때는 배열의 중간값이 total/num 이다.
		// num이 짝수일때는 배열의 중간-1의 값이 total/num 이다.
		// 이 두가지 조건을 가지고 앞뒤로 1씩 증감 시키면 된다.
        if(num%2!=0){
            answer[answer.length/2] = total / num;
            for(int i=answer.length/2-1, j=1; i>=0; i--, j++){
                answer[i] = answer[answer.length/2]-j;
            }
            for(int i=answer.length/2+1, j=1; i<answer.length; i++, j++){
                answer[i] = answer[answer.length/2]+j;
            }
        }else{
            answer[answer.length/2-1] = total / num;
            for(int i=answer.length/2-2, j=1; i>=0; i--, j++){
                answer[i] = answer[answer.length/2-1]-j;
            }
            for(int i=answer.length/2, j=1; i<answer.length; i++, j++){
                answer[i] = answer[answer.length/2-1]+j;
            }
        }
        System.out.println(Arrays.toString(answer));
	}
}
