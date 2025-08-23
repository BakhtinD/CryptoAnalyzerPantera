package com.javarush.bakhtin.command;

public class DecoderCommand implements MenuCommand {
    public void execute(int key){
        EncoderCommand encoderCommand = new EncoderCommand();
        encoderCommand.execute(key*-1);
    }
}
