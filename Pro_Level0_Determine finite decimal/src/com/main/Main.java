package com.main;

import java.util.*;

public class Main {
	/*
	[문제 설명]
	소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다.
	분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다.
	유한소수가 되기 위한 분수의 조건은 다음과 같습니다.
		기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
	두 정수 a와 b가 매개변수로 주어질 때,
	 a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.
	[제한사항]
	a, b는 정수
	0 < a ≤ 1,000
	0 < b ≤ 1,000
	[입출력 예]
	a		b		result
	7		20		1
	11		22		1
	12		21		2
	[입출력 예 설명]
	입출력 예 #1
		분수 7/20은 기약분수 입니다. 분모 20의 소인수가 2, 5 이기 때문에 유한소수입니다. 따라서 1을 return합니다.
	입출력 예 #2
		분수 11/22는 기약분수로 나타내면 1/2 입니다. 분모 2는 소인수가 2 뿐이기 때문에 유한소수 입니다.
		따라서 1을 return합니다.
	입출력 예 #3
		분수 12/21는 기약분수로 나타내면 4/7 입니다. 분모 7은 소인수가 7 이므로 무한소수입니다.
		따라서 2를 return합니다.
	[힌트]
	분자와 분모의 최대공약수로 약분하면 기약분수를 만들 수 있습니다.
	정수도 유한소수로 분류합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int answer = 0;
		// 분모 b 만 최대공약수로 나누어 기약분수의 분모로 만든다.
        int temp = b / maxNum(a,b);
        // 분모를 2로 소인수 분해
        while(temp % 2 == 0){
            temp /= 2;
        }
        // 분모를 5로 소인수 분해
        while(temp % 5 == 0){
            temp /= 5;
        }
        // 최종 1이면 소인수 2, 5이기 때문에 answer 1, 아니면 2를 반환
        if(temp == 1){
            answer = 1;
        } else{
            answer = 2;
        }
        System.out.println(answer);
	}
	// a와 b의 최대 공약수 구하는 메소드
	private static int maxNum(int a, int b){
        int max = 0;
        for(int i=1; i<=a && i<=b; i++){
            if(a%i == 0 && b%i == 0){
                max = i;
            }
        }
        return max;
    }
}
