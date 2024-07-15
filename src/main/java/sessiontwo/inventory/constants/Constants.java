package sessiontwo.inventory.constants;

public class Constants {

    public static final String  FAIL_CODE = "001";
    public static final String  EXCEPTION_CODE = "002";
    public static final String  FAIL_MESSAGE = "NOOK";

    public static final String ADD_PRODUCT = "Producto agregado exitosamente.";
    public static final String DELETE_PRODUCT = "Producto eliminando exitosamente.";
    public static final String DELETE_NOT_PRODUCT = "No se pudo eliminar cantidad debe ser Cero.";
    public static final String QUANTITY_NOT_RESERVE = "Cantidad insuficiente para reservar";
    public static final String UPDATE_PRODUCT = "Los datos del producto han sido actualizados.";
    public static final String GENERATE_REPORT = "Generando reporte consultalo en unos instantes.";
    public static final String RESERVE = "Reserva realizada.";
    public static final String RELEASE_RESERVE = "Reserva liberada.";
    public static final String PRODUCT_NOT_FOUND = "NO se econtro producto ";
    public static final Long QUANTITY_TO_DELETE = 0L;
    public static final Long MIN_QUANTITY = 2L;
    public static final Long QUANTITY_TO_RESUPPLY = 10L;

    private Constants() {
    }
}
