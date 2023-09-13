import exceptions.*;

public class CarroAluguel {
    private float valorPorkm;
    private int distanciaPercorrida;
    private boolean disponivel;
    private boolean sinistro;
    private float debito;

    public CarroAluguel (float valorPorKm) {
        this.valorPorkm = valorPorKm;
        this.distanciaPercorrida = 0;
        this.disponivel = true;
        this.sinistro = false;
        this.debito = 0;
    }

    public void setValorPorKm (float valorPorKm) {
        this.valorPorkm = valorPorKm;
    }

    public float getValorPorKm() {
        return this.valorPorkm;
    }

    public void setDistanciaPercorrida (int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    } 

    public float getDistanciaPercorrida() {
        return this.distanciaPercorrida;
    }

    public void alugar() throws CarroIndisponivelException {
        if(!disponivel) {
            throw new CarroIndisponivelException("O carro está indisponível.");
        }
        disponivel = false;
    }

    public void devolver() throws CarroDisponivelException, CarroNaoPagoException {
        if(disponivel) {
            throw new CarroDisponivelException("O carro está disponível.");
        }
        if(getDebito() > 0) {
            throw new CarroNaoPagoException("O carro não foi pago.");
        }
        sinistro = false;
        distanciaPercorrida = 0;
        disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public boolean hasSinistro() {
        return sinistro;
    }

    public void setSinistro(boolean sinistro) {
        this.sinistro = sinistro;
    }

    public float getDebito() {
        debito = valorPorkm * distanciaPercorrida;
        if(hasSinistro()){
            debito += debito * 0.6;
        }
        return debito;
    }

    public void pagar() throws CarroDisponivelException {
        if(isDisponivel()){
            throw new CarroDisponivelException("O carro está disponível.");
        }
        sinistro = false;
        distanciaPercorrida = 0;
    }
}