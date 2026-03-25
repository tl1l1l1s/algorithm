#include <stdio.h>

int main() {
    int a = 2000;
    int b;
    int c = 2000;

    for(int i=0; i<3; i++) {
        scanf("%d", &b);

        if(b < a) {
            a = b;
        }
    }
    
    for(int i=0; i<2; i++) {
        scanf("%d", &b);

        if(b < c) {
            c = b;
        }
    }
    
    printf("%d\n", (a+c-50));
    return 0;
}