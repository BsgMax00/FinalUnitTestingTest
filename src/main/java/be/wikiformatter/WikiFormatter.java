package be.wikiformatter;

//notFound is useless   -> remove
//Previous is useless   -> remove
//else is useless       -> remove

public class WikiFormatter {
    String emptyString = "";

    public String format(String[] arrayOfStrings) {

        for (String strings : arrayOfStrings) {
            if (!strings.contains("*")) {
                NormalBuilder(strings);
            }
            else {
                int i = strings.indexOf("*");
                String[] part = strings.split("\\*");

                if (part.length > 0) {
                    BoldBuilder(part);
                }
                else {
                    part[i] = arrayOfStrings[i - 1];
                }
            }
        }
        return emptyString;
    }

    public String NormalBuilder(String strings){
        emptyString += "<p>";
        emptyString += strings;
        emptyString += "</p>";

        return emptyString;
    }

    public String BoldBuilder(String[] part){
        for (int j = 0; j < part.length; j++) {

            if (j == 0) {
                emptyString += "<p>";
            }

            if (j % 2 == 1) {
                emptyString += "<b>";
            }

            if (j >= 0 && j < part.length) {
                emptyString += part[j];
            }

            if (j % 2 == 1) {
                emptyString += "</b>";
            }

            if (j >= part.length - 1) {
                emptyString += "</p>";
            }
        }

        return emptyString;
    }
}
