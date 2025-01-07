package com.craftinginterpreters.Lox;

public enum TokenType {
    //
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
    COMMA, COLON, DOT, STAR, PLUS, MINUS, SLASH, SEMICOLON,


    //2CHARS
    BANG, BANG_EQUAL,
    EQUAL, EQUAL_EQUAL,
    GREATER, GREATER_EQUAL,
    LESS, LESS_EQUAL,

    //literals
    IDENTIFIER,STRING, NUMBER,

    //keywords
    AND, CLASS, IF, ELSE, TRUE, FALSE, NIL, OR, PRINT,
    RETURN, SUPER, THIS, FOR, VAR, WHILE, FUN,

    EOF
}