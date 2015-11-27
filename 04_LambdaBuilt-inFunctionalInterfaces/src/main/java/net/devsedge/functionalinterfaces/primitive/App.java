package net.devsedge.functionalinterfaces.primitive;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
/**
 * 
 * @author Luigi Cortese
 *
 */
public class App {

	public static void main(String[] args) {
		
		/*
		 * 
		 * Predicate
		 * 
		 */
		
		System.out.println("'Predicate' takes any type and returns a boolean");
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
		
		/*
		 * 
		 * Function
		 * 
		 */
		
		System.out.println("\n'Function' takes any type and returns any type");
		
		new Function<String,Integer>(){
			@Override
			public Integer apply(String t) {
				System.out.println("\tFunction takes any type and returns any type");
				return 1;
			}
		}.apply("");

		new IntFunction<String>(){
			@Override
			public String apply(int value) {
				System.out.println("\tIntFunction takes an int and returns any type");
				return "";
			}
		}.apply(1);
		
		new ToIntFunction<String>(){
			@Override
			public int applyAsInt(String value) {
				System.out.println("\tToIntFunction takes any value and returns an int");
				return 0;
			}
		}.applyAsInt("");
		
		new IntToLongFunction(){
			@Override
			public long applyAsLong(int value) {
				System.out.println("\tIntToLongFunction takes an int and returns a long");
				return 0L;
			}
		}.applyAsLong(1);
		
		new IntToDoubleFunction(){
			@Override
			public double applyAsDouble(int value) {
				System.out.println("\tIntToDoubleFunction takes an int and returns a double");
				return 0D;
			}
		}.applyAsDouble(1);

		System.out.println("\t----");
		
		new LongFunction<String>(){
			@Override
			public String apply(long value) {
				System.out.println("\tLongFunction takes a long and returns any type");
				return "";
			}
		}.apply(1);
		
		new ToLongFunction<String>(){
			@Override
			public long applyAsLong(String value) {
				System.out.println("\tToLongFunction takes any value and returns a long");
				return 0L;
			}
		}.applyAsLong("");
		
		new LongToIntFunction(){
			@Override
			public int applyAsInt(long value) {
				System.out.println("\tLongToIntFunction takes a long and returns an int");
				return 0;
			}
		}.applyAsInt(1L);
		
		new LongToDoubleFunction(){
			@Override
			public double applyAsDouble(long value) {
				System.out.println("\tLongToDoubleFunction takes a long and returns a double");
				return 0D;
			}
		}.applyAsDouble(1L);		
		
		System.out.println("\t----");
		
		new DoubleFunction<String>(){
			@Override
			public String apply(double value) {
				System.out.println("\tDoubleFunction takes a double and returns any type");
				return "";
			}
		}.apply(1);
		
		new ToDoubleFunction<String>(){
			@Override
			public double applyAsDouble(String value) {
				System.out.println("\tToDoubleFunction takes any value and returns a double");
				return 0L;
			}
		}.applyAsDouble("");
		
		new DoubleToIntFunction(){
			@Override
			public int applyAsInt(double value) {
				System.out.println("\tDoubleToIntFunction takes a double and returns an int");
				return 0;
			}
		}.applyAsInt(1D);
		
		new DoubleToLongFunction(){
			@Override
			public long applyAsLong(double value) {
				System.out.println("\tDoubleToLongFunction takes a double and returns a long");
				return 0L;
			}
		}.applyAsLong(1D);

	}

}
