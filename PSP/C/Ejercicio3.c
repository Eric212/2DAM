#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h> 
void main(){
	int x=6;
	pid_t pid;
	pid=fork();
	if (pid == -1) { // Hubo error
    	printf("Hubo un problema al crear el hijo");
   	 exit(-1);
   	 }
	if(pid==0){
	x=x-5;
	printf("El resultado del hijo es: %d\n",x);
	}else{
	x=x+5;
	printf("El resultado del padre es: %d\n",x);
	}
}
