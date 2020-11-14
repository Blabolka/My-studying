#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int countNumberOfSquaresFromRectangle(int width, int height);

int main(int argc, char *argv[]) {
	
	int height, width;
	clock_t time;
	
	printf("Enter the width of the rectangle: ");
	scanf("%d", &width);
	
	printf("Enter the height of the rectangle: ");
	scanf("%d", &height);
	
	printf("\n");
	
	time = clock();
	printf("\nMinimum number of squares in rectangle: %d\n", countNumberOfSquaresFromRectangle(width, height));
	time = clock() - time;
	printf("Time: %d ms\n\n", time);
	
	return 0;
}

int countNumberOfSquaresFromRectangle(int width, int height){
	
	if(width == height){
		printf("(%d x %d)", width, width);
		return 1;
	}
	
	int count = 0;
	
	while(1){
		if(width > height){
			width -= height;
			printf("(%d x %d) ", height, height);
			count++;
		}else if(width < height){
			height -= width;
			printf("(%d x %d) ", width, width);
			count++;
		}else{
			printf("(%d x %d) ", width, width);
			return count + 1;
		}
	}
}












