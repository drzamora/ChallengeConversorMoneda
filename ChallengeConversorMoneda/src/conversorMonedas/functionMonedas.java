package conversorMonedas;

import javax.swing.JOptionPane;

public class functionMonedas {

    private double pesosMexicanos;
    private double dolar;
    private double euro;
    private double libras;
    private double yen;
    private double won_coreano;
    private double valorGeneral;

    public functionMonedas() {
        this.dolar = 17.42; // 1 dolar es igual a 17.42 pesos
        this.euro = 18.41; //1 euro es igual a  18.41 pesos
        this.libras = 21.25; //1 libra es igual a 21.25 pesos
        this.won_coreano = 0.013; //1 won_coreano es igual a 0.013 pesos
        this.yen = 0.12; //1 yen es igual a 0.12 pesos
    }

    public void setMoneda(String moneda, double valor) {
        if (valor >= 0) {
            switch (moneda) {
                case "pesos_mex":
                    setPesosMexicanos(valor);
                    break;
                case "dolar":
                    setDolar(valor);
                    break;
                case "euro":
                    setEuro(valor);
                    break;
                case "libras":
                    setLibras(valor);
                    break;
                case "yen":
                    setYen(valor);
                    break;
                case "won_coreano":
                    setWon_coreano(valor);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Moneda no válida");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Moneda no válida");
        }
    }

    public void setDolar(double dolar) {
        this.dolar = dolar;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public void setLibras(double libras) {
        this.libras = libras;
    }

    public void setYen(double yen) {
        this.yen = yen;
    }

    public void setWon_coreano(double won_coreano) {
        this.won_coreano = won_coreano;
    }

    public double getValorGeneral() {
        return valorGeneral;
    }

    public void setValorGeneral(double valorGeneral) {
        if (valorGeneral > 0) {
            this.valorGeneral = valorGeneral;
        } else {
            this.valorGeneral = 0;
        }
    }

    public void setPesosMexicanos(double pesosMexicanos) {
        this.pesosMexicanos = pesosMexicanos;
    }

    public double getLibras() {
        return libras;
    }

    public double getYen() {
        return yen;
    }

    public double getWon_coreano() {
        return won_coreano;
    }

    public double getEuro() {
        return euro;
    }

    public double getPesosMexicanos() {
        return pesosMexicanos;
    }

    public double getDolar() {
        return dolar;
    }

}
