#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAX 1000000

int main(void) {
    int a, flag = 1, i, j = 2, size = 0;
    int memo[MAX+1] = {0, 0};

    memo[0] = 1, memo[1] = 1;
    for(i=2; i<sqrt(MAX); i++) {
        if(memo[i] == 0) {
            for(j=2; (i*j)<MAX; j++) {
                memo[i*j] = 1;
            }
        }
    }
    
    while(1) {
        scanf("%d", &a);
        if(a == 0) break;

        int flag = 1;
        for(i=3; i<=a/2; i+=2) {
            if(memo[i] == 0 && memo[a-i] == 0) {
                printf("%d = %d + %d\n", a, i, a-i);
                flag = 0;
                break;
            }
        }

        if(flag != 0) printf("Goldbach's conjecture is wrong.\n"); 
    }

    return 0;
}