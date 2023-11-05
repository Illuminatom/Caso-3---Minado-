public class Monitor {
    private Boolean encontrado;

    public Monitor() {
        encontrado = false;
    }

    public synchronized void setEncontrado(Boolean encontradoP) {
        encontrado = encontradoP;
    }

    public synchronized Boolean getEncontrado() {
        return encontrado;
    }
}
