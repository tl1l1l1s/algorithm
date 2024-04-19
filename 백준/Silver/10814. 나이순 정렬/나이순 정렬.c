#include<stdio.h>
#include<stdlib.h>

typedef struct Info {
    int age;
    char name[101];
} Info;

int compare(const void *a, const void *b) {
    Info* listA = (Info*)a;
    Info* listB = (Info*)b;

    if(listA->age == listB->age) {
        return 0;
    } else if(listA->age > listB->age) {
        return 1;
    } return -1;
};

int main() {
    int N, i;
    // 나이, 이름이 공백으로 구분되어 주어짐
    // 1<=age<=200, name[100] 알파벳 대소문자
    
    scanf("%d", &N);
    Info list[N];
    for(i=0; i<N; i++) {
        scanf("%d", &list[i].age);
        scanf("%s", list[i].name);
    }

    qsort(list, N, sizeof(Info), compare);

    for(i=0; i<N; i++) {
        printf("%d %s\n", list[i].age, list[i].name);
    }
    
    return 0;
}