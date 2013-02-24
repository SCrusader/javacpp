package com.googlecode.javacpp.annotation;

import com.googlecode.javacpp.Generator;
import com.googlecode.javacpp.Pointer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies a C++ class to act as an adapter to convert the types of arguments.
 * Two such C++ classes made available by {@link Generator} are <tt>StringAdapter</tt>
 * and <tt>VectorAdapter</tt>, to bridge a few differences between <tt>std::string</tt>
 * and {@link String}; and between <tt>std::vector</tt>, Java arrays of primitive types,
 * and {@link Pointer}. Adapter classes must define the following public members:
 * <ul>
 * <li> A constructor accepting 2 arguments (or more if {@link #argc()} > 1): a pointer and a size
 * <li> Another constructor that accepts a reference to the object of the other class
 * <li> A <tt>static void deallocate(pointer)</tt> function
 * <li> Overloaded cast operators to both types, for references and pointers
 * <li> A <tt>void assign(pointer, size)</tt> function
 * <li> A <tt>size</tt> member variable for arrays accessed via pointer
 * </ul>
 * To reduce further the amount of coding, this annotation can also be used on
 * other annotations, such as with {@link StdString} and {@link StdVector}.
 *
 * @see Generator
 *
 * @author Samuel Audet
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
public @interface Adapter {
    /** The name of the C++ adapter class. */
    String value();
    /** The number of arguments that {@link Generator} takes from the method as
     *  arguments to the adapter constructor. */
    int argc() default 1;
}