package monoJ.parser;

import monoJ.codegen.JavaGenerator;
import monoJ.lexer.Token;
import monoJ.lexer.TokenType;
import java.util.ArrayList;
import java.util.List;


public class Parser {
    public ArrayList<String> parse(ArrayList<Token> tokenList){
//        System.out.println("Parsing tokens: " + tokenList);
        ArrayList<String> statement = new ArrayList<>();
        
//        System.out.println(tokenList.get(0).getType());
        for (int i = 0; i < tokenList.size(); i++) {
                Token currentToken = tokenList.get(i);
                if((currentToken.getType()== TokenType.NUMBER_TYPE) || (currentToken.getType()== TokenType.STRING_TYPE)){
                    if(currentToken.getType()== TokenType.NUMBER_TYPE && i+3<tokenList.size() && tokenList.get(i+1).getType()==TokenType.IDENTIFIER && tokenList.get(i+2).getType()==TokenType.ASSIGN && tokenList.get(i+3).getType()==TokenType.NUMBER_LITERAL){
                        statement.add("number"+":::"+tokenList.get(i+1).getValue()+":::"+tokenList.get(i+2).getValue()+":::"+tokenList.get(i+3).getValue());
                    }
                    else if(currentToken.getType()== TokenType.STRING_TYPE && i+3<tokenList.size() && tokenList.get(i+1).getType()==TokenType.IDENTIFIER && tokenList.get(i+2).getType()==TokenType.ASSIGN && tokenList.get(i+3).getType()==TokenType.STRING_LITERAL){
                        statement.add("String"+":::"+tokenList.get(i+1).getValue()+":::"+tokenList.get(i+2).getValue()+":::"+tokenList.get(i+3).getValue());
                    }
                    else {
                        System.err.println("monoJ Syntax error  " + currentToken);
                        throw new RuntimeException("monoJ Syntax error  " + currentToken);
                    }
                    i=i+3;
                }
                else if(i+1<tokenList.size() && currentToken.getType()==TokenType.DISPLAY){

                        if(tokenList.get(i+1).getType()==TokenType.IDENTIFIER){
                            statement.add("display"+":::"+"Identifier"+":::"+tokenList.get(i+1).getValue());

                        }
                        else if(tokenList.get(i+1).getType()==TokenType.STRING_LITERAL ){
                            statement.add("display"+":::"+"String"+":::"+tokenList.get(i+1).getValue());

                        }
                        else if(tokenList.get(i+1).getType()==TokenType.NUMBER_LITERAL){
                            statement.add("display"+":::"+"Number"+":::"+tokenList.get(i+1).getValue());
                        }
                        else {
                            System.err.println("monoJ Syntax error  " + currentToken);
                            throw new RuntimeException("monoJ Syntax error  " + currentToken);
                        }
                    i=i+1;
                }
                else {
                    System.err.println("monoJ Syntax error  " + currentToken);
                    throw new RuntimeException("monoJ Syntax error  " + currentToken);
                }
        }
        return statement;
    }
}
