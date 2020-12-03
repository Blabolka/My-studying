#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

void signs1(int number);

void signs2(int number);
void signs2recursion(int number, char* t, int currentCountOfSymbols);

int main(int argc, char **argv){
	
	int number;
	clock_t time;
	
	printf("Enter the number: ");
	scanf("%d", &number);
	
	printf("signs1\n");
	time = clock();
	signs1(number);
	printf("Time for signs1: %d ms\n\n", clock()-time);
	
	printf("signs2\n");
	time = clock();
	signs2(number);
	printf("Time for signs2: %d ms\n\n", clock()-time);
	return 0;
}

void signs1(int number){
	
	int i,j;
	int kod;
	
	int sum;
	int r;
	char op;
	
	char* t = (char*)calloc(20, 1);
	char* asciiSymbol = (char*)calloc(2,1);
	
	for(i=0 ; i<=6560 ; i++){
		kod = i;
		strcpy(t, "1");
		
		for(j=2 ; j<=9 ; j++){
			
			switch(kod%3){
				case 1:
					strcat(t, "+");
					break;
				case 2:
					strcat(t, "-");
					break;
			}
			asciiSymbol[0] = 48+j;
			asciiSymbol[1] = '\0';
			strcat(t, asciiSymbol);
			
			kod /= 3;
		}
		
		strcat(t, ".");
		sum = 1;
		r = 0;
		op = '+';
		
		int strln = strlen(t);
		for(j=1 ; j<=strln ; j++){
			if(t[j] < '0'){
				if(op == '+'){
					r += sum;
				}else{
					r -= sum;
				}
				sum = 0;
				op = t[j];
			}else{
				sum = sum*10 + (t[j]-48);
			}
		}
		
		if(r == number){
			printf("%s\n", t);
		}
		
	}
}

void signs2(int number){
	char* t = (char*)calloc(17, 1);
	strcpy(t, "1");
	
	signs2recursion(number, t, 2);
}

void signs2recursion(int number, char* t, int currentCountOfSymbols){
	
	int i;
		
	if(currentCountOfSymbols <= 9){
		
		char* tnew = (char*)calloc(17,1);
		for(i=1 ; i<=3 ; i++){
			
			/*DORABOTAT*/
			switch(i){
				case 1:
					break;
				case 2:
					break;	
				default:
					break;
			}
		}
		signs2recursion(number, tnew, currentCountOfSymbols);
	}else{
		strcat(t, ".");
		int s = 1;
		int r = 0;
		char op = '+';
		
		int strln = strlen(t);
		for(i=1 ; i<=strln ; i++){
			if(t[i] < '0'){
				if(op == '+'){
					r += s;
				}else{
					r -= s;
				}
				s = 0;
				op = t[i];
			}else{
				s = s*10 + (t[i]-48);
			}
		}
		
		if(r == number){
			printf("%s\n", t);
		}
	}
}
