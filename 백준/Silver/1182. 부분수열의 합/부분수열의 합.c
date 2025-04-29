#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include<memory.h>
#include<stdbool.h>
int n, s;
int* array, cnt = 0;
void dfs(int idx, int sum) {
    if (idx == n) { return; }
    if (sum + array[idx] == s) { cnt++; }

    dfs(idx + 1, sum);
    dfs(idx + 1, sum + array[idx]);
}

int main() {
    scanf("%d %d", &n, &s);
    array = (int*)malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++) { scanf("%d", &array[i]); }
    
    dfs(0, 0);

    printf("%d", cnt);


    return 0;
}
