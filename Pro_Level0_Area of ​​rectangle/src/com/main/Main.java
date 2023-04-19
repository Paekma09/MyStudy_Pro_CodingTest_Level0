package com.main;

import java.util.*;

public class Main {
	/*
	[문제 설명]
	2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다.
	직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열
	dots가 매개변수로 주어질 때, 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.
	[제한사항]
	dots의 길이 = 4
	dots의 원소의 길이 = 2
	-256 < dots[i]의 원소 < 256
	잘못된 입력은 주어지지 않습니다.
	[입출력 예]
	dots													result
	[[1, 1], [2, 1], [2, 2], [1, 2]]				1
	[[-1, -1], [1, 1], [1, -1], [-1, 1]]		4
	[입출력 예 설명]
	입출력 예 #1
		좌표 [[1, 1], [2, 1], [2, 2], [1, 2]] 를 꼭짓점으로 갖는
		직사각형의 가로, 세로 길이는 각각 1, 1이므로 직사각형의 넓이는 1 x 1 = 1입니다.
	입출력 예 #2
		좌표 [[-1, -1], [1, 1], [1, -1], [-1, 1]]를 꼭짓점으로 갖는
		직사각형의 가로, 세로 길이는 각각 2, 2이므로 직사각형의 넓이는 2 x 2 = 4입니다.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dots = new int[4][2];
		for(int i=0; i<dots.length; i++) {
			for(int j=0; j<dots[i].length; j++) {
				dots[i][j] = sc.nextInt();
			}
		}
		int answer = 0;
		// 가로, 세로 변수 선언
		int width = 0;
        int length = 0;
        // 이 문제의 키 포인트
        // 가로 = x 최대값 - x 최소값
        // 세로 = y 최대값 - y 최소값
        int x_max = dots[0][0];
        int x_min = dots[0][0];
        int y_max = dots[0][1];
        int y_min = dots[0][1];
        for(int i=0; i<4; i++){
            if(x_max < dots[i][0]){
                x_max = dots[i][0];
            }
            if(x_min > dots[i][0]){
                x_min = dots[i][0];
            }
            if(y_max < dots[i][1]){
                y_max = dots[i][1];
            }
            if(y_min > dots[i][1]){
                y_min = dots[i][1];
            }
        }
        width = x_max - x_min;
        length = y_max - y_min;
        answer = width * length;
        System.out.println(answer);
	}
}
