#include "crypto.h"
#include <stdio.h>
#include <cstring>
#include <stdlib.h>
#include <jni.h>

JNIEXPORT jstring JNICALL Java_stefan_jovanovic_chatapplication_Crypto_crypt (JNIEnv *env, jobject obj, jstring message)
{
    const char *msg = env->GetStringUTFChars(message, NULL);
    char *key;
    key = "This is the key";
    int size = strlen(msg);
    char* crypted = (char*)malloc(size*sizeof(char));
    memset(crypted, 0, size);

    int i=0;
    int key_cnt = 0;
    for (i = 0; i<size; i++)
    {
        if (key[key_cnt] != msg[i]){
            char temp = key[key_cnt] ^ msg[i];
            crypted[i] = temp;
            key_cnt++;
            if (key_cnt == 16) key_cnt = 0;
        } else {
            char temp = msg[i];
            crypted[i] = temp;
            key_cnt++;
            if (key_cnt == 16) key_cnt = 0;
        }
    }
    crypted[i] = 0;

    env->ReleaseStringUTFChars(message, msg);
    jstring encrypted_out;
    encrypted_out = env->NewStringUTF(crypted);
    return encrypted_out;
}
