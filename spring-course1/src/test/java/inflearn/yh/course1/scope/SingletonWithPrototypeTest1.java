package inflearn.yh.course1.scope;

import static org.assertj.core.api.Assertions.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            PrototypeBean.class);

        PrototypeBean proto1 = ac.getBean(PrototypeBean.class);
        proto1.addCount();
        assertThat(proto1.getCount()).isEqualTo(1);

        PrototypeBean proto2 = ac.getBean(PrototypeBean.class);
        proto2.addCount();
        assertThat(proto2.getCount()).isEqualTo(1);

    }

    @Test
    void singletonClientUserPrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
            ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);


        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);


    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class ClientBean {
        private final ObjectProvider<PrototypeBean> objectProvider;

        public int logic() {
            PrototypeBean prototypeBean = objectProvider.getObject();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }


    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);

        }

        @PreDestroy
        public void destory() {
            System.out.println("PrototypeBean.destory");
        }

    }
}
