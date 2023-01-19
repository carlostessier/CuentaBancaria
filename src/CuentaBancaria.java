public class CuentaBancaria {

    public static final int MAX_NUMERO_TITULARES = 3;
    private int numeroCuenta;
    private Titular [] titulares;
    private int numeroTitulares;
    private double saldo;

    public CuentaBancaria() {
        titulares = new Titular[MAX_NUMERO_TITULARES];
        for (int i = 0; i < titulares.length; i++) {
            titulares[i] = new Titular();
        }
        numeroTitulares = 0;

    }

    public boolean eliminarTitular(Titular titular){
        int indice;
        boolean eliminado = false;
        indice = buscarTitular(titular);
        if(indice<0){
            System.err.println("El titular "+titular.getDocumentoNIF()+" no existe");
        }
        else {
            titulares[indice] = new Titular();
            eliminado = true;
            numeroTitulares--;
            System.out.println("El titular "+titular.getDocumentoNIF()+" se ha borrado correctamente");

        }
        return eliminado;
    }

    public boolean añadirTitular(Titular titular){
        // comprobar si el titular ya existe
        int indice;
        boolean añadido = false;
        if(buscarTitular(titular)>=0){
            System.err.println("El titular "+titular.getDocumentoNIF()+" ya existe");
        }
        else{
            // comprobar si tengo espacio para un titular nuevo

            if (numeroTitulares == MAX_NUMERO_TITULARES){
                System.err.println("No hay espacio para un nuevo titular");
            }
            // guardar el nuevoTitular en ese
            else{
                // busco un titular "vacio"
                indice = buscarTitular(new Titular());
                // asigno el nuevo titular en el "hueco"
                titulares[indice] = titular;
                añadido = true;
                numeroTitulares++;
            }

        }
        return añadido;
    }

    public int buscarTitular(Titular titular) {
        int indice = 0;
        boolean encontrado = false;
        while(!encontrado && indice < titulares.length){
            if (titulares[indice].getDocumentoNIF().equals(titular.getDocumentoNIF())){
                encontrado = true;
            }
            else{
                indice++;
            }
        }
        if(!encontrado){
            indice = -1;
        }
       return indice;
    }



    public CuentaBancaria(int numeroCuenta, Titular[] titulares, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titulares = titulares;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Titular[] getTitulares() {
        return titulares;
    }

    public void setTitulares(Titular[] titulares) {
        this.titulares = titulares;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroTitulares() {
        return numeroTitulares;
    }

    public void setNumeroTitulares(int numeroTitulares) {
        this.numeroTitulares = numeroTitulares;
    }

    public void ingresar(double cantidad){
        saldo += cantidad;
    }

    public double retirar(double cantidad){
        double dineroRetirado = 0.0;

        if(cantidad > saldo){
            System.err.println("No hay suficiente saldo");
            cantidad = 0;
        }
        else{
            dineroRetirado = cantidad;
            saldo -= cantidad;
        }

        return dineroRetirado;
    }
}
