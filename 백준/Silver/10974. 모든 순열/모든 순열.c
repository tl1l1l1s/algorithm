#include <stdio.h>
#include <stdbool.h>

int N;
bool used[9];
int permutation[9];

void printPermutation() {
    for (int i = 1; i <= N; i++) {
        printf("%d ", permutation[i]);
    }
    printf("\n");
}

void generatePermutations(int current) {
    if (current == N + 1) {
        printPermutation();
        return;
    }

    for (int i = 1; i <= N; i++) {
        if (!used[i]) {
            permutation[current] = i;
            used[i] = true;
            generatePermutations(current + 1);
            used[i] = false;
        }
    }
}

int main() {
    scanf("%d", &N);

    for (int i = 1; i <= N; i++) {
        used[i] = false;
    }

    generatePermutations(1);

    return 0;
}
