package be.wikiformatter;

//notFound is useless   -> remove
//Previous is useless   -> remove
//else is useless       -> remove
//method NormalBuilder
//method BoldBuilder
//else is useless       -> remove
//if is useless         -> remove
//in i is useless       -> remove

public class WikiFormatter {
    String emptyString = "";

    public String format(String[] arrayOfStrings) {

        for (String strings : arrayOfStrings) {
            if (!strings.contains("*")) {
                ParaghrafBuilder(strings);
            }
            else {
                String[] part = strings.split("\\*");
                BoldBuilder(part);
            }
        }
        return emptyString;
    }

    public String ParaghrafBuilder(String strings){
        emptyString += "<p>";
        emptyString += strings;
        emptyString += "</p>";

        return emptyString;
    }

    public String BoldBuilder(String[] part){
        for (int j = 0; j < part.length; j++) {

            if (j == 0) { emptyString += "<p>"; }
            if (j % 2 == 1) { emptyString += "<b>"; }
            if (j >= 0 && j < part.length) { emptyString += part[j]; }
            if (j % 2 == 1) { emptyString += "</b>"; }
            if (j >= part.length - 1) { emptyString += "</p>"; }
        }
        return emptyString;
    }
}
