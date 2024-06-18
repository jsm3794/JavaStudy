package quiz;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class E02_CorrectNumber {

	/*
	 	예외처리 방식을 사용하여 다음을 구현하세요
       
       1. 사용자가 중복없는 4개의 숫자를 한 글자씩 입력해야 한다
       
       2. 사용자가 입력한 숫자가 0 ~ 9 사이의 숫자가 아닌경우 예외가 발생해야 한다
       
       3. 사용자가 입력한 숫자가 이미 입력했던 숫자인 경우 예외가 발생해야 한다

       4. 숫자 4개를 모두 입력하고 나면 입력했던 숫자를 다시한번 하나씩 입력하여 확인해야 한다
       
       5. 사용자가 입력했던 숫자와 이번에 입력한 숫자가 다르다면 예외가 발생해야 한다

	 */
	
	static class NumberMachine {
	      ArrayList<Integer> numbers = new ArrayList<>(4);
	            
	      public int put(int num) 
	            throws ExistNumberException, InvalidNumberException {
	         int size = numbers.size();
	         
	         if (size >= 4) {
	            System.out.println("[System] 이미 꽉 찼습니다.");
	            return size;
	         }
	         
	         if (num > 9 || num < 0) {
	            throw new InvalidNumberException("올바르지 않은 숫자: " + num);
	         }
	         
	         if (numbers.contains(num)) {
	            throw new ExistNumberException("중복된 숫자: " + num); 
	         }      
	         
	         numbers.add(num);         
	         return numbers.size();
	      } 
	   }
	   
	   static class GuessMachine {
	      Scanner sc = new Scanner(System.in);
	      
	      NumberMachine m = new NumberMachine();
	      
	      public GuessMachine() {
	         while (true) {
	            try {
	               int size = m.put((int)(Math.random() * 20));
	               
	               if (size == 4) {
	                  break;
	               }
	            } catch (InvalidNumberException e) {
	               System.out.println(e.getMessage());
	            } catch (ExistNumberException e) {
	               System.out.println(e.getMessage());
	            } 
	         }
	      }
	      
	      int cur;
	      private void guess(int num) throws Exception {
		      if (cur >= 4) {
		    	  System.out.println("이미 모든 정답을 맞춘 상태입니다.");
		    	  return;
		      }
	    	  
	    	  ArrayList<Integer> n = m.numbers;
		         
		         if (num == n.get(cur)) {
		        	 System.out.println("정답입니다!");
		        	 ++cur;
		         } else {
		        	 throw new Exception("오답!");
		         }
	      
	      public void start() {
	         while (true) {
	        	 int num;
		         while (true) {
		        	try {
		        		 System.out.println("> ");
			        	 num = sc.nextInt();
		        	} catch (InputMismatchException e) {
		        		System.out.println("숫자만 입력하세요..");
		        		sc.nextLine();
		        	}
		         }
		         
		         try {
		        	 int size = guess(num);
		        	 
		        	 if (cur == 4) {
		        		 break;
		        	 }
		         } catch (Exception e) {
		        	 e.printStackTrace();
		         }
	         }
	   }
	   
	   static class InvalidNumberException extends Exception {
	      public InvalidNumberException(String message) {
	         super(message);
	      }
	   }
	   
	   static class ExistNumberException extends Exception {
	      public ExistNumberException(String message) {
	         super(message);
	      }
	   }   
	   
	   public static void main(String[] args) {
	      new GuessMachine().start();
	   }
	}

}
