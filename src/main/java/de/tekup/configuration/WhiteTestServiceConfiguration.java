package de.tekup.configuration;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import de.tekup.endpoint.WiteTestEligebilityEndPoint;

@EnableWs
@Configuration
public class WhiteTestServiceConfiguration {
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context)
	{
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		 return new ServletRegistrationBean<MessageDispatcherServlet>(servlet,"/ws/*");
	}

	@Bean
	public XsdSchema schema()
	{
		return new SimpleXsdSchema(new ClassPathResource("whiteTest.xsd"));
	}
	
	@Bean(name="whiteTest")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema)
	{
		DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("WhiteTestDetails");
		defaultWsdl11Definition.setLocationUri("/ws");
		
		defaultWsdl11Definition.setTargetNamespace(WiteTestEligebilityEndPoint.nameSpace);
		defaultWsdl11Definition.setSchema(schema);
		return defaultWsdl11Definition;
	}
}

