package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // System.out.println("memberService = " + memberService);
        // System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    // 반환타입으로 무조건 하지 않아도 조회가 가능하지만
    // 구체 타입으로 조회하는 것은 유연성이 떨어지기 떄문에 좋지 않다
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

//    @Test
//    @DisplayName("빈 이름으로 조회X")
//        // 반환타입으로 무조건 하지 않아도 조회가 가능하지만 구체 타입으로 조회하는 것은 좋지 않다
//    void findBeanByNameX() {
//        MemberService xxxxx = ac.getBean("xxxxx", MemberServiceImpl.class);
//        // junit의 Assertions
//        // 오른쪽 코드를 실행하면 왼쪽에 있는 예외가 터져야 성공
//        assertThrows(NoSuchBeanDefinitionException.class,
//                () -> ac.getBean("xxxxx", MemberServiceImpl.class));
//    }
}
