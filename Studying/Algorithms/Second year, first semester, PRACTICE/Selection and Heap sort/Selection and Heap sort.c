#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

void fill_array(int *array, int size);
void print_array(int *array, int size);
void selection_sort(int *array, int size);
void heap_sort(int *array, int size);
void heapify(int *array, int size, int root);

double timeForSelectionSort;
double timeForHeapSort;

int main(int argc, char *argv[]){
	
	srand(time(0));
	
	int size;
	clock_t time;
	
	printf("Enter the number of elements array: ");
	scanf("%d", &size);
	
	int *array1 = (int*)malloc(sizeof(int)*size);
	int *array2 = (int*)malloc(sizeof(int)*size);
	
	fill_array(array1, size);
	memcpy(array2, array1, sizeof(int)*size);
	
	time = clock();
	selection_sort(array1, size);
	timeForSelectionSort = (double)(clock() - time);
	
	time = clock();
	heap_sort(array2, size);
	timeForHeapSort = (double)(clock() - time);
	
	printf("%.0lf ms\n", timeForSelectionSort);
	printf("%.0lf ms", timeForHeapSort);
	
	return 0;
}

void fill_array(int *array, int size){
	
	int i;
	
	for(i=0 ; i<size ; i++){
		array[i] = rand()%30;
	}
}

void print_array(int *array, int size){
	
	int i;
	
	for(i=0 ; i<size ; i++){
		printf("%d\t", array[i]);
	}
	printf("\n");
}

void selection_sort(int *array, int size){
	
	int i, j, temp;
	int index;
	
	for(i=size-1 ; i>=0 ; i--){
		index = 0;
		for(j=0 ; j<i+1 ; j++){
			if(array[j] > array[index]){
				index = j;
			}
		}
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
}

void heap_sort(int *array, int size){
	
	int i,temp;
	
	for (i = size/2 - 1; i >= 0; i--){
		heapify(array, size, i);
	}
	    
	for (i = size-1; i >= 0; i--){
		
		temp = array[0];
		array[0] = array[i];
		array[i] = temp;
		
	    heapify(array, i, 0);
	}
}

void heapify(int *array, int size, int root){
	
	int temp;
	int largest = root;   
	
	int left = 2*root + 1;
	int right = 2*root + 2;
	
	if (left < size && array[left] > array[largest]){
		largest = left;
	}
	    
	if (right < size && array[right] > array[largest]){
		largest = right;
	}
	    
	if (largest != root){
		temp = array[root];
		array[root] = array[largest];
		array[largest] = temp;
		
	    heapify(array, size, largest);
	}
}











