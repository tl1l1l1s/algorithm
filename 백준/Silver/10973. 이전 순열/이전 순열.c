#include <stdio.h>

// 이전 순열을 구하는 함수
int previousPermutation(int arr[], int N) {
    int i = N - 1;

    // 순열을 끝에서부터 역순으로 탐색하며 내림차순이 깨지는 지점을 찾음
    while (i > 0 && arr[i - 1] <= arr[i]) {
        i--;
    }

    // 가장 처음에 오는 순열인 경우 -1 반환
    if (i == 0) {
        return 0;
    }

    int j = N - 1;

    // 내림차순이 깨지는 지점부터 순열의 끝까지 역순으로 탐색하며
    // arr[i-1]보다 작은 첫 번째 수를 찾음
    while (arr[j] >= arr[i - 1]) {
        j--;
    }

    // 두 수를 스왑
    int temp = arr[i - 1];
    arr[i - 1] = arr[j];
    arr[j] = temp;

    // 스왑한 지점 이후의 순열을 내림차순으로 정렬
    j = N - 1;
    while (i < j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }

    return 1;
}

int main() {
    int N;
    scanf("%d", &N);

    int arr[N];
    for (int i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    // 이전 순열을 찾음
    if (previousPermutation(arr, N)) {
        for (int i = 0; i < N; i++) {
            printf("%d ", arr[i]);
        }
    } else {
        printf("-1");
    }

    return 0;
}
