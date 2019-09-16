package util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 操作对象Field的get和set
 */
public class ReflectHelper {
    //获取属性对应field,第一次从当前类找，没有再看父类获取field
    public static Field getFieldByFieldName(Object obj, String fieldName) {
       /* Class<?> aClass = obj.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        Field[] fields = aClass.getDeclaredFields();
        for(Annotation annotation:annotations){
            System.out.println(annotation+"annotations_name:"+annotations.getClass().getName());
        }
        for(Field field :fields){
            System.out.println(field.getName());
        }
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(aClass.getName()+"----"+superclass.getName());*/
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
                .getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);//getDeclaredField(fileName)
            } catch (NoSuchFieldException e) {
            }
        }
        return null;
    }

    /**
     * @description: 根据属性取值
     * @param obj
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName)
            throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);//filename-Field
        Object value = null;
        if(field!=null){
            if (field.isAccessible()) {//private属性操作
               //field.setAccessible(true);
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * @description: 根据属性赋值
     * @param obj
     * @param fieldName
     * @param value
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setValueByFieldName(Object obj, String fieldName,
                                           Object value) throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        if (field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }
    }
}

