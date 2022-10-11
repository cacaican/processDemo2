package com.xiaocai.processdemo2.batch.processor;

import com.xiaocai.processdemo2.batch.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/10/11 15:31
 */
public class PersonItemProcessor  implements ItemProcessor<Person, String> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PersonItemProcessor.class);


    @Override
    public String process(Person person) throws Exception {
        String greeting = "Hello " + person.getFirstName() + " "
                + person.getLastName() + "!";

        LOGGER.info("converting '{}' into '{}'", person, greeting);
        return greeting;    }
}
