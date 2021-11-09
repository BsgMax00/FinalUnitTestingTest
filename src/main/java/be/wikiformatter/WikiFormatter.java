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
                    for (int j = 0; j < part.length; j++) {

                        //Opens <p>
                        if (j == 0) {
                            emptyString += "<p>";
                        }

                        //Opens <b>
                        if (j % 2 == 1)
                            emptyString += "<b>";

                        //puts the words in the empty array
                        if (j >= 0 && j < part.length) {
                            emptyString += part[j];
                        }

                        //Closes <b>
                        if (j % 2 == 1) {
                            emptyString += "</b>";
                        }

                        //Closes <p>
                        if (j >= part.length - 1)
                            emptyString += "</p>";

                    }
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

}
