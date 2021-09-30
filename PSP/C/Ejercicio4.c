#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
//paso de informacion de proceso padre a hijo mediante un Pipe
int main(void)
{
  int fd[2];
  pid_t pid;
  
  pipe(fd);   //creo pipe
  pid=fork(); //creo proceso 

 switch(pid) {
   case -1 : //ERROR
           printf("NO SE HA PODIDO CREAR HIJO...");
           return(-1);           
           
   case 0 : //HIJO ENVIA
            close(fd[0]);//el hijo sólo va a leer así que cierra el descriptor de salida
            char saludoHijo[]="Buenos dias padre!";
            write(fd[1], saludoHijo, sizeof(saludoHijo));//padre escribe en pipe           
            printf("\tEl HIJO envia algo del pipe: %s\n",saludoHijo);  
            wait(NULL); //espero al proceso hijo           
            break;  
             
   default ://PADRE RECIBE       
            close(fd[1]); //el padre sólo va a escribir así que cierra el descriptor de entrada
            char buffer[80];
            read(fd[0], buffer, sizeof(buffer)); //hijo lee del pipe printf("El PADRE ENVIA MENSAJE AL HIJO...\n");   
            printf("\tEl PADRE recibe algo del pipe: %s\n",buffer);  
            break;
 }  
 return 0;
}

