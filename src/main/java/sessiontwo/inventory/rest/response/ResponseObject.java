package sessiontwo.inventory.rest.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject<T>{
	

	/**
     * Código de respuesta
     */
    private String code;
    
    /**
     * Mensaje de respuesta
     */
    private String message; 
    
    /**
     * Cuerpo de la respuesta
     */
    private T body;
    
    /**
	 * Cuerpo de respuesta vacío
	 * 
	 * @param code código de la respuesta
	 * @param message mensaje de la respuesta
	 */
	public ResponseObject(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
