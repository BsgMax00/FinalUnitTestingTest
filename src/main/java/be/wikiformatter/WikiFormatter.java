package be.wikiformatter;

public class WikiFormatter {
    public String format(String[] arrayOfStrings) {
        String emptyString = "";
        for (String strings : arrayOfStrings) {
            //is notfound usefull?

            if (!strings.contains("*")) {
                emptyString += "<p>";
                emptyString += strings;
                emptyString += "</p>";
            }
            else {
                int i = strings.indexOf("*");
                String[] part = strings.split("\\*");
                int previous = i - 1;
                if (part.length > 0) {
                    for (int j = 0; j < part.length; j++) {


                        if (previous > i || j == 0) {
                            emptyString += "<p>";
                        }


                        if (i != previous && j % 2 == 1)
                            emptyString += "<b>";


                        if (j >= 0 && j < part.length) {
                            emptyString += part[j];


                        }
                        else {
                            j = part.length;
                            emptyString = part[j-1];
                        }


                        if (j % 2 == 1) {
                            emptyString += "</b>";
                        }


                        if (j >= part.length - 1)
                            emptyString += "</p>";

                    }
                } else {
                    part[i] = arrayOfStrings[previous];
                }
            }
        }
        return emptyString;
    }

}
