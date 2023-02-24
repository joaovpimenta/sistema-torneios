package br.com.joaovpiment.torneios.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig{

	//	@Bean
	//	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
	//		return new BasicAuthRequestInterceptor("user", "password");
	//	}
	//
	//	public ObjectMapper customObjectMapper(){
	//		ObjectMapper objectMapper = new ObjectMapper();
	//		//Customize as much as you want
	//		return objectMapper;
	//	}
	//
	//	@SuppressWarnings("deprecation")
	//	@Bean
	//	public Decoder feignDecoder() {
	//		HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
	//		ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
	//		return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
	//	}
}