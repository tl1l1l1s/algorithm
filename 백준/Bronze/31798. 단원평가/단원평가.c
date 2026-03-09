#include <stdio.h>
#include <math.h>

int main() {

    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);

    if(a == 0) {
        printf("%.0f", pow(c, 2) - b);
    } else if(b == 0) {
        printf("%.0f", pow(c, 2) - a);
    } else if(c == 0) {
        printf("%.0f", sqrt(a + b));
    }
    return 0;
}