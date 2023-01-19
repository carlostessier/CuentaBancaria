public class Titular {
        private String nombre;
        private String apellidos;
        private String documentoNIF;
        private String telefono;

    public Titular() {
        this.nombre = "";
        this.apellidos = "";
        this.documentoNIF = "";
        this.telefono = "";
    }

    public Titular(String nombre, String apellidos, String documentoNIF, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documentoNIF = documentoNIF;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumentoNIF() {
        return documentoNIF;
    }

    public void setDocumentoNIF(String documentoNIF) {
        this.documentoNIF = documentoNIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
