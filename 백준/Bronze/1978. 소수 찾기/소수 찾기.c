#include<stdio.h>
#include<stdlib.h>

int main(void) {
    int n, count = 0;
    
    scanf("%d", &n);
    int *arr = (int*)malloc(sizeof(int)*n);
    for(int i=0; i<n; i++) {
        scanf("%d", &arr[i]);
        for(int j=2; j<=arr[i]; j++) {
            if(arr[i] == j) count+=1;
            if(arr[i]%j == 0) break;
        }
        
    }

    printf("%d", count);
    free(arr);
    return 0;
}