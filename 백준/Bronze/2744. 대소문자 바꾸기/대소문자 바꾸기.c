// 영어 소문자 대문자 입력
// 대문자 > 소문자, 소문자 > 대문자
//A~Z 65~90 +32
//a~z 97~122 -32
#include<stdio.h>
#include<string.h>

int main() {
    char word[101] = {};
    char answer[101] = {};
    int size;

    scanf("%s", word);
    size = strlen(word);

    for(int i=0; i<=size; i++) {
        if(word[i]<'a') answer[i]=word[i]+32;
        else answer[i]=word[i]-32;
    }

    printf("%s", answer);

    return 0;
}