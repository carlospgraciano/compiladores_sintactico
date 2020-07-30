# Analizador Sintáctico (Teoría de compiladores)

Nuestro analizador sintáctico **cumple** con los siguientes **requerimientos**:

**Mandato:**

**Escriba un Analizador Sintáctico que permita validar expresiones condicionales de tipo if considerando los siguientes operadores relacionales (>, >=, <, <=, !=, ==).  Las evaluaciones retornarán un booleano True ó False según corresponda.**

**Ejemplos:**
```java
if(5>4) RESULTADO = TRUE
```
```java
if(3<1) RESULTADO = FALSE
```
```java
if(5 != 5) RESULTADO = FALSE
```
```java
if(8 == 3) RESULTADO = FALSE
```

Este proyecto fue hecho utilizando las siguientes **herramientas**:
* [**Java JDK 8**](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [**JFlex v1.4.3**](https://mega.nz/#!kp5wmSTR!VRGITdbm5zuSWDMeZ8hVgVYWCNl-J0gMcAqQ2k8FBfM)
* [**Java Cup v11-beta**](https://mega.nz/file/i1o0XSiJ#DEFCsJhDOTvvtCuBmw3rsdmS65IRkZdMaBrx2T6jCKA)
* [**Eclipse IDE**](https://www.eclipse.org/downloads/)
* [**WindowBuilder para JFrame (Eclipse IDE)**](https://es.stackoverflow.com/questions/102406/como-agregar-jframe-en-eclipse)

Los **miembros** de este grupo son:
* *Carlos Polanco*: **19-0728**
* *Francisco Florian*: **19-0730**
* *Rosalina Norberto*: **19-0433**
* *Ines Cuevas*: **15-0790**
* *Jorge Cuevas*: **19-0459**
* *Rafael Batista*: **19-0702**

# Cómo correr el programa? :thinking:

La aplicación se corre ejecutando/correr desde el IDE los 2 archivos principales:

1. Principal.java: Cambiar las URLs absolutas a las de tu computadora.
2. Agregar java-cup v11-beta como JAR externo al proyecto
3. Principal.java: Se debe de correr este archivo puesto que genera los archivos para el analizador léxico y sintáctico.
4. FrmPrincipal.java: Se debe correr este archivo para poder visualizar la aplicación de Desktop hecha con JFrame.
