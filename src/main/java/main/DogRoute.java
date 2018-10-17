package main;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class DogRoute extends RouteBuilder {
    @Override
    public void configure(){
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/dog").post().outType(Dog.class)
                .to("direct:present");
        from("direct:present")
                .process(exchange -> {
                    Dog d = new Dog();
                    d.setNombre("Firulais");
                    d.setDueño(new Person("Angel", "Posada"));
                    exchange.getIn().setBody(d);
                });
    }
}
