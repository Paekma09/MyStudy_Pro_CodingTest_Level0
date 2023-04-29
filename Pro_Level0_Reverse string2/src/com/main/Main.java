package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	문자열 my_string과 이차원 정수 배열 queries가 매개변수로 주어집니다. 
	queries의 원소는 [s, e] 형태로, my_string의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다. 
	my_string에 queries의 명령을 순서대로 처리한 후의 문자열을 return 하는 solution 함수를 작성해 주세요.
	[제한사항]
	my_string은 영소문자로만 이루어져 있습니다.
	1 ≤ my_string의 길이 ≤ 1,000
	queries의 원소는 [s, e]의 형태로 0 ≤ s ≤ e < my_string의 길이를 만족합니다.
	1 ≤ queries의 길이 ≤ 1,000
	[입출력 예]
	my_string			queries										result
	"rermgorpsam"	[[2, 3], [0, 7], [5, 9], [6, 10]]	"programmers"
	[입출력 예 설명]
	입출력 예 #1
		예제 1번의 my_string은 "rermgorpsam"이고 주어진 queries를 순서대로 처리하면 다음과 같습니다.
		queries	my_string
					"rermgorpsam"
		[2, 3]	"remrgorpsam"
		[0, 7]	"progrmersam"
		[5, 9]	"prograsremm"
		[6, 10]	"programmers"
		따라서 "programmers"를 return 합니다.
	*/
	public static void main(String[] args) {
		String my_string = "rermgorpsam";
		int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
		
		System.out.print(my_string+" "+Arrays.deepToString(queries)+" ");
		System.out.println(solution(my_string, queries));
	}
	public static String solution(String my_string, int[][] queries) {
		String answer = "";
		String tempAll = "";
		for(int i=0; i<queries.length; i++) {
			// 최초 뒤집을 때
			if(i == 0) {
				// 문자열 나누기
				String temp1 = my_string.substring(0,queries[i][0]);
				String temp2 = my_string.substring(queries[i][0],queries[i][1]+1);
				String temp3 = my_string.substring(queries[i][1]+1,my_string.length());
				// StringBuffer 생성
				StringBuffer sb = new StringBuffer(temp2);
				// 문자열 뒤집기
				String reTemp2 = sb.reverse().toString();
				// 문자열 합치기
				tempAll = temp1.concat(reTemp2.concat(temp3));
			// 최초 이후 뒤집을 때
			}else {
				String temp1 = tempAll.substring(0,queries[i][0]);
				String temp2 = tempAll.substring(queries[i][0],queries[i][1]+1);
				String temp3 = tempAll.substring(queries[i][1]+1,my_string.length());
				StringBuffer sb = new StringBuffer(temp2);
				String reTemp2 = sb.reverse().toString();
				tempAll = temp1.concat(reTemp2.concat(temp3));
			}
		}
        answer = tempAll;
        return answer;
    }
}
