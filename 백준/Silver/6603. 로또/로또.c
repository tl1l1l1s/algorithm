// {1...49}까지 중에서 수 6개를 고름
// 49가지 수 중 6보다 큰 수의 k개를 골라 집합 s를 만든 후 , 그 중에서 선택
#include<stdio.h>
#include<stdlib.h>

void pick(int n, int* arr, int* picked, int m, int toPick) {
    int smallest, lastIndex, i;
    if(toPick == 0) {
        for(i=0; i<m; i++) {
            printf("%d ", arr[picked[i]]);
        }
        printf("\n");
        return;
    }

    lastIndex = m-toPick-1;
    if(m==toPick) {
        smallest = 0;
    } else {
        smallest = picked[lastIndex]+1;
    }

    for(i=smallest; i<n; i++) {
        picked[lastIndex+1] = i;
        pick(n, arr, picked, m, toPick-1);
    }
}

int main(void) {
    int n, i;
    int* arr, *picked;

    scanf("%d", &n);
    while(n!=0) {
        arr = (int*)malloc(sizeof(int)*n);
        picked = (int*)malloc(sizeof(int)*n);
        for(i=0; i<n; i++) {
            scanf("%d", &arr[i]);
        }
        pick(n, arr, picked, 6, 6);
        printf("\n");
        scanf("%d", &n);
    }

    free(arr);
    free(picked);

    return 0;
}