package com.example.demo.mains;

public class JavaHoHtmlMain {



    public static void main(String[] args) throws Exception {

        String s = "title\nNew line one\nnew Line Two";
        StringBuilder stringBuilder = new StringBuilder();
        String arrayOfStrings[] = s.split("\n");
        for (String str : arrayOfStrings){
            stringBuilder.append("<p>"+str+"</p><br>");
        }

        System.out.println(stringBuilder.toString());





       /* Path textPath = Paths.get("D:/H/test1.txt");
        Charset textCharset = Charset.defaultCharset();  // Or StandardCharsets.UTF_8
        Path htmlPath = Paths.get("D:/H/test1.html");
        try (BufferedWriter out = Files.newBufferedWriter(htmlPath))  {

            out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("<head>\n");
            out.write("<meta charsets=\"UTF-8\">\n");
            out.write("</head>\n");
            out.write("<body>\n");
            out.write("<pre>\n");
            Files.lines(textPath, textCharset)
                    .map(line -> ))

            out.write("</pre>\n");
            out.write("</body>\n");
            out.write("</html>\n");
         *//*   out.write("<!DOCTYPE html>\n");
            out.write("<html>\n");
            out.write("<head>\n");
            out.write("<meta charsets=\"UTF-8\">\n");
            out.write("</head>\n");
            out.write("<body>\n");
            out.write("<pre>\n");

            Files.lines(textPath, textCharset)
                    .map(line -> line.replace("&", "&amp;") // & first
                            .replace("<", "&lt;")
                            .replace(">", "&gt;")
                            .replace("\"", "&quot;") + "\n")
                    .forEach(str -> {
                        try {
                            out.write(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            out.write("</pre>\n");
            out.write("</body>\n");
            out.write("</html>\n");
       catch (IOException e) {
            e.printStackTrace();
            }*/
    }
}

