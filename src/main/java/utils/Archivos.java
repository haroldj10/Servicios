package utils;

import exceptions.ArchivosException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivos {

    public static String cargarArchivo(String ruta) {
        String archivo = null;
        String linea;
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            while((linea = bf.readLine()) != null) {
                sb.append(linea);
            }
            archivo = sb.toString();
            bf.close();
            fr.close();
        } catch (FileNotFoundException e) {
            throw new ArchivosException(ArchivosException.NO_SE_ENCONTRO_EL_ARCHIVO);
        } catch (IOException e) {
            throw new ArchivosException(ArchivosException.NO_SE_LOGRO_CARGAR_EL_ARCHIVO);
        }
        return archivo;
    }
}
