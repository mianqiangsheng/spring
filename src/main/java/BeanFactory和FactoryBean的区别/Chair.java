package BeanFactory和FactoryBean的区别;

/**
 * Created by lizhen on 2018/10/29.
 */
public class Chair implements Furniture {
    @Override
    public void sayHello() {
        System.out.println("我是一把椅子。");
    }
}
