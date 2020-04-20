package employees.adapter;

import employees.model.Employee;
import employees.utils.Replacer;
import com.google.gson.*;


import java.lang.reflect.Type;
import java.math.BigDecimal;

public class EmployeeJsonAdapter implements JsonDeserializer<Employee> {
    @Override
    public Employee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject object = jsonElement.getAsJsonObject();

        final Long id = object.get("id").getAsLong();
        final String name = object.get("name").getAsString();
        final String surname = object.get("surname").getAsString();
        final String job = object.get("job").getAsString();

        String salaryString = object.get("salary").getAsString();
        String replacedSalaryString = Replacer.replaceUnwantedSigns(salaryString);

        final BigDecimal salary = new BigDecimal(replacedSalaryString);

        return new Employee(id, name, surname, job, salary);
    }
}
