#include <stdio.h>
#include <stdlib.h>

int** init_array(int size, int **array);
void visited_to_false(int size, char *visited);
void set_connections_for_matrix(int sizeX, int sizeY, int **matrix);
void print_matrix(int size, int **matrix);
void count_all_knight_moves(int **matrix, char *visited, int sizeX, int sizeY);
void search_moves(int **matrix, char *visited, int start, int size);
int isVisited(char *visited, int size);

long long int counter = 0;

int main() {
	
	int sizeX, sizeY;
	printf("Enter width of chest desk: ");
	scanf("%d", &sizeX);
	printf("Enter height of chest desk: ");
	scanf("%d", &sizeY);
	
	int **matrix = NULL;
	matrix = init_array(sizeX*sizeY, matrix);
		
	char *visited = (char*)malloc(sizeof(char)*(sizeX*sizeY));
	visited_to_false(sizeX*sizeY, visited);

	set_connections_for_matrix(sizeX, sizeY, matrix);
	
	//print_matrix(sizeX*sizeY, matrix);
	
	count_all_knight_moves(matrix, visited, sizeX, sizeY);
	
	printf("Counter = %ld\n", counter);
	
	system("pause");
	return 0;
}

int** init_array(int size, int **array){
	
	int i;
	
	array = (int**)calloc(size, sizeof(int*));
	for(i=0 ; i<size ; i++){
		array[i] = (int*)calloc(size, sizeof(int));
	}
	return array;
}

void visited_to_false(int size, char *visited){
	
	int i;
	
	for(i=0 ; i<size ; i++){
		visited[i] = 'f';
	}
}

void set_connections_for_matrix(int sizeX, int sizeY, int **matrix){
	
	int i,j;
	
	for(i=0 ; i<sizeY ; i++){
		for(j=0 ; j<sizeX ; j++){
			if(i-1 >= 0 && j-2 >= 0){
				matrix[i*sizeX + j][(i-1)*sizeY + (j-2)] = 1;
			}
			if(i-2 >= 0 && j-1 >= 0){
				matrix[i*sizeX + j][(i-2)*sizeY + (j-1)] = 1;
			}
			if(i-2 >= 0 && j+1 < sizeX){
				matrix[i*sizeX + j][(i-2)*sizeY + (j+1)] = 1;
			}
			if(i-1 >= 0 && j+2 < sizeX){
				matrix[i*sizeX + j][(i-1)*sizeY + (j+2)] = 1;
			}
			if(i+1 < sizeY && j+2 < sizeX){
				matrix[i*sizeX + j][(i+1)*sizeY + (j+2)] = 1;
			}
			if(i+2 < sizeY && j+1 < sizeX){
				matrix[i*sizeX + j][(i+2)*sizeY + (j+1)] = 1;
			}
			if(i+2 < sizeY && j-1 >= 0){
				matrix[i*sizeX + j][(i+2)*sizeY + (j-1)] = 1;
			}
			if(i+1 < sizeY && j-2 >= 0){
				matrix[i*sizeX + j][(i+1)*sizeY + (j-2)] = 1;
			}
		}
	}
}

void print_matrix(int size, int **matrix){
	
	int i,j;
	
	for(i=0 ; i<size ; i++){
		for(j=0 ; j<size ; j++){
			printf("%d  ", matrix[i][j]);
		}
		printf("\n");
	}
}

void count_all_knight_moves(int **matrix, char *visited, int sizeX, int sizeY){
	
	int i;
	for(i=0 ; i<(sizeX*sizeY) ; i++){
		search_moves(matrix, visited, i, sizeX*sizeY);
	}
}

void search_moves(int **matrix, char *visited, int start, int size){
	
	visited[start] = 't';
	if(isVisited(visited, size)){
		visited[start] = 'f';
		counter++;
		printf("%ld\n", counter);
		return;
	}
	
	int i;
	for(i=0 ; i<size ; i++){
		if(matrix[start][i] == 1 && visited[i] == 'f'){
			search_moves(matrix, visited, i, size);
		}
	}
	
	visited[start] = 'f';
}

int isVisited(char *visited, int size){
	
	int i;
	for(i=0 ; i<size ; i++){
		if(visited[i] == 'f'){
			return 0;
		}
	}
	
	return 1;
}










