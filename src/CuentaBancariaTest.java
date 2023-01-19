import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaBancariaTest {

    @org.junit.jupiter.api.Test
    void eliminarTitular() {
        Titular [] titulares = new Titular[3];
        Titular juan= new Titular ("Juan", "Perez", "12345678A", "123456789");
        titulares[0] = juan;
        titulares[1] = new Titular();
        titulares[2] = new Titular();

        CuentaBancaria cuenta= new CuentaBancaria(123456789, titulares, 0);
        assertEquals("12345678A", cuenta.getTitulares()[0].getDocumentoNIF());
        assertTrue(cuenta.eliminarTitular(juan));
        assertEquals("", cuenta.getTitulares()[0].getDocumentoNIF());
    }

    @org.junit.jupiter.api.Test
    void añadirTitular() {
        CuentaBancaria cuenta= new CuentaBancaria();
        Titular maria = new Titular ("Maria", "Garcia", "987654321A", "123456789");
        Titular juan = new Titular ("Juan", "Perez", "12345678A", "0000000000");
        Titular lucas = new Titular ("Lucas", "Turul", "12345678B", "0987654322");
        Titular pepe = new Titular ("Pepe", "Perez", "12345678C", "0987654322");

        cuenta.setSaldo(1000);
        cuenta.setNumeroCuenta(123456789);

        assertEquals(true, cuenta.añadirTitular(maria));
        assertEquals(false, cuenta.añadirTitular(maria));
        assertEquals(true, cuenta.añadirTitular(lucas));
        assertEquals(true, cuenta.añadirTitular(juan));
        assertEquals(false, cuenta.añadirTitular(pepe));

    }

    @Test
    void buscarTitular() {
        Titular [] titulares = new Titular[3];

        Titular maria = new Titular ("Maria", "Garcia", "987654321A", "123456789");
        Titular juan = new Titular ("Juan", "Perez", "12345678A", "0000000000");
        Titular lucas = new Titular ("Lucas", "Turul", "12345678B", "0987654322");
        Titular pepe = new Titular ("Pepe", "Perez", "12345678C", "0987654322");

        titulares[0] = maria;
        titulares[1] = juan;
        titulares[2] = lucas;

        CuentaBancaria cuenta= new CuentaBancaria(123456789, titulares, 0);
        assertEquals(0, cuenta.buscarTitular(maria));
        assertEquals(1, cuenta.buscarTitular(juan));
        assertEquals(2, cuenta.buscarTitular(lucas));
        assertEquals(-1, cuenta.buscarTitular(pepe));

    }


    @Test
    void getNumeroTitulares() {
        CuentaBancaria cuenta= new CuentaBancaria();
        Titular maria = new Titular ("Maria", "Garcia", "987654321A", "123456789");
        Titular juan = new Titular ("Juan", "Perez", "12345678A", "0000000000");
        Titular lucas = new Titular ("Lucas", "Turul", "12345678B", "0987654322");
        Titular pepe = new Titular ("Pepe", "Perez", "12345678C", "0987654322");

        cuenta.setSaldo(1000);
        cuenta.setNumeroCuenta(123456789);

        assertEquals(0, cuenta.getNumeroTitulares());
        assertEquals(true, cuenta.añadirTitular(maria));
        assertEquals(1, cuenta.getNumeroTitulares());
        assertEquals(false, cuenta.añadirTitular(maria));
        assertEquals(1, cuenta.getNumeroTitulares());
        assertEquals(true, cuenta.añadirTitular(lucas));
        assertEquals(2, cuenta.getNumeroTitulares());
        assertEquals(true, cuenta.añadirTitular(juan));
        assertEquals(3, cuenta.getNumeroTitulares());
        assertEquals(false, cuenta.añadirTitular(pepe));
        assertEquals(3, cuenta.getNumeroTitulares());

    }

    @Test
    void ingresar() {
    }

    @Test
    void retirar() {
    }
}