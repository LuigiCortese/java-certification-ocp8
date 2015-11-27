package net.devsedge.functionalinterfaces.unaryoperator;

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * 
		 * UnaryOperator
		 * 
		 */
		
		System.out.println("'UnaryOperator' takes any type and returns the same type");
		new UnaryOperator<String>(){
			@Override
			public String apply(String t) {
				System.out.println("\tUnaryOperator takes/returns any type");
				return "";
			}
		}.apply("");
		
		new IntUnaryOperator(){
			@Override
			public int applyAsInt(int t) {
				System.out.println("\tIntUnaryOperator takes/returns an int");
				return 1;
			}
		}.applyAsInt(1);

		new LongUnaryOperator(){
			@Override
			public long applyAsLong(long t) {
				System.out.println("\tLongUnaryOperator takes/returns a long");
				return 1;
			}
		}.applyAsLong(1L);
		
		new DoubleUnaryOperator(){
			@Override
			public double applyAsDouble(double t) {
				System.out.println("\tDoubleUnaryOperator takes/returns a double");
				return 1;
			}
		}.applyAsDouble(1);
	}

}
