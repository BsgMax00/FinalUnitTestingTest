package be.wikiformatter;

//notFound is useless -> remove

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
                //is previous useless?
                if (part.length > 0) {
                    for (int j = 0; j < part.length; j++) {

                        //is previous statement useless here because its always i-1
                        if (j == 0) {
                            emptyString += "<p>";
                        }


                        if (j % 2 == 1)
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
                }
                else {
                    part[i] = arrayOfStrings[i - 1];
                }
            }
        }
        return emptyString;
    }

}
