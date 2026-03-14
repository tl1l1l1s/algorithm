#include <stdio.h>
#include <stdlib.h>

int main() {
    int a, b;
    scanf("%d %d", &a, &b);

    for(int i=0; i<(abs(a-b)); i++) {
        printf("1");
    }

    if(a-b != 0) {
        for(int i=0; i<(a < b ? a : b); i++) {
            printf("2");
        }    
    } else {
        for(int i=0; i<a; i++) {
            printf("2");
        }
    }
    
    return 0;
}