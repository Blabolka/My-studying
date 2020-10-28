#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

typedef struct queue{
	int count;
	int number;
	struct queue *pNext;
}Queue;

void fill_array(int *array, int size);
void print_array(int *array, int size);
void counting_sort(int *array, int size);
void pigeonhole_sort(int *array, int size);
Queue* push(Queue *head, int number);

double timeForCountingSort;
double timeForPigeonholeSort;

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
	counting_sort(array1, size);
	timeForCountingSort = (double)(clock() - time);
	
	time = clock();
	pigeonhole_sort(array2, size);
	timeForPigeonholeSort = (double)(clock() - time);
	
	printf("Time of Counting sort: %.0lf ms\n", timeForCountingSort);
	printf("Time of Pigeonhole sort: %.0lf ms", timeForPigeonholeSort);
	
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

void pigeonhole_sort(int *array, int size){
	
	int i;
	Queue *head = NULL;
	
	for(i=0 ; i<size ; i++){
		head = push(head, array[i]);
	}
	
	int index = 0;

	while(head){
		for(i=0 ; i<head->count ; i++){
			array[index] = head->number;
			index++;
		}
		head = head->pNext;
	}
}

Queue* push(Queue *head, int number){
	
	if(!head){
		head = (Queue*)malloc(sizeof(Queue));
		head->count = 1;
		head->number = number;
		head->pNext = NULL;
		return head;
	}
	
	Queue *temp = head;
	Queue *prev;
	
	while(temp){
		if(number == temp->number){
			temp->count++;
			return head;
		}
		
		if(number < temp->number){
			Queue *newElem = (Queue*)malloc(sizeof(Queue));
			newElem->count = 1;
			newElem->number = number;
			newElem->pNext = temp;
			if(head->number == temp->number){
				return newElem;
			}else{
				prev->pNext = newElem;
				return head;
			}
		}
		
		prev = temp;
		temp = temp->pNext;	
	}
	
	Queue *newElem = (Queue*)malloc(sizeof(Queue));
	newElem->count = 1;
	newElem->number = number;
	newElem->pNext = NULL;
	prev->pNext = newElem;
	return head;
}
