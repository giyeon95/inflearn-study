package inflearn.yh.course1.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {


    @Test
    void singletonBeanField() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            SingletonBean.class);

        SingletonBean single1 = ac.getBean(SingletonBean.class);
        SingletonBean single2 = ac.getBean(SingletonBean.class);


        System.out.println("single1 = " + single1);
        System.out.println("single2 = " + single2);

        Assertions.assertThat(single1).isSameAs(single2);

        ac.close();
    }



    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println(this.getClass().getSimpleName()+ ".init");
        }

        @PreDestroy
        public void close() {
            System.out.println(this.getClass().getSimpleName()+ ".close");
        }
    }

}
