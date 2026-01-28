#include <stdio.h>
#include <string.h>

int main() {
    char gh[10];
    scanf("%s", gh);

    if(strcmp(gh, "SONGDO") == 0) {
        puts("HIGHSCHOOL");
    } else if(strcmp(gh, "CODE") == 0) {
        puts("MASTER"); 
    } else if(strcmp(gh, "2023") == 0) {
        puts("0611");
    } else {
        puts("CONTEST");
    }
}