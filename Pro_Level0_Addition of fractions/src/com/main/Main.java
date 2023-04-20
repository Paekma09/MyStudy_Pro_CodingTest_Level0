package com.main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 
	두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다. 
	두 분수를 더한 값을 기약 분수로 나타냈을 때 
	분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
	[제한사항]
	0 <numer1, denom1, numer2, denom2 < 1,000
	[입출력 예]
	numer1		denom1	numer2		denom2	result
	1				2				3				4				[5, 4]
	9				2				1				3				[29, 6]
	[입출력 예 설명]
	입출력 예 #1
		1 / 2 + 3 / 4 = 5 / 4입니다. 따라서 [5, 4]를 return 합니다.
	입출력 예 #2
		9 / 2 + 1 / 3 = 29 / 6입니다. 따라서 [29, 6]을 return 합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numer1 = sc.nextInt();
		int denom1 = sc.nextInt();
		int numer2 = sc.nextInt();
		int denom2 = sc.nextInt();
		
		int[] answer = new int[2];
		// 이 문제는 통분하고 기약분수로 만들기 (기약분수는 분모와 분자의 최대공약수로 나누어진 분수)
		int numerator = (numer1 * denom2) + (numer2 * denom1);
        int denominator = denom1 * denom2;
        answer[0] = numerator / maxNum(numerator, denominator);
        answer[1] = denominator / maxNum(numerator, denominator);
        System.out.println(Arrays.toString(answer));
	}
	// 최대 공약수 구하기
	private static int maxNum(int a, int b){
        int max = 0;
        for(int i=1; i<=a && i<=b; i++){
            if(a%i == 0 && b%i == 0){
                max = i;
            }
        }
        return max;
    }
}
