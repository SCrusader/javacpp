package com.googlecode.javacpp.annotation;

import com.googlecode.javacpp.Generator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * By default, all allocators attach a deallocator to the peer object on creation.
 * This way, the deallocator automatically gets called during garbage collection.
 * Since an allocator uses the <tt>new</tt> (or for arrays the <tt>new[]</tt>)
 * operator, the deallocator produced uses the <tt>delete</tt> (or <tt>delete[]</tt>)
 * operator. However, if that operator is not accessible, or the native library
 * does not use that operator for object deallocation, we may apply this annotation
 * to an allocator method to prevent it from using these operators.
 *
 * @see Allocator
 * @see ArrayAllocator
 * @see Generator
 *
 * @author Samuel Audet
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface NoDeallocator { }