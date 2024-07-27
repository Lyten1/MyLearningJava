package Codewars;


import javax.management.RuntimeMBeanException;
import java.util.Arrays;
import java.util.List;



public class Translator {
    public static String orderingBeers(int nbOfBeers) {


        if(nbOfBeers > 0 && nbOfBeers < 100) {
            List<String> zeroNine = Arrays.asList("zero", "jeden", "dwa", "trzy", "cztery", "piec", "szesc", "siedem", "osiem", "dziewiec");
            List<String> tenNineteen = Arrays.asList("dziesiec", "jedenascie", "dwanascie", "trzynascie", "czternascie", "pietnascie", "szesnascie", "siedemnascie", "osiemnascie", "dziewietnascie");
            List<String> dekas = Arrays.asList("dziesiec", "dwadziescia", "trzydziesci", "czterdziesci", "piecdziesiat", "szescdziesiat", "siedemdziesiat", "osiemdziesiat", "dziewiecdziesiat");

            String jedno = "jedno";

            int dek = nbOfBeers / 10;
            int jed = nbOfBeers % 10;

            if(jed == 0){
                return capitalise(dekas.get(dek-1))+ " piw poprosze";
            }
            else if(jed == 1){
                if(dek == 0)
                    return capitalise(jedno) + " piwo poprosze";
                else{
                    if(dek == 1)
                        return capitalise(tenNineteen.get(jed)) + " piw poprosze";
                    else
                        return capitalise(dekas.get(dek - 1)) + " " + jedno + " piwo poprosze";
                }

            }
            if(jed == 2 || jed == 3 || jed == 4){
                if(dek == 1)
                    return capitalise(tenNineteen.get(jed)) + " piw poprosze";
                else if(dek == 0)
                    return capitalise(zeroNine.get(jed)) + " piwa poprosze";
                else
                    return capitalise(dekas.get(dek - 1)) + " " + zeroNine.get(jed) + " piwa poprosze";
            }
            else{
                if(dek == 1)
                    return capitalise(tenNineteen.get(jed)) + " piw poprosze";
                else if(dek == 0)
                    return capitalise(zeroNine.get(jed)) + " piw poprosze";
                else
                    if(jed == 1)
                        return capitalise(dekas.get(dek - 1)) + " " + jedno + " piwo poprosze";
                    else
                        return capitalise(dekas.get(dek - 1)) + " " + zeroNine.get(jed) + " piw poprosze";
            }
        }
        else if(nbOfBeers == 0){
            return "Woda mineralna poprosze";
        }
        else {
            throw new RuntimeException("More piwa");
        }


    }

    public static String capitalise(String text){
        return text.substring(0,1).toUpperCase() + text.substring(1);
    }


}
