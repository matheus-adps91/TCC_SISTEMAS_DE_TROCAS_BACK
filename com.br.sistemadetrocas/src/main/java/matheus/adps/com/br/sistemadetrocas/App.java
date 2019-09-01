package matheus.adps.com.br.sistemadetrocas;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(App.class).profiles("app").run(args);
    }
}
