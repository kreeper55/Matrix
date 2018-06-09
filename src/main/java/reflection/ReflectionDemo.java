package reflection;

import collections.Human;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDemo {
    public static int countIsHuman(List<?> objects) {
        int count = 0;
        for (Object obj : objects) {
            if (obj instanceof Human)
                count++;
        }
        return count;
    }

    public static List<String> getNamePublicMethods(Object obj) {
        List<String> filtered = new ArrayList<>();
        Method[] methods = obj.getClass().getMethods();
        for (Method i : methods) {
            filtered.add(i.getName());
        }
        return filtered;
    }

    public static List<String> getAllSuperClass(Object obj) {
        List<String> list = new ArrayList<>();
        Class superClass = obj.getClass().getSuperclass();
        while (superClass != null) {
            list.add(superClass.getName());
            superClass = superClass.getSuperclass();
        }
        return list;
    }

    public static int executeList(List<?> list) throws Exception {
        int count = 0;
        for(Object obj : list) {
            if (obj instanceof IExecutable) {
                count++;
                ((IExecutable) obj).execute();
            }
//            Class[] interfaces = obj.getClass().getInterfaces();
//            for (Class clss : interfaces) {
//                if(clss == IExecutable.class) {
//                    count++;
//                    Method method = obj.getClass().getMethod("execute");
//                    method.invoke(obj);
//                    break;
//                }
//            }
        }
        return count;
    }

    public static List<String> getGettersAndSetters(Object obj) {
        List<String> filtered = new ArrayList<>();
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method i : methods) {
            if (isSetter(i) || isGetter(i) || isGetterBoolean(i)) {
                filtered.add(i.getName());
            }
        }
        return filtered;
    }

    private static boolean isGetter(Method m) {
        return  (!Modifier.isStatic(m.getModifiers()) &&
                (m.getParameterCount() == 0) &&
                (m.getReturnType() != void.class) &&
                (m.getName().startsWith("get"))
        );
    }

    private static boolean isGetterBoolean(Method m) {
        return  (!Modifier.isStatic(m.getModifiers()) &&
                (m.getParameterCount() == 0) &&
                (m.getReturnType() != void.class) &&
                (m.getReturnType() == boolean.class || (m.getReturnType() == Boolean.class)) &&
                (m.getName().startsWith("is") || m.getName().startsWith("has"))
        );
    }

    private static boolean isSetter(Method m) {
        return  (!Modifier.isStatic(m.getModifiers()) &&
                (m.getParameterCount() == 1) &&
                (m.getReturnType() == void.class) &&
                (m.getName().startsWith("set")));
    }
}
