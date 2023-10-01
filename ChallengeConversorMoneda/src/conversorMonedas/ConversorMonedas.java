package conversorMonedas;

import Principal.SeleccionOpciones;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConversorMonedas {

    SeleccionOpciones menuOpciones = new SeleccionOpciones();
    functionMonedas monedaCambio = new functionMonedas();
    DecimalFormat formato = new DecimalFormat("#.00"); //para formatear un double con solo 2 decimales

    public void mensaje(String monedaElegida, double valorObtenido, String monedaConvertida, double resultadoFinal) {
        String resultadoConvertido = formato.format(resultadoFinal);
        String mensajeFinal = "La cantidad de " + valorObtenido + " " + monedaElegida + " es igual a " + resultadoConvertido + " " + monedaConvertida;
        JOptionPane.showMessageDialog(null, mensajeFinal);
        menuOpciones.continuar();
    }

    public void monedaToPesos(double moneda, String monedaElegida, double valorObtenido, String validarMoneda) {
        double totalConvertido = valorObtenido * moneda;
        monedaCambio.setMoneda("pesos_mex", totalConvertido);//set para pesosMEX
        monedaCambio.setMoneda(validarMoneda, valorObtenido);//set para la moneda que convierte
        mensaje(monedaElegida, valorObtenido, "Pesos Mexicanos", totalConvertido);

    }

    public void pesosToMoneda(double moneda, String monedaElegida, String validarMoneda) {
        monedaCambio.setMoneda("pesos_mex", monedaCambio.getValorGeneral());//set para pesosCOP
        double pesosMexicanos = monedaCambio.getPesosMexicanos();
        double totalConvertido = pesosMexicanos / moneda;
        monedaCambio.setMoneda(validarMoneda, totalConvertido); //set para la moneda a convertir
        mensaje("Pesos Mexicanos", pesosMexicanos, monedaElegida, totalConvertido);
    }

    public void eleccionMoneda() {
        Object[] options = {"De Pesos Mexicanos a Dolar", "De Pesos Mexicanos a Euro",
                "De Pesos Mexicanos a Libras", "De Pesos Mexicanos a Yen", "De Pesos Mexicanos a Won Coreano",
                "De Dolar a Pesos Mexicanos", "De Euro a Pesos Mexicanos", "De Libras a Pesos Mexicanos",
                "De Yen a Pesos Mexicanos", "De Coreano a Pesos Mexicanos"};

        String selectedOption = (String) JOptionPane.showInputDialog(null, "Elije la moneda a convertir", "Monedas",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selectedOption != null) {//si se selecciona algo entonces funciona
            switch (selectedOption) {
                case "De Pesos Mexicanos a Dolar":
                    pesosToMoneda(monedaCambio.getDolar(), "Dólares", "dolar");
                    break;
                case "De Pesos Mexicanos a Euro":
                    pesosToMoneda(monedaCambio.getEuro(), "Euros", "euro");
                    break;
                case "De Pesos Mexicanos a Libras":
                    pesosToMoneda(monedaCambio.getLibras(), "Libras", "libras");
                    break;
                case "De Pesos Mexicanos a Yen":
                    pesosToMoneda(monedaCambio.getYen(), "Yenes", "yen");
                    break;
                case "De Pesos Mexicanos a Won Coreano":
                    pesosToMoneda(monedaCambio.getWon_coreano(), "Wones", "won_coreano");
                    break;
                case "De Dolar a Pesos Mexicanos":
                    monedaToPesos(monedaCambio.getDolar(), "Dólares", monedaCambio.getValorGeneral(), "dolar");
                    break;
                case "De Euro a Pesos Mexicanos":
                    monedaToPesos(monedaCambio.getEuro(), "Euros", monedaCambio.getValorGeneral(), "euro");
                    break;
                case "De Libras a Pesos Mexicanos":
                    monedaToPesos(monedaCambio.getLibras(), "Libras", monedaCambio.getValorGeneral(), "libras");
                    break;
                case "De Yen a Pesos Mexicanos":
                    monedaToPesos(monedaCambio.getYen(), "Yenes", monedaCambio.getValorGeneral(), "yen");
                    break;
                case "De Coreano a Pesos Mexicanos":
                    monedaToPesos(monedaCambio.getWon_coreano(), "Wones", monedaCambio.getValorGeneral(), "won_coreano");
                    break;
            }
        } else { // Si el usuario cierra el diálogo sin seleccionar nínguna opción
            JOptionPane.showMessageDialog(null, "No seleccionaste nínguna opción");
        }
    }

    public void conversionMoneda() {
        JTextField textField = new JTextField();
        Object[] message = {
                "Digite la cantidad a convertir:", textField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Conversión de moneda", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String valorRecibido = textField.getText();
            if (!valorRecibido.trim().isEmpty()) {
                try {
                    double valorDigitado = Double.parseDouble(valorRecibido);
                    if (valorDigitado > 0) {
                        monedaCambio.setValorGeneral(valorDigitado);
                        eleccionMoneda();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: cantidad ingresada no válida", "Error de entrada",
                                JOptionPane.ERROR_MESSAGE);
                        conversionMoneda();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: valor ingresado no válido", "Error de entrada",
                            JOptionPane.ERROR_MESSAGE);
                    conversionMoneda();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error: No ingresaste ningún valor", "Error de entrada",
                        JOptionPane.ERROR_MESSAGE);
                conversionMoneda();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saliste del programa", "Programa finalizado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
