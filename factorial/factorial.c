#include<stdio.h>
#define MAX_DIGITS 1000 //Maximum possible digits in the factorial

int num_of_digits = 0;
int result[MAX_DIGITS];


void product(int number){
    long i, carry = 0;
	
    for(i = 0; i <= num_of_digits; i++){
		int temp = result[i];
		result[i] = (temp * number + carry) % 10;
		carry = (temp * number + carry) / 10; //carry bit
    }
	//if carry is > 0, num of digits has to be increased 
    if(carry > 0){
		while(carry != 0){
			result[i] = carry % 10;
			carry = carry / 10;
			i++;
		}
    }
    num_of_digits = i - 1;    
}

void factorial(int number){
    int i;
    for(i = 2; i <= number; i++){
		product(i); 
    }
}


int main(int argc, char* argv[]){
    int number = atoi(argv[1]);
    int i;
	
    result[0] = 1;
	 
    factorial(number);
    
    for(i = num_of_digits; i >= 0;i--){
		printf("%d",result[i]);
    }
	printf("\n");
    return 0;
}
