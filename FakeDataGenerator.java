package dataProviders;

import com.github.javafaker.Faker;

public class FakeDataGenerator {

	
public String GetFakeData(String ControlName)
{
	String value = null;
	Faker faker = new Faker();
	switch (ControlName)
	{ 
	case "CompanyName" :
		value = faker.company().name();
		break;
	case  "FirstName" :
		value = faker.name().firstName();
		break;
	case  "Lastname" :
		value = faker.name().lastName();
		break;
	}
	return value;
	
}
}
