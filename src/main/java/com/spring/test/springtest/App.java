package com.spring.test.springtest;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class App {
	
//	@Autowired
//	public static  JdbcTemplate jdbcTemplate;  
//	public static Student student;

	public static void main(String[] args) {
		System.out.println("Hello World!");
//		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");  
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        BeanFactory factory=new XmlBeanFactory(context);  
		System.out.println("beans created for \n"+Arrays.asList(context.getBeanDefinitionNames()));

		Student student = (Student) context.getBean("student");
//		Address address = (Address) context.getBean("getAddr");
//        student.displayInfo();
		System.out.println("student is " + student.getJdbcTemplate());
		JdbcTemplate jdbcTemplate = student.getJdbcTemplate();
		List<String> list = jdbcTemplate.queryForList("select id from test",String.class);
		System.out.println(list);
//		System.out.println("address is " + address.getCity());
	}
}
