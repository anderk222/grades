package anderk222.grades.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @Expose
    private String msgUsuario;
    @Expose
    private String msgTecnico;
    @Expose
    private JsonObject body;
    @Expose
    private String code;

    // Constructores

    public Response(ResponseEnum rEnum, Object body) {

        this.body = body == null ?null : (JsonObject) getGson().toJsonTree(body);
        this.msgUsuario = rEnum.msgUsuario;
        this.code = rEnum.codRespuesta;
        this.msgTecnico = rEnum.msgTecnico;
    }

    public Response(Object body) {

        this.body = body == null ?null : (JsonObject) getGson().toJsonTree(body);
    }

    public Response(ResponseEnum rEnum) {

        this.msgUsuario = rEnum.msgUsuario;
        this.code = rEnum.codRespuesta;
        this.msgTecnico = rEnum.msgTecnico;
    }

    // Static methods

    public static Response resEnum(ResponseEnum rEnum) {

        return new Response(rEnum, null);

    }

    public static Response body(Object body) {

        return new Response(ResponseEnum.RESPONSE_OK, body);

    }

    // Methods

    public Response setResEnum(ResponseEnum rEnum) {

        this.msgUsuario = rEnum.msgUsuario;
        this.code = rEnum.codRespuesta;
        this.msgTecnico = rEnum.msgTecnico;

        return this;

    }

    public Response setBody(Object body) {

        this.body = body == null ?null : (JsonObject) getGson().toJsonTree(body);

        return this;

    }

    public Response msgTecnico(String msg) {

        this.msgTecnico = msg;
        return this;

    }

    public Response msgUsuario(String msg) {

        this.msgUsuario = msg;

        return this;
    }

    private static Gson getGson(){
     
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        
    }

}