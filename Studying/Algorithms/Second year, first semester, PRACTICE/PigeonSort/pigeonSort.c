#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct queue{
	int count;
	int number;
	struct queue *pNext;
}Queue;

void fill_array(int *array, int size);
void print_array(int *array, int size);
void pigeonhole_sort(int *array, int size);
Queue* push(Queue *head, int number);

int main(int argc, char *argv[]){
	
	int size;
	
	printf("Enter the number of elements array: ");
	scanf("%d", &size);
	
	int *array = (int*)malloc(sizeof(int)*size);
	
	srand(time(0));
	
	fill_array(array, size);
	
	pigeonhole_sort(array, size);
	
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
