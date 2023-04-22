package com.main;

import java.util.Scanner;

public class Main {
	/*
	[문제 설명]
	다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
	지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
	지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 
	안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
	[제한사항]
	board는 n * n 배열입니다.
	1 ≤ n ≤ 100
	지뢰는 1로 표시되어 있습니다.
	board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
	[입출력 예]
	board																																							result
	[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]													16
	[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]													13
	[[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0
	[입출력 예 설명]
	입출력 예 #1
		(3, 2)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선 총 8칸은 위험지역입니다.
		따라서 16을 return합니다.
	입출력 예 #2
		(3, 2), (3, 3)에 지뢰가 있으므로 지뢰가 있는 지역과 지뢰와 인접한 위, 아래, 좌, 우, 대각선은 위험지역입니다.
		 따라서 위험지역을 제외한 칸 수 13을 return합니다.
	입출력 예 #3
		모든 지역에 지뢰가 있으므로 안전지역은 없습니다. 따라서 0을 return합니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		// 이 문제의 키포인트는 지뢰가 있으면 
		// 상,하,좌,우, 왼쪽 위 대각선, 오른쪽 위 대각선, 왼쪽 아래 대각선, 오른쪽 아래 대각선 모두 위험 지역이다.
		// 단 지뢰가 board의 모서리 끝이거나, 변의 끝이면 다르다.
		int answer = 0;
		int[][] temp = new int[board.length][board[0].length];
		// 지뢰 찾기
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == 1) {
					// 지뢰와 그 주변 위험 지역 찾기 danger() 메소드 
					danger(i,j,temp);
				}
			}
		}
		// 안전 지대 카운트 count() 메소드
		answer = count(temp);
        System.out.println(answer);
	}
	// 지뢰의 주변 위험 지역 찾기 메소드
	private static void danger(int i, int j, int[][] temp) {
		// X축
		int X = temp.length;
		// Y축
		int Y = temp[0].length;
		
		temp[i][j] = 1;				// 지뢰
		if(i>0) {
			temp[i-1][j] = 1;		// 지뢰의 왼쪽
		}
		if(i<X-1) {
			temp[i+1][j] = 1;		// 지뢰의 오른쪽
		}
		if(j>0) {
			temp[i][j-1] = 1;		// 지뢰의 위쪽
		}
		if(j<Y-1) {
			temp[i][j+1] = 1;		// 지뢰위 아래쪽
		}
		if(i>0 && j>0 ) {		
			temp[i-1][j-1] = 1;	// 지뢰의 왼쪽 상단
		}
		if(i<X-1 && j>0) {		
			temp[i+1][j-1] =1;	// 지뢰의 오른쪽 상단
		}
		if(i>0 && j<Y-1) {		
			temp[i-1][j+1] = 1;	// 지뢰의 왼쪽 하단
		}
		if(i<X-1 && j<Y-1) {	
			temp[i+1][j+1] = 1;	// 지뢰의 오른쪽 하단
		}
	}
	// 안전 지대 카운트
	private static int count(int[][] temp) {
		int count = 0;
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<temp[i].length; j++) {
				if(temp[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
}
