package matheus.adps.com.br.sistemadetrocas;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan( basePackages = "matheus.adps.com.br.sistemadetrocas.filter" )
public class App 
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(App.class).profiles("app").run(args);
    }
}
