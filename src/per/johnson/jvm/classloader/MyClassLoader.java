package per.johnson.jvm.classloader;

import sun.plugin2.applet.Applet2ClassLoaderCache;

import java.io.*;

/**
 * Created by Johnson on 2018/7/19.
 */
public class MyClassLoader extends ClassLoader{
    private String path;
    private ClassLoader parent;
    public MyClassLoader(String path){
        this.path = path;
        this.parent = getClass().getClassLoader();
    }
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class c = findLoadedClass(name);
        if(c == null) {
            try {
                if (parent != null)
                    c = parent.loadClass(name);
            } catch (ClassNotFoundException e) {
                // 父亲无法找到该类时
            }
            if (c == null) {
                c = findClass(name);
            }
        }
        return c;
    }

    @Override
    protected  Class<?> findClass(String name) throws ClassNotFoundException {
        String classFilePath = path + name.replaceAll("\\.","/")+".class";
        try {
            InputStream is = new FileInputStream(new File(classFilePath));
            byte[] data = new byte[is.available()];
            is.read(data);
            return defineClass(name,data,0,data.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
