#include<stdio.h>
#include<string.h>

//A~Z 65~90 - 65
//a~z 97~122 - 97
int main(void) {
    int num[26] = {0, };
    char word[1000001];
    char a;
    int i, max = 0, size;

    scanf("%s", word);
    size = strlen(word);

    for(i=0; i<size; i++) {
        if(word[i]>='a') {
            num[word[i]-'a']++;
        } else {
            num[word[i]-'A']++;
        }
    }

    for(i=0; i<26; i++) {
        if(max<num[i]) {
            max = num[i];
            a = i+'A';
        }
        else if(max==num[i]) a = '?';
    }

    printf("%c", a);

    return 0;
}