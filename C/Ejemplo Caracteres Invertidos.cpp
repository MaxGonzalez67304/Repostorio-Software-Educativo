#include <stdio.h>
#include <stdlib.h>

int main()
{
    char cadena[200];
    int i = 0;
    int j;
    printf("Introduce una cadena de texto: \n");
    gets(cadena);
    while(cadena[i]!='\0'){
        i++;
    }
    printf("La cadena invertida es:\n\t");
    for (j=i-1; j>=0; j--){
        printf("%c", cadena[j]);
    }

    return 0;
}
