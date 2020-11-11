package com.jetbrains;

public class MyOwnException extends Exception
{
    MyOwnException()
    {
        super("Its works not in right way");
    }
    MyOwnException(String message)
    {
        super(message);
    }
}