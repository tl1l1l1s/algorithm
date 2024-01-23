#include<stdio.h>

// counting sort

int main() {
    int n, m;
    int nums[10001] = {0, };
    scanf("%d", &n);

    for(int i=0; i<n; i++) {
        scanf("%d", &m);
        nums[m]++;
    }

    for(int i=0; i<10001; i++) {
        while(nums[i]!=0) {
            printf("%d\n", i);
            nums[i]--;
        }
    }

    return 0;
}