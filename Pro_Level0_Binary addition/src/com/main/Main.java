package com.main;

import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때,
	두 이진수의 합을 return하도록 solution 함수를 완성해주세요.
	[제한사항]
	return 값은 이진수를 의미하는 문자열입니다.
	1 ≤ bin1, bin2의 길이 ≤ 10
	bin1과 bin2는 0과 1로만 이루어져 있습니다.
	bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.
	[입출력 예]
	bin1			bin2			result
	"10"			"11"			"101"
	"1001"		"1111"		"11000"
	[입출력 예 설명]
	입출력 예 #1
		10 + 11 = 101 이므로 "101" 을 return합니다.
	입출력 예 #2
		1001 + 1111 = 11000 이므로 "11000"을 return합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String bin1 = sc.nextLine();
		String bin2 = sc.nextLine();
		String answer = "";
        int temp;
        // 문자열 2진수를 10진수 int로 변환하여 연산 ( 2진수 -> 10진수)
        temp = Integer.parseInt(bin1,2) + Integer.parseInt(bin2, 2);
        // int 10진수를 2진수 문자열로 변환 ( 10진수 -> 2진수)
        answer = Integer.toBinaryString(temp);
        System.out.println(answer);
	}
}
