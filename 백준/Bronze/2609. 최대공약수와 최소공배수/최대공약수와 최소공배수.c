#include<stdio.h>

int main(void) {
    int a, b, a1, b1, ret;

    scanf("%d", &a);
    scanf("%d", &b);
    a1 = a;
    b1 = b;

    // 최대공약수 유클리드 호제법
    do {
        ret = a1%b1;
        a1 = b1;
        b1 = ret;
    } while(ret != 0);
    printf("%d\n", a1);

    // 최소공배수
    printf("%d", (a*b)/a1);

    return 0; 
}