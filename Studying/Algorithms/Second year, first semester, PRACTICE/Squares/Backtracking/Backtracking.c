#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <limits.h>

//functions
void optimizeRectangleSize();
int** initTwoDimentionalArray(int columns, int rows);
void searchMinNumberOfSquares(int **rectangle);
int isFilled(int **rectangle);
void clearCurrentNumber(int **rectangle, int number);
int min(int number1, int number2);
int isFreeCell(int **rectangle, int posY, int posX);
int possibleToSetSquare(int **rectangle, int startPosY, int startPosX, int sideLenght);
void setSquare(int **rectangle, int startPosY, int startPosX, int sideLenght);
void printRectangle(int **rectangle);

//variables
int rectWidth, rectHeight;
int currentNumberOfSquares = 0;
int minNumberOfSquares = INT_MAX;

int main(int argc, char *argv[]) {

	printf("Enter the width of rectangle: ");
	scanf("%d", &rectWidth);
	
	printf("Enter the height of rectangle: ");
	scanf("%d", &rectHeight);
	
	optimizeRectangleSize();
	
	int** rectangle = initTwoDimentionalArray(rectWidth, rectHeight);
	
	searchMinNumberOfSquares(rectangle);
	
	printf("%d", minNumberOfSquares);
	return 0;
}

void optimizeRectangleSize(){
	int greatestCommonFactor = min(rectWidth, rectHeight);
	
	int i;
	for(i=greatestCommonFactor ; i>1 ; i--){
		if(rectWidth%i == 0 && rectHeight%i == 0){
			rectWidth /= i;
			rectHeight /= i;
			break;
		}
	}
}

int** initTwoDimentionalArray(int columns, int rows){
	
	int **array = (int**)calloc(rows, sizeof(int*));
	
	int i;
	for(i=0 ; i<rows ; i++){
		array[i] = (int*)calloc(columns, sizeof(int));
	}
	
	return array;
}

void searchMinNumberOfSquares(int **rectangle){
		
	if(currentNumberOfSquares >= minNumberOfSquares){
		return;
	}
	
	if(isFilled(rectangle)){
		minNumberOfSquares = currentNumberOfSquares;	
		return;	
	}
	
	
	int i,j,k;
	for(i=0 ; i<rectHeight ; i++){
		for(j=0 ; j<rectWidth ; j++){
			if(isFreeCell(rectangle, i, j)){
				for(k=min(rectWidth,rectHeight) ; k>0 ; k--){
					if(possibleToSetSquare(rectangle, i, j, k)){
						currentNumberOfSquares++;
						setSquare(rectangle, i, j, k);
						searchMinNumberOfSquares(rectangle);
						clearCurrentNumber(rectangle, currentNumberOfSquares);
						currentNumberOfSquares--;
					}
				}
			}
		}
	}
	
	return;
}

int isFilled(int **rectangle){
	
	int i,j;
	
	for(i=0 ; i<rectHeight ; i++){
		for(j=0 ; j<rectWidth ; j++){
			if(rectangle[i][j] == 0){
				return 0;
			}
		}
	}
	return 1;
}

void clearCurrentNumber(int **rectangle, int number){
	
	int i,j;
	for(i=0 ; i<rectHeight ; i++){
		for(j=0 ; j<rectWidth ; j++){
			if(rectangle[i][j] == number){
				rectangle[i][j] = 0;
			}
		}
	}
}

int min(int number1, int number2){
	if(number1 < number2){
		return number1;
	}else{
		return number2;
	}
}

int isFreeCell(int **rectangle, int posY, int posX){
	if(rectangle[posY][posX] != 0){
		return 0;
	}
	return 1;
}

int possibleToSetSquare(int **rectangle, int startPosY, int startPosX, int sideLenght){
	
	if((startPosY + sideLenght > rectHeight) || (startPosX + sideLenght > rectWidth)){
		return 0;
	}
	
	int i,j;
	for(i=startPosY ; i<startPosY+sideLenght ; i++){
		for(j=startPosX ; j<startPosX+sideLenght ; j++){
			if(rectangle[i][j] != 0){
				return 0;
			}
		}
	}
	
	return 1;
}

void setSquare(int **rectangle, int startPosY, int startPosX, int sideLenght){
	
	int i,j;
	for(i=startPosY ; i<startPosY+sideLenght ; i++){
		for(j=startPosX ; j<startPosX+sideLenght ; j++){
			rectangle[i][j] = currentNumberOfSquares;
		}
	}
}

void printRectangle(int **rectangle){
	
	int i,j;
	for(i=0 ; i<rectHeight ; i++){
		for(j=0 ; j<rectWidth ; j++){
			printf("%d  ", rectangle[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}
