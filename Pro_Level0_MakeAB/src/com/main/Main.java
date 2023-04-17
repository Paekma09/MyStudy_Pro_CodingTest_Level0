package com.main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	문자열 before와 after가 매개변수로 주어질 때,
	before의 순서를 바꾸어 after를 만들 수 있으면 1을, 
	만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.
	[제한사항]
	0 < before의 길이 == after의 길이 < 1,000
	before와 after는 모두 소문자로 이루어져 있습니다.
	[입출력 예]
	before		after			result
	"olleh"		"hello"		1
	"allpe"		"apple"		0
	[입출력 예 설명]
	입출력 예 #1
		"olleh"의 순서를 바꾸면 "hello"를 만들 수 있습니다.
	입출력 예 #2
		"allpe"의 순서를 바꿔도 "apple"을 만들 수 없습니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String before = sc.nextLine();
		String after = sc.nextLine();
		int answer = 0;
		// 이 문제의 핵심은 before와 after가 같은 조건으로 정렬하였을 때 모두 같아야 한다 것이다.
		// 길이는 문제의 제한 사항에 있으므로 그 외에 모든 것이 같아야 한다.
        int temp = 0;
        char[] b_temp = before.toCharArray();
        // 오름차순으로 정렬
        Arrays.sort(b_temp);
        char[] a_temp = after.toCharArray();
        // 오름차순으로 정렬
        Arrays.sort(a_temp);
        for(int i=0; i<b_temp.length; i++){
        	// before와 after 비교 후 같으면 count
            if(b_temp[i] == a_temp[i]){
                temp++;
            }
        }
        // count와 before의 길이가 같으면 모두 같은 것으로 판명
        if(temp == before.length()){
            answer = 1;
        } else {
            answer = 0;
        }
        System.out.println(answer);
	}
}
