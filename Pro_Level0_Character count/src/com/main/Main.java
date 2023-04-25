package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	알파벳 대소문자로만 이루어진 문자열 my_string이 주어질 때, 
	my_string에서 'A'의 개수, my_string에서 'B'의 개수,..., 
	my_string에서 'Z'의 개수, my_string에서 'a'의 개수, my_string에서 'b'의 개수,..., 
	my_string에서 'z'의 개수를 순서대로 담은 길이 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.
	[제한사항]
	1 ≤ my_string의 길이 ≤ 1,000
	[입출력 예]
	my_string			result
	"Programmers"	[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 
							0, 1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0]
	[입출력 예 설명]
	입출력 예 #1
		예제 1번의 my_string에서 'P'가 1개, 'a'가 1개, 'e'가 1개, 'g'가 1개, 'm'이 2개, 'o'가 1개, 'r'가 3개, 's'가 1개
		있으므로 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1,
		0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0]를 return 합니다.
	*/
	public static void main(String[] args) {
		String my_string = "Programmers";
		
		System.out.println(my_string);
		System.out.println(Arrays.toString(solution(my_string)));
	}
	public static int[] solution(String my_string) {
		// 이 문제의 키포인트는 영문자와 갯수가 key와 value로 묶어서 관리하면 쉽게 구할 수 있다.
		// HashMap을 사용하되 put한 순서대로 저장하기 위하여 LinkedHashMap을 사용
        HashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>(52);
        // 알파벳을 저장할 Character 배열 선언하여 대문자, 소문자 따로 저장
        Character[] Alpha = new Character[26];
        Character[] alpha = new Character[26];
        for(int i=0; i<Alpha.length;i++) {
        	Alpha[i] = (char) ('A'+i);
        }
        for(int i=0; i<alpha.length;i++) {
        	alpha[i] = (char) ('a'+i);
        }
        // map에 put(key->저장해놓은 알파벳, value->초기화0) 으로 저장
        for(int i=0; i<Alpha.length;i++) {
        	map.put(Alpha[i], 0);
        }
        for(int i=0; i<alpha.length;i++) {
        	map.put(alpha[i], 0);
        }
        // my_string의 각 문자가 map의 key값이 있는지 검사하여 있으면 temp에 원래 값 저장 해 놓고 기존 값에 +1
        // 하는 형태로 카운팅한다.
		for(int i=0; i<my_string.length();i++) {
			if(map.containsKey(my_string.charAt(i))) {
				int temp = map.get(my_string.charAt(i));
				map.replace(my_string.charAt(i), temp+1);
			}
		}
		// 갯수가 저장된 value값을 ArrayList로 변환
		List<Integer> value = new ArrayList<>(map.values());
		// ArrayList 를 int 배열로 저장
		int[] answer = new int[value.size()];
	    for (int i = 0 ; i < value.size() ; i++) {
	    	answer[i] = value.get(i).intValue();
	    }
        return answer;
    }
}
