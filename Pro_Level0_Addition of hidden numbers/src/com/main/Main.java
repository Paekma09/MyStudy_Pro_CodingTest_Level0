package com.main;

import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	문자열 my_string이 매개변수로 주어집니다.
	my_string은 소문자, 대문자, 자연수로만 구성되어있습니다.
	my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
	[제한사항]
	1 ≤ my_string의 길이 ≤ 1,000
	1 ≤ my_string 안의 자연수 ≤ 1000
	연속된 수는 하나의 숫자로 간주합니다.
	000123과 같이 0이 선행하는 경우는 없습니다.
	문자열에 자연수가 없는 경우 0을 return 해주세요.
	[입출력 예]
	my_string					result
	"aAb1B2cC34oOp"		37
	"1a2b3c4d123Z"		133
	[입출력 예 설명]
	입출력 예 #1
		"aAb1B2cC34oOp"안의 자연수는 1, 2, 34 입니다. 따라서 1 + 2 + 34 = 37 을 return합니다.
	입출력 예 #2
		"1a2b3c4d123Z"안의 자연수는 1, 2, 3, 4, 123 입니다.
		따라서 1 + 2 + 3 + 4 + 123 = 133 을 return합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String my_string = sc.nextLine();
		int answer = 0;
		// 숫자만 제외하고 " "으로 대체
        String intStr = my_string.replaceAll("[^0-9]"," ");
        // " "으로 구분하여 String 배열로 변환
        String[] str = intStr.split(" ");
        // 숫자 배열 선언
        int[] num = new int[str.length];
        // String배열을 int배열로 변환
        for(int i=0; i<num.length; i++){
        	if(!str[i].equals("")) {	// 이부분 매우 중요 (없으면 NumberFormat Exception 발생)
        		num[i] = Integer.parseInt(str[i]);
        	}
        }
        // num배열값 모두 덧셈
        for(int i=0; i<num.length; i++){
            answer += num[i];
        }
        System.out.println(answer);
	}
}
