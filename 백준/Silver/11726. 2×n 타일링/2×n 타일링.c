// 2xn 크기의 직사각형을 1x2, 2x1 사이즈로 채우는 방법의 수
// 그 방법의 수를 를 10,007로 나눈 나머지를 출력
#include<stdio.h>
#include<stdlib.h>

int main() {
    int n;

    scanf("%d", &n);
    int* arr = (int*)malloc(sizeof(int)*n+1);
    arr[1] = 1;
    arr[2] = 2;
    for(int i=3; i<=n; i++) {
        arr[i] = (arr[i-1]+arr[i-2])%10007;
    }
    printf("%d", arr[n]);

    return 0;
}