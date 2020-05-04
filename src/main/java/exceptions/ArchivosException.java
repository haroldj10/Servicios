package exceptions;

public class ArchivosException extends AssertionError {

    public static final String NO_SE_ENCONTRO_EL_ARCHIVO = "No se encontró el archivo";
    public static final String NO_SE_LOGRO_CARGAR_EL_ARCHIVO = "No se logro cargar el archivo";

    public ArchivosException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArchivosException(String message) {
        super(message);
    }
}
