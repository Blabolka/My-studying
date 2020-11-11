#include <stdio.h>
#include <stdlib.h>

int countNumberOfSquaresFromRectangle(int width, int height);

int main(int argc, char *argv[]) {
	
	int height, width;
	
	printf("Enter the width of the rectangle: ");
	scanf("%d", &width);
	
	printf("Enter the height of the rectangle: ");
	scanf("%d", &height);
	
	printf("Minimum number of squares in rectangle: %d", countNumberOfSquaresFromRectangle(width, height));
	
	return 0;
}

int countNumberOfSquaresFromRectangle(int width, int height){
	
	if(width == height){ return 1;}
	
	int count = 0;
	
	while(1){
		if(width > height){
			width -= height;
			count++;
		}else if(width < height){
			height -= width;
			count++;
		}else{
			return count + 1;
		}
	}
}












