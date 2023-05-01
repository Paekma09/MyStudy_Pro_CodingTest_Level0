package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	/*
	[문제 설명]
	정수 l과 r이 주어졌을 때, l 이상 r이하의 정수 중에서 
	숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
	만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.
	[제한사항]
	1 ≤ l ≤ r ≤ 1,000,000
	[입출력 예]
	l		r		result
	5		555	[5, 50, 55, 500, 505, 550, 555]
	10		20		[-1]
	[입출력 예 설명]
	입출력 예 #1
		5 이상 555 이하의 0과 5로만 이루어진 정수는 작은 수부터 5, 50, 55, 500, 505, 550, 555가 있습니다. 
		따라서 [5, 50, 55, 500, 505, 550, 555]를 return 합니다.
	입출력 예 #2
		10 이상 20 이하이면서 0과 5로만 이루어진 정수는 없습니다. 따라서 [-1]을 return 합니다.
	*/
	public static void main(String[] args) {
		int l1 = 5;
		int r1 = 555;
		int l2 = 10;
		int r2 = 20;
		
		System.out.print(l1+" "+r1+" ");
		System.out.println(Arrays.toString(solution(l1, r1)));
		System.out.print(l2+" "+r2+" ");
		System.out.println(Arrays.toString(solution(l2, r2)));
	}
	public static int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        // l부터 r까지 차례대로 문자열에 넣기 위한 temp 선언
        String temp = "";
        // 정규식 표현 패턴 만들기
        Pattern pt = Pattern.compile("^[50]+$");
        for(int i=l; i<=r; i++){
        	temp = Integer.toString(i);
        	// 정규식 표현 패턴과 매칭하는지 여부 알기 위한 matcher 만들기
        	Matcher matcher1 = pt.matcher(temp);
        	// find메소드 이용하여 찾아 list에 저장하기
            if(matcher1.find() == true) {
            	list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        if(list.size() ==0) {
        	list.add(-1);
        	answer = list.stream().mapToInt(Integer::intValue).toArray();
        }else {
        	answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        return answer;
    }
}
