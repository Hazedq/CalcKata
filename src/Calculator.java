import java.util.Scanner;

class Calculator {
    static String[] array = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static void proverkaTipovChisel(String chislo1, String chislo2) throws CalculatorException {
        for (String cifra : array) {
            if (chislo1.equals(cifra)) {
                for (RimskieChisla i : RimskieChisla.values()) {
                    String b = String.valueOf(i);
                    if (b.equals(chislo2)) {
                        throw new CalculatorException();
                    }
                }
            } else if (cifra.equals(chislo2)) {
                if (chislo2.equals(cifra)) {
                    for (RimskieChisla i : RimskieChisla.values()) {
                        String b = String.valueOf(i);
                        if (b.equals(chislo1)) {
                            throw new CalculatorException();
                        }
                    }
                }
            }
        }
    }
    static void proverkaDlinni (String [] array) throws CalculatorException {
        if (3 < array.length) {
            throw new CalculatorException();
        } else if (2 > array.length) {
            throw new CalculatorException();
        }
    }
    static int preobrazovaieInteger (String chislo) {
        int result = 0;
        for (String cifra : array) {
            if (chislo.equals(cifra)) {
                result = Integer.parseInt(chislo);

                break;
            } else {
                for (RimskieChisla i : RimskieChisla.values()) {
                    String b = String.valueOf(i);
                    if (b.equals(chislo)) {
                        i.getRChislo();
                        result = i.getRChislo();
                        break;
                    }
                }
            }
        }
        return result;
    }
    static void proverkaMinMaxChislo (int chislo1, int chuslo2) throws CalculatorException {
        if (chislo1 > 10 || chislo1 < 1) {
            throw new CalculatorException();
        }
        if (chuslo2 > 10 || chuslo2 < 1) {
            throw new CalculatorException();
        }
    }
    static int proverkaOperanda (int chislo1, String operand, int chislo2) throws CalculatorException {
        int result = 0;
        switch (operand) {
            case "+":
                result = chislo1 + chislo2;
                break;
            case "-":
                result = chislo1 - chislo2;
                break;
            case "*":
                result = chislo1 * chislo2;
                break;
            case "/":
                result = chislo1 / chislo2;
                break;
            default:
                throw new CalculatorException();
        }
        return result;
    }
    static String preobrazovaieResultKTipyChisel (String chislo1, String chislo2, String otvet) throws CalculatorException {
        String result = otvet;
        for (RimskieChisla i : RimskieChisla.values()) {
            String b = String.valueOf(i);
            if (b.equals(chislo1)) {
                for (RimskieChisla o : RimskieChisla.values()) {
                    String p = String.valueOf(o);
                    if (p.equals(chislo2)) {
                        result = RimskieChisla.getRim(otvet);
                        return result;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws CalculatorException {
        System.out.println("Введите пример:");
        Scanner scan = new Scanner(System.in);
        String primer = scan.nextLine();
        String[] array = primer.split(" ");
        proverkaDlinni(array);
        String chislo1 = array[0];
        String chislo2 = array[2];
        String operand = array[1];
        proverkaTipovChisel(chislo1, chislo2);
        int number1 = preobrazovaieInteger(chislo1);
        int number2 = preobrazovaieInteger(chislo2);
        proverkaMinMaxChislo(number1, number2);
        String result1 = Integer.toString(proverkaOperanda(number1, operand, number2));
        String r2 = preobrazovaieResultKTipyChisel(chislo1, chislo2, result1);
        System.out.println("Ответ: " + r2);
    }
}

