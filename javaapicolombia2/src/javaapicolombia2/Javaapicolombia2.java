package javaapicolombia2;

public class Javaapicolombia2 {

    public static void main(String[] args) {
        String dato_url = "https://jsonplaceholder.typicode.com/posts";
        apimodelo obj_api = new apimodelo(dato_url);

        // Ejecución del método GET
        obj_api.hacer_peticion_get();

        // Mostrar la información obtenida
        obj_api.imprimir_info();
        obj_api.info_respuesta();
    }
}