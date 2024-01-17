package com.antonio.AOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //indicamos a spring que este es un aspecto
@Component //indicamos que es un bean
public class SaludarAspect {
    private  Logger logger= LoggerFactory.getLogger(SaludarAspect.class);// interceptor
    //    execution /lo que devuelve o se puede poner * para que devuelva cualquier tipo / paquete donde esta el metodo suamdo a un punto(.) nombre de la clase sumado (.) nombre del metodo / parametros con (..)
   // @Before("execution(String com.antonio.AOP.services.ISaludarService.saludar(..))")//indicamos a cual metodo interceptar,
    //@Before("execution(String com.antonio.AOP.services.ISaludarService.*(..))")//a todos los metodos de la clase
    //@Before("execution(String com.antonio.AOP.services.*.*(..))") // aplica a todas las clases que esten en el package service
/*
    @Before("execution(* com.antonio.AOP.services.*.*(..))")//todas las clases de la app que se ejecuten
    public void loggerBefore(JoinPoint joinPoint){ //cuando se invoca un metodo
        String method= joinPoint.getSignature().getName(); //nombre del metodo
        String args= Arrays.toString(joinPoint.getArgs()); //argumentos del metodo
        logger.info("Antes del metodo :"+method+" con los argumentos: "+args);//informamos todo antes de ejecutar el metodo
    }
    @After("execution(* com.antonio.AOP.services.*.*(..))")//todas las clases de la app que se ejecuten
    public void loggerAfter(JoinPoint joinPoint){ //cuando se invoca un metodo
        String method= joinPoint.getSignature().getName(); //nombre del metodo
        String args= Arrays.toString(joinPoint.getArgs()); //argumentos del metodo
        logger.info("Despues del metodo :"+method+" con los argumentos: "+args);//informamos todo antes de ejecutar el metodo
    }
    @AfterReturning("execution(* com.antonio.AOP.services.*.*(..))")//todas las clases de la app que se ejecuten
    public void loggerAfterReturning(JoinPoint joinPoint){ //cuando se invoca un metodo
        String method= joinPoint.getSignature().getName(); //nombre del metodo
        String args= Arrays.toString(joinPoint.getArgs()); //argumentos del metodo
        logger.info("Despues de retornar un valor :"+method+" con los argumentos: "+args);//informamos todo antes de ejecutar el metodo
    }
    @AfterThrowing("execution(* com.antonio.AOP.services.*.*(..))")//todas las clases de la app que se ejecuten
    public void loggerAfterThrowing(JoinPoint joinPoint){ //cuando se invoca un metodo
        String method= joinPoint.getSignature().getName(); //nombre del metodo
        String args= Arrays.toString(joinPoint.getArgs()); //argumentos del metodo
        logger.info("Despues de lanzar una excepcion :"+method+" con los argumentos: "+args);//informamos todo antes de ejecutar el metodo
    }

*/

    @Around("execution(* com.antonio.AOP.services.*.*(..))")// envuleve el metodo haciendo un before y after
    public Object loggerAround(ProceedingJoinPoint joinPoint){ //cuando se invoca un metodo
        String method= joinPoint.getSignature().getName(); //nombre del metodo
        String args= Arrays.toString(joinPoint.getArgs()); //argumentos del metodo

        Object result = null;
        try{


            logger.info("Antes del metodo : "+method+" con los argumentos : "+args);//antes de que se ejecute el metodo (@Before)
            result=joinPoint.proceed();// aca se ejecuta el metodo
            logger.info("Despues del metodo : "+method+" con los argumentos : "+args);//despues de que se ejecute el metodo (@After)
            //return result; //aca devolvemos el valor
        }catch (Throwable e){
            logger.error("Error en la llamada al metodo : "+method+" con los argumentos : "+args);
        }
        return result;
    }



}
