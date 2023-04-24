package com.main;

public class Main {
	/*
	[문제 설명]
	어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
	예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
	문자열 my_string과 is_suffix가 주어질 때, is_suffix가 my_string의 접미사라면 1을, 
	아니면 0을 return 하는 solution 함수를 작성해 주세요.
	[제한사항]
	1 ≤ my_string의 길이 ≤ 100
	1 ≤ is_suffix의 길이 ≤ 100
	my_string과 is_suffix는 영소문자로만 이루어져 있습니다.
	[입출력 예]
	my_string		is_suffix		result
	"banana"		"ana"			1
	"banana"		"nan"			0
	"banana"		"wxyz"			0
	"banana"		"abanana"		0
	[입출력 예 설명]
	입출력 예 #1
		예제 1번에서 is_suffix가 my_string의 접미사이기 때문에 1을 return 합니다.
	입출력 예 #2
		예제 2번에서 is_suffix가 my_string의 접미사가 아니기 때문에 0을 return 합니다.
	입출력 예 #3
		예제 3번에서 is_suffix가 my_string의 접미사가 아니기 때문에 0을 return 합니다.
	입출력 예 #4
		예제 4번에서 is_suffix가 my_string의 접미사가 아니기 때문에 0을 return 합니다.
	*/
	public static void main(String[] args) {
		String my_string1 = "banana";
		String is_suffix1 = "ana";
		String my_string2 = "banana";
		String is_suffix2 = "nan";
		String my_string3 = "banana";
		String is_suffix3 = "wxyz";
		String my_string4 = "banana";
		String is_suffix4 = "abanana";
		System.out.print(my_string1+" "+is_suffix1+" ");
		System.out.println(solution(my_string1, is_suffix1));
		System.out.print(my_string2+" "+is_suffix2+" ");
		System.out.println(solution(my_string2, is_suffix2));
		System.out.print(my_string3+" "+is_suffix3+" ");
		System.out.println(solution(my_string3, is_suffix3));
		System.out.print(my_string4+" "+is_suffix4+" ");
		System.out.println(solution(my_string4, is_suffix4));
	}
	public static int solution(String my_string, String is_suffix) {
        int answer = 0;
        if(my_string.length()<is_suffix.length()){
            answer = 0;
        }else{
            for(int i=is_suffix.length()-1,j=0; i>=0; i--,j++){
                if(my_string.charAt(my_string.length()-1-j) == is_suffix.charAt(i)){
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
