#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct nList{
	char surname[15];
	char name[15];
	char patronymic[15];
	int age;
	int mark;
	struct nList *pNext;
}list; 

void print_list(list *head);
void print_list_by_marks(list *head);
void search_students_by_surname(list *head);
list* init_list(list *head);
list* add_element_to_begin(list *head);
list* add_element_to_end(list *head);
list* add_element_to_list_by_surname(list* head);
list* del_element(list *head);
list* sort_list(list *head);

int main(){
	
	int choice,counter=0;
	list *head = NULL;
	
	system("chcp 1251 > nul");
	
	while(1){
		printf("1.�������� ���� ������\n2.���������� ������ �������� � ������ ������\n3.���������� ������ �������� � ����� ������\n"
		"4.���������� ������ �������� ����� ���������� �� ������� ��������\n5.����� ��������� �� �������\n6.����� ��������� �� ������������\n"
		"7.�������� ��������� � �������� ��������\n8.����������� �� ������� ������\n0.�����\n");
		scanf("%d", &choice);
		switch(choice){
			case 1:
				if(counter==0){
					printf("�� �� �������� �� ������ ��������!\n");
				}else{
					print_list(head);
				}
				break;
			case 2:
				if(counter==0){
					head = init_list(head);
				}else{
					head = add_element_to_begin(head);
				}
				counter++;
				break;	
			case 3:
				if(counter==0){
					head = init_list(head);
				}else{
					head = add_element_to_end(head);
				}
				counter++;
				break;	
			case 4:
				if(counter==0){
					printf("�� �� �������� �� ������ ��������!\n");
				}else{
					head = add_element_to_list_by_surname(head);
					counter++;
				}
				break;	
			case 5:
				if(counter==0){
					printf("�� �� �������� �� ������ ��������!\n");
				}else{
					search_students_by_surname(head);
				}
				break;	
			case 6:
				if(counter==0){
					printf("�� �� �������� �� ������ ��������!\n");
				}else{
					print_list_by_marks(head);
				}
				break;	
			case 7:
				if(counter==0){
					printf("�� �� �������� �� ������ ��������!\n");
				}else{
					head = del_element(head);
					counter--;
				}
				break;
			case 8:
				if(counter==0){
					printf("�� �� �������� �� ������ ��������!\n");
				}else{
					head = sort_list(head);
				}
				break;		
			case 0:
				return 0;
		}
	}
	return 0;
}

void print_list(list *head){
	
	list *temp = head;
	
	while(temp!=NULL){
		printf("%-15s", temp->surname);
		printf("%-15s", temp->name);
		printf("%-15s", temp->patronymic);
		printf("%-6d", temp->age);
		printf("%-6d\n", temp->mark);
		temp = temp->pNext;
	}
}

void print_list_by_marks(list *head){
	
	list *temp = head;
	int flag=0;
	
	printf("������� (90-100):\n");
	while(temp!=NULL){
		if(temp->mark >= 90 && temp->mark <=100){
			printf("%15s", temp->surname);
			printf("%15s", temp->name);
			printf("%15s", temp->patronymic);
			printf("%6d", temp->age);
			printf("%6d\n", temp->mark);
			flag=1;
		}
		temp = temp->pNext;
	}
	if(flag==0){
		printf("\t������ ������\n");
	}
	flag=0;
	temp = head;
	
	printf("������ (70-89):\n");
	while(temp!=NULL){
		if(temp->mark >= 70 && temp->mark <=89){
			printf("%15s", temp->surname);
			printf("%15s", temp->name);
			printf("%15s", temp->patronymic);
			printf("%6d", temp->age);
			printf("%6d\n", temp->mark);
			flag=1;
		}
		temp = temp->pNext;
	}
	if(flag==0){
		printf("\t������ ������\n");
	}
	flag=0;
	temp = head;
	
	printf("����������������� (50-69):\n");
	while(temp!=NULL){
		if(temp->mark >= 50 && temp->mark <=69){
			printf("%15s", temp->surname);
			printf("%15s", temp->name);
			printf("%15s", temp->patronymic);
			printf("%6d", temp->age);
			printf("%6d\n", temp->mark);
			flag=1;
		}
		temp = temp->pNext;
	}
	if(flag==0){
		printf("\t������ ������\n");
	}
	flag=0;
	temp = head;
	
	printf("������������������� (0-49):\n");
	while(temp!=NULL){
		if(temp->mark >= 0 && temp->mark <=49){
			printf("%15s", temp->surname);
			printf("%15s", temp->name);
			printf("%15s", temp->patronymic);
			printf("%6d", temp->age);
			printf("%6d\n", temp->mark);
			flag=1;
		}
		temp = temp->pNext;
	}
	if(flag==0){
		printf("\t������ ������\n");
	}
}

void search_students_by_surname(list *head){
	
	list *temp = head;
	int flag = 0;
	char surname[15];
	
	printf("������� ������� �������� �������� ������ �����: ");
	scanf("%s", &surname);
	
	while(temp!=NULL){
		if(strcmp(surname,temp->surname)==0){
			printf("%-15s", temp->surname);
			printf("%-15s", temp->name);
			printf("%-15s", temp->patronymic);
			printf("%-6d", temp->age);
			printf("%-6d\n", temp->mark);
			flag = 1;
		}
		temp = temp->pNext;
	}
	if(flag==0){
		printf("�������� � ����� �������� ���!\n");
	}
}

