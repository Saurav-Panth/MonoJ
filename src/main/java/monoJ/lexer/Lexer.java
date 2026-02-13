package monoJ.lexer;

import monoJ.parser.Parser;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isDigit;

public class Lexer {
    public void makeToken(String value) {
//        System.out.println("Tokenizing: " + value);
        char[] chars = value.toCharArray();
        List<Token> tokenList = new ArrayList<>();
//        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isWhitespace(c) || c == '(' || c == ')') {
//                System.out.println(true);
                continue;
            }

            if (c == '=') tokenList.add(new Token(TokenType.ASSIGN, "="));

            else if (c == '"') {
                String ans = stringLiteral(value, i);
                tokenList.add(new Token(TokenType.STRING_LITERAL, ans));
                i = i + ans.length() + 1;
//                System.out.println(tokenList+" "+i);
            } else if (Character.isDigit(c)) {
//                System.out.println("number literal found at index " + i);
                String ans = numberLiteral(value, i);
                tokenList.add(new Token(TokenType.NUMBER_LITERAL, ans));
                i = i + ans.length() - 1;
//                System.out.println(tokenList);
            } else if (c == 's' && i + 5 < chars.length && value.substring(i, i + 6).equals("string")) {
                tokenList.add(new Token(TokenType.STRING_TYPE, "string"));
                i = i + 5;
            } else if (c == 'n' && i + 5 < chars.length && value.substring(i, i + 6).equals("number")) {
                tokenList.add(new Token(TokenType.NUMBER_TYPE, "number"));
                i = i + 5;
            } else if (c == 'd' && i + 6 < chars.length && value.substring(i, i + 7).equals("display")) {
                tokenList.add(new Token(TokenType.DISPLAY, "display"));
                i = i + 6;
            } else if (c == 't' && i + 3 < chars.length && value.substring(i, i + 4).equals("take")) {
                tokenList.add(new Token(TokenType.TAKE, "take"));
                i = i + 3;

            } else if (Character.isLetter(c) || c == '_') {
                String ans = identifier(value, i);
                tokenList.add(new Token(TokenType.IDENTIFIER, ans));
                i = i + ans.length() - 1;
                System.out.println();
            } else {
                System.err.println("Unknown token at index " + i);
                return;
            }
        }

        Parser parser = new Parser();
        parser.parse((ArrayList<Token>) tokenList);

//        System.out.println(tokenList);
    }

    static String stringLiteral(String value, int index) {
        StringBuffer sb = new StringBuffer();
        for (int i = index + 1; i <= value.length(); i++) {
            try {
                if (value.charAt(i) == '"')
                    break;
                sb.append(value.charAt(i));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Unclosed string literal in monoJ");
                break;
            }
        }
        return sb.toString();

    }

    static String numberLiteral(String value, int i) {
        StringBuilder sb = new StringBuilder();

        while (i < value.length() && Character.isDigit(value.charAt(i))) {
            sb.append(value.charAt(i));
            i++;
        }

        return sb.toString();
    }

    static String identifier(String value, int i) {
        StringBuilder sb = new StringBuilder();

        while (i < value.length() && (Character.isLetterOrDigit(value.charAt(i)) || value.charAt(i) == '_')) {
            sb.append(value.charAt(i));
            i++;
        }

        return sb.toString();
    }

}