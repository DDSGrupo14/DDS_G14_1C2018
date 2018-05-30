package modelos.reglas.actuadores;

import modelos.dispositivos.DispositivoInteligente;

public class Actuador {

    private DispositivoInteligente dispositivoInteligente;

    public Actuador( DispositivoInteligente dispositivoInteligente ){

        this.dispositivoInteligente = dispositivoInteligente;
    }

    public void apagar(){ dispositivoInteligente.apagarDispositivo(); }

    public void encender() { dispositivoInteligente.encenderDispositivo(); }

    public void ahorroEnergia() { dispositivoInteligente.pasarAhorroEnergia(); }

}
