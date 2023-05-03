package com.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	문자열 myString과 pat가 주어집니다. myString의 부분 문자열중 pat로 끝나는 
	가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성해 주세요.
	[제한사항]
	5 ≤ myString ≤ 20
	1 ≤ pat ≤ 5
		pat은 반드시 myString의 부분 문자열로 주어집니다.
	myString과 pat에 등장하는 알파벳은 대문자와 소문자를 구분합니다.
	[입출력 예]
	myString		pat	result
	"AbCdEFG"	"dE"	"AbCdE"
	"AAAAaaaa"	"a"	"AAAAaaaa"
	[입출력 예 설명]
	입출력 예 #1
		"AbCdEFG"에서 "dE"는 한 번 등장하며 처음부터 해당 위치까지 잘라내면 "AbCdE"가 됩니다. 
		따라서 이 문자열이 "dE"로 끝나는 가장 긴 문자열이며, "AbCdE"를 return 합니다.
	입출력 예 #2
		"AAAAaaaa"에서 "a"는 총 네 번 등장하며 이 중 가장 마지막에 있는 위치까지 잘라내면 "AAAAaaaa"가 됩니다. 
		따라서 이 문자열이 "a"로 끝나는 가장 긴 문자열이며, "AAAAaaaa"를 return 합니다.
	*/
	public static void main(String[] args) {
		String myString1 = "AbCdEFG";
		String pat1 = "dE";
		String myString2 = "AAAAaaaa";
		String pat2 = "a";
		
		System.out.print(myString1+" "+pat1+" ");
		System.out.println(solution(myString1, pat1));
		System.out.print(myString2+" "+pat2+" ");
		System.out.println(solution(myString2, pat2));
	}
	public static String solution(String myString, String pat) {
		String answer = "";
		// myString에서 pat을 포함하는 시작 인덱스를 저장할 List 생성
		List<Integer> list = new ArrayList<>();
		// pat으로 끝나는 문자열을 저장할 List 생성
		List<String> str = new ArrayList<>();
		// myString에서 pat가 처음 나오는 인데스 저장
		int index = myString.indexOf(pat);
		// index가 저장되어 있으므로 while문으로 반복, 더이상 나오지 않으면 while문을 나온다. 
		// 먼저 list에 처음 나오는 인덱스 저장하고
		// 그 이후에 나오는 인덱스를 찾아 나오지 않을때까지 list에 저장
		while(index != -1) {
			list.add(index);
			index = myString.indexOf(pat, index+pat.length());
		}
		// list에서 하나씩 꺼내어 그 인덱스로 myString을 substring으로 잘라서 str에 저장한다.
		for(int i=0; i<list.size(); i++) {
			String temp = myString.substring(0,list.get(i)+pat.length());
			str.add(temp);
		}
		// 가장 길이가 긴 문자열을 찾아야 하므로 length가 max인 값을 찾는다.
		int length = str.get(0).length();
		for(int i=0; i<str.size(); i++) {
			if(length < str.get(i).length()) {
				length = str.get(i).length();
			}
		}
		// length max값과 같은 길이의 문자열 탐색하여 같으면 answer에 담고 break로 반복문을 나온다.
		for(int i=0; i<str.size(); i++) {
			if(str.get(i).length() == length) {
				answer = str.get(i);
				break;
			}
		}
        return answer;
    }
}
