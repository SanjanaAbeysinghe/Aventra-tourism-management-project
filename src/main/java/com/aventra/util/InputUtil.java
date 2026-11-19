package com.aventra.util;
import com.aventra.exception.InvalidInputException;
import java.time.LocalDate; import java.time.format.DateTimeParseException; import java.util.Scanner;
public final class InputUtil {
 private final Scanner scanner; public InputUtil(Scanner scanner){this.scanner=scanner;}
 public String readText(String prompt){System.out.print(prompt);return scanner.nextLine().trim();}
 public int readInt(String prompt)throws InvalidInputException{try{return Integer.parseInt(readText(prompt));}catch(NumberFormatException e){throw new InvalidInputException("Please enter a whole number.");}}
 public LocalDate readDate(String prompt)throws InvalidInputException{try{return LocalDate.parse(readText(prompt+" (YYYY-MM-DD): "));}catch(DateTimeParseException e){throw new InvalidInputException("Invalid date. Use YYYY-MM-DD.");}}
}
