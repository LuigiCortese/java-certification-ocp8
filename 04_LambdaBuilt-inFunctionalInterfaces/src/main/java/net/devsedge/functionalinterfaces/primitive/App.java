package net.devsedge.functionalinterfaces.primitive;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {

	public static void main(String[] args) {
		
		/*
		 * 
		 * Predicate
		 * 
		 */
		
		System.out.println("'Predicate' takes one parameter and returns a boolean");
		new Predicate<String>(){
			@Override
			public boolean test(String t) {
				System.out.println("\tPredicate takes any type");
				return true;
			}
		}.test("");
		
		new IntPredicate(){
			@Override
			public boolean test(int value) {
				System.out.println("\tIntPredicate takes an int");
				return true;
			}
			
		}.test(1);
		
		new LongPredicate(){
			@Override
			public boolean test(long value) {
				System.out.println("\tLongPredicate takes a long");
				return true;
			}
		}.test(1L);
		
		new DoublePredicate(){
			@Override
			public boolean test(double value) {
				System.out.println("\tDoublePredicate takes a double");
				return true;
			}
		}.test(1D);
		
		/*
		 * 
		 * Consumer
		 * 
		 */
		
		System.out.println("\n'Consumer' takes one parameter and returns void");
		
		new Consumer<String>(){
			@Override
			public void accept(String t) {
				System.out.println("\tConsumer takes any type");
			}
		}.accept("");
		
		new IntConsumer(){
			@Override
			public void accept(int t) {
				System.out.println("\tIntConsumer takes an int");
			}
		}.accept(1);
		
		new LongConsumer(){
			@Override
			public void accept(long t) {
				System.out.println("\tLongConsumer takes a long");
			}
		}.accept(1L);
		
		new DoubleConsumer(){
			@Override
			public void accept(double t) {
				System.out.println("\tDoubleConsumer takes a double");
			}
		}.accept(1D);

		/*
		 * 
		 * Supplier
		 * 
		 */
		
		System.out.println("\n'Supplier' takes no parameters and returns any type");
		
		new Supplier<String>(){
			@Override
			public String get() {
				System.out.println("\tSupplier return any type");
				return "";
			}
		}.get();
		
		new BooleanSupplier(){
			@Override
			public boolean getAsBoolean() {
				System.out.println("\tBooleanSupplier return a boolean");
				return true;
			}
		}.getAsBoolean();
		
		new IntSupplier(){
			@Override
			public int getAsInt() {
				System.out.println("\tIntSupplier return a int");
				return 1;
			}
		}.getAsInt();
		
		new LongSupplier(){
			@Override
			public long getAsLong() {
				System.out.println("\tLongSupplier return a long");
				return 1L;
			}
		}.getAsLong();
		
		new DoubleSupplier(){
			@Override
			public double getAsDouble() {
				System.out.println("\tDoubleSupplier return a double");
				return 1D;
			}
		}.getAsDouble();
		
//
//		Function<T,R>
//		IntFunction<R>
//		ToIntFunction<T>
//		IntToLongFunction
//		IntToDoubleFunction
//
//		LongFunction<R>
//		ToLongFunction<T>
//		LongToIntFunction
//		LongToDoubleFunction
//
//		DoubleFunction<R>
//		ToDoubleFunction<T>
//		DoubleToIntFunction
//		DoubleToLongFunction
//
//		UnaryOperator<T>
//		IntUnaryOperator
//		LongUnaryOperator
//		DoubleUnaryOperator

	}

}
