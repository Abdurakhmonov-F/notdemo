package com.example.notdemo.context;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.immutables.value.Value;

import javax.annotation.Nonnull;
import java.beans.ConstructorProperties;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@SuppressFBWarnings("all")
@Target({ElementType.PACKAGE , ElementType.TYPE})
@Value.Style(
        depluralize = true,
        optionalAcceptNullable = true,
        passAnnotations = {Nonnull.class, Deprecated.class, ConstructorProperties.class},
        typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC
)
public @interface ImmutableModel {
}
