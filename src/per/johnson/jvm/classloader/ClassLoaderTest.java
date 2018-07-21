package per.johnson.jvm.classloader;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Johnson on 2018/7/19.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String filename = name.substring(name.lastIndexOf('.')+1)+".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myClassLoader.loadClass("per.johnson.jvm.classloader.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        ClassLoaderTest test = (ClassLoaderTest)obj;
        //System.out.println(obj instanceof per.johnson.jvm.classloader.ClassLoaderTest);
    }
}
