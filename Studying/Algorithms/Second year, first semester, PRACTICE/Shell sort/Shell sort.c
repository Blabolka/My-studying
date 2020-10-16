#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

void fill_array(int *array, long size);
void print_array(int *array, long size);
void shell_sort_donald_shell(int *array, long size);
void shell_sort_marcin_ciura(int *array, long size);

long counterForDonaldShell = 0;
long counterForMarcinCiura = 0;

double timeForDonaldShell;
double timeForMarcinCiura;

int main(int argc, char *argv[]){
	
	srand(time(0));
	
	long size;
	
	printf("Enter the number of elements array: ");
	scanf("%ld", &size);
	
	int *array1 = (int*)malloc(sizeof(int)*size);
	int *array2 = (int*)malloc(sizeof(int)*size);
	
	fill_array(array1, size);
	memcpy(array2, array1, sizeof(int)*size);
	
	shell_sort_donald_shell(array1, size);
	shell_sort_marcin_ciura(array2, size);
	
	printf("Number of exchanges Donald Shell's sequence: %ld\n", counterForDonaldShell);
	printf("Time of Donald Shell's sort: %.0fms\n\n", timeForDonaldShell);
	
	printf("Number of exchanges Marcin Ciura's sequence: %ld\n", counterForMarcinCiura);
	printf("Time of Marcin Ciura sort: %.0fms\n", timeForMarcinCiura);
	
	return 0;
}

void fill_array(int *array, long size){
	
	int i;
	
	for(i=0 ; i<size ; i++){
		array[i] = size-i;//rand()%30;
	}
}

void print_array(int *array, long size){
	
	int i;
	
	for(i=0 ; i<size ; i++){
		printf("%d\t", array[i]);
	}
	printf("\n");
}

void shell_sort_donald_shell(int *array, long size){
	
	clock_t time = clock();
	
	int i,j,step,temp;
	
	for (step = size / 2; step > 0; step /= 2){
		
		for (i = step; i < size; i++){
			
			for (j = i - step; j >= 0 && array[j] > array[j + step]; j -= step){
				counterForDonaldShell++;
				temp = array[j];
				array[j] = array[j + step];
				array[j + step] = temp;
			}	
		} 	
	}
	
	timeForDonaldShell = (double)(clock() - time);
}

void shell_sort_marcin_ciura(int *array, long size){
	
	clock_t time = clock();
	
	int steps[] = {1750, 701, 301, 132, 57, 23, 10, 4, 1};
	int i,j,k,temp;
	
	for (k=0 ; k<9 ; k++){
		
		for (i = steps[k]; i < size; i++){
			
			for (j = i - steps[k]; j >= 0 && array[j] > array[j + steps[k]]; j -= steps[k]){
				counterForMarcinCiura++;
				temp = array[j];
				array[j] = array[j + steps[k]];
				array[j + steps[k]] = temp;
			}	
		} 	
	}
	
	timeForMarcinCiura = (double)(clock() - time);
}







