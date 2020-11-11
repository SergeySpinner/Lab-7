package com.jetbrains;

public class MyOwnRudeException extends Exception
{
    MyOwnRudeException()
    {
        super("You are doing a terrible things");
    }
    MyOwnRudeException(String message)
    {
        super(message);
    }
}