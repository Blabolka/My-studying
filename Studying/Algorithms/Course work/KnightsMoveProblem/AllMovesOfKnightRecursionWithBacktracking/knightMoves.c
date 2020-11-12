#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	
	int chestDeskWidth, chestDeskHeight;
	
	printf("Enter the width of desk: ");
	scanf("%d", &chestDeskWidth);
	
	printf("Enter the heigth of desk: ");
	scanf("%d", &chestDeskHeight);
	
	int chestDesk[chestDeskHeight][chestDeskWidth];
	
	int possibleKnightMoveX[] = { -1, -1, 1, 1, -2, -2, 2, 2 };
	int possibleknightMoveY[] = { 2, -2, 2, -2, 1, -1, 1, -1 };
	
	return 0;
}


