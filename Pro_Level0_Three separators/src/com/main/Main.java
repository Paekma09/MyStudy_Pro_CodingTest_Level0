package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	임의의 문자열이 주어졌을 때 문자 "a", "b", "c"를 구분자로 사용해 문자열을 나누고자 합니다.
	예를 들어 주어진 문자열이 "baconlettucetomato"라면 나눠진 문자열 목록은 
	["onlettu", "etom", "to"] 가 됩니다.
	문자열 myStr이 주어졌을 때 위 예시와 같이 
	"a", "b", "c"를 사용해 나눠진 문자열을 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
		단, 두 구분자 사이에 다른 문자가 없을 경우에는 아무것도 저장하지 않으며, 
		return할 배열이 빈 배열이라면 ["EMPTY"]를 return 합니다.
	[제한사항]
	1 ≤ myStr의 길이 ≤ 1,000,000
		MyStr은 알파벳 소문자로 이루어진 문자열 입니다.
	[입출력 예]
	myStr							result
	"baconlettucetomato"	["onlettu", "etom", "to"]
	"abcd"							["d"]
	"cabab"							["EMPTY"]
	[입출력 예 설명]
	입출력 예 #1
		문제 설명의 예시와 같습니다.
	입출력 예 #2
		"c" 이전에는 "a", "b", "c" 이외의 문자가 없습니다.
		"c" 이후에 문자열 "d"가 있으므로 "d"를 저장합니다.
		따라서 ["d"]를 return 합니다.
	입출력 예 #3
		"a", "b", "c" 이외의 문자가 존재하지 않습니다. 따라서 저장할 문자열이 없습니다.
		따라서 ["EMPTY"]를 return 합니다.
	*/
	public static void main(String[] args) {
		String myStr1 = "baconlettucetomato";
		String myStr2 = "abcd";
		String myStr3 = "cabab";
		
		System.out.print(myStr1+" ");
		System.out.println(Arrays.toString(solution(myStr1)));
		System.out.print(myStr2+" ");
		System.out.println(Arrays.toString(solution(myStr2)));
		System.out.print(myStr3+" ");
		System.out.println(Arrays.toString(solution(myStr3)));
	}
	public static String[] solution(String myStr) {
		// 동시에 "a","b","c"를 공백으로 대체
        String temp = myStr.replaceAll("a"," ").replaceAll("b", " ").replaceAll("c", " ");
        // 앞뒤에 공백 제거
        temp = temp.trim();
        // 여러 공백일때 한개의 공백으로 데체
        temp = temp.replaceAll("\\s+", " ");
        // 공백을 기준으로 배열로 변환
        String[] answer = temp.split(" ");
        // 값이 ""일때 "EMPTY"로 저장하여 return
        if(answer[0].equals("") ) {
        	answer[0] = "EMPTY";
        }
        return answer;
    }
}
