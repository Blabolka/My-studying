#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct nList{
	int num;
	struct nList *pNext;
}list;

/*Функции для списка*/
void init_list(list **head);
void add_element_to_begin(list **head);
void add_element_to_end_list(list **head);
void delete_element_from_begin_list(list **head);
void print_list(list *head);
void show_upper_for_stack_list(list *head);
void show_upper_for_range_list(list *head);

/*Функции для массива*/
int* add_element_to_end_array(int *arr, int counter, int *maxCounter);
void delete_element_from_end_stack_array(int *arr, int counter);
int* delete_element_from_begin_range_array(int *arr, int maxCounter);
void print_array(int *arr, int maxCounter);
void show_upper_element_for_stack_array(int *arr, int counter);
void show_upper_element_for_range_array(int *arr, int counter);
void clear_array(int *arr, int maxCounter);

int main(){
	
	int choice,flag=0;
	int stackListCounter=0,rangeListCounter=0,stackArrayCounter=0,rangeArrayCounter=0; //Счётчики фактического количества элементов в массиве
	int maxNumberOfElementsStackArray = 5, maxNumberOfElementsRangeArray = 5; //Максимальное количество элементов в массивах(при нехватке могут изменяться)
	list *stackListHead = NULL;
	list *rangeListHead = NULL;
	int *stackArray = (int*)calloc(maxNumberOfElementsStackArray,sizeof(int));
	int *rangeArray = (int*)calloc(maxNumberOfElementsRangeArray,sizeof(int));

	system("chcp 1251 > nul");
	
	while(1){
		printf("1.Стек - массив\n2.Стек - ОЛС\n3.Очередь - массив\n4.Очередь - ОЛС\n0.Выход\n");
		scanf("%d", &choice);
		switch(choice){
			case 1:
				system("cls");
				while(1){
					printf("1.Вставить(в конец)\n2.Удалить(из конца)\n3.Распечатать\n4.Показать верхний\n5.Очистить\n6.Проверить, пусто ли\n0.Выход из пункта\n");
					scanf("%d", &choice);
					switch(choice){
						case 1:
							stackArray = add_element_to_end_array(stackArray,stackArrayCounter,&maxNumberOfElementsStackArray);
							stackArrayCounter++;
							break;
						case 2:
							if(stackArrayCounter == 0){
								printf("Вы ещё не добавили элементов!\n");
							}else{
								delete_element_from_end_stack_array(stackArray,stackArrayCounter);
								stackArrayCounter--;
							}
							break;	
						case 3:
							print_array(stackArray,maxNumberOfElementsStackArray);
							break;
						case 4:
							show_upper_element_for_stack_array(stackArray,stackArrayCounter);
							break;	
						case 5:
							clear_array(stackArray,maxNumberOfElementsStackArray);
							stackArrayCounter = 0;
							break;	
						case 6:
							if(stackArrayCounter==0){
								printf("В стеке массива нет элемент!\n");
							}else{
								printf("В стеке массива есть элементы!\nКоличество: %d\n", stackArrayCounter);
							}
							break;		
						case 0:
							flag=1;
							break;	
					}
					if(flag==1){
						system("cls");
						break;
					}
				}
				flag=0;
				break;
			case 2:
				system("cls");
				while(1){
					printf("1.Вставить(в начало)\n2.Удалить(из начала)\n3.Распечатать\n4.Показать верхний\n5.Очистить\n6.Проверить, пусто ли\n0.Выход из пункта\n");
					scanf("%d", &choice);
					switch(choice){
						case 1:
							if(stackListCounter==0){
								init_list(&stackListHead);
							}else{
								add_element_to_begin(&stackListHead);
							}
							stackListCounter++;
							break;
						case 2:
							if(stackListCounter==0){
								printf("Вы ещё не добавили элементов!\n");
							}else{
								delete_element_from_begin_list(&stackListHead);
								stackListCounter--;
							}	
							break;
						case 3:
							print_list(stackListHead);
							break;
						case 4:
							show_upper_for_stack_list(stackListHead);
							break;	
						case 5:
							while(stackListCounter!=0){
								delete_element_from_begin_list(&stackListHead);
								stackListCounter--;
							}
							break;	
						case 6:
							if(stackListCounter==0){
								printf("В стеке списка нет элементов\n");
							}else{
								printf("В стеке списка есть элементы\nКоличество элементов: %d\n", stackListCounter);
							}
							break;	
						case 0:
							flag=1;
							break;		
					}
					if(flag==1){
						system("cls");
						break;
					}
				}
				flag=0;
				break;
			case 3:
				system("cls");
				while(1){
					printf("1.Вставить(в конец)\n2.Удалить(из начала)\n3.Распечатать\n4.Показать верхний\n5.Очистить\n6.Проверить, пусто ли\n0.Выход из пункта\n");
					scanf("%d", &choice);
					switch(choice){
						case 1:
							rangeArray = add_element_to_end_array(rangeArray,rangeArrayCounter,&maxNumberOfElementsRangeArray);
							rangeArrayCounter++;
							break;
						case 2:
							if(rangeArrayCounter==0){
								printf("Вы ещё не добавили элементов!\n");
							}else{
								rangeArray = delete_element_from_begin_range_array(rangeArray,maxNumberOfElementsRangeArray);
								rangeArrayCounter--;
							}
							break;
						case 3:
							print_array(rangeArray,maxNumberOfElementsRangeArray);
							break;	
						case 4:
							show_upper_element_for_range_array(rangeArray,rangeArrayCounter);
							break;
						case 5:
							clear_array(rangeArray,maxNumberOfElementsRangeArray);
							rangeArrayCounter = 0;
							break;
						case 6:
							if(rangeArrayCounter==0){
								printf("В очереди массива нет элементов!\n");
							}else{
								printf("В очереди массива есть элементы\nКоличество элементов: %d\n", rangeArrayCounter);
							}
							break;	
						case 0:
							flag=1;
							break;	
					}
					if(flag==1){
						system("cls");
						break;
					}
				}
				flag=0;
				break;
			case 4:
				system("cls");
				while(1){
					printf("1.Вставить(в конец)\n2.Удалить(из начала)\n3.Распечатать\n4.Показать верхний\n5.Очистить\n6.Проверить, пусто ли\n0.Выход из пункта\n");
					scanf("%d", &choice);
					switch(choice){
						case 1:
							if(rangeListCounter==0){
								init_list(&rangeListHead);
							}else{
								add_element_to_end_list(&rangeListHead);
							}
							rangeListCounter++;
							break;
						case 2:
							if(rangeListCounter==0){
								printf("Вы ещё не добавили элементов!\n");
							}else{
								delete_element_from_begin_list(&rangeListHead);
								rangeListCounter--;
							}
							break;	
						case 3:
							print_list(rangeListHead);
							break;	
						case 4:
							show_upper_for_range_list(rangeListHead);
							break;
						case 5:
							while(rangeListCounter!=0){
								delete_element_from_begin_list(&rangeListHead);
								rangeListCounter--;
							}
							break;	
						case 6:
							if(rangeListCounter==0){
								printf("В очереди списка нет элементов\n");
							}else{
								printf("В очереди списка есть элементы\nКоличество элементов: %d\n", rangeListCounter);
							}
							break;		
						case 0:
							flag=1;
							break;	
					}
					if(flag==1){
						system("cls");
						break;
					}
				}
				flag=0;
				break;
			case 0:
				return 0;				
		}
	}
	
	return 0;
}

