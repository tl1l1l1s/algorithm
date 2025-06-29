#include<stdio.h>
#include<stdlib.h>

void merge(int *a, int p, int q, int r, int* temp) {
    int i = p, j = q+1, t = p, k = p;

    while(i<=q && j<=r) {
        if(a[i] < a[j]) {
            temp[t] = a[i];
            i++;
        }
         else {
            temp[t] = a[j];
            j++;
         }
         t++;
    }

    while(1) {
        if(i<=q) {
            temp[t] = a[i];
            i++; t++;
        } else if(j<=r) {
            temp[t] = a[j];
            j++; t++;
        } else {
            break;
        }
    }
    
    for(; k<=r; k++) {
        a[k] = temp[k];
    }

    return;
}

void mergeSort(int* a, int p, int r, int* temp) {
    int q;

    if(p<r) {
        q = (p+r)/2;
        mergeSort(a, p, q, temp);
        mergeSort(a, q+1, r, temp);
        merge(a, p, q, r, temp);
    }

    return;
}

int main(void) {
    int size;
    scanf("%d", &size);

    int* arr = (int*)malloc(sizeof(int) * (size));
    int* temp = (int*)malloc(sizeof(int) * (size));

    for(int i=0; i<size; i++) {
        scanf("%d", &arr[i]);
    }

    mergeSort(arr, 0, size-1, temp);
    printf("%d", arr[0]*arr[size-1]);

    free(arr);
    free(temp);

    return 0;
}