package com.bvn.slack;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BvnSlackServiceApplication {

	private static final Log log = LogFactory.getLog(BvnSlackServiceApplication.class);

	@Value("${service.title: Service Title}")
	private String __TITLE;
	@Value("${service.description: Service Description}")
	private String __DESCRIPTION;
	@Value("${service.version: HD Meeting}")
	private String __VERSION;

	@Value("${api.documentation.TermsAndConditionURL: http://api.tandc.broadviewnet.com}")
	private String __T_AND_C_URL;
	@Value("${api.documentation.contact: api-support@broadviewnet.com}")
	private String __CONTACT;
	@Value("${api.documentation.license: Broadview Networks License}")
	private String __LICENSE;

	@Value("${api.documentation.license_url: http://api.license.broadviewnet.com}")
	private String __LICENSE_URL;

	public static ConfigurableApplicationContext APP_CONTEXT;

	@Bean
	public Docket swaggerAPI()
	{
		return new Docket(DocumentationType.SWAGGER_2).groupName("SlackGatewayService").apiInfo(apiInfo()).select().paths(paths()).build();
	}

	/**********************
	 * Define the rest controller paths endpoints to display in swagger ui
	 * 
	 * @return
	 */
	private Predicate<String> paths()
	{
		return or(regex("/SlackGatewayService.*"), regex("/YetAnotherService.*"));
	}

	/******************************
	 * 
	 * @return
	 */
	private ApiInfo apiInfo()
	{

		springfox.documentation.service.Contact c = new springfox.documentation.service.Contact("Broadview Networks Inc.", __LICENSE_URL,
			"api-support@broadviewnet.com");
		return new ApiInfoBuilder().title(__TITLE).description(__DESCRIPTION).termsOfServiceUrl(__T_AND_C_URL).contact(c).license(__LICENSE)
			.licenseUrl(__LICENSE_URL).version(__VERSION).build();
	}

	public static void main(String[] args)
	{
		SpringApplication.run(BvnSlackServiceApplication.class, args);

		log.info(EnvConfig.getEnv().getProperty("spring.application.name", "DUNNO") + " STARTED");
	}
}
