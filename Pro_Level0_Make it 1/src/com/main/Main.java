package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	문자열 myString이 주어집니다. "x"를 기준으로 해당 문자열을 잘라내 배열을 만든 후 
	사전순으로 정렬한 배열을 return 하는 solution 함수를 완성해 주세요.
	단, 빈 문자열은 반환할 배열에 넣지 않습니다.
	[제한사항]
	1 ≤ myString ≤ 100,000
	myString은 알파벳 소문자로 이루어진 문자열입니다.
	[입출력 예]
	myString				result
	"axbxcxdx"			["a","b","c","d"]
	"dxccxbbbxaaaa"	["aaaa","bbb","cc","d"]
	[입출력 예 설명]
	입출력 예 #1
		myString을 "x"를 기준으로 자른 배열은 ["a","b","c","d"]이며, 이 배열은 이미 사전순으로 정렬된 상태입니다. 
		따라서 해당 배열을 return 합니다.
	입출력 예 #2
		myString을 "x"를 기준으로 자른 배열은 ["d","cc","bbb","aaaa"]이며, 
		이 배열을 사전순으로 정렬하면 ["aaaa","bbb","cc","d"]입니다. 따라서 해당 배열을 return 합니다.
	*/
	public static void main(String[] args) {
		String myString1 = "axbxcxdx";
		String myString2 = "dxccxbbbxaaaa";
		String myString3 = "xxdxccxbbbxaaaaxx";
		
		System.out.print(myString1+" ");
		System.out.println(Arrays.toString(solution(myString1)));
		System.out.print(myString2+" ");
		System.out.println(Arrays.toString(solution(myString2)));
		System.out.print(myString3+" ");
		System.out.println(Arrays.toString(solution(myString3)));
	}
	public static String[] solution(String myString) {
		// 문자열을 list에 split을 이용하여 나누어서 넣는다
        List<String> list = new ArrayList<>(Arrays.asList(myString.split("x")));
        // list의 공백 및 null 을 삭제해준다 (3번 예시)
        list.removeAll(Arrays.asList("", null));
        // list를 문자열 배열로 변환 저장
        String[] answer = list.toArray(new String[list.size()]);
        // 사전순으로 정렬
        Arrays.sort(answer);
        return answer;
    }
}
