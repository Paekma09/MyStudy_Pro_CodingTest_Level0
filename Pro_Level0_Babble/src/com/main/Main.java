package com.main;

import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 
	조카는 아직 "aya", "ye", "woo", "ma" 
	네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다. 
	문자열 배열 babbling이 매개변수로 주어질 때, 
	머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
	[제한사항]
	1 ≤ babbling의 길이 ≤ 100
	1 ≤ babbling[i]의 길이 ≤ 15
	babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
		즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
	문자열은 알파벳 소문자로만 이루어져 있습니다.
	[입출력 예]
	babbling															result
	["aya", "yee", "u", "maa", "wyeoo"]					1
	["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	3
	[입출력 예 설명]
	입출력 예 #1
		["aya", "yee", "u", "maa", "wyeoo"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.
	입출력 예 #2
		["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]에서 발음할 수 있는 것은 
		"aya" + "ye" = "ayaye", "ye", "ye" + "ma" + "woo" = "yemawoo"로 3개입니다. 
		따라서 3을 return합니다.
	[유의사항]
	네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정합니다. 
	예를 들어 "woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		String[] babbling = new String[length];
		for(int i=0; i<length; i++) {
			babbling[i] = sc.next();
		}
		// 이 문제는 머쓱이가 발음 할 수 있는 것들을 소거해가면서 마지막에 ""이면 카운트를 증가 시키면 된디.
		int answer = 0;
        for(int i=0; i<babbling.length; i++){
        	// 발음 할 수 있는 것이 여러번 반복될 수 있으므로 replaceFirst() 메소드를 사용했다.
        	// ""으로 바로 대체하면 소거후의 문자들이 같이 붙어서 의외의 문자열이 반환 될 수 있어 초기에는 ","으로 대체 후
        	// 추후 한꺼번에 ""으로 대체했다.
           babbling[i] = babbling[i].replaceFirst("aya",",");
           babbling[i] = babbling[i].replaceFirst("woo",",");
           babbling[i] = babbling[i].replaceFirst("ye",",");
           babbling[i] = babbling[i].replaceFirst("ma",",");
           babbling[i] = babbling[i].replace(",", "");
           // 여기서는 문자열 vs 문자열 비교이므로 == 이 아닌 equals() 메소드를 사용
           if(babbling[i].equals("")) {
        	   answer++;
           }
        }
        System.out.println(answer);
	}
}
