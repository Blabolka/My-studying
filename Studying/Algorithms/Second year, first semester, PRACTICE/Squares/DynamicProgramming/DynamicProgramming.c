#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <time.h>

int min_squares(int rectHeight, int n);
int min(int number1, int number2);

int main() {
	
	int rectHeight, rectWidth;
	clock_t time;
	
	printf("Enter the height of rectangle: ");
	scanf("%d", &rectHeight);
	
	printf("Enter the width of rectangle: ");
	scanf("%d", &rectWidth);

	time = clock();
	printf("\nMinimun number of squares: %d\n", min_squares(rectHeight, rectWidth));
	time = clock() - time;
	printf("Time: %d ms\n\n", time);
	
	return 0;
}

int min_squares(int rectHeight, int rectWidth) {
	if (rectHeight == rectWidth)
	    return 1;
	
	static int cache[100][100];
	
	if (rectHeight < rectWidth){
		int temp = rectHeight;
		rectHeight = rectWidth;
		rectWidth = temp;
	}
	    
	if (cache[rectHeight][rectWidth]){
		return cache[rectHeight][rectWidth];
	}
	    
	
	int x = INT_MAX;
	
	int i;
	for(i=1; i+i <= rectWidth; i++){
		x = min(x, min_squares(rectHeight, i) + min_squares(rectHeight, rectWidth-i));
	}
	    
	for (i=1; i+i <= rectHeight; i++){
		x = min(x, min_squares(i, rectWidth) + min_squares(rectHeight-i, rectWidth));
	}
	    
	
	return cache[rectHeight][rectWidth] = x;
}

int min(int number1, int number2){
	return number1 < number2 ? number1 : number2;
}
