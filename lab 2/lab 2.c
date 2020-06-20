#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
	char surname[20];
	char name[20];
	char patronymic[20];
	int dd;
	int mm;
	int yyyy;
	int srus;
}stu;

stu* add_student(stu *students);
void sort_students(stu *students);
void search_student_by_surname(stu *students);
void search_student_by_srus(stu *students);
void search_student_by_data_of_birth(stu *students);
stu* del_student(stu *students);
void print_students(stu *students);

int counter = 0;

int main(){
	
	int choice,flag=0;
	stu *students = NULL;
	
	system("chcp 1251 > nul");
	
	while(1){
		printf("1.Добавить студента\n2.Поиск студента\n3.Удалить студента\n"
		"4.Печать группы\n0.Выход из программы\n");
		scanf("%d", &choice);
		
		switch(choice){
			case 1:
				students = add_student(students);
				sort_students(students); 
				break;
			case 2:
				if(counter == 0){
					printf("Вы не добавили ни одного студента!\n");
					break;
				}
				system("cls");				
				while(1){
					printf("1.Поиск студента по фамилии\n2.Поиск студента по диапазону успеваемости\n3.Поиск студента по дате рождения\n0.Вернуться в главное меню\n");
					scanf("%d", &choice);
					switch(choice){
						case 1:
							search_student_by_surname(students);
							break;
						case 2:
							search_student_by_srus(students);
							break;
						case 3:	
							search_student_by_data_of_birth(students);
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
				break;
			case 3:
				if(counter != 0){
					students = del_student(students);
				}else{
					printf("Вы не добавили ни одного студента!\n");
				}
				break;
			case 4:
				if(counter != 0){
					print_students(students);
				}else{
					printf("Вы не добавили ни одного студента!\n");
				}
				break;					
			case 0:
				return 0;				
		}
	}
	
	return 0;
}

stu* add_student(stu *students){
	
	char S[20],sredusp[5];
	char *pS = S;
	int i,flag=0;
	
	students = (stu*)realloc(students, (counter+1)*sizeof(stu));
	
	printf("Введите фамилию студента: ");
	scanf("%s", &students[counter].surname);
	printf("Введите имя студента: ");
	scanf("%s", &students[counter].name);
	printf("Введите отчество студента: ");
	scanf("%s", &students[counter].patronymic);
	
	while(1){
		printf("Введите дату рождения студента(дд.мм.гггг): ");
		scanf("%s", &S);
		for(i=0 ; i<strlen(S) ; i++){
			if(S[i] == '.'){
				flag++;
			}
		}
		if(flag==2){
			break;
		}else{
			printf("Проверьте правильность ввода разделяющих точек!\n");
			flag=0;
		}
	}
	
	students[counter].dd = atoi(pS);
	for(i=0 ; S[i]!='.' ; i++, pS++);
	i++;
	pS++;
	
	students[counter].mm = atoi(pS);
	
	for(; S[i]!='.' ; i++, pS++);
	i++;
	pS++;
	
	students[counter].yyyy = atoi(pS);
	
	while(1){
		printf("Введите среднюю успеваемость студента: ");
		scanf("%s", &sredusp);
		students[counter].srus = atoi(sredusp);
		if(students[counter].srus<=100 && students[counter].srus>=0){
			break;
		}else{
			printf("Проверьте правильность ввода средней успеваемости!\n");
		}
	}
	counter++;
	return students;
}

void sort_students(stu *students){
	
	int i,j;
	
	for(i=0 ; i<counter-1 ;i++){
		for(j=0 ; j<counter-1 ; j++){
			if(students[j].surname[0] >= students[j+1].surname[0]){
				if(students[j].surname[0] == students[j+1].surname[0]){
					if(students[j].surname[1] > students[j+1].surname[1]){
						stu temp = students[j];
						students[j] = students[j+1];
						students[j+1] = temp;
						continue;
					}else{
						continue;
					}
				}
			stu temp = students[j];
			students[j] = students[j+1];
			students[j+1] = temp;
			}
		}
	}
}

void search_student_by_surname(stu *students){
	
	int i,proverka=0;
	char sur[20];
	
	printf("Введите фамилию студента, которого хотите найти: ");
	scanf("%s", &sur);
	
	for(i=0 ; i<counter ; i++){
		if(strcmp(sur,students[i].surname) == 0){
			proverka=1;
			printf("|%-10s ", students[i].surname);
			printf("%-10s ", students[i].name);
			printf("%-20s|", students[i].patronymic);
			printf("%10d.", students[i].dd);
			printf("%d.", students[i].mm);
			printf("%d|", students[i].yyyy);
			printf("%10d|\n", students[i].srus);
		}
	}
	
	if(proverka == 0){
		printf("Студенты с такой фамилией не найдены!\n");
	}
}

void search_student_by_srus(stu *students){
	
	int ot,doo,i,proverka=0;
	printf("Введите диапазон успеваемости студентов, которых хотите найти\n");
	printf("От: ");	
	scanf("%d", &ot);
	printf("До: ");	
	scanf("%d", &doo);
	
	for(i=0 ; i<counter ; i++){
		if((students[i].srus >= ot) && (students[i].srus <= doo)){
			proverka=1;
			printf("|%-10s ", students[i].surname);
			printf("%-10s ", students[i].name);
			printf("%-20s|", students[i].patronymic);
			printf("%10d.", students[i].dd);
			printf("%d.", students[i].mm);
			printf("%d|", students[i].yyyy);
			printf("%10d|\n", students[i].srus);
		}
	}
	
	if(proverka == 0){
		printf("Студенты с такой средней успеваемостью не найдены!\n");
	}	
}

void search_student_by_data_of_birth(stu *students){
	int dd,mm,i,flag=0,proverka=0;
	char S[20];
	char *pS = S;
	
	while(1){
		printf("Введите дату рождения студента(дд.мм): ");
		scanf("%s", &S);
		for(i=0 ; i<strlen(S) ; i++){
			if(S[i] == '.'){
				flag++;
			}
		}
		if(flag==1){
			break;
		}else{
			printf("Проверьте правильность ввода разделяющих точек!\n");
			flag=0;
		}
	}

	dd = atoi(pS);
	for(i=0 ; S[i]!='.' ; i++, pS++);
	i++;
	pS++;
	
	mm = atoi(pS);
	
	for(i=0 ; i<counter ; i++){
		if((students[i].dd == dd) && (students[i].mm == mm)){
			proverka=1;
			printf("|%-10s ", students[i].surname);
			printf("%-10s ", students[i].name);
			printf("%-20s|", students[i].patronymic);
			printf("%10d.", students[i].dd);
			printf("%d.", students[i].mm);
			printf("%d|", students[i].yyyy);
			printf("%10d|\n", students[i].srus);
		}
	}
	
	if(proverka == 0){
		printf("Студенты с такой датой рождения не найдены!\n");
	}
}

stu* del_student(stu *students){
	
	int i,choice;
	
	while(1){
		printf("Введите номер студента которого хотите удалить: ");
		scanf("%d", &choice);
		if(choice>=0 && choice<=counter-1){
			break;
		}else{
			printf("Таких студентов нет!\n");
			return students;
		}
	}
		
	for(i=choice ; i<counter-1 ; i++){
		students[i]=students[i+1];
	}
	
	students = (stu*)realloc(students, (counter-1)*sizeof(stu));
	
	counter--;
	return students;
}

void print_students(stu *students){
	
	int i;
	
	for(i=0 ; i<counter ; i++){
		printf("|%-10s ", students[i].surname);
		printf("%-10s ", students[i].name);
		printf("%-20s|", students[i].patronymic);
		printf("%10d.", students[i].dd);
		printf("%d.", students[i].mm);
		printf("%d|", students[i].yyyy);
		printf("%10d|\n", students[i].srus);
	}
}