void init_list(list **head){
	
	*head = (list*)malloc(sizeof(list));
	
	printf("Введите значение: ");
	scanf("%d", &(*head)->num);
	
	(*head)->pNext = NULL;
}

void add_element_to_begin(list **head){
	 
	 list *temp;
	 temp = (list*)malloc(sizeof(temp));
	 
	 printf("Введите значение: ");
	 scanf("%d", &temp->num);
	 
	 temp->pNext = *head;
	 *head = temp;
}

void add_element_to_end_list(list **head){
	
	list *temp = (*head);
	list *p;
	
	while(temp!=NULL){
		p = temp;
		temp = temp->pNext;
	}
	
	temp = (list*)malloc(sizeof(list));
	printf("Введите значение: ");
	scanf("%d", &temp->num);
	temp->pNext = NULL;
	
	p->pNext = temp;
}

void delete_element_from_begin_list(list **head){
	 
	if((*head)->pNext == NULL){
		free(*head);
		(*head) = NULL;
		return;
	}	
	
	list *temp = *head;
	*head = (*head)->pNext;
	free(temp);
}

void print_list(list *head){
	
	list *temp = head;
	
	while(temp!=NULL){
		printf("%-6d", temp->num);
		temp = temp->pNext;
	}
	printf("\n");
}

void show_upper_for_stack_list(list *head){
	
	if(head!=NULL){
		printf("%d\n", head->num);
	}
}

void show_upper_for_range_list(list *head){
	
	list *temp = head;
	list *p = NULL;
	
	while(temp!=NULL){
		p = temp;
		temp = temp->pNext;
	}
	if(p!=NULL){
		printf("%d\n", p->num);
	}
}

int* add_element_to_end_array(int *arr, int counter, int *maxCounter){
	
	int flag,i;
		
	if(counter == *maxCounter){
		arr = (int*)realloc(arr,((*maxCounter)*2)*sizeof(int));
		*maxCounter *= 2;
		for(i=counter ; i<(*maxCounter) ; i++){
			arr[i] = 0;
		}
	}
	
	while(1){
		printf("Введите значение: ");
		scanf("%d", &arr[counter]);
		if(arr[counter]!=0){
			break;
		}else{
			printf("Введите число не равное нулю!\n");
		}
	}
	
	return arr;
}

void delete_element_from_end_stack_array(int *arr, int counter){
	arr[counter-1] = 0;
}

int* delete_element_from_begin_range_array(int *arr, int maxCounter){
	
	int *p = &arr[1];
	
	memcpy(arr,p,maxCounter*sizeof(int));
	arr[maxCounter-1] = 0;
	
	return arr;
}

void print_array(int *arr, int maxCounter){
	
	int i;
	for(i=0 ; i<maxCounter ; i++){
		printf("%-7d", arr[i]);
	}
	printf("\n");
}

void show_upper_element_for_stack_array(int *arr, int counter){
	if(counter!=0){
		printf("%d\n", arr[counter-1]);
	}
}

void show_upper_element_for_range_array(int *arr, int counter){
	if(counter!=0){
		printf("%d\n", arr[0]);
	}
}

void clear_array(int *arr, int maxCounter){
	int i;
	for(i=0 ; i<maxCounter ; i++){
		arr[i] = 0;
	}
}














