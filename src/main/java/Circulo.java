public class Circulo {
    private float raio;
    private static final float PI = 3.14159f;

    public Circulo(float raio) {
        this.raio = raio;
    }

    public float getRaio() {
        return this.raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    public float getArea() {
        return PI * raio * raio;
    }

    public float getCircunferencia() {
        return 2 * PI * raio;
    }

}
