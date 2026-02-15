package monoJ.codegen;

import java.util.List;

public class JavaGenerator {
    public String monojTJava(List<String> statements){
        StringBuilder javaCode = new StringBuilder();
        javaCode.append("import java.util.Scanner;\n");
        javaCode.append("public class MonoRun {\n");
        javaCode.append("    public static void main(String[] args) {\n");
        javaCode.append("Scanner scanner = new Scanner(System.in);\n");
        for (String statement : statements) {
            String[] parts = statement.split(":::");
            if (parts[0].equals("number")) {
                javaCode.append("        Integer ").append(parts[1]).append(" = ").append(parts[3]).append(";\n");
            }

            else if (parts[0].equals("String")) {
                javaCode.append("        String ")
                        .append(parts[1])
                        .append(" = \"")
                        .append(parts[3])
                        .append("\";\n");
            }

            else if (parts[0].equals("display")) {
                if (parts[1].equals("Identifier")) {
                    javaCode.append("        System.out.println(").append(parts[2]).append(");\n");
                } else if (parts[1].equals("String") || parts[1].equals("Number")) {
                    javaCode.append("        System.out.println(\"").append(parts[2]).append("\");\n");
                }
                else{
                    javaCode.append("        System.out.println(").append(parts[2]).append(");\n");
                }
            }
        }
        javaCode.append("    }\n");
        javaCode.append("}\n");

//        System.out.println("Generated Java code:\n" + javaCode.toString());
        return javaCode.toString();
    }

}
