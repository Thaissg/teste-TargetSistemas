import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Ex4 {
    public static double[] representacao(JSONArray UF, JSONArray valor) {
        double[] representacao = new double[UF.size()];
        double soma = 0;
        double temp = 0;
        for (int i = 0; i < UF.size(); i++) {
            soma += (double) valor.get(i);
        }
        for (int i = 0; i < UF.size(); i++) {
            temp = (double) valor.get(i);
            representacao[i] = temp * 100 / soma;
        }
        return representacao;
    }

    public static void main(String[] args) {
        try {
            JSONObject jsonObject;
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(new FileReader("FaturamentoMensal.json"));
            JSONObject UFObj = (JSONObject) jsonObject.get("UF");
            JSONArray UF = (JSONArray) UFObj.get("values");
            JSONObject valorObj = (JSONObject) jsonObject.get("Faturamento");
            JSONArray valor = (JSONArray) valorObj.get("values");
            double[] representacao = representacao(UF, valor);
            for (int i = 0; i < representacao.length; i++) {
                System.out.printf(UF.get(i) + ": %.2f %s %n", representacao[i], "%");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}