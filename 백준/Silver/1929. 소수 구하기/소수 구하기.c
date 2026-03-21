#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) {
    int a, b, i, j = 2;

    scanf("%d", &a);
    scanf("%d", &b);

    int* memo = (int*)malloc(sizeof(int)*(a>b ? a : b)+1);
    for(i=2; i<=(a>b? a:b); i++) {
        memo[i] = 0;
        // true==0, false==1
    }

    memo[0] = 1;
    memo[1] = 1;
    i = 2;
    while(i<=(a>b ? sqrt(a):sqrt(b))) {
        if(memo[i] == 0) {
            for(j=2; (i*j)<=(a>b ? a : b); j++) {
                memo[i*j] = 1;
            }
        }
        i++;
    }

    for(j=(a>b ? b:a); j<=(a>b? a:b); j++) {
        if(memo[j] == 0) {
            printf("%d\n", j);
        }
    }

    free(memo);
    return 0;
}