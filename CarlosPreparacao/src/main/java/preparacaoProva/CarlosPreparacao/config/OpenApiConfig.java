package preparacaoProva.CarlosPreparacao.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciamento de filmes")
                        .version("1.0")
                        .description("API RESTful devenvolvida para controle, cadastro e manutenção do catálogo de filmes")
                        .contact(new Contact()
                                .name("Suporte Técnico")
                                .email("aaaa@gmail.com")
                        )
                );
    }
}
