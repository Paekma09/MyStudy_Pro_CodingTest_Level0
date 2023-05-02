package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	문자열 리스트 str_list에는 "u", "d", "l", "r" 네 개의 문자열이 여러 개 저장되어 있습니다. 
	str_list에서 "l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 해당 문자열을 기준으로 
	왼쪽에 있는 문자열들을 순서대로 담은 리스트를, 먼저 나오는 문자열이 "r"이라면 해당 문자열을 기준으로 
	오른쪽에 있는 문자열들을 순서대로 담은 리스트를 return하도록 solution 함수를 완성해주세요. 
	"l"이나 "r"이 없다면 빈 리스트를 return합니다.
	[제한사항]
	1 ≤ str_list의 길이 ≤ 20
	str_list는 "u", "d", "l", "r" 네 개의 문자열로 이루어져 있습니다.
	[입출력 예]
	str_list					result
	["u", "u", "l", "r"]	["u", "u"]
	["l"]						[]
	[입출력 예 설명]
	입출력 예 #1
		"r"보다 "l"이 먼저 나왔기 때문에 "l"의 왼쪽에 있는 문자열들을 담은 리스트인 ["u", "u"]를 return합니다.
	입출력 예 #2
		"l"의 왼쪽에 문자열이 없기 때문에 빈 리스트를 return합니다.
	*/
	public static void main(String[] args) {
		String[] str_list1 = {"u", "u", "l", "r"};
		String[] str_list2 = {"l"};
		
		System.out.print(Arrays.toString(str_list1)+" ");
		System.out.println(Arrays.toString(solution(str_list1)));
		System.out.print(Arrays.toString(str_list2)+" ");
		System.out.println(Arrays.toString(solution(str_list2)));
	}
	public static String[] solution(String[] str_list) {
		// 배열의 길이가 유동적이므로 List생성
		List<String> list = new ArrayList<>();
		// 배열을 문자열로 변환
        String temp = "";
        for(int i=0; i<str_list.length; i++){
            temp += str_list[i];
        }
        // 문자열 중 "l"과 "r"값을 포함할때와 안할때 나누어서 분기문
        if(temp.contains("l") || temp.contains("r")){
            for(int i=0; i<str_list.length; i++) {
            	// "l"이 나오면 0번 인덱스에서 "l"이 나온 인덱스 이전까지 list에 저장하고 break
                if(str_list[i].equals("l")) {
                    for(int j=0; j<i; j++) {
                        list.add(str_list[j]);
                    }
                    break;
                // "r"이 나오면 "r"이 나온 인덱스부터 끝까지 list에 저장하고 break
                }else if(str_list[i].equals("r")) {
                    for(int j=i+1; j<str_list.length; j++) {
                        list.add(str_list[j]);
                    }
                    break;
                }
            }
        }
        // list를 String 배열로 변환 저장
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
}
