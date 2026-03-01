#include <stdio.h>
#include <math.h>

int main() {

    int C, K, P;
    scanf("%d %d %d", &C, &K, &P);

    int result = 0;

    for(int c=1; c<=C; c++) {
        result += K*c + (P * pow(c, 2));
    }
    
    printf("%d\n", result);
    return 0;
}