#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
void main(){
    char alfabeto[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
    int fd[2];
    pid_t pid[2];   
    pipe(fd);
    for(int i=0;i<2;i++){
        pid[i]=fork();
    }
    
}