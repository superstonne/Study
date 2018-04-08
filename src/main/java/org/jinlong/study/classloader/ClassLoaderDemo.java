package org.jinlong.study.classloader;

import java.util.HashMap;
import java.util.Map;

public class ClassLoaderDemo {

    static {
        System.out.println("static block has been executed.");
    }
    public Map map = new HashMap(){
        {
            System.out.println(map);

        }
    };

    {
        System.out.println("Non static block has been executed.");
        map.put("1", "1");
        map.put("2", "2");
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // ExtClassLoader 加载该路径下的class文件
        System.out.println(System.getProperty("java.ext.dirs"));

        // AppClassLoader 加载该路径下的class文件
        System.out.println(System.getProperty("java.class.path"));

        Class.forName("org.jinlong.study.classloader.ClassLoaderDemo");
        System.out.println(ClassLoaderDemo.class.getClassLoader().getResource("").toString());

//        System.loadLibrary("NoLib");
//        nativeMethod();

//        Map map = new HashMap();
//        map.put("1", 1);
//        Integer _1 = (Integer) map.get("1");
//        Object _1 = map.get("1");

        System.out.println("here");
        new ClassLoaderDemo();

        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.getClass().getCanonicalName());
            classLoader = classLoader.getParent();
        }

        PathClassLoader pathClassLoader = new PathClassLoader("E:/workspace/idea-workspace/Study/target/classes/");
        Class toBeLoadedClass = pathClassLoader.findClass("org.jinlong.study.classloader.ToBeLoaded");
        System.out.println("toBeLoadedClass = " + toBeLoadedClass);
        System.out.println(toBeLoadedClass.newInstance());

        ToBeLoaded toBeLoaded = new ToBeLoaded();
        System.out.println(toBeLoadedClass.newInstance());
        classLoader = toBeLoadedClass.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.getClass().getCanonicalName());
            classLoader = classLoader.getParent();
        }

    }

    public static native void  nativeMethod();
}
