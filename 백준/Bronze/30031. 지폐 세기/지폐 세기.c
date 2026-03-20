#include <stdio.h>

int main() {
    int N;
    scanf("%d", &N);

    int result = 0;
    int m1; int m2;
    for(int n=0; n<N; n++) {
        scanf("%d %d", &m1, &m2);

        if(m1==136) {
            result += 1000;
        } else if(m1==142) {
            result += 5000;
        } else if(m1==148) {
            result += 10000;
        } else {
            result += 50000;
        }
    }
    printf("%d\n", result);
    return 0;
}