package com.main;

import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	등차수열 혹은 등비수열 common이 매개변수로 주어질 때,
	마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.
	[제한사항]
	2 < common의 길이 < 1,000
	-1,000 < common의 원소 < 2,000
	common의 원소는 모두 정수입니다.
	등차수열 혹은 등비수열이 아닌 경우는 없습니다.
	등비수열인 경우 공비는 0이 아닌 정수입니다.
	[입출력 예]
	common		result
	[1, 2, 3, 4]	5
	[2, 4, 8]		16
	[입출력 예 설명]
	입출력 예 #1
		[1, 2, 3, 4]는 공차가 1인 등차수열이므로 다음에 올 수는 5이다.
	입출력 예 #2
		[2, 4, 8]은 공비가 2인 등비수열이므로 다음에 올 수는 16이다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] common = new int[length];
		for(int i=0; i<common.length; i++) {
			common[i] = sc.nextInt();
		}
		int answer = 0;
		// 등차 수열인지 판단 (등차 수열이 아니면 등비 수열이다)
        boolean ari = false;
        int gongcha = 0;
        for(int i=0; i<common.length-2; i++){
            if(common[i+1]-common[i] == common[common.length-1]-common[common.length-2]){
                ari = true;
                gongcha = common[i+1]-common[i];
                break;
            }
        }
        if(ari == true){
            answer = common[common.length-1] + gongcha;
        }else{
            answer = common[common.length-1] * (common[common.length-1] / common[common.length-2]);
        }
        System.out.println(answer);
	}
}
