package com.main;

public class Main {
	/*
	[문제 설명]
	문자열 my_string과 두 정수 m, c가 주어집니다. 
	my_string을 한 줄에 m 글자씩 가로로 적었을 때 왼쪽부터 세로로 c번째 열에 적힌 글자들을 
	문자열로 return 하는 solution 함수를 작성해 주세요.
	[제한사항]
	my_string은 영소문자로 이루어져 있습니다.
	1 ≤ m ≤ my_string의 길이 ≤ 1,000
	m은 my_string 길이의 약수로만 주어집니다.
	1 ≤ c ≤ m
	[입출력 예]
	my_string						m	c	result
	"ihrhbakrfpndopljhygc"	4	2	"happy"
	"programmers"				1	1	"programmers"
	[입출력 예 설명]
	입출력 예 #1
		예제 1번의 my_string을 한 줄에 4 글자씩 쓰면 다음의 표와 같습니다.
		1열	2열	3열	4열
		i		h		r		h
		b		a		k		r
		f		p		n		d
		o		p		l		j
		h		y		g		c
		2열에 적힌 글자를 세로로 읽으면 happy이므로 "happy"를 return 합니다.
	입출력 예 #2
		예제 2번의 my_string은 m이 1이므로 세로로 "programmers"를 적는 것과 같고 
		따라서 1열에 적힌 글자를 세로로 읽으면 programmers입니다. 따라서 "programmers"를 return 합니다.
	*/
	public static void main(String[] args) {
		String my_string1 = "ihrhbakrfpndopljhygc";
		int m1 = 4;
		int c1 = 2;
		String my_string2 = "programmers";
		int m2 = 1;
		int c2 = 1;
		String my_string3 = "ihrhbakrfpndopljhygc";
		int m3 = 20;
		int c3 = 20;
		
		System.out.print(my_string1+" "+m1+" "+c1+" ");
		System.out.println(solution(my_string1, m1, c1));
		System.out.print(my_string2+" "+m2+" "+c2+" ");
		System.out.println(solution(my_string2, m2, c2));
		System.out.print(my_string3+" "+m3+" "+c3+" ");
		System.out.println(solution(my_string3, m3, c3));
	}
	public static String solution(String my_string, int m, int c) {
        String answer = "";
        // my_string을 char 배열로 변환
        char[] temp = new char[my_string.length()];
        for(int i=0; i<my_string.length(); i++){
            temp[i] = my_string.charAt(i);
        }
        // m==1일때(예제2번)와 아닐때 인덱스와 c를 m으로 나누었을때 나머지 값이 같은 경우 answer에 저장
        if(m==1){
            answer = my_string;
        }else {
            for(int i=0; i<temp.length; i++){
                if((i+1)%m == c%m){
                    answer += temp[i];
                }
            }
        }
        return answer;
    }
}
