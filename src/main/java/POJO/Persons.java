package POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

/**
 * @author Remigiusz Zudzin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persons {

    public Persons(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    private ObjectId id;
    private String name;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
