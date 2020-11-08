package com.github.unidbg.linux.android.dvm.jni;

import com.github.unidbg.linux.android.dvm.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class ProxyJni extends JniFunction {

    private static final Log log = LogFactory.getLog(ProxyJni.class);

    private final ClassLoader classLoader;

    ProxyJni(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public DvmObject<?> newObject(BaseVM vm, DvmClass dvmClass, DvmMethod dvmMethod, VarArg varArg) {
        try {
            Class<?> clazz = classLoader.loadClass(dvmClass.getName());
            ProxyCall proxyCall = ProxyUtils.findConstructor(clazz, dvmMethod, varArg);
            Object obj = proxyCall.call(null);
            return new ProxyDvmObject(vm, obj);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            log.warn("newObject", e);
        }

        return super.newObject(vm, dvmClass, dvmMethod, varArg);
    }

    @Override
    public DvmObject<?> callStaticObjectMethod(BaseVM vm, DvmClass dvmClass, DvmMethod dvmMethod, VarArg varArg) {
        try {
            Class<?> clazz = classLoader.loadClass(dvmClass.getName());
            ProxyCall proxyCall = ProxyUtils.findMethod(clazz, dvmMethod, varArg);
            Object obj = proxyCall.call(null);
            return new ProxyDvmObject(vm, obj);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            log.warn("callStaticObjectMethod", e);
        }
        return super.callStaticObjectMethod(vm, dvmClass, dvmMethod, varArg);
    }

    @Override
    public DvmObject<?> getStaticObjectField(BaseVM vm, DvmClass dvmClass, DvmField dvmField) {
        try {
            Class<?> clazz = classLoader.loadClass(dvmClass.getName());
            Field field = clazz.getField(dvmField.getFieldName());
            field.setAccessible(true);
            Object obj = field.get(null);
            if (obj == null) {
                return null;
            }
            return new ProxyDvmObject(vm, obj);
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            log.warn("getStaticObjectField", e);
        }

        return super.getStaticObjectField(vm, dvmClass, dvmField);
    }

}
