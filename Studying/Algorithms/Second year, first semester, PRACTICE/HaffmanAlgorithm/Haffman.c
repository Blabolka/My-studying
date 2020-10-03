#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <malloc.h>

#define SIZEFORCHARARRAY 200

typedef struct node{
    int freq;
    char character;
    char code[10];
    struct node *pLeft;
    struct node *pRight;
}Node;

Node** free_nodes(Node **nodes);
Node** split_string_fill_arr(Node **nodes, char string[]);
void sort_arr(Node **nodes);
Node** make_tree(Node **nodes);
void fill_codes_of_nodes(Node *root, Node **nodes, char *code);
void fill_encrypted_string(Node **nodes, char *string, char *encrypted_string);
void print_table_of_codes(Node **nodes);
void write_to_file(Node **nodes, char *encrypted_string);
int file_is_empty();
Node** read_from_file(Node **nodes, char *encrypted_string);
void fill_string_after_reading_from_file(Node *root, char *string, char *encrypted_string);
void free_string(char *string);

int sizeArr = 0;
int fakeWall;

int main(int argc, char const *argv[]){
	
	int choice;
	char string[SIZEFORCHARARRAY];
	char encrypted_string[SIZEFORCHARARRAY];
	char code[10] = "";
	Node** nodes = NULL;
	
	while(1){
		printf("1: Encrypt string and insert into file\n2: Print string"
		"\n3: Print encrypted string\n4: Print table of codes\n5: Get encrypted string from file\n0: Exit\n");
		scanf("%d", &choice);
		
		switch(choice){
			case 1:
				nodes = free_nodes(nodes);
				
				printf("\nENTER THE STRING:\n");
				fflush(stdin);
				fgets(string , SIZEFORCHARARRAY,stdin);
			    string[strlen(string)-1] = '\0';
				
				nodes = split_string_fill_arr(nodes, string);
				nodes = make_tree(nodes);
				fill_codes_of_nodes(nodes[0], nodes, code);
				fill_encrypted_string(nodes, string, encrypted_string);
				write_to_file(nodes, encrypted_string);
				
				printf("\n");
				break;
			case 2:
				if(nodes){
					printf("%s\n", string);
				}
				break;
			case 3:
				if(nodes){
					printf("%s\n", encrypted_string);
				}
				break;
			case 4:
				if(nodes){
					print_table_of_codes(nodes);
				}
				break;	
			case 5:
				if(!file_is_empty()){
					free_string(encrypted_string);
					nodes = read_from_file(nodes, encrypted_string);
					fakeWall = sizeArr;
					nodes = make_tree(nodes);
					fill_codes_of_nodes(nodes[0], nodes, code);
					fill_string_after_reading_from_file(nodes[0], string, encrypted_string);
				}
				break;
			case 0:
				return 0;		
		}
	}
    return 0;
}

Node** free_nodes(Node **nodes){
	int i;
	
	for(i=0 ; i<sizeArr ; i++){
		free(nodes[i]);
	}
	free(nodes);
	
	sizeArr = 0;
	
	return NULL;
}

Node** split_string_fill_arr(Node **nodes, char string[]){
	
	int i,j;
	int flag;
	int strln = strlen(string);
	
	for(i=0 ; i<strln ; i++){
		flag = 1;	
		for(j=0 ; j<sizeArr ; j++){
			if(string[i] == nodes[j]->character){
				nodes[j]->freq++;
				flag = 0;
				break;
			}
		}
		
		if(flag == 1){
			nodes = (Node**)realloc(nodes, sizeof(Node*)*(sizeArr+1));
			nodes[sizeArr] = (Node*)malloc(sizeof(Node));
			nodes[sizeArr]->character = string[i];
			nodes[sizeArr]->freq = 1;
			nodes[sizeArr]->pLeft = NULL;
			nodes[sizeArr]->pRight = NULL;
			sizeArr++;
		}
	}
	fakeWall = sizeArr;
	return nodes;
}

void sort_arr(Node **nodes){
	
	int i,j;
	
	for(i=0 ; i<sizeArr-1 ; i++){
		for(j=0 ; j<sizeArr-i-1 ; j++){
			if(nodes[j]->freq < nodes[j+1]->freq){
				Node *temp = nodes[j];
				nodes[j] = nodes[j+1];
				nodes[j+1] = temp;
			}
		}
	}
}

Node** make_tree(Node **nodes){
	
	while(fakeWall > 1){
		sort_arr(nodes);
		nodes = (Node**)realloc(nodes, sizeof(Node*)*(sizeArr+1));
		nodes[sizeArr] = (Node*)malloc(sizeof(Node));
		nodes[sizeArr]->freq = nodes[fakeWall-1]->freq + nodes[fakeWall-2]->freq;
		nodes[sizeArr]->character = '@';
		nodes[sizeArr]->pLeft = nodes[fakeWall-1];
		nodes[sizeArr]->pRight = nodes[fakeWall-2];
		sizeArr++;
		fakeWall--;
	}
	sort_arr(nodes);
	return nodes;
}

