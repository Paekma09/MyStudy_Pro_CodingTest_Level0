package com.main;

import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	문자열 s가 매개변수로 주어집니다.
	s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
	한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
	[제한사항]
	0 < s의 길이 < 1,000
	s는 소문자로만 이루어져 있습니다.
	[입출력 예]
	s						result
	"abcabcadc"		"d"
	"abdc"				"abcd"
	"hello"				"eho"
	[입출력 예 설명]
	입출력 예 #1
		"abcabcadc"에서 하나만 등장하는 문자는 "d"입니다.
	입출력 예 #2
		"abdc"에서 모든 문자가 한 번씩 등장하므로 사전 순으로 정렬한 "abcd"를 return 합니다.
	입출력 예 #3
		"hello"에서 한 번씩 등장한 문자는 "heo"이고 이를 사전 순으로 정렬한 "eho"를 return 합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String answer = "";
		// 알파벳 소문자 배열 만들기
        char[] alphabet = new char[26];
        for(int i=0; i<alphabet.length; i++){
            alphabet[i] = (char)(97 + i);
        }
        // 문자열과 알파벳 문자 배열과 비교하여 카운팅
        int[] count = new int[alphabet.length];
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<alphabet.length; j++){
                if(s.charAt(i) == alphabet[j]){
                    count[j]++;
                }
            }
        }
        // 카운트 배열에서 1인 문자만 answer 문자열에 추가
        for(int i=0; i<count.length; i++){
            if(count[i] == 1){
                answer += alphabet[i];
            }
        }
        System.out.println(answer);
	}
}
