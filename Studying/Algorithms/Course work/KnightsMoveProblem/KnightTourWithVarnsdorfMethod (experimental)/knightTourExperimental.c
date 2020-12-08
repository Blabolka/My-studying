#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

//functions
int** initTwoDimentionalArray(int columns, int rows);
void varnsdortFromAllCells(int height, int width, int **chessBoard);
int varnsdorf(int height, int width, int **chessBoard, int currentPosY, int currentPosX);
int countNumberOfAvailableMoves(int height, int width, int **chessBoard, int currentPosY, int currentPosX);
void printChess(int height, int width, int **chessBoard);
void clearChess(int height, int width, int **chessBoard);

//variables
const int possibleKnightMoveX[] = { -1, -1, 1, 1, -2, -2, 2, 2 };
const int possibleKnightMoveY[] = { 2, -2, 2, -2, 1, -1, 1, -1 };

int main(int argc, char *argv[]) {

	int height, width;
	
	printf("Enter the height of chessboard: ");
	scanf("%d", &height);
	
	printf("Enter the width of chessboard: ");
	scanf("%d", &width);
	
	int **chessBoard = initTwoDimentionalArray(height, width);
	varnsdortFromAllCells(height, width, chessBoard);
	
	return 0;
}

int** initTwoDimentionalArray(int rows, int columns){
	
	int **array = (int**)calloc(rows, sizeof(int*));
	
	int i;
	for(i=0 ; i<rows ; i++){
		array[i] = (int*)calloc(columns, sizeof(int));
	}
	
	return array;
}

void varnsdortFromAllCells(int height, int width, int **chessBoard){
	
	int i,j;
	int numberOfPassedCells;
	for(i=0 ; i<height ; i++){
		for(j=0 ; j<width ; j++){
			numberOfPassedCells = varnsdorf(height, width, chessBoard, i, j);
			printf("\n\nStarting from [%d][%d]\n", i, j);
			printf("Number of passed cells: %d\n", numberOfPassedCells);
			printChess(height, width, chessBoard);
			clearChess(height, width, chessBoard);
		}
	}
}

int varnsdorf(int height, int width, int **chessBoard, int currentPosY, int currentPosX){
		
	int i,j;
	
	for(i=0 ; i<height*width ; i++){
		chessBoard[currentPosY][currentPosX] = i+1;
		
		int whereToGo;
		int endMove = -1;
		int maxAvailableMoves = 0;
		for(j=0 ; j<8 ; j++){
			if(possibleToMove(height, width, chessBoard, currentPosY, currentPosX, j)){
				endMove = j;
				int numberOfAvailableMoves = countNumberOfAvailableMoves(height, width, chessBoard, currentPosY+possibleKnightMoveY[j], currentPosX+possibleKnightMoveX[j]);
				if(maxAvailableMoves < numberOfAvailableMoves){
					maxAvailableMoves = numberOfAvailableMoves;
					whereToGo = j;
				}
			}
		}
		
		if(endMove != -1 && maxAvailableMoves == 0){
			chessBoard[currentPosY+possibleKnightMoveY[endMove]][currentPosX+possibleKnightMoveX[endMove]] = i+2;
			return i+2;
		}else if(maxAvailableMoves == 0){
			return i;
		}
		
		currentPosY += possibleKnightMoveY[whereToGo];
		currentPosX += possibleKnightMoveX[whereToGo];
	}
}

int possibleToMove(int height, int width, int **chessBoard, int currentPosY, int currentPosX, int i){
	
	if((currentPosY + possibleKnightMoveY[i] < height) && (currentPosY + possibleKnightMoveY[i] >= 0) && 
	(currentPosX + possibleKnightMoveX[i] < width) && (currentPosX + possibleKnightMoveX[i] >= 0) && 
	(chessBoard[currentPosY + possibleKnightMoveY[i]][currentPosX + possibleKnightMoveX[i]] == 0)){
		return 1;
	}
	
	return 0;
}

int countNumberOfAvailableMoves(int height, int width, int **chessBoard, int currentPosY, int currentPosX){
	
	int i, counter=0;
	for(i=0 ; i<8 ; i++){
		if(possibleToMove(height, width, chessBoard, currentPosY, currentPosX, i)){
			counter++;
		}
	}
	
	return counter;
}

void printChess(int height, int width, int **chessBoard){
	
	int i,j;
	for(i=0 ; i<height ; i++){
		for(j=0 ; j<width ; j++){
			printf("%d\t", chessBoard[i][j]);
		}
		printf("\n");
	}
}

void clearChess(int height, int width, int **chessBoard){
	
	int i,j;
	for(i=0 ; i<height ; i++){
		for(j=0 ; j<width ; j++){
			chessBoard[i][j] = 0;
		}
	}
}
