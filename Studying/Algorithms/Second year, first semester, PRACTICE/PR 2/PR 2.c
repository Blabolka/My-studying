#include <stdio.h>
#include <stdlib.h>

typedef struct tree{
	int num;
	struct tree *parent;
	struct tree *left;
	struct tree *right;
}node;

typedef struct LinkedList{
	int num;
	node *left;
	node *right;
	struct LinkedList *pNext;
}queue;

node* init_tree(node *root);
node* add_element_to_tree(node *root);
node* delete_element(node *root);
node* search_min(node *root);
void direct_print(node *root);
void converse_print(node *root);
void symmetrical_print(node *root);
void wide_print(node *root);
queue* push_back(queue *head, node *newElement);
queue* delete_queue(queue *head);

int main(){
	
	int choice;
	node *root = NULL;
	
	system("chcp 1251 > nul");
	
	while(1){
		printf("1.Add element\n2.Delete element\n3.Print elements\n0.Exit program\n");
		scanf("%d", &choice);
		
		switch(choice){
			case 1:
				root = add_element_to_tree(root);
				break;	
			case 2:
				root = delete_element(root);
				break;	
			case 3:
				if(root==NULL){ 
					printf("You have not added elements!\n");
					break; 
				}
				printf("Direct print: \t\t");
				direct_print(root);
				printf("\n");
				printf("Reverse print:\t\t");
				converse_print(root);
				printf("\n");
				printf("Symmetrical print:\t");
				symmetrical_print(root);
				printf("\n");
				printf("Broad print:\t\t\t");
				wide_print(root);
				printf("\n");
				break;
			case 0:
				return 0;
		}
	}
	
	return 0;
}

node* init_tree(node *root){
	
	root = (node*)malloc(sizeof(node));
	
	printf("Enter the value: ");
	scanf("%d", &root->num);
	
	root->parent = NULL;
	root->left = NULL;
	root->right = NULL;
	
	return root;
}

node* add_element_to_tree(node *root){
	if(root == NULL){
		root = init_tree(root);
		return root;
	}
	
	int num;
	node *temp;
	node *p = root;
	node *parent;
	
	printf("Enter the value: ");
	scanf("%d", &num);
	
	while(p!=NULL){
		parent = p;
		if(num == p->num){
			printf("The same element already exists in the tree!\n");
			return root;	
		}else if(num < p->num){
			p = p->left;
		}else{
			p = p->right;
		}
	}
	
	temp = (node*)malloc(sizeof(node));
	
	temp->num 	 = num;
	temp->parent = parent;
	temp->left   = NULL;
	temp->right  = NULL;
	
	if(temp->num < parent->num){
		parent->left  = temp;
	}else{
		parent->right = temp;
	}
	return root;
}

node* delete_element(node *root){
	if(root == NULL){
		printf("You have not added elements!\n");
		return root;
	}
	
	int num;
	int flag=0;
	node *p = root;
	node *parent = root->parent;
	node *temp,*min,*max;
	
	printf("Enter the value to deleting ");
	scanf("%d", &num);
	
	while(p!=NULL){
		if(num == p->num){
			flag=1;
			break;
		}
		parent = p;
		if(num < p->num){
			p = p->left;
		}else{
			p = p->right;
		}
	}
	if(flag==0){
		printf("No such element exists!\n");
		return root;
	}
	
	if(p->left == NULL && p->right == NULL){	//Deleting tree leaf
		if(parent != NULL){
			if(parent->left == p){
				parent->left  = NULL;
			}else{
				parent->right = NULL;
			}
			free(p);
			return root;	
		}else{
			free(p);
			return NULL;
		}
	}else if(p->left != NULL && p->right == NULL){	//Left child exists, Right child does not exists
		if(parent != NULL){
			if(parent->left == p){
				parent->left  = p->left;
			}else{
				parent->right = p->left;
			}
			temp = p->left;
			temp->parent = parent;
			free(p);
			return root;
		}else{
			temp = p->left;
			temp->parent = parent;
			free(p);
			return temp;
		}
	}else if(p->left == NULL && p->right != NULL){	//Left child does not exists, Right child exists
		if(parent != NULL){
			if(parent->left == p){
				parent->left  = p->right;
			}else{
				parent->right = p->right;
			}
			temp = p->right;
			temp->parent = parent;
			free(p);
			return root;
		}else{
			temp = p->right;
			temp->parent = parent;
			free(p);
			return temp;
		}
	}else if(p->left != NULL && p->right != NULL){	//Left child exists, Right child exists
		if(parent != NULL){
			if(parent->left == p){
				parent->left  = p->right;
			}else{
				parent->right = p->right;
			}
			temp = p->left;
			temp->parent = (search_min(p->right))->left;
			temp = p->right;
			temp->parent = parent;
			(search_min(temp))->left = p->left;
			free(p);
			return root;
		}else{
			temp = p->left;
			temp->parent = (search_min(p->right))->left;
			temp = p->right;
			temp->parent = parent;
			(search_min(temp))->left = p->left;
			free(p);
			return temp;
		}
	}
	return root;
}

node* search_min(node *root){
	while(root->left != NULL){
		root = root->left;
	}
	return root;
}

void direct_print(node *root){
	if(root == NULL){ return; }
	
	printf("%5d", root->num);
	direct_print(root->left);
	direct_print(root->right);
	return;
}

void converse_print(node *root){
	if(root == NULL){ return; }
	
	converse_print(root->left);
	converse_print(root->right);
	printf("%5d", root->num);
	return;
}

void symmetrical_print(node *root){
	if(root == NULL){ return; }
	
	symmetrical_print(root->left);
	printf("%5d", root->num);
	symmetrical_print(root->right);
	return;	
}

void wide_print(node *root){
	if(root == NULL){ return; }
	
	queue *head = NULL;
	head = push_back(head,root);
	queue *temp = head;
	
	while(temp != NULL){
		printf("%-6d", temp->num);
		if(temp->left  != NULL){
			head = push_back(head,temp->left);
		}
		if(temp->right != NULL){
			head = push_back(head,temp->right);
		}
		temp = temp->pNext;
	}
	printf("\n");
	
	head = delete_queue(head);
}

queue* push_back(queue *head, node *newElement){
	if(head == NULL){
		head = (queue*)malloc(sizeof(queue));
		head->num   = newElement->num;
		head->left  = newElement->left;
		head->right = newElement->right;
		head->pNext = NULL; 
		return head;
	}
	
	queue *temp = head;
	queue *p=NULL;
	
	while(temp != NULL){
		p = temp;
		temp = temp->pNext;
	}
	
	temp = (queue*)malloc(sizeof(queue));
	temp->num   = newElement->num;
	temp->left  = newElement->left;
	temp->right = newElement->right;
	temp->pNext = NULL;
	
	p->pNext = temp;
	
	return head;
}

queue* delete_queue(queue *head){
	
	queue *temp;
	queue *parent;
	queue *preparent;
		
	while(1){
		preparent = NULL;
		parent = NULL;
		temp = head;
		while(temp != NULL){
			preparent = parent;
			parent    = temp;
			temp 	  = temp->pNext;
		}
		if(preparent == NULL){
			free(head);
			head = NULL;
			break;
		}
		free(parent);
		preparent->pNext = NULL;
	}
	return head;
}
