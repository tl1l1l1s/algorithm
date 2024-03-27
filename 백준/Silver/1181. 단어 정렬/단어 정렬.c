#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int compare(const void *a, const void *b) {
    if(strlen(a) > strlen(b)) {
        return 1;
    } else if(strlen(a) < strlen(b)) {
        return -1;
    } // 문자열 길이가 더 긴 것을 기준으로 하되, 길이가 같으면
    return strcmp(a, b); // 글자 크기를 strcmp 함수로 비교해 출력
}

int main(void) {
    int n;
    char words[20000][51];

    scanf("%d", &n);
    for(int i=0; i<n; i++) {
        scanf("%s", words[i]);
    }
    
    qsort(words, n, 51 * sizeof(char), compare); // qsort 함수를 통해 문자열 정렬
    for(int i=0; i<n; i++) {
        if(strcmp(words[i], words[i+1]) != 0 || i == (n-1)) { // 중복되는 문자열은 출력하지 않기 위해 if문 작성
            printf("%s\n", words[i]);
        }
    }

    return 0;
}