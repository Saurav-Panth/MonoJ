package monoJ;

import monoJ.lexer.Lexer;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
//        System.out.print("MonoJ");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Lexer le = new Lexer();
        le.makeToken(input);
//        System.out.println(le.makeToken(input));


    }
}