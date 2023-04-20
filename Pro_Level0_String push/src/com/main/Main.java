package com.main;

import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다.
	이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때,
	A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 밀어서 B가 될 수 없으면 -1을 return 하도록
	solution 함수를 완성해보세요.
	[제한사항]
	0 < A의 길이 = B의 길이 < 100
	A, B는 알파벳 소문자로 이루어져 있습니다.
	[입출력 예]
	A			B			result
	"hello"	"ohell"	1
	"apple"	"elppa"	-1
	"atat"	"tata"	1
	"abc"	"abc"	0
	[입출력 예 설명]
	입출력 예 #1
		"hello"를 오른쪽으로 한 칸 밀면 "ohell"가 됩니다.
	입출력 예 #2
		"apple"은 몇 번을 밀어도 "elppa"가 될 수 없습니다.
	입출력 예 #3
		"atat"는 오른쪽으로 한 칸, 세 칸을 밀면 "tata"가 되므로 최소 횟수인 1을 반환합니다.
	입출력 예 #4
		"abc"는 밀지 않아도 "abc"이므로 0을 반환합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		
        System.out.println(solution(A,B));
	}
	
	public static int solution(String A, String B) {
        int answer = 0;
        // A를 복사
        String temp = A;
        // 반복 비교 후 같은것이 없으면 바로 -1 return
        for(int i=0; i<A.length(); i++){
        	// 밀기 전 처음 비교
            if(temp.equals(B)){
                return answer;
            }
            // 마지막 문자만 남겨두고 자르기
            String a = temp.substring(temp.length()-1);
            // 잘라둔 마지막 문자와 처음부터 마지막 전까지 붙이기
            temp = a + temp.substring(0, temp.length()-1);
            answer++;
        }
        return -1;
    }
}
