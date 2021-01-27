package pt.ipbeja.pdm.ipbejarecicla;

public class Reciclagens {

    private double totalRec;
    private double energiaPoupada;
    private double co2Absorvido;
    private double petroleoPoupado;

    public Reciclagens(double totalRec, double energiaPoupada, double co2Absorvido, double petroleoPoupado) {
        this.totalRec = totalRec;
        this.energiaPoupada = energiaPoupada;
        this.co2Absorvido = co2Absorvido;
        this.petroleoPoupado = petroleoPoupado;
    }

    public double getTotalRec() {
        return totalRec;
    }

    public void setTotalRec(double totalRec) {
        this.totalRec = totalRec;
    }

    public double getEnergiaPoupada() {
        return energiaPoupada;
    }

    public void setEnergiaPoupada(double energiaPoupada) {
        this.energiaPoupada = energiaPoupada;
    }

    public double getCo2Absorvido() {
        return co2Absorvido;
    }

    public void setCo2Absorvido(double co2Absorvido) {
        this.co2Absorvido = co2Absorvido;
    }

    public double getPetroleoPoupado() {
        return petroleoPoupado;
    }

    public void setPetroleoPoupado(double petroleoPoupado) {
        this.petroleoPoupado = petroleoPoupado;
    }
}
