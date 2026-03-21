#include<stdio.h>

int main()
{
  
    int n,num = 1;
    int count = 1;
    
    while (scanf("%d", &n) != EOF) {
        int i=0;
    	if(n == 1){
            printf("1\n"); continue;
        }
    	for(long long a = 1; (a*10+1)%n; i++){
            a=(a*10+1)%n;
        };
    
    	printf("%d\n",i+2);
    }

    return 0;
}