package monoJ;

import monoJ.codegen.JavaGenerator;
import monoJ.lexer.Lexer;
import monoJ.lexer.Token;
import monoJ.parser.Parser;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Lexer le = new Lexer();
        ArrayList<Token> tokenizer = le.makeToken(input);

        Parser pa = new Parser();
        ArrayList<String> parsed =pa.parse(tokenizer);

        JavaGenerator jg = new JavaGenerator();
        String javaCode = jg.monojTJava(parsed);

        try {
            FileWriter writer = new FileWriter("MonoRun.java");
            writer.write(javaCode);
            writer.close();

            ProcessBuilder compile = new ProcessBuilder("javac", "MonoRun.java");
            compile.inheritIO();
            Process compileProcess = compile.start();
            int compileResult = compileProcess.waitFor();

            System.out.println("Compile exit code: " + compileResult);

            if (compileResult != 0) {
                System.out.println("Compilation failed.");
                return;
            }

            ProcessBuilder run = new ProcessBuilder("java", "-cp", ".", "MonoRun");
            run.inheritIO();
            run.start().waitFor();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}