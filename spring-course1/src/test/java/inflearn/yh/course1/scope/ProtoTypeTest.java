package inflearn.yh.course1.scope;

import inflearn.yh.course1.scope.SingletonTest.SingletonBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class ProtoTypeTest {


    @Test
    void protoTypeBeanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);

        System.out.println("find prototypeBean2");
        PrototypeBean protoTypeBean2 = ac.getBean(PrototypeBean.class);


        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + protoTypeBean2);

        Assertions.assertThat(prototypeBean1).isNotSameAs(protoTypeBean2);

        ac.close();
    }


    @Scope("prototype")
    static class PrototypeBean {
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
