package com.springprj.springprj;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringprjApplicationTests {



    @Test
	public void  JsonToJavaPerson(){
        Person person;
		//String json = "{\"name\":\"cody\", \"address\":{ \"rue\":\"17 rue du test\", \"ville\":\"paris\"}}";
		String json = "{\"name\":\"cody\"}";
		ObjectMapper oMapper = new ObjectMapper();
		try {
		    person = oMapper.readValue(json,Person.class);
            Assert.assertEquals("cody" , person.getname());
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

    @Test
    public void  JsonToJavaAddress(){
        String json = "{\"rue\":\"17 rue du test\", \"zipCode\":\"77777\"}";

        ObjectMapper oMapper = new ObjectMapper();
        try {
            Address address = oMapper.readValue(json,Address.class);
            System.out.println("la rue est : " + address.getRue() + "\n" + "le zipCode est : " + address.getZipCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  JsonToJavaPersonWithAddress(){
        String json = "{\"name\":\"cody\", \"address\":{ \"rue\":\"17 rue du test\", \"zipCode\":\"paris\"}}";
        ObjectMapper oMapper = new ObjectMapper();
        //oMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            Person person = oMapper.readValue(json,Person.class);
            System.out.println(person.getname() + "'s address: " + person.getAddress() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person createPerson(){
	    Person person = new Person();
        Address address = new Address();
        person.setname("cody");
	    address.setRue("rue du test javatojson");
	    address.setZipCode("77777");
	    person.setAddress(address);

	    return person;
    }

    @Test
    public void JavaToJson(){

        String json = "{\"name\":\"cody\",\"address\":{\"rue\":\"rue du test javatojson\",\"zipCode\":\"77777\"}}";
        ObjectMapper oMapper = new ObjectMapper();

        Person person = createPerson();
        try {
            String test = oMapper.writeValueAsString(person);
            Assert.assertEquals(json,test);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /*
    @Test
    public void javaToJsonMapper() {

        Map<String, Object> m = new HashMap<>();
        m.put("name", "cody");

        Map<String, Object> adressMap = new HashMap<>();
        m.put("address", adressMap);
        adressMap.put("rue", "rue du test javatojson");
        adressMap.put("zipCode", "77777");

        System.out.println("mapper test : " + m );

        ObjectMapper oMapper = new ObjectMapper();

        Person person = createPerson();

        try {

            String json = oMapper.writeValueAsString(person);
            Assert.assertEquals(m, json);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

}
