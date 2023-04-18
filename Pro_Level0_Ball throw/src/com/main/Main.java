package com.main;

import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다.
	공은 1번부터 던지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다.
	친구들의 번호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때,
	k번째로 공을 던지는 사람의 번호는 무엇인지 return 하도록 solution 함수를 완성해보세요.
	[제한사항]
	2 < numbers의 길이 < 100
	0 < k < 1,000
	numbers의 첫 번째와 마지막 번호는 실제로 바로 옆에 있습니다.
	numbers는 1부터 시작하며 번호는 순서대로 올라갑니다.
	[입출력 예]
	numbers					k		result
	[1, 2, 3, 4]				2		3
	[1, 2, 3, 4, 5, 6]		5		3
	[1, 2, 3]					3		2
	[입출력 예 설명]
	입출력 예 #1
		1번은 첫 번째로 3번에게 공을 던집니다.
		3번은 두 번째로 1번에게 공을 던집니다.
	입출력 예 #2
		1번은 첫 번째로 3번에게 공을 던집니다.
		3번은 두 번째로 5번에게 공을 던집니다.
		5번은 세 번째로 1번에게 공을 던집니다.
		1번은 네 번째로 3번에게 공을 던집니다.
		3번은 다섯 번째로 5번에게 공을 던집니다.
	입출력 예 #3
		1번은 첫 번째로 3번에게 공을 던집니다.
		3번은 두 번째로 2번에게 공을 던집니다.
		2번은 세 번째로 1번에게 공을 던집니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] numbers = new int[length];
		for(int i=0; i<length; i++) {
			numbers[i] = i + 1;
		}
		int k = sc.nextInt();
		// k 번째로 던져진 지점이 아니라 던진 사람이기 때문에 (k-1)
		// 한 칸씩 건너뛰기 때문에 곱하기 2
		// 배열 안에서 순환이기 때문에 배열의 길이로 나눈 나머지 값이 answer의 index값임.
		int answer = numbers[(k-1) * 2 % numbers.length];
        System.out.println(answer);
	}
}
