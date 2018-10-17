package main;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class PersonRoute extends RouteBuilder {

    @Override
    public void configure(){
        restConfiguration().component("servlet").bindingMode(RestBindingMode.json);

        rest("/person").get().outType(Person.class)
                .to("direct:talk");
        from("direct:talk")
                .process(exchange -> {
                    Person p = new Person();
                    p.setFirstname("Batman");
                    p.setLastname("Robin");
                    exchange.getIn().setBody(p);
                });


        rest("/person").post().outType(Person.class)
                .to("direct:couple");
        from("direct:couple")
                .process(exchange -> {
                    Person p = new Person();
                    p.setFirstname("Woman");
                    p.setLastname("Wonder");
                    p.setCouple(new Person("Batman", "Robin"));
                    exchange.getIn().setBody(p);
                });
    }
}
