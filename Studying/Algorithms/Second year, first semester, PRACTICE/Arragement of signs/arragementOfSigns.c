#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define LEN 17

void signs1();

void signs2();
void signs2recursion(char t[LEN], int currentCountOfSymbols);

void signs3();
void signs3recursion(int s, int r, char op, int currentNumber, char t[LEN]);

int number;

int main(int argc, char **argv){
	
	clock_t time;
	
	printf("Enter the number: ");
	scanf("%d", &number);
	
	printf("signs1\n");
	time = clock();
	signs1();
	time = clock()-time;
	printf("Time for signs1: %d ms\n\n", time);
	
	printf("signs2\n");
	time = clock();
	signs2();
	time = clock()-time;
	printf("Time for signs2: %d ms\n\n", time);
	
	printf("signs3\n");
	time = clock();
	signs3();
	time = clock()-time;
	printf("Time for signs3: %d ms\n\n", time);
	return 0;
}

void signs1(){
	
	int i,j;
	int kod;
	
	int sum;
	int r;
	char op;
	
	char t[LEN];
	char asciiSymbol[2];
	
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

void signs2(){
	char t[LEN];
	strcpy(t, "1");
	
	signs2recursion(t, 2);
}

void signs2recursion(char t[LEN], int currentCountOfSymbols){
	
	int i;
		
	if(currentCountOfSymbols <= 9){
		
		char tnew[LEN];
		char asciiSymbol[2];
		for(i=1 ; i<=3 ; i++){
			
			memcpy(tnew, t, LEN);
			switch(i){
				case 1:
					strcat(tnew, "+");
					
					asciiSymbol[0] = 48+currentCountOfSymbols;
					asciiSymbol[1] = '\0';
					strcat(tnew, asciiSymbol);
					break;
				case 2:
					strcat(tnew, "-");
					
					asciiSymbol[0] = 48+currentCountOfSymbols;
					asciiSymbol[1] = '\0';
					strcat(tnew, asciiSymbol);
					break;	
				default:
					asciiSymbol[0] = 48+currentCountOfSymbols;
					asciiSymbol[1] = '\0';
					strcat(tnew, asciiSymbol);
					break;
			}
			signs2recursion(tnew, currentCountOfSymbols+1);
		}
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

void signs3(){
	char t[LEN];
	strcpy(t, "1");

	signs3recursion(1, 0, '+', 2, t);
}

void signs3recursion(int s, int r, char op, int currentNumber, char t[LEN]){
	
	int newr;
	
	if(op == '+'){
		newr = r+s;
	}else{
		newr = r-s;
	}
	
	if(currentNumber <= 9){
		char tnew[LEN];
		char asciiSymbol[2];
		
		memcpy(tnew, t, LEN);
		strcat(tnew, "+");
		asciiSymbol[0] = 48+currentNumber;
		asciiSymbol[1] = '\0';
		strcat(tnew, asciiSymbol);
		signs3recursion(currentNumber, newr, '+', currentNumber+1, tnew);
		
		memcpy(tnew, t, LEN);
		strcat(tnew, "-");		
		asciiSymbol[0] = 48+currentNumber;
		asciiSymbol[1] = '\0';
		strcat(tnew, asciiSymbol);
		signs3recursion(currentNumber, newr, '-', currentNumber+1, tnew);
		
		memcpy(tnew, t, LEN);	
		asciiSymbol[0] = 48+currentNumber;
		asciiSymbol[1] = '\0';
		strcat(tnew, asciiSymbol);
		signs3recursion(s*10+currentNumber, r, op, currentNumber+1, tnew);
	}else{
		if(newr == number){
			printf("%s\n", t);
		}
	}
}
