package com.lidroid.xutils.db.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Finder {
    String targetColumn();
    
    String valueColumn();
}
