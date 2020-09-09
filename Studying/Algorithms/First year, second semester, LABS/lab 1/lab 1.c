#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char** vvod_strani(int M, char **S, int **A);
int** vvod_medali(int M, int **A);
void print_po_strane(int M, int **A, char **S);
void print_tablica_info(char **S, int **A, int M);

int flag=0;

int main(){
	
	int p,M=0;
	int **A = NULL;
	char **S = NULL;
	
	system("chcp 1251 > NULL");
	
	for(;;){
		printf("1.Change data\n2.Show info about country\n"
		"3.Print table about countries\n4.Exit\n");
		scanf("%d", &p);
		
		switch(p){
			case 1:
				S = vvod_strani(M,S,A);
				if(flag==0){
					A = vvod_medali(M,A);
					M++;
				}
				flag=0;
				break;
			case 2:
				print_po_strane(M,A,S);
				break;
			case 3:
				print_tablica_info(S,A,M);	
				break;
			case 4:
				return 0;
		}
	}
	
	return 0;
}

char** vvod_strani(int M, char **S, int **A){
	
	int i;
	char a[50];
	int temp;
	printf("Enter country: ");
	fflush(stdin);
	fgets(a,50,stdin);
	
	a[strlen(a)-1] = 0; 
	
	for(i=0 ; i<M ; i++){
		if(strcmp(a , S[i])==0){
			printf("Gold: ");
			scanf("%d", &temp);
			A[i][0] += temp;
			printf("Silver: ");
			scanf("%d", &temp);
			A[i][1] += temp;
			printf("Bronze: ");
			scanf("%d", &temp);
			A[i][2] += temp;

			A[i][3] = A[i][0] + A[i][1] + A[i][2];
			
			flag=1;
			return S;
		}
	}	
	
	S = (char**)realloc(S, (M+1)*sizeof(char*));
	S[M] = (char*)malloc(strlen(a)*sizeof(char));
	
	for(i=0 ; i<strlen(a) ; i++){
		S[M][i] = a[i];
	}
	
	S[M][strlen(a)] = 0; //Delete \n in the string
	
	return S;
}

int** vvod_medali(int M, int **A){
	
	A = (int**)realloc(A, (M+1)*sizeof(int*));
	A[M] = (int*)malloc(4*sizeof(int));
	
	printf("Gold: ");
	scanf("%d", &A[M][0]);
	printf("Silver: ");
	scanf("%d", &A[M][1]);
	printf("Bronze: ");
	scanf("%d", &A[M][2]);
	
	A[M][3]=A[M][0]+A[M][1]+A[M][2];
	
	return A;
}

void print_po_strane(int M, int **A, char **S){
	
	int i,j;
	char a[50];
	
	printf("Enter country: ");
	fflush(stdin);
	fgets(a,50,stdin);
	
	a[strlen(a)-1] = 0;
	
	for(i=0 ; i<M ; i++){
		if(strcmp(a , S[i])==0){
			printf("%s", S[i]);
		
			for(j=0 ; j<4 ; j++){
				printf("%9d", A[i][j]);
			}
			printf("\n");
			return;
		}
		
	}
	printf("Country with this name is not found");
	printf("\n");
}

void print_tablica_info(char **S, int **A, int M){
	
	int i,j;
	
	for(i=0 ; i<M ; i++){
		printf("%s", S[i]);
		
		for(j=0 ; j<4 ; j++){
			printf("%9d", A[i][j]);
		}
		printf("\n");
	}
}










