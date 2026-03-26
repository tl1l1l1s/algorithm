#include <stdio.h>

int main() {
    int T, N;

    scanf("%d", &T);
    scanf("%d", &N);

    int res = 0;
    for(int i=0; i<N; i++) {
        int temp;
        scanf("%d", &temp);
        res += temp;
    }

    if(res >= T) {
        printf("Padaeng_i Happy");
    } else {
        printf("Padaeng_i Cry");
    }

    return 0;
}