void fill_codes_of_nodes(Node *root, Node **nodes, char *code){
	
	if(root->pLeft){
		fill_codes_of_nodes(root->pLeft, nodes, strcat(code,"0"));
	}
	if(root->pRight){
		fill_codes_of_nodes(root->pRight, nodes, strcat(code,"1"));
	}
	if(!root->pLeft && !root->pRight){
		int i;
		for(i=0 ; i<sizeArr ; i++){
			if(root->character == nodes[i]->character){
				strcpy(nodes[i]->code , code);
				break;
			}
		}
	}
	
	code[(strlen(code)-1)] = 0;
	
	return;
}

void fill_encrypted_string(Node **nodes, char *string, char *encrypted_string){
	
	free_string(encrypted_string);
	
	int i,j;
	int strln = strlen(string);
	
	for(i=0 ; i<strln ; i++){
		for(j=0 ; j<sizeArr ; j++){
			if(string[i] == nodes[j]->character){
				strcat(encrypted_string , nodes[j]->code);
			}
		}
	}
	printf("%d\n", strlen(encrypted_string));
}

void print_table_of_codes(Node **nodes){
	
	int i;
	
	for(i=0 ; i<sizeArr ; i++){
		if(nodes[i]->character != '@'){
			printf("%c - %s\n", nodes[i]->character, nodes[i]->code);
		}
	}
}

void write_to_file(Node **nodes, char *encrypted_string){
	
	//Add size of array to file
	int i, sizeArrWithoutAssociateNodes = 0;
	for(i=0 ; i<sizeArr ; i++){
		if(nodes[i]->character != '@'){
			sizeArrWithoutAssociateNodes++;
		}
	}
	
	FILE *fp;
	
	if((fp = fopen("haffmancode.dat", "wb")) == NULL){
		printf("Problem with opening file!\n");
		return;
	}
	fwrite(&sizeArrWithoutAssociateNodes, sizeof(int), 1, fp);
	
	//Add char and frequency of nodes to file
	for(i=0 ; i<sizeArr ; i++){
		if(nodes[i]->character != '@'){
			fwrite(&nodes[i]->character, sizeof(char), 1, fp);
			fwrite(&nodes[i]->freq, sizeof(int), 1, fp);
		}
	}
	
	//Add count of char to file
	int strln = strlen(encrypted_string);
	fwrite(&strln, sizeof(int), 1, fp);
	
	//Add encrypted_string to file
	fwrite(encrypted_string, sizeof(char)*strln, 1, fp);
	
	fclose(fp);
}

int file_is_empty(){
	FILE *fp;
	fp = fopen("haffmancode.dat", "rb");
	
	fseek(fp, 0 , SEEK_END);
	int pos = ftell(fp);
	if(pos <= 2){
		printf("File is empty!\n");
		return 1;
	}
	
	fclose(fp);
	
	return 0;
}

Node** read_from_file(Node **nodes, char *encrypted_string){
	
	int i;
	FILE *fp;
	
	if((fp = fopen("haffmancode.dat", "rb")) == NULL){
		printf("Problem with opening file!\n");
		return;
	}
	
	//Get sizeArr from file
	fread(&sizeArr, sizeof(int), 1, fp);
	
	//Get character and frequency from file to nodes
	nodes = (Node**)realloc(nodes, sizeof(Node*)*sizeArr);
	for(i=0 ; i<sizeArr ; i++){
		nodes[i] = (Node*)malloc(sizeof(Node));
		fread(&nodes[i]->character, sizeof(char), 1, fp);
		fread(&nodes[i]->freq, sizeof(int), 1, fp);
		nodes[i]->pLeft = NULL;
		nodes[i]->pRight = NULL;
	}
	
	//Get length of encrypted string from file
	int strln = 0;
	fread(&strln, sizeof(int), 1, fp);
	
	//Get encrypted string from file
	fread(encrypted_string, sizeof(char)*strln, 1, fp);
	
	fclose(fp);
	return nodes;
}

void free_string(char *string){
	
	int i;
	
	for(i=0 ; i<SIZEFORCHARARRAY ; i++){
		string[i] = '\0';
	}
}

void fill_string_after_reading_from_file(Node *root, char *string, char *encrypted_string){
	
	free_string(string);
	
	int index = 0;
	int strln = strlen(encrypted_string);
	
	Node *temp;
	while(index < strln){
		temp = root;
		while(temp->pLeft && temp->pRight){
			if(encrypted_string[index] == '0'){
				temp = temp->pLeft;
			}else{
				temp = temp->pRight;
			}
			index++;
		}
		string[strlen(string)] = temp->character;
	}
}



