list* init_list(list *head){
	
	head = (list*)malloc(sizeof(list));
	
	printf("�������: ");
	scanf("%s", &head->surname);
	printf("���: ");
	scanf("%s", &head->name);
	printf("��������: ");
	scanf("%s", &head->patronymic);
	printf("�������: ");
	scanf("%d", &head->age);
	
	while(1){
		printf("������� ����(0-100): ");
		scanf("%d", &head->mark);
		if(head->mark >= 0 && head->mark <= 100){
			break;
		}else{
			printf("������� ���������� ������!\n");
		}
	}
	
	head->pNext = NULL;
	
	return head;
}

list* add_element_to_begin(list *head){
	
	list *temp;
	temp = (list*)malloc(sizeof(list));
	
	printf("�������: ");
	scanf("%s", &temp->surname);
	printf("���: ");
	scanf("%s", &temp->name);
	printf("��������: ");
	scanf("%s", &temp->patronymic);
	printf("�������: ");
	scanf("%d", &temp->age);
	printf("������� ����: ");
	
	while(1){
		printf("������� ����(0-100): ");
		scanf("%d", &temp->mark);
		if(temp->mark >= 0 && temp->mark <= 100){
			break;
		}else{
			printf("������� ���������� ������!\n");
		}
	}
	
	temp->pNext = head;
	head = temp;
	
	return head;
}

list* add_element_to_end(list *head){
	
	list *temp = head;
	list *p;
	
	while(temp!=NULL){
		p = temp;
		temp = temp->pNext;
	}
	
	temp = (list*)malloc(sizeof(list));
	p->pNext = temp;
	
	printf("�������: ");
	scanf("%s", &temp->surname);
	printf("���: ");
	scanf("%s", &temp->name);
	printf("��������: ");
	scanf("%s", &temp->patronymic);
	printf("�������: ");
	scanf("%d", &temp->age);
	
	while(1){
		printf("������� ����(0-100): ");
		scanf("%d", &temp->mark);
		if(temp->mark >= 0 && temp->mark <= 100){
			break;
		}else{
			printf("������� ���������� ������!\n");
		}
	}
	
	temp->pNext = NULL;
	
	return head;
}

list* add_element_to_list_by_surname(list* head){
	
	list *p = head;
	list *temp;
	int flag=0;
	char surname[15];
	
	printf("������� ������� �������� ����� �������� ������ �������� ������: ");
	scanf("%s", &surname);
	
	while(p!=NULL){
		if(strcmp(surname,p->surname)==0){
			temp = (list*)malloc(sizeof(list));
			printf("�������: ");
			scanf("%s", &temp->surname);
			printf("���: ");
			scanf("%s", &temp->name);
			printf("��������: ");
			scanf("%s", &temp->patronymic);
			printf("�������: ");
			scanf("%d", &temp->age);
			
			while(1){
				printf("������� ����(0-100): ");
				scanf("%d", &temp->mark);
				if(temp->mark >= 0 && temp->mark <= 100){
					break;
				}else{
					printf("������� ���������� ������!\n");
				}
			}
			
			temp->pNext = p->pNext;
			p->pNext = temp;	
			flag = 1;
			break;
		}
		p = p->pNext;
	}
	
	if(flag==0){
		printf("�������� � ����� �������� ���!\n");
	}
	
	return head;
}

list* del_element(list *head){
	
	list *p = head;
	list *prev;
	list *temp;
	int flag=0;
	int counter=0;
	char surname[15];
	
	printf("������� ������� �������� �������� ������ �������: ");
	scanf("%s", &surname);
	
	while(p!=NULL){
		if(strcmp(surname,p->surname)==0){
			if(counter==0){
				temp = head;
				head = head->pNext;
				free(temp);
				p = head;
				flag = 1;
			}else{
				temp = p;
				prev->pNext = p->pNext;
				free(temp);
				flag = 1;
			}
		}else{
			prev = p;
			p = p->pNext;
			counter++;
		}
	}
	
	if(flag==0){
		printf("�������� � ����� �������� ���!\n");
	}
	
	return head;
}

list* sort_list(list *head){
	
	list *temp = head;
	list *tmp;	//��������� ��������� ��� ��������� ���������� ��������
	list *pnext;	//��������� �� ��������� ������� ����� temp
	list *pprev;	//��������� �� ���������� ������� ����� temp
	int flag1 = 0;	//���������, ������ �� �� ������ ������� ������
	int flag2 = 0;	//���������, ���� �� ��������� � ������ �� ��������� ���� ����� ����� � ������������ �����
	
	while(1){
		while(temp!=NULL){
			pnext = temp->pNext;
			if(pnext == NULL){	//�������� �� ��������� ������� � ������
				break;
			}
			
			if(temp->surname[0] > pnext->surname[0]){
				if(flag1 == 0){
					tmp = head;
					head = tmp->pNext;
					tmp->pNext = head->pNext;
					head->pNext = tmp;
					temp = head;
				}else{
					tmp = temp;
					temp = tmp->pNext;
					pprev->pNext = tmp->pNext;
					tmp->pNext = temp->pNext;
					temp->pNext = tmp;
				}
				flag2 = 1;
			}
			flag1 = 1;
			pprev = temp;
			temp = temp->pNext;
		}
		
		if(flag2==0){
			break;
		}
		flag1=0;
		flag2=0;
		temp = head;
	}
	
	return head;
}







