package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	정수 배열 date1과 date2가 주어집니다. 두 배열은 각각 날짜를 나타내며 [year, month, day] 꼴로 주어집니다. 
	각 배열에서 year는 연도를, month는 월을, day는 날짜를 나타냅니다.
	만약 date1이 date2보다 앞서는 날짜라면 1을, 아니면 0을 return 하는 solution 함수를 완성해 주세요.
	[제한사항]
	date1의 길이 = date2의 길이 = 3
	0 ≤ year ≤ 10,000
	1 ≤ month ≤ 12
		day는 month에 따라 가능한 날짜로 주어집니다.
	[입출력 예]
	date1				date2				result
	[2021, 12, 28]	[2021, 12, 29]	1
	[1024, 10, 24]	[1024, 10, 24]	0
	[입출력 예 설명]
	입출력 예 #1
		date1이 date2보다 하루 앞서기 때문에 1을 return 합니다.
	입출력 예 #2
		date1과 date2는 날짜가 서로 같으므로 date1이 더 앞서는 날짜가 아닙니다. 따라서 0을 return 합니다.
	*/
	public static void main(String[] args) {
		int[] date1 = {2021, 12, 28};
		int[] date2 = {2021, 12, 29};
		int[] date3 = {1024, 10, 24};
		int[] date4 = {1024, 10, 24};
		
		System.out.print(Arrays.toString(date1)+" "+Arrays.toString(date2)+" ");
		System.out.println(solution(date1, date2));
		System.out.print(Arrays.toString(date3)+" "+Arrays.toString(date4)+" ");
		System.out.println(solution(date3, date4));
	}
	public static int solution(int[] date1, int[] date2) {
        int answer = 0;
        // 이 문제의 키포인트는 날짜를 다 붙여서 숫자 형태로 비교하면 된다는 것이다.
        String Date1 = "";
        String Date2 = "";
        // int 배열을 String으로 변환
        for(int i=0; i<date1.length; i++){
            Date1 += date1[i];
            Date2 += date2[i];
        }
        // String을 Integer형태로 비교하여 answer값 저장
        if(Integer.parseInt(Date1)<Integer.parseInt(Date2)){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}
