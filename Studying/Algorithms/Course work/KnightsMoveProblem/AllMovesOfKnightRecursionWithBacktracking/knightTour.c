#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <time.h>

//functions
void countAllKnightMoveTours();
int tourIsPossible(int posInRow, int posInColumn);
int** initTwoDimentionalArray(int columns, int rows);
void countKnightMovesFromOneCell(int posInRow, int posInColumn, int **chessBoard);
void printChessBoard(int **chessBoard);

//variables
int chessBoardWidth;
int chessBoardHeight;
int knightTourCounter = 0; //current number of passed cells
int numberOfKnightTours = 0; //summary number of knight tours
int maxCountOfKnightTour;
int printable;
const int possibleKnightMoveX[] = { -1, -1, 1, 1, -2, -2, 2, 2 };
const int possibleknightMoveY[] = { 2, -2, 2, -2, 1, -1, 1, -1 };

int main(int argc, char *argv[]) {	
		
	printf("Enter the width of desk: ");
	scanf("%d", &chessBoardWidth);
	
	printf("Enter the heigth of desk: ");
	scanf("%d", &chessBoardHeight);
	
	
	printf("Do you want to print knight tour? (0 - No, 1 - Yes): ");
	scanf("%d", &printable);
	
	if(printable == 1){
		printf("How much knight tour's you want to print?\nTo print ALL enter 'YOUR NUMBER' < 1\nEnter the number: ");
		scanf("%d", &maxCountOfKnightTour);
		
		countAllKnightMoveTours();
	}else if(printable == 0){
		maxCountOfKnightTour = 0;
		
		printf("Calculating...\n");
		countAllKnightMoveTours();
		printf("%d Tours", numberOfKnightTours);
	}
	
	return 0;
}

void countAllKnightMoveTours(){
	
	int **chessBoard = initTwoDimentionalArray(chessBoardWidth, chessBoardHeight);
	
	int i,j;
	for(i=0 ; i<chessBoardHeight ; i++){
		for(j=0 ; j<chessBoardWidth ; j++){
			if(tourIsPossible(i, j)){
				countKnightMovesFromOneCell(i, j, chessBoard);
			}
		}
	}
}

int tourIsPossible(int posInRow, int posInColumn){
	if(((chessBoardWidth * chessBoardHeight)%2 != 0) 
		&& ((posInRow + posInColumn)%2 != 0)){
		return 0;
	}
	return 1;
}

int** initTwoDimentionalArray(int columns, int rows){
	
	int **array = (int**)calloc(rows, sizeof(int*));
	
	int i;
	for(i=0 ; i<rows ; i++){
		array[i] = (int*)calloc(columns, sizeof(int));
	}
	
	return array;
}

void countKnightMovesFromOneCell(int posInRow, int posInColumn, int **chessBoard){
	
	knightTourCounter++;
	chessBoard[posInRow][posInColumn] = knightTourCounter;
	
	if(knightTourCounter == chessBoardWidth*chessBoardHeight){
		numberOfKnightTours++;
		
		if(printable == 1){
			printChessBoard(chessBoard);
		}
		
		if(maxCountOfKnightTour == numberOfKnightTours){
			exit(0);
		}
		
		chessBoard[posInRow][posInColumn] = 0;
		knightTourCounter--;
		return;
	}
	
	int i;
	for(i=0 ; i<8 ; i++){
		if((posInRow + possibleknightMoveY[i] < chessBoardHeight) && (posInRow + possibleknightMoveY[i] >= 0) && 
		(posInColumn + possibleKnightMoveX[i] < chessBoardWidth) && (posInColumn + possibleKnightMoveX[i] >= 0) && 
		(chessBoard[posInRow + possibleknightMoveY[i]][posInColumn + possibleKnightMoveX[i]] == 0)){
			countKnightMovesFromOneCell(posInRow + possibleknightMoveY[i], posInColumn + possibleKnightMoveX[i], chessBoard);
		}
	}
	
	chessBoard[posInRow][posInColumn] = 0;
	knightTourCounter--;
	return;
}

void printChessBoard(int **chessBoard){
	
	int i,j;
	for(i=0 ; i<chessBoardHeight ; i++){
		for(j=0 ; j<chessBoardWidth ; j++){
			printf("%d\t", chessBoard[i][j]);
		}
		printf("\n");
	}
	printf("\n\n");
}
