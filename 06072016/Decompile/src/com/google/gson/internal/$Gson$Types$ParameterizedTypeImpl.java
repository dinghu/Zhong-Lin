package com.google.gson.internal;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable
{
    private static final long serialVersionUID = 0L;
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;
    
    public ParameterizedTypeImpl(Type canonicalize, final Type type, final Type... array) {
        boolean b = false;
        if (type instanceof Class) {
            final Class clazz = (Class)type;
            boolean b2;
            if (Modifier.isStatic(clazz.getModifiers()) || clazz.getEnclosingClass() == null) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            if (canonicalize != null || b2) {
                b = true;
            }
            $Gson$Preconditions.checkArgument(b);
        }
        if (canonicalize == null) {
            canonicalize = null;
        }
        else {
            canonicalize = $Gson$Types.canonicalize(canonicalize);
        }
        this.ownerType = canonicalize;
        this.rawType = $Gson$Types.canonicalize(type);
        this.typeArguments = array.clone();
        for (int i = 0; i < this.typeArguments.length; ++i) {
            $Gson$Preconditions.checkNotNull(this.typeArguments[i]);
            $Gson$Types.access$000(this.typeArguments[i]);
            this.typeArguments[i] = $Gson$Types.canonicalize(this.typeArguments[i]);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof ParameterizedType && $Gson$Types.equals(this, (Type)o);
    }
    
    @Override
    public Type[] getActualTypeArguments() {
        return this.typeArguments.clone();
    }
    
    @Override
    public Type getOwnerType() {
        return this.ownerType;
    }
    
    @Override
    public Type getRawType() {
        return this.rawType;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ $Gson$Types.access$100(this.ownerType);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder((this.typeArguments.length + 1) * 30);
        sb.append($Gson$Types.typeToString(this.rawType));
        if (this.typeArguments.length == 0) {
            return sb.toString();
        }
        sb.append("<").append($Gson$Types.typeToString(this.typeArguments[0]));
        for (int i = 1; i < this.typeArguments.length; ++i) {
            sb.append(", ").append($Gson$Types.typeToString(this.typeArguments[i]));
        }
        return sb.append(">").toString();
    }
}
