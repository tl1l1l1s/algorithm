#include<stdio.h>

int main(void) {
    int n;
    long long result = 0;

    scanf("%d", &n);

    for(int i=1; i<=n; i++) {
        result += (n / i) * i;
    }
    printf("%lld", result);

    return 0;
}