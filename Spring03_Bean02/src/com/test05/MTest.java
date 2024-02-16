package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		// ApplicationContext : Context 초기화 시점에 모든 빈을 생성한다. (미리 빈을 생성해 빈이 필요할 때 즉시 사용할 수 있게 한다.)
		// 기본적으로 따로 설정이 없다면 getBean 전에 미리 bean이 생성된다.
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");
		
		/* 기존 방식
		 * BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/test05/applicationContext.xml"));
		 * bf.getBean("id명");
		 * 처음 getBean이 호출된 시점에 해당 bean을 생성한다.
		 */
		
		System.out.println("Spring Bean Container 생성 완료");
		
		TV tv = factory.getBean("samsung", SamsungTV.class);
		// 해당 bean에 lazy-init="true"를 설정해, getBean 수행할 때 해당 bean을 생성한다.
		// 기본적으로는 ApplicationContext를 만들어서 xml 문서를 읽어들일 때 bean이 생성된다.
		
		TV tv2 = factory.getBean("samsung", SamsungTV.class);
		
		System.out.println(tv == tv2);
		// true
		// 동일 id의 bean을 이용해 beanfactory에서 객체를 만들기 때문에 tv와 tv2는 동일한 객체이다.
		// 동일한 주소 값을 갖는다.
		// (동일한 객체를 돌려쓰는 방식을 싱글톤 패턴이라고 한다.)
		
		TV tv3 = factory.getBean("lg", LGTV.class);
		TV tv4 = factory.getBean("lg", LGTV.class);
		System.out.println(tv3 == tv4);
		// true
		// 동일 id의 bean을 이용해 beanfactory에서 객체를 만들기 때문에 tv3와 tv4는 동일한 객체이다.
		// 동일한 주소 값을 갖는다.
		// (동일한 객체를 돌려쓰는 방식을 싱글톤 패턴이라고 한다.)
		
	}

}
