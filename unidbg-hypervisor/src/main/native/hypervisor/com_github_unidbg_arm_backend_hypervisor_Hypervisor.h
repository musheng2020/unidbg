/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_github_unidbg_arm_backend_hypervisor_Hypervisor */

#ifndef _Included_com_github_unidbg_arm_backend_hypervisor_Hypervisor
#define _Included_com_github_unidbg_arm_backend_hypervisor_Hypervisor
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_github_unidbg_arm_backend_hypervisor_Hypervisor
 * Method:    setHypervisorCallback
 * Signature: (JLcom/github/unidbg/arm/backend/hypervisor/HypervisorCallback;)I
 */
JNIEXPORT jint JNICALL Java_com_github_unidbg_arm_backend_hypervisor_Hypervisor_setHypervisorCallback
  (JNIEnv *, jclass, jlong, jobject);

/*
 * Class:     com_github_unidbg_arm_backend_hypervisor_Hypervisor
 * Method:    createVM
 * Signature: (Z)J
 */
JNIEXPORT jlong JNICALL Java_com_github_unidbg_arm_backend_hypervisor_Hypervisor_createVM
  (JNIEnv *, jclass, jboolean);

/*
 * Class:     com_github_unidbg_arm_backend_hypervisor_Hypervisor
 * Method:    mem_unmap
 * Signature: (JJJ)I
 */
JNIEXPORT jint JNICALL Java_com_github_unidbg_arm_backend_hypervisor_Hypervisor_mem_1unmap
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     com_github_unidbg_arm_backend_hypervisor_Hypervisor
 * Method:    mem_map
 * Signature: (JJJI)I
 */
JNIEXPORT jint JNICALL Java_com_github_unidbg_arm_backend_hypervisor_Hypervisor_mem_1map
  (JNIEnv *, jclass, jlong, jlong, jlong, jint);

/*
 * Class:     com_github_unidbg_arm_backend_hypervisor_Hypervisor
 * Method:    mem_protect
 * Signature: (JJJI)I
 */
JNIEXPORT jint JNICALL Java_com_github_unidbg_arm_backend_hypervisor_Hypervisor_mem_1protect
  (JNIEnv *, jclass, jlong, jlong, jlong, jint);

#ifdef __cplusplus
}
#endif
#endif
