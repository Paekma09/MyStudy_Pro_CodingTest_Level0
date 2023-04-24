package com.main;

public class Main {
	/*
	[문제 설명]
	어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다.
	예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
	문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을,
	아니면 0을 return 하는 solution 함수를 작성해 주세요.
	[제한사항]
	1 ≤ my_string의 길이 ≤ 100
	1 ≤ is_prefix의 길이 ≤ 100
	my_string과 is_prefix는 영소문자로만 이루어져 있습니다.
	[입출력 예]
	my_string		is_prefix		result
	"banana"		"ban"			1
	"banana"		"nan"			0
	"banana"		"abcd"			0
	"banana"		"bananan"		0
	[입출력 예 설명]
	입출력 예 #1
		예제 1번에서 is_prefix가 my_string의 접두사이기 때문에 1을 return 합니다.
	입출력 예 #2
		예제 2번에서 is_prefix가 my_string의 접두사가 아니기 때문에 0을 return 합니다.
	입출력 예 #3
		예제 3번에서 is_prefix가 my_string의 접두사가 아니기 때문에 0을 return 합니다.
	입출력 예 #4
		예제 4번에서 is_prefix가 my_string의 접두사가 아니기 때문에 0을 return 합니다.
	*/
	public static void main(String[] args) {
		String my_string1 = "banana";
		String is_prefix1 = "ban";
		String my_string2 = "banana";
		String is_prefix2 = "nan";
		String my_string3 = "banana";
		String is_prefix3 = "abcd";
		String my_string4 = "banana";
		String is_prefix4 = "bananan";
		System.out.print(my_string1+" "+is_prefix1+" ");
		System.out.println(solution(my_string1, is_prefix1));
		System.out.print(my_string2+" "+is_prefix2+" ");
		System.out.println(solution(my_string2, is_prefix2));
		System.out.print(my_string3+" "+is_prefix3+" ");
		System.out.println(solution(my_string3, is_prefix3));
		System.out.print(my_string4+" "+is_prefix4+" ");
		System.out.println(solution(my_string4, is_prefix4));
	}
	public static int solution(String my_string, String is_prefix) {
		int answer = 0;
        if(my_string.length() < is_prefix.length()){
            answer = 0;
        }else{
            for(int i=0; i<is_prefix.length(); i++){
                if(my_string.charAt(i) == is_prefix.charAt(i)){
                    answer = 1;
                }else{
                    answer = 0;
                    break;
                }
            }       
        }
        return answer;
    }
}
