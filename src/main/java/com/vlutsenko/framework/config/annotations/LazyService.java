package com.vlutsenko.framework.config.annotations;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Lazy
@Service
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LazyService {
}
