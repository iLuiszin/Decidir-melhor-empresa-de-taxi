class Challenge {

    public static double calcularPreco(double fixa, double var, double distancia) {
        return fixa + (var * distancia);
    }

    public static String escolheTaxi(String tf1, String vqr1, String tf2, String vqr2) {

        // Resolvendo o sistema linear por eliminação gaussiana
        double fixa1 = Double.parseDouble(tf1);
        double fixa2 = Double.parseDouble(tf2);
        double var1 = Double.parseDouble(vqr1);
        double var2 = Double.parseDouble(vqr2);

        if ((fixa1 == fixa2) && (var1 == var2)) {
            return "Tanto faz";
        }

        double i = var2 / -var1;
        double j = i + 1;
        double k = (fixa1 * i) + fixa2;
        double y = k / j;
        double x = (fixa1 - y) / -var1;

        double teste1 = calcularPreco(fixa1, var1, 5);
        double teste2 = calcularPreco(fixa2, var2, 5);

        if (x <= 0) {
            if (teste1 <= teste2)
                return "Empresa 1";
            else
                return "Empresa 2";
        }

        String empresa1;
        String empresa2;

        if (teste1 <= teste2) {
            empresa1 = "Empresa 1";
            empresa2 = "Empresa 2";
        } else {
            empresa1 = "Empresa 2";
            empresa2 = "Empresa 1";
        }

        String xFormatado;
        if (x - ((int) x) == 0)
            xFormatado = String.format("%.1f", x);
        else
            xFormatado = String.format("%.2f", x);

        return empresa1 + " quando a distância < "
                + xFormatado
                + ", Tanto faz quando a distância = "
                + xFormatado
                + ", "
                + empresa2
                + " quando a distância > "
                + xFormatado;
    }

}
