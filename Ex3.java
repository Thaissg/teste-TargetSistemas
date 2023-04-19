import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Ex3 {

    public static double menorvalor(double[] valordiario) {
        double menor = valordiario[0];
        for (int i = 0; i < valordiario.length; i++) {
            if (valordiario[i] > 0 && valordiario[i] < menor) {
                menor = valordiario[i];
            }
        }
        return menor;
    }

    public static double maiorvalor(double[] valordiario) {
        double maior = valordiario[0];
        for (int i = 0; i < valordiario.length; i++) {
            if (valordiario[i] > maior) {
                maior = valordiario[i];
            }
        }
        return maior;
    }

    public static int diasAcimaMedia(double[] valordiario) {
        double soma = 0;
        int dias = 0;
        for (int i = 0; i < valordiario.length; i++) {
            if (valordiario[dias] > 0) {
                soma = soma + valordiario[dias];
                dias++;
            }
        }
        double media = soma / dias;
        dias = 0;
        for (int i = 0; i < valordiario.length; i++) {
            if (valordiario[i] > media) {
                dias++;
            }
        }

        return dias;
    }

    public static void main(String[] args) {
        try {
            JSONArray jsonObject;
            JSONParser parser = new JSONParser();
            jsonObject = (JSONArray) parser.parse(new FileReader("dados.json"));
            double[] valores = new double[jsonObject.size()];
            for (int i = 0; i < jsonObject.size(); i++) {
                JSONObject dia = (JSONObject) jsonObject.get(i);
                if (dia.get("valor").getClass().getName() == "java.lang.Long") {
                    valores[i] = 0;
                } else {
                    valores[i] = (double) dia.get("valor");
                }
            }
            System.out.println("Menor valor diário: " + menorvalor(valores));
            System.out.println("Maior valor diário: " + maiorvalor(valores));
            System.out.println("Número de dias acima da média: " +
                    diasAcimaMedia(valores));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
