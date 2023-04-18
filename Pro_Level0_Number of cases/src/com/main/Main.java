package com.main;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	머쓱이는 구슬을 친구들에게 나누어주려고 합니다.
	구슬은 모두 다르게 생겼습니다.
	머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, 
	balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.
	[제한사항]
	1 ≤ balls ≤ 30
	1 ≤ share ≤ 30
	구슬을 고르는 순서는 고려하지 않습니다.
	share ≤ balls
	[입출력 예]
	balls		share		result
	3			2				3
	5			3				10
	[입출력 예 설명]
	입출력 예 #1
		서로 다른 구슬 3개 중 2개를 고르는 경우의 수는 3입니다.
	입출력 예 #2
		서로 다른 구슬 5개 중 3개를 고르는 경우의 수는 10입니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int balls = sc.nextInt();
		int share = sc.nextInt();
		int answer = 0;
		// 이 문제의 키 포인트 -> 서로 다른 n개 중 m개를 뽑는 경우의 수 공식 = n !  /  (n-m) ! x m ! 
		// 각각의 배열 변수 선언
        int[] balls_arr = new int[balls];
        int[] share_arr = new int[share];
        int[] temp = new int[balls-share];
        // factory 연산할 변수 BigInteger 선언
        BigInteger factory_temp = new BigInteger("1");
        BigInteger factory_balls_arr = new BigInteger("1");
        BigInteger factory_share_arr = new BigInteger("1");
        // (n-m) ! 구하기 -> int를 BigInteger로 형 변환 BigInteger.valueOf() 이용 -> 곱하기 연산 multiply()
        for(int i=0; i<temp.length; i++){
            temp[i] = temp.length - i;
            factory_temp = factory_temp.multiply(BigInteger.valueOf(temp[i]));
        }
        // n ! 구하기 -> int를 BigInteger로 형 변환 BigInteger.valueOf() 이용 -> 곱하기 연산 multiply()
        for(int i=0; i<balls_arr.length; i++){
            balls_arr[i] = balls_arr.length - i;
            factory_balls_arr = factory_balls_arr.multiply(BigInteger.valueOf(balls_arr[i]));
        }
        // m ! 구하기 -> int를 BigInteger로 형 변환 BigInteger.valueOf() 이용 -> 곱하기 연산 multiply()
        for(int i=0; i<share_arr.length; i++){
            share_arr[i] = share_arr.length - i;
            factory_share_arr = factory_share_arr.multiply(BigInteger.valueOf(share_arr[i]));
        }
        // 연산 후 int로 형 변환 intValue() 사용 -> 곱하기 연산 multiply() / 나누기 연산 divide()
        answer = factory_balls_arr.divide((factory_temp.multiply(factory_share_arr))).intValue();
        System.out.println(answer);
	}
}
