#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <malloc.h>

void fill_array(int *array, int size);
void print_array(int *array, int size);
void counting_sort(int *array, int size);

int main(int argc, char *argv[]){
	
	int size;
	
	printf("Enter the number of elements array: ");
	scanf("%d", &size);
	
	int *array = (int*)malloc(sizeof(int)*size);
	
	srand(time(0));
	
	fill_array(array, size);
	
	print_array(array, size);
	counting_sort(array, size);
	print_array(array, size);
	
	return 0;
}

void fill_array(int *array, int size){
	
	int i;
	
	for(i=0 ; i<size ; i++){
		array[i] = rand()%10;
	}
}

void print_array(int *array, int size){
	
	int i;
	
	for(i=0 ; i<size ; i++){
		printf("%d\t", array[i]);
	}
	printf("\n");
}

void counting_sort(int *array, int size){
	
	int i;
	
	/*for size of counting array*/
	int maxNumber = array[0];
	
	/*allocate memory to sorted array*/
	int *sortedArray = (int*)malloc(sizeof(int)*size);
	
	/*counting array*/
	int *countingArray = NULL;
	
	/*search max number of input array*/
	for(i=0 ; i<size ; i++){
		if(array[i] > maxNumber){
			maxNumber = array[i];
		}
	}
	
	/*allocate memory for counting array*/
	countingArray = (int*)calloc(maxNumber+1, sizeof(int));
	
	/*search frequency for element of input array*/
	for(i=0 ; i<size ; i++){
		countingArray[array[i]] += 1;
	}
	
	/*modify the count array by adding the previous counts*/
	for(i=0 ; i<maxNumber ; i++){
		countingArray[i+1] = countingArray[i] + countingArray[i+1];
	}
	
	/*fill sortedArray, do the counting sort*/
	for(i=size-1 ; i>=0 ; i--){
		sortedArray[countingArray[array[i]] - 1] = array[i];
		countingArray[array[i]]--;
	}
	
	/*fill array from sortedArray*/
	for(i=0 ; i<size ; i++){
		array[i] = sortedArray[i];
	}
}
