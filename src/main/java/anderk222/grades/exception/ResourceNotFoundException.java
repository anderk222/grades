package anderk222.grades.exception;



import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/**
 *
 * @author linuxlite
 */

@Getter
@Setter
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(Object id,String fieldName,String resourceName){
        super(String.format("%s no encontrada con %s %s", resourceName,fieldName,id));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.fieldValue = id;
    }

}