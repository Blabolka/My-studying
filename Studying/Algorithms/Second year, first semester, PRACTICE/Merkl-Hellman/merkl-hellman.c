#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <string.h>
#include <math.h>

/*Preparing to encrypting and decrypting*/
int sumPrivateKeyElements(int* privateKey);
int calculateNearestEvenNumber(int number);
int* calculatePublicKey(int primeNumber, int mod, int* privateKey);

/*For encrypting*/
int* encrypt(char* string, int* publicKey);
int* fromDecimalToBinary(int number);
int summarizeTheRelevantElements(int* publicKey, int* binaryRepresentation);

/*For decrypting*/
int calculateReciprocalNumber(int primeNumber, int mod);
char* decrypt(int sizeOfEncryptedStringArray, int* encryptedString, int reciprocalNumber, int mod, int* privateKey);
int* toBinaryRepresentation(int* privateKey, int number);
int fromBinaryToDecimal(int* binaryRepresentation);
char* getAscii(int number);

void print_array(int size, int* array);


int main() {
	
	int primeNumber = 31;
	int privateKey[] = {2,3,6,13,27,52,105,210};
	int mod = calculateNearestEvenNumber(sumPrivateKeyElements(privateKey));
	int* publicKey = calculatePublicKey(primeNumber, mod, privateKey);
	
	char* string = "Sanya hui sosi";
	
	/*Encrypting*/
	int* encryptedString = encrypt(string, publicKey);
	printf("Encrypted string:\n");
	print_array(strlen(string), encryptedString);
	
	/*Decrypting*/
	int reciprocalNumber = calculateReciprocalNumber(primeNumber, mod);
	char* decryptedString = decrypt(strlen(string), encryptedString, reciprocalNumber, mod, privateKey);
	printf("Decrypted string:\n");
	printf("%s", decryptedString);
	
	return 0;
}

int sumPrivateKeyElements(int* privateKey){
	
	int i, sum=0;
	for(i=0 ; i<8 ; i++){
		sum += privateKey[i];
	}
	return sum;
}

int calculateNearestEvenNumber(int number){
	number++;
	if(number%2 == 0){
		return number;
	}else{
		return number+1;
	}
}

int* calculatePublicKey(int primeNumber, int mod, int* privateKey){
	
	int* publicKey = (int*)malloc(8*sizeof(int));
	
	int i;
	for(i=0 ; i<8 ; i++){
		publicKey[i] = (privateKey[i]*primeNumber)%mod;
	}
	
	return publicKey;
}

int* encrypt(char* string, int* publicKey){
	
	int i;
	int strln = strlen(string);
	int* encryptedString = (int*)malloc(strln*sizeof(int));
	
	for(i=0 ; i<strln ; i++){
		encryptedString[i] = summarizeTheRelevantElements(publicKey, fromDecimalToBinary(string[i]));
	}
	
	return encryptedString;
}

// from 0 to 255
int* fromDecimalToBinary(int number){
	
	int* binaryRepresentation = (int*)calloc(8, sizeof(int));
	
	int i, v=128;
	
	for(i=0 ; i<8; i++){
		
	    if(number >= v){
	        binaryRepresentation[i] = 1;
	        number -= v;
	    }
	    
	    v /= 2; 
	}
	
	return binaryRepresentation;
}

int summarizeTheRelevantElements(int* publicKey, int* binaryRepresentation){
	
	int i, sum=0;
	for(i=0 ; i<8 ; i++){
		if(binaryRepresentation[i] == 1){
			sum += publicKey[i];
		}
	}
	
	return sum;
}

int calculateReciprocalNumber(int primeNumber, int mod){
	int i;
	for(i=1 ; i<mod*2 ; i++){
		if((i*primeNumber)%mod == 1){
			return i;
		}
	}
	return -1;
}

char* decrypt(int sizeOfEncryptedStringArray, int* encryptedString, int reciprocalNumber, int mod, int* privateKey){
	
	int i;
	char* decryptedString = (char*)malloc(sizeOfEncryptedStringArray);
	decryptedString[0] = '\0';
	
	for(i=0 ; i<sizeOfEncryptedStringArray ; i++){
		strcat(decryptedString, getAscii(fromBinaryToDecimal(toBinaryRepresentation(privateKey, (encryptedString[i]*reciprocalNumber)%mod))));
	}
	
	return decryptedString;
}

int* toBinaryRepresentation(int* privateKey, int number){
	
	int* binaryRepresentation = (int*)calloc(8, sizeof(int));
	
	int i;
	for(i=7 ; i>=0 ; i--){
		if(privateKey[i] <= number){
			number -= privateKey[i];
			binaryRepresentation[i] = 1;
		}
	}
	return binaryRepresentation;
}

// from 0 to 255
int fromBinaryToDecimal(int* binaryRepresentation){
	int i, sum=0;
	
	for(i=0 ; i<8 ; i++){
		if(binaryRepresentation[i] == 1){
			sum += pow(2,8-(i+1));
		}
	}
	return sum;
}

char* getAscii(int number){
	char* asciiChar = (char*)malloc(2);
	asciiChar[0] = number;
	asciiChar[1] = '\0';
	
	return asciiChar;
}

void print_array(int size, int* array){
	int i;
	for(i=0 ; i<size ; i++){
		printf("%d\t", array[i]);
	}
	printf("\n");
}
