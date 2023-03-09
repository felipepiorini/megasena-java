package megasena;

import java.util.Random;

public class MegaSena {

    private int numbers[];
    private int numbers2[];
    private int contN;
    private int contador;

    public MegaSena(int qtde) {
        numbers = new int[qtde];
        numbers2 = new int[qtde];
        contN = 0;
    }

    public MegaSena() {
        numbers = new int[10];
        numbers2 = new int[6];
        contN = 0;
    }

    public MegaSena(int[] numbers, int[] numbers2) {
        this.numbers = numbers;
        this.numbers2 = numbers2;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int[] getNumbers2() {
        return numbers2;
    }

    public int getContN() {
        return contN;
    }

    public int getContador() {
        return contador;
    }

    public int add(int num) {

        if (contN < numbers.length) {
            if (!search(num)) {
                numbers[contN++] = num;
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    //------------------------------------------------------------- 
    //Gera Sorteio de 60 numeros da mega sena
    public void geraNumeros() {
        Random random = new Random();
        for (contador = 0; contador < numbers2.length; contador++) {
            int numS = random.nextInt(60) + 1;
            if (!searchSorteio(numS)) {
                numbers2[contador] = numS;
                //return 1;
            }
        }
    }

    public String toStringSorteio() {
        String dados = "";

        for (int i = 0; i < contador; i++) {
            if (numbers2[i] < 1) {
                return "";
            }
            dados += numbers2[i];
            if (i != contador - 1) {
                dados += " - ";
            }
        }
        return dados;
    }

    public String toString() {
        String dados = "";

        for (int i = 0; i < contN; i++) {
            if (numbers[i] < 1) {
                return "";
            }
            dados += numbers[i];
            if (i != contN - 1) {
                dados += " - ";
            }
        }
        return dados;
    }

    public String toStringValorAposta() {
        String dados = "";

        if (contN == 6) {
            dados = "R$ 4,50";
        } else if (contN == 7) {
            dados = "R$ 31,50";
        } else if (contN == 8) {
            dados = "R$ 126,00";
        } else if (contN == 9) {
            dados = "R$ 378,00";
        } else if (contN == 10) {
            dados = "R$ 945,00";
        }
        return dados;
    }

    public int qtdeElementosIguais() {
        int tot = 0;
        for (int i = 0; i < contador; i++) {
            for (int j = 0; j < contN; j++) {
                if (numbers2[i] == numbers[j]) {
                    tot += 1;
                }
            }
        }
        return tot;
    }

    public boolean search(int value) {
        for (int i = 0; i < contN; i++) {
            if (numbers[i] == value) {
                return true;
            }
        }
        return false;
    }

    public boolean searchSorteio(int value) {
        for (int i = 0; i < contador; i++) {
            if (numbers2[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        contN = 0;
        contador = 0;
    }

    public void clearCont() {
        contador = 0;
    }
}
