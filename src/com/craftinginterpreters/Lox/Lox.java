import com.craftinginterpreters.Lox.Token;
import com.craftinginterpreters.Lox.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Lox {
    static boolean hadError = false;
    public static void main(String[] args) throws IOException {
     if (args.length != 1) {
        System.out.print("Usage: java com.craftinginterpreters.lox.lox <file>");
        System.exit(64);
     } else if(args.length==1){
         runFile(args[0]);
     } else {
         runPrompt();
     }
    }
}

private static void runFile(String path) throws IOException {
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    run(new String(bytes, Charset.defaultCharset()));
}

private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
    for (;;) {
        System.out.print("> ");
        String line = reader.readLine();
        if (line == null) break;
        run(line);
        Lox.hadError = false;
    }
}
private static void run(String source) {
    Scanner scanner = new Scanner(source);
    List<Token> tokens = scanner.scanTokens();
    if(Lox.hadError){
        System.exit(65);
    }
    for (Token token : tokens) {
        System.out.println(token);
    }
}
static void error(int line, String message){
    report(line, "",message);
}
private static void report(int line, String message, String where){
    System.err.println("[line" +  line + "] Error "+ where + ":" + message);
    Lox.hadError=true;
}

public void main() {
}

