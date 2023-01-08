package kg.megacom.natv;

import kg.megacom.natv.models.dtos.OrdersDto;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients("kg.megacom.natv.microservices")
public class NatvApplication {
	public static void main(String[] args) {
		SpringApplication.run(NatvApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
