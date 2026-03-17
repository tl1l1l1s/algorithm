#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    // 만들 수 있는 직사각형의 개수
    // 1. 일렬로 연결
    // 2. 두 줄로 나열
    // 3. 세 줄로 나열
    // 4.. 네..

    int res = 0;
    for(int r = 1; r <= n; r++) {
        res++;

        for(int c = 2; c < r; c++) {
            if(r % c == 0) {
                if(c > r/c) {
                    break;
                } else res++;
            }
        }
    }
    
    printf("%d\n", res);
    return 0;
}