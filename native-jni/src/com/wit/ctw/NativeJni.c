#include "com_wit_ctw_NativeJni.h"
#include <String.h>

JNIEXPORT jint JNICALL Java_com_wit_ctw_NativeJni_multiply
  (JNIEnv * env, jclass jcl, jint a, jint b)
{
 return  a*b;
}
