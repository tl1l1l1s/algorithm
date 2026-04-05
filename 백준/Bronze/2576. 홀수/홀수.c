#include <stdio.h>

int main() {
    int n;
    int addition = 0;
    int min = 100;
    
    for(int i=0; i<7; i++) {
        scanf("%d", &n);

        if(n%2 != 0) {
            addition += n;
            if(n < min) {
                min = n;
            }
        }
    }

    if(addition == 0) {
        printf("-1");
    } else {
        printf("%d\n%d", addition, min);    
    }
    
    return 0;
}