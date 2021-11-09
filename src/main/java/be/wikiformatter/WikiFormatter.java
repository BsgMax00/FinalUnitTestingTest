package be.wikiformatter;

//notFound is useless -> remove
//Previous is useless -> remove

public class WikiFormatter {
    public String format(String[] arrayOfStrings) {
        String emptyString = "";
        for (String strings : arrayOfStrings) {
            if (!strings.contains("*")) {
                emptyString += "<p>";
                emptyString += strings;
                emptyString += "</p>";
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

}